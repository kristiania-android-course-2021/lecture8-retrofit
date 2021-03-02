package no.kristinia.myapplication.data

import no.kristinia.myapplication.data.domain.Comic
import retrofit2.http.GET
import retrofit2.http.Path

interface XkcdService {

    @GET("info.0.json")
    suspend fun getLatest(): Comic

    @GET("{comicId}/info.0.json")
    suspend fun getComic(@Path("comicId") comicId: String): Comic

}