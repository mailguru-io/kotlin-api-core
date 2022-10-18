package io.mailguru.api.core.model

/**
 * Representation of the `source` property of a JSON:API error, to be encapsulated into an [ApiError].
 * <p>
 * See <a href="https://jsonapi.org/format/#error-objects">JSON:API Error objects</a>,
 *     <a href="https://datatracker.ietf.org/doc/html/rfc6901">RFC6901</a>.
 * @see <a href="https://jsonapi.org/format/#error-objects">JSON:API Error objects</a>
 *      <p>
 *      <a href="https://datatracker.ietf.org/doc/html/rfc6901">RFC6901</a>
 *
 * @constructor Creates an instance with the given values. A slash will be inserted at the beginning of `propertyPath`
 * if necessary.
 * @param parameter A string indicating which URI query parameter caused the error. MAY be null, but MUST NOT be blank.
 * @param propertyPath A JSON Pointer (RFC6901) to the associated entity in the request document; e.g. "/data" for a
 *                     primary data object, or "/data/attributes/title" for a specific attribute. A slash will be
 *                     inserted at the beginning if necessary. MAY be null, but MUST NOT be blank.
 */

data class ApiErrorSource @Throws(IllegalArgumentException::class) constructor(
    val parameter: String? = null,
    private val propertyPath: String? = null,
) {

    init {
        require(parameter?.isNotBlank() != false) { "The constructor arg `parameter` must not be blank." }
        require(propertyPath?.isNotBlank() != false) { "The constructor arg `propertyPath` must not be blank." }
    }

    /**
     * A JSON Pointer (RFC6901) to the associated entity in the request document; e.g. "/data" for a primary data
     * object, or "/data/attributes/title" for a specific attribute. Will be generated from the propertyPath param
     */
    val pointer: String? by lazy {
        propertyPath?.let { "/" + it.trimStart('/') }
    }
}
