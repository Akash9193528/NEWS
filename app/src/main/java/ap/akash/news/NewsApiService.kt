package ap.akash.news

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    fun getEverythingNews(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String = "in"
    ): Call<NewsApiResponse>
}
