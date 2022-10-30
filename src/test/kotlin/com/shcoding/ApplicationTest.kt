package com.shcoding

import com.shcoding.domain.repository.HeroRepository
import com.shcoding.domain.util.ServerResponse
import io.ktor.http.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.shcoding.routes.util.EndPoints
import io.ktor.client.utils.*
import io.ktor.client.utils.EmptyContent.status
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.java.KoinJavaComponent.inject

class ApplicationTest {
    private val repository: HeroRepository by inject(HeroRepository::class.java)

    @Test
    fun testRoot() = testApplication {
        application {
            module()
        }
        client.get(EndPoints.ROOT).apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals(expected = "Welcome to boruto anime server powered by ktor!", bodyAsText())
        }
    }

    @Test
    fun testAllHeroes() = testApplication {

        application { module() }

        client.get(EndPoints.ALL_HEROES).apply {

            assertEquals(HttpStatusCode.OK, status)
            val expected = ServerResponse(
                success = true,
                message = "Ok",
                nextPage = 2,
                prevPage = null,
                heroes = repository.page1
            )
            val actual = Json.decodeFromString<ServerResponse>(bodyAsText())

            assertEquals(expected = expected, actual = actual)
        }

    }
}