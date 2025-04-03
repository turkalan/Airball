package com.kobayagi.airball.network.model.first

import com.kobayagi.airball.core.firstModel.domain.model.contract.FirstModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FirstRemoteModel(
    @SerialName("id")override val id: Int,
    @SerialName("name")override val name: String,
    @SerialName("surname")override val surname: String
): FirstModel