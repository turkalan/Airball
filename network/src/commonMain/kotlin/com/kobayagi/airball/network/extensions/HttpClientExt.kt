package com.kobayagi.airball.network.extensions

import com.kobayagi.airball.common.core.errorhandling.DataError
import com.kobayagi.airball.common.core.errorhandling.Either
import com.kobayagi.airball.common.core.errorhandling.Either.Companion.fail
import com.kobayagi.airball.common.core.errorhandling.Either.Companion.success
import com.kobayagi.airball.common.core.errorhandling.Error
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(
    crossinline execute: () -> HttpResponse,
): Either<Error, T> {
    val response = try {
        execute()
    } catch (e: SocketTimeoutException) {
        return fail(DataError.Remote.REQUEST_TIMEOUT)
    } catch (e: UnresolvedAddressException) {
        return fail(DataError.Remote.NO_INTERNET)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return fail(DataError.Remote.UNKNOWN)
    }
    return responseToEither(response)
}

suspend inline fun <reified T> responseToEither(
    response: HttpResponse,
): Either<Error, T> {
    return when(response.status.value) {
        in 200..299 -> {
            try {
                success(response.body<T>())
            } catch(e: NoTransformationFoundException) {
                fail(DataError.Remote.SERIALIZATION)
            }
        }
        in 400..407, in 409..428, in 430..499 -> fail(DataError.Remote.UNKNOWN)
        408 -> fail(DataError.Remote.UNKNOWN)
        429 -> fail(DataError.Remote.TOO_MANY_REQUESTS)
        in 500..599 -> fail(DataError.Remote.SERVER)
        else -> fail(DataError.Remote.UNKNOWN)
    }
}