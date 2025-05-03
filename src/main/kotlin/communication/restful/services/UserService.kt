package communication.restful.services

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import communication.restful.models.user.AdditionalInformation
import communication.restful.models.user.EditUserRequest
import communication.restful.models.user.NewUserRequest
import communication.restful.services.interfaces.IAuthService
import communication.restful.services.interfaces.IUserService
import communication.restful.utils.ApiResult
import communication.restful.utils.createUnsafeOkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UserService(baseUrl: String) : BaseService(baseUrl) {
    private val userService = retrofit.create(IUserService::class.java)

    suspend fun createUser(
        username: String,
        email: String,
        password: String,
        code: Int,
        additionalInformation: AdditionalInformation
    ): ApiResult<Unit?> {
        val newUserRequest = NewUserRequest(
            nameUser = username,
            email = email,
            password = password,
            code = code,
            additionalInformation = additionalInformation
        )
        return safeCall { userService.createUser(newUserRequest) }
    }

    suspend fun editUser(
        username: String,
        email: String,
        password: String,
        additionalInformation: AdditionalInformation
    ): ApiResult<Unit?> {
        val editUserRequest = EditUserRequest(
            nameUser = username,
            email = email,
            password = password,
            additionalInformation = additionalInformation
        )
        return safeCall { userService.editUser(editUserRequest) }
    }
}