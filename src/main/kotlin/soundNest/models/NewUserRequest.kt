package soundNest.models

data class NewUserRequest(
    val nameUser: String,
    val email: String,
    val password: String
)