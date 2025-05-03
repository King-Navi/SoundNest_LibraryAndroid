package communication.restful.services

import communication.restful.models.comment.CommentResponse
import communication.restful.models.comment.CreateCommentRequest
import communication.restful.services.interfaces.ICommentService
import communication.restful.utils.ApiResult


class CommentService(baseUrl : String ) : BaseService(baseUrl) {
    private val commentService = retrofit.create(ICommentService::class.java)

    suspend fun postComment(request: CreateCommentRequest): ApiResult<Unit?> {
        return safeCall { commentService.createComment(request) }
    }

    suspend fun fetchComments(songId: String): ApiResult<List<CommentResponse>?> {
        return safeCall { commentService.getAllCommentsByIdSong(songId) }
    }

    suspend fun fetchCommentById(id: String): ApiResult<CommentResponse?> {
        return safeCall { commentService.getCommentById(id) }
    }

    suspend fun removeComment(id: String): ApiResult<Unit?> {
        return safeCall { commentService.deleteComment(id) }
    }
}