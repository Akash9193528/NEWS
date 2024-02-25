package ap.akash.news

data class NewsApiResponse(
    val articles: List<newsArticle>,
    val status: String,
    val totalResults: Int
)