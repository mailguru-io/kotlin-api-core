package io.mailguru.api.core.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import io.mailguru.api.core.exception.SourceException
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ApiErrorTest {

    private val mapperNullIncluded: JsonMapper = JsonMapper.builder()
        .addModule(kotlinModule())
        .build()

    private val mapperNullExcluded: JsonMapper = JsonMapper.builder()
        .addModule(kotlinModule())
        .serializationInclusion(JsonInclude.Include.NON_NULL)
        .build()

    @Test
    fun `primary constructor with non-null values`() {
        ApiError(
            id = "id1",
            about = "about1",
            status = "status1",
            code = "code1",
            title = "title1",
            detail = "detail1",
            source = ApiErrorSource(parameter = "param1", propertyPath = "/pointer1"),
            meta = "meta1",
        ).let { sut ->
            assertEquals(
                """
                {
                "id":"id1",
                "about":"about1",
                "status":"status1",
                "code":"code1",
                "title":"title1",
                "detail":"detail1",
                "source":{"parameter":"param1","pointer":"/pointer1"},
                "meta":"meta1"
                }
                """.trimIndent().replace("\n", ""),
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """
                {
                "id":"id1",
                "about":"about1",
                "status":"status1",
                "code":"code1",
                "title":"title1",
                "detail":"detail1",
                "source":{"parameter":"param1","pointer":"/pointer1"},
                "meta":"meta1"
                }
                """.trimIndent().replace("\n", ""),
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }

    @Test
    fun `primary constructor with null values`() {
        ApiError().let { sut ->
            assertEquals(
                """
                {
                "id":null,
                "about":null,
                "status":null,
                "code":null,
                "title":null,
                "detail":null,
                "source":{"parameter":null,"pointer":null},
                "meta":null
                }
                """.trimIndent().replace("\n", ""),
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """{"source":{}}""",
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }

    @Test
    fun `secondary constructor A`() {
        ApiError(
            code = 123,
            title = "title1",
            detail = "detail1",
            parameter = "param1",
            propertyPath = "property1",
        ).let { sut ->
            assertEquals(
                """
                {
                "id":null,
                "about":null,
                "status":null,
                "code":"123",
                "title":"title1",
                "detail":"detail1",
                "source":{"parameter":"param1","pointer":"/property1"},
                "meta":null
                }
                """.trimIndent().replace("\n", ""),
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """
                {
                "code":"123",
                "title":"title1",
                "detail":"detail1",
                "source":{"parameter":"param1","pointer":"/property1"}
                }
                """.trimIndent().replace("\n", ""),
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }

    @Test
    fun `secondary constructor B`() {
        ApiError(
            status = 123,
            reasonPhrase = "reasonPhrase1",
            sourceException = object : SourceException(
                message = "message1",
                parameter = "param1",
                propertyPath = "property1",
            ) {},
        ).let { sut ->
            assertEquals(
                """
                {
                "id":null,
                "about":null,
                "status":"123",
                "code":"123",
                "title":"reasonPhrase1",
                "detail":"message1",
                "source":{"parameter":"param1","pointer":"/property1"},
                "meta":null
                }
                """.trimIndent().replace("\n", ""),
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """
                {
                "status":"123",
                "code":"123",
                "title":"reasonPhrase1",
                "detail":"message1",
                "source":{"parameter":"param1","pointer":"/property1"}
                }
                """.trimIndent().replace("\n", ""),
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }

    @Test
    fun `secondary constructor C`() {
        ApiError(
            code = 123,
            title = "title1",
            detail = "detail1",
        ).let { sut ->
            assertEquals(
                """
                {
                "id":null,
                "about":null,
                "status":null,
                "code":"123",
                "title":"title1",
                "detail":"detail1",
                "source":{"parameter":null,"pointer":null},
                "meta":null
                }
                """.trimIndent().replace("\n", ""),
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """
                {
                "code":"123",
                "title":"title1",
                "detail":"detail1",
                "source":{}
                }
                """.trimIndent().replace("\n", ""),
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }
}
