package hse.cs.features.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginModelRequest(
    val login: String,
    val password: String
)

@Serializable
data class LoginModelResponse(
    val token: String
)

