package io.mailguru.api.core.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class ApiErrorSourceTest {

    private val mapperNullIncluded: JsonMapper = JsonMapper.builder()
        .addModule(kotlinModule())
        .build()

    private val mapperNullExcluded: JsonMapper = JsonMapper.builder()
        .addModule(kotlinModule())
        .serializationInclusion(JsonInclude.Include.NON_NULL)
        .build()

    @Test
    fun `no parameter, no propertyPath`() {
        ApiErrorSource().let { sut ->
            assertEquals(
                """{"parameter":null,"pointer":null}""",
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """{}""",
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }

    @Test
    fun `no parameter, empty string in propertyPath`() {
        val thrown = assertThrows<IllegalArgumentException> {
            ApiErrorSource(propertyPath = "")
        }

        assertEquals("The constructor arg `propertyPath` must not be blank.", thrown.message)
    }

    @Test
    fun `no parameter, non-empty string in pointer NOT starting with slash`() {
        ApiErrorSource(propertyPath = "someProperty").let { sut ->
            assertEquals(
                """{"parameter":null,"pointer":"/someProperty"}""",
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """{"pointer":"/someProperty"}""",
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }

    @Test
    fun `no parameter, non-empty string in pointer starting with slash`() {
        ApiErrorSource(propertyPath = "/someProperty").let { sut ->
            assertEquals(
                """{"parameter":null,"pointer":"/someProperty"}""",
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """{"pointer":"/someProperty"}""",
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }

    @Test
    fun `empty string in parameter, no propertyPath`() {
        val thrown = assertThrows<IllegalArgumentException> {
            ApiErrorSource(parameter = "")
        }

        assertEquals("The constructor arg `parameter` must not be blank.", thrown.message)
    }

    @Test
    fun `non-empty string in parameter, no propertyPath`() {
        ApiErrorSource(parameter = "a random string with blanks").let { sut ->
            assertEquals(
                """{"parameter":"a random string with blanks","pointer":null}""",
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """{"parameter":"a random string with blanks"}""",
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }

    @Test
    fun `non-empty string in parameter, non-empty string in propertyPath`() {
        ApiErrorSource(parameter = "foo", propertyPath = "bar").let { sut ->
            assertEquals(
                """{"parameter":"foo","pointer":"/bar"}""",
                mapperNullIncluded.writeValueAsString(sut)
            )
            assertEquals(
                """{"parameter":"foo","pointer":"/bar"}""",
                mapperNullExcluded.writeValueAsString(sut)
            )
        }
    }
}
