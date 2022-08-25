package io.mailguru.api.core.exception

class MalformedParameterException(
    override val message: String = "Malformed input.",
    override val parameter: String,
) : SourceException(message, parameter = parameter)
