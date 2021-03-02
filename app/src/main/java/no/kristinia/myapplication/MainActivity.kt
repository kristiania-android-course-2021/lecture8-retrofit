package no.kristinia.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import no.kristinia.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        initListeners()
    }

    private fun initListeners() {
        binding.previousButton.setOnClickListener {
            viewModel.loadPreviousComic()
        }
        binding.nextButton.setOnClickListener {
            viewModel.loadNextComic()
        }
    }

    private fun initObservers() {
        viewModel.currentComic.observe(this) { comic ->
            binding.title.text = comic.title
            Glide.with(this).load(comic.img).into(binding.img)
        }

        viewModel.error.observe(this) {
            Snackbar.make(
                binding.root,
                "Failed to fetch comic. Do you have an internet connection?",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

}