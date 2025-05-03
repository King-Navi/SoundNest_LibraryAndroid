package communication.restful.models.user

import com.squareup.moshi.Json

data class NewUserRequest(
    @Json(name = "nameUser")
    val nameUser: String,

    @Json(name = "email")
    val email: String,

    @Json(name = "password")
    val password: String,

    @Json(name = "code")
    val code: Int,

    @Json(name = "additionalInformation")
    val additionalInformation: AdditionalInformation
)

data class AdditionalInformation(
    @Json(name = "bio")
    val bio: String,

    @Json(name = "instagram")
    val instagram: String,

    @Json(name = "genres")
    val genres: List<String>
)