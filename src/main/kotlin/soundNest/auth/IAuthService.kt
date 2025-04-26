package soundNest.auth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import soundNest.models.LoginRequest
import soundNest.models.LoginResponse
import soundNest.models.NewUserRequest

interface IAuthService {
    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse> // No defines respuesta en Swagger

    @POST("api/user/newUser")
    suspend fun createUser(@Body request: NewUserRequest): Response<Unit>
}