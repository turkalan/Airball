package com.kobayagi.airball.common.core.errorhandling

sealed interface Either<out F, out S> {
    data class Fail<out F>(val value: F) : Either<F, Nothing> {
        companion object {
            operator fun <F> invoke(f: F): Either<F, Nothing> = Fail(f)
        }
    }

    data class Success<out S>(val value: S) : Either<Nothing, S> {
        companion object {
            operator fun <S> invoke(s: S): Either<Nothing, S> = Success(s)
        }
    }

    companion object {
        fun <S> success(value: S): Either<Nothing, S> = Success(value)
        fun <F> fail(value: F): Either<F, Nothing> = Fail(value)
    }
}

inline fun <F: Error, S> Either<F, S>.onSuccess(crossinline action: (S) -> Unit): Either<F, S> {
    return when (this) {
        is Either.Success -> {
            action(value)
            this
        }
        is Either.Fail -> this
    }
}

inline fun <F: Error, S> Either<F, S>.onError(crossinline action: (F) -> Unit): Either<F, S> {
    return when (this) {
        is Either.Success -> this
        is Either.Fail -> {
            action(value)
            this
        }
    }
}