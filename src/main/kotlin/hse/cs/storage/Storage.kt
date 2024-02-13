package hse.cs.storage

import hse.cs.features.registration.RegistrationModelRequest

data class TokenStorage(
    val token: String,
    val userLogin: String
)

object Storage {
    val userList: MutableList<RegistrationModelRequest> = mutableListOf()
    val tokenList: MutableList<TokenStorage> = mutableListOf()
}