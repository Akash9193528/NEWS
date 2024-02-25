package ap.akash.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ap.akash.news.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val apiKey = "dc44a116dde0450aa53e176692d99d47"
    private lateinit var adapter: NewsAdapter

private val binding : ActivityMainBinding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter(emptyList())
        binding.recyclerView.adapter = adapter







        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsApiService = retrofit.create(NewsApiService::class.java)

        val call = newsApiService.getEverythingNews(apiKey)

        call.enqueue(object : Callback<NewsApiResponse> {
            override fun onResponse(call: Call<NewsApiResponse>, response: Response<NewsApiResponse>) {
                if (response.isSuccessful) {
                    val newsList = response.body()?.articles ?: emptyList()
                    adapter.updateNewsList(newsList)
                } else {
                    val errorMessage = "Failed to fetch news. Status code: ${response.code()}"
                    Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Network error: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }




    }
