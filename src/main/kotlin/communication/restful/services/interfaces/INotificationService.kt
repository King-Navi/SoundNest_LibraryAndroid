package communication.restful.services.interfaces

import communication.restful.constants.ApiRoutes
import communication.restful.models.notification.CreateNotificationRequest
import communication.restful.models.notification.NotificationResponse
import retrofit2.Response
import retrofit2.http.*

interface INotificationService {
    @POST(ApiRoutes.NOTIFICATION_CREATE)
    suspend fun createNotification(@Body request: CreateNotificationRequest): Response<Unit>

    @GET(ApiRoutes.NOTIFICATION_GET_BY_ID)
    suspend fun getNotificationById(@Path("id") id: String): Response<NotificationResponse>

    @GET(ApiRoutes.NOTIFICATION_GET_BY_USER_ID)
    suspend fun getNotificationsByUserId(@Path("userId") userId: String): Response<List<NotificationResponse>>

    @DELETE(ApiRoutes.NOTIFICATION_DELETE)
    suspend fun deleteNotification(@Path("id") id: String): Response<Unit>

    @PATCH(ApiRoutes.NOTIFICATION_MARK_AS_READ)
    suspend fun markNotificationAsRead(@Path("id") id: String): Response<Unit>
}