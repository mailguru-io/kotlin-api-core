package io.mailguru.api.core.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ApiErrorResponseTest {

    private val mapperNullIncluded: JsonMapper = JsonMapper.builder()
        .addModule(kotlinModule())
        .build()

    private val mapperNullExcluded: JsonMapper = JsonMapper.builder()
        .addModule(kotlinModule())
        .serializationInclusion(JsonInclude.Include.NON_NULL)
        .build()

    @Test
    fun `primary constructor with non-null values`() {
        val error = ApiError(
            id = "id1",
            about = "about1",
            status = "status1",
            code = "code1",
            title = "title1",
            detail = "detail1",
            source = ApiErrorSource(parameter = "param1", propertyPath = "/pointer1"),
            meta = "meta1",
        )
        ApiErrorResponse(error).let { sut ->
            assertEquals(
                """
                {"errors":[{
                "id":"id1",
                "about":"about1",
                "status":"status1",
                "code":"code1",
                "title":"title1",
                "detail":"detail1",
                "source":{"parameter":"param1","pointer":"/pointer1"},
                "meta":"meta1"
                }]}
                """.trimIndent().replace("\n", ""),
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """
                {"errors":[{
                "id":"id1",
                "about":"about1",
                "status":"status1",
                "code":"code1",
                "title":"title1",
                "detail":"detail1",
                "source":{"parameter":"param1","pointer":"/pointer1"},
                "meta":"meta1"
                }]}
                """.trimIndent().replace("\n", ""),
                mapperNullExcluded.writeValueAsString(sut)
            )

            assertEquals(
                mutableMapOf<String, Any>(
                    "errors" to setOf(error)
                ),
                sut.toAttributeMap()
            )
        }
    }

    @Test
    fun `primary constructor with null values`() {
        val error = ApiError()
        ApiErrorResponse(error).let { sut ->
            assertEquals(
                """
                {"errors":[{
                "id":null,
                "about":null,
                "status":null,
                "code":null,
                "title":null,
                "detail":null,
                "source":{"parameter":null,"pointer":null},
                "meta":null
                }]}
                """.trimIndent().replace("\n", ""),
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """{"errors":[{"source":{}}]}""",
                mapperNullExcluded.writeValueAsString(sut)
            )

            assertEquals(
                mutableMapOf<String, Any>(
                    "errors" to setOf(error)
                ),
                sut.toAttributeMap()
            )
        }
    }
}
