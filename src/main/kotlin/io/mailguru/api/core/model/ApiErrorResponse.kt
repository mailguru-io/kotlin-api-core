package io.mailguru.api.core.model

/**
 * Representation of a JSON:API errors (top-level) document; encapsulates one of more
 * [ApiError]s (as an array under the `errors` key) into a single document that is going to be returned to the client.
 * <p>
 * See <a href="https://jsonapi.org/format/#error-objects">JSON:API Error objects</a>.
 * @see <a href="https://jsonapi.org/format/#error-objects">JSON:API Error objects</a>
 *
 * @constructor Creates an instance with the given collection of errors.
 * @param errors A collection hat represents the errors occurred on processing an API request.
 *               In terms of JSON:API spec, this parameter is going to be serialized as a JSON array in the response.
 */
class ApiErrorResponse(
    val errors: Collection<ApiError> = emptySet()
) {

    /**
     * Creates an instance with a single-item collection of the given error.
     */
    constructor(error: ApiError) : this(setOf(error))

    /**
     * Helper method for mapping the contents of errors into JSON.
     */
    fun toAttributeMap(): MutableMap<String, Any> = mutableMapOf(ApiErrorResponse::errors.name to errors)
}
