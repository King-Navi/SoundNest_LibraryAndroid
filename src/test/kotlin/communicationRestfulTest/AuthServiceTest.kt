package communicationRestfulTest

import communication.restful.constants.ApiRoutes
import communication.restful.services.AuthService
import communication.restful.utils.ApiResult
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AuthServiceTest {
    private val baseUrl = ApiRoutes.BASE_URL;

    @Test
    fun `login with username 1 and password 1 should succeed`() = runBlocking {
        val loginClient = AuthService(baseUrl)
        val result = loginClient.login("1", "1")

        when (result) {
            is ApiResult.Success -> {
                assertNotNull(result.data)
            }
            is ApiResult.HttpError -> fail("HTTP error: ${result.code} - ${result.message}")
            is ApiResult.NetworkError -> fail("Network error: ${result.exception.message}")
            is ApiResult.UnknownError -> fail("Unknown error: ${result.exception.message}")
        }

    }
    @Test
    fun `send email code to email should succeed`() = runBlocking {
        val loginClient = AuthService(baseUrl)
        val result = loginClient.sendCodeToEmail("zs22013698@estudiantes.uv.mx")
        when (result) {
            is ApiResult.Success -> {
                println("Nice")
            }
            is ApiResult.HttpError -> fail("HTTP error: ${result.code} - ${result.message}")
            is ApiResult.NetworkError -> fail("Network error: ${result.exception.message}")
            is ApiResult.UnknownError -> fail("Unknown error: ${result.exception.message}")
        }

    }
}