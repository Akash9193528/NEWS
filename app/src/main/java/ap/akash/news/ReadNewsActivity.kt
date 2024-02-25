package ap.akash.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ap.akash.news.databinding.ActivityReadNewsBinding
import com.squareup.picasso.Picasso

class ReadNewsActivity : AppCompatActivity() {
    private val binding : ActivityReadNewsBinding by lazy {
        ActivityReadNewsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val title = intent.getStringExtra(NEWS_TITLE) ?: ""
        val description = intent.getStringExtra(DESCRIPTION)
        val image = intent.getStringExtra(NEWS_IMAGE)
       // val url = intent.getStringExtra(NEW_URL)


    binding.TextView.text = title

        binding.TextView.text = title
        binding.Description.text = description

  Picasso.get().load(image).into(binding.imageView)


    }



    companion object{
        const val NEWS_IMAGE = " Image"
        const val NEWS_TITLE = " title"
        const val NEW_URL = "url"
        const val DESCRIPTION = "description"
    }

}