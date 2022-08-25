package io.mailguru.api.core.exception

class UnavailableForLegalReasonsException(
    override val message: String = "The requested resource is unavailable for legal reasons.",
    override val parameter: String,
) : SourceException(message, parameter = parameter)