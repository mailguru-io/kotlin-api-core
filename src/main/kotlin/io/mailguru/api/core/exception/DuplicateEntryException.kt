package io.mailguru.api.core.exception

class DuplicateEntryException(
    override val message: String = "Duplicate entry",
    override val propertyPath: String,
) : SourceException(message, propertyPath = propertyPath)
