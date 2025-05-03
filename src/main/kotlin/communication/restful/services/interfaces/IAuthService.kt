package communication.restful.services.interfaces

import communication.restful.constants.ApiRoutes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import communication.restful.models.auth.LoginRequest
import communication.restful.models.auth.LoginResponse
import communication.restful.models.auth.SendCodeRequest
import communication.restful.models.auth.VerifyCodeRequest

interface IAuthService {
    @POST(ApiRoutes.AUTH_LOGIN)
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST(ApiRoutes.AUTH_SEND_CODE_EMAIL)
    suspend fun sendCode(@Body request: SendCodeRequest): Response<Unit>
    @POST(ApiRoutes.AUTH_VERIFY_CODE)
    suspend fun verifyCode(@Body request: VerifyCodeRequest): Response<Unit>
}