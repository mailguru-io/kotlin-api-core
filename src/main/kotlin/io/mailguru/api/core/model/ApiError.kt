package io.mailguru.api.core.model

import io.mailguru.api.core.exception.SourceException

/**
 * Representation of a JSON:API error; encapsulated into the `errors` property of an [ApiErrorResponse].
 * <p>
 * See <a href="https://jsonapi.org/format/#error-objects">JSON:API Error objects</a>.
 * @see <a href="https://jsonapi.org/format/#error-objects">JSON:API Error objects</a>
 *
 * @constructor Creates an instance with the given properties.
 * @param id A unique identifier for this particular occurrence of the problem.
 * @param about A link that leads to further details about this particular occurrence of the problem.
 * @param status The HTTP status code applicable to this problem, expressed as a string value.
 * @param code An application-specific error code, expressed as a string value.
 * @param title A short, human-readable summary of the problem that **SHOULD NOT** change from occurrence to occurrence
 *              of the problem, except for purposes of localization.
 * @param detail A human-readable explanation specific to this occurrence of the problem. Like `title`, this field’s
 *               value can be localized.
 * @param source An object containing references to the source of the error, see [ApiErrorSource].
 * @param meta A meta object containing non-standard meta-information about the error.
 */
@Suppress("LongParameterList")
class ApiError(
    val id: String? = null,
    val about: String? = null,
    val status: String? = null,
    val code: String? = null,
    val title: String? = null,
    val detail: String? = null,
    val source: ApiErrorSource = ApiErrorSource(),
    val meta: Any? = null,
) {

    /**
     * Convenience constructor.
     */
    @Deprecated("Use primary constructor instead.")
    constructor(
        code: Int,
        title: String,
        detail: String,
        parameter: String? = null,
        propertyPath: String? = null
    ) : this(
        code = code.toString(),
        title = title,
        detail = detail,
        source = ApiErrorSource(
            parameter = parameter,
            propertyPath = propertyPath
        )
    )

    /**
     * Convenience constructor.
     */
    @Deprecated("Use primary constructor instead.")
    constructor(
        status: Int,
        reasonPhrase: String,
        sourceException: SourceException,
    ) : this(
        status = status.toString(),
        code = status.toString(),
        title = reasonPhrase,
        detail = sourceException.message,
        source = ApiErrorSource(
            parameter = sourceException.parameter,
            propertyPath = sourceException.propertyPath
        )
    )

    /**
     * Convenience constructor.
     */
    @Deprecated("Use primary constructor instead.")
    constructor(
        code: Int,
        title: String,
        detail: String,
    ) : this(
        code = code.toString(),
        title = title,
        detail = detail,
    )
}
