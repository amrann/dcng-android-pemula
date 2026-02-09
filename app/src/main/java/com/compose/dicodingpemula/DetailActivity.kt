package com.compose.dicodingpemula

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.compose.dicodingpemula.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

  companion object {
    const val EXTRA_DATA = "extra_data"
  }

  private lateinit var bindingDetail: ActivityDetailBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    bindingDetail = ActivityDetailBinding.inflate(layoutInflater)
    setContentView(bindingDetail.root)
    ViewCompat.setOnApplyWindowInsetsListener(bindingDetail.main) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }
  }
}