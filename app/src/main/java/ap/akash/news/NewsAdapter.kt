package ap.akash.news


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class NewsAdapter( private var newsList: List<newsArticle>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {




    fun updateNewsList(newNewsList: List<newsArticle>) {
        newsList = newNewsList
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val newsImageView: ImageView = itemView.findViewById(R.id.newsImageView)




        fun bind(newsArticle: newsArticle) {
            titleTextView.text = newsArticle.title
            descriptionTextView.text = newsArticle.description

            Picasso.get().load(newsArticle.urlToImage).error(R.drawable.ic_launcher_background)
                .into(newsImageView)


        }

    }


}
