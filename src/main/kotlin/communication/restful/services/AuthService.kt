package communication.restful.services

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import communication.restful.models.auth.LoginRequest
import communication.restful.models.auth.LoginResponse
import communication.restful.models.auth.SendCodeRequest
import communication.restful.models.auth.VerifyCodeRequest
import communication.restful.services.interfaces.IAuthService
import communication.restful.utils.ApiResult

class AuthService(baseUrl: String) : BaseService(baseUrl) {
    private val authService = retrofit.create(IAuthService::class.java)

    suspend fun login(username: String, password: String): ApiResult<LoginResponse?> {
        return safeCall { authService.login(LoginRequest(username, password)) }
    }

    suspend fun sendCodeToEmail(email: String): ApiResult<Unit?> {
        return safeCall { authService.sendCode(SendCodeRequest(email)) }
    }

    suspend fun verifyCode(email: String, code: Int): ApiResult<Unit?> {
        return safeCall { authService.verifyCode(VerifyCodeRequest(email, code)) }
    }
}
