package soundNest.auth

import soundNest.utils.createUnsafeOkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import soundNest.models.LoginRequest
import soundNest.models.NewUserRequest

class LoginClient(baseUrl: String) {

    private val authService: IAuthService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createUnsafeOkHttpClient()) //This is for the self-signed
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        authService = retrofit.create(IAuthService::class.java)
    }

    suspend fun login(username: String, password: String): Result<String> {
        return try {
            val response = authService.login(LoginRequest(username, password))
            if (response.isSuccessful) {
                val loginResponse = response.body()
                if (loginResponse != null) {
                    Result.success(loginResponse.token)
                } else {
                    Result.failure(Exception("Empty response body"))
                }
            } else {
                Result.failure(Exception("Login failed with status: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun createUser(username: String, email: String, password: String): Result<Unit> {
        return try {
            val response = authService.createUser(NewUserRequest(username, email, password))
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("User creation failed with status: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}