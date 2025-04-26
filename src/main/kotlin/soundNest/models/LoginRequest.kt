package soundNest.models

/**
 * Representa una solicitud de inicio de sesión de usuario.
 *
 * @property username El nombre de usuario del sistema.
 * @property password La contraseña asociada al usuario.
 */
data class LoginRequest(
    val username: String,
    val password: String
)