package io.mailguru.api.core.model

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class ApiErrorSourceTest {

    private val objectMapper: JsonMapper = JsonMapper.builder()
        .addModule(kotlinModule())
        .build()

    @Test
    fun `no parameter, empty string in propertyPath`() {
        val thrown = assertThrows<IllegalArgumentException> {
            ApiErrorSource(propertyPath = "")
        }

        assertEquals("The constructor arg `propertyPath` must not be blank.", thrown.message);
    }

    @Test
    fun `no parameter, non-empty string in pointer NOT starting with slash`() {
        assertEquals(
            """{"parameter":null,"pointer":"/someProperty"}""",
            objectMapper.writeValueAsString(
                ApiErrorSource(propertyPath = "someProperty")
            )
        )
    }

    @Test
    fun `no parameter, non-empty string in pointer starting with slash`() {
        assertEquals(
            """{"parameter":null,"pointer":"/someProperty"}""",
            objectMapper.writeValueAsString(
                ApiErrorSource(propertyPath = "/someProperty")
            )
        )
    }

    @Test
    fun `empty string in parameter, no propertyPath`() {
        val thrown = assertThrows<IllegalArgumentException> {
            ApiErrorSource(parameter = "")
        }

        assertEquals("The constructor arg `parameter` must not be blank.", thrown.message);
    }

    @Test
    fun `non-empty string in parameter, no propertyPath`() {
        assertEquals(
            """{"parameter":"a random string with blanks","pointer":null}""",
            objectMapper.writeValueAsString(
                ApiErrorSource(parameter = "a random string with blanks")
            )
        )
    }
}
