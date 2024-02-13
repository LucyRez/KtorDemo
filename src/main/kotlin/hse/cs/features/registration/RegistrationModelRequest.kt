package hse.cs.features.registration

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationModelRequest(
    val email: String,
    val login: String,
    val password: String
)
