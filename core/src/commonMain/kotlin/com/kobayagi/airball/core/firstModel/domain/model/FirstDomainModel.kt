package com.kobayagi.airball.core.firstModel.domain.model

import com.kobayagi.airball.core.firstModel.domain.model.contract.FirstModel

class FirstDomainModel(
    override val id: Int,
    override val name: String,
    override val surname: String,
): FirstModel