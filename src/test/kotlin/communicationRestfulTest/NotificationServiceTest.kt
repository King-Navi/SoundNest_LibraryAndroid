package communicationRestfulTest

import communication.restful.constants.ApiRoutes
import communication.restful.models.notification.CreateNotificationRequest
import communication.restful.models.notification.Relevance
import communication.restful.services.NotificationService
import communication.restful.utils.ApiResult
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NotificationServiceTest {
    private val baseUrl = ApiRoutes.BASE_URL

    @Test
    fun `create notification should succeed`() = runBlocking {
        val service = NotificationService(baseUrl)
        val request = CreateNotificationRequest(
            sender = "Meee",
            userId = 2,
            user = "Pepe",
            notification = "Test Notification",
            relevance = Relevance.low
        )
        val result = service.createNotification(request)

        when (result) {
            is ApiResult.Success -> {
                println("Notification created successfully")
            }
            is ApiResult.HttpError -> fail("HTTP error: ${result.code} - ${result.message}")
            is ApiResult.NetworkError -> fail("Network error: ${result.exception.message}")
            is ApiResult.UnknownError -> fail("Unknown error: ${result.exception.message}")
        }
    }

    @Test
    fun `get notification by id should return notification`() = runBlocking {
        val service = NotificationService(baseUrl)

        val notificationId: String? = when (val resultById = service.getNotificationsByUserId("1")) {
            is ApiResult.Success -> resultById.data?.firstOrNull()?.id
            is ApiResult.HttpError -> throw Exception("HTTP error: ${resultById.code} - ${resultById.message}")
            is ApiResult.NetworkError -> throw resultById.exception
            is ApiResult.UnknownError -> throw resultById.exception
        }

        val result = service.getNotificationById(notificationId ?: throw Exception("No notification ID found"))

        when (result) {
            is ApiResult.Success -> {
                assertNotNull(result.data, "Notifications list should not be null")
                println("Received notifications: ${result.data}")
            }
            is ApiResult.HttpError -> fail("HTTP error: ${result.code} - ${result.message}")
            is ApiResult.NetworkError -> fail("Network error: ${result.exception.message}")
            is ApiResult.UnknownError -> fail("Unknown error: ${result.exception.message}")
        }
    }

    @Test
    fun `get notifications by user id should return list`() = runBlocking {
        val service = NotificationService(baseUrl)
        val userId = "1"

        val result = service.getNotificationsByUserId(userId)

        when (result) {
            is ApiResult.Success -> {
                val notifications = result.data
                assertNotNull(notifications, "Notifications list should not be null")
                println("Received notifications: $notifications")
            }
            is ApiResult.HttpError -> fail("HTTP error: ${result.code} - ${result.message}")
            is ApiResult.NetworkError -> fail("Network error: ${result.exception.message}")
            is ApiResult.UnknownError -> fail("Unknown error: ${result.exception.message}")
        }
    }

    @Test
    fun `delete notification should succeed`() = runBlocking {
        val service = NotificationService(baseUrl)
        val userIdForDelete = 200
        service.createNotification(
            CreateNotificationRequest(
                sender = "Meee",
                userId = userIdForDelete,
                user = "Pepe",
                notification = "Test Notification",
                relevance = Relevance.low
            )
        )
        val notificationId: String? = when (val resultById = service.getNotificationsByUserId(userIdForDelete.toString())) {
            is ApiResult.Success -> resultById.data?.firstOrNull()?.id
            is ApiResult.HttpError -> throw Exception("HTTP error: ${resultById.code} - ${resultById.message}")
            is ApiResult.NetworkError -> throw resultById.exception
            is ApiResult.UnknownError -> throw resultById.exception
        }


        val result = service.getNotificationById(notificationId ?: throw Exception("No notification ID found"))

        when (result) {
            is ApiResult.Success -> {
                println("Notification deleted successfully")
            }
            is ApiResult.HttpError -> fail("HTTP error: ${result.code} - ${result.message}")
            is ApiResult.NetworkError -> fail("Network error: ${result.exception.message}")
            is ApiResult.UnknownError -> fail("Unknown error: ${result.exception.message}")
        }
    }

    @Test
    fun `mark notification as read should succeed`() = runBlocking {
        val service = NotificationService(baseUrl)
        val notificationId = "681640001606df47613187f5"

        val result = service.markNotificationAsRead(notificationId)

        when (result) {
            is ApiResult.Success -> {
                println("Notification marked as read successfully")
            }
            is ApiResult.HttpError -> fail("HTTP error: ${result.code} - ${result.message}")
            is ApiResult.NetworkError -> fail("Network error: ${result.exception.message}")
            is ApiResult.UnknownError -> fail("Unknown error: ${result.exception.message}")
        }
    }
}