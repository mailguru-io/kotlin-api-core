package io.mailguru.api.core.model

class ApiErrorResponse(
    val errors: Collection<ApiError> = listOf()
) {
    constructor(error: ApiError) : this(listOf(error))

    fun toAttributeMap(): MutableMap<String, Any> = mutableMapOf(ApiErrorResponse::errors.name to errors)
}
