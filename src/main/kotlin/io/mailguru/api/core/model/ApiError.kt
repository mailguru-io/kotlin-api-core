package io.mailguru.api.core.model

import io.mailguru.api.core.exception.SourceException

class ApiError(
    val code: Int,
    val title: String,
    val detail: String,
    parameter: String? = null,
    propertyPath: String? = null
) {

    constructor(
        status: Int,
        reasonPhrase: String,
        sourceException: SourceException,
    ) : this(
        status,
        reasonPhrase,
        sourceException.message,
        sourceException.parameter,
        sourceException.propertyPath,
    )

    val source: ApiErrorSource = ApiErrorSource(parameter = parameter, propertyPath = propertyPath)

    class ApiErrorSource(
        val parameter: String? = null,
        propertyPath: String? = null,
    ) {
        val pointer: String? = propertyPath?.let { "/${it}" }
    }
}
