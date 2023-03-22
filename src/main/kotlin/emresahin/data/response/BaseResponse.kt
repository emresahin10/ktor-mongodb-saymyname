package emresahin.data.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(val data: T? = null)