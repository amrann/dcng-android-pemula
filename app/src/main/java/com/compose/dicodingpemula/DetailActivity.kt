package com.compose.dicodingpemula

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.compose.dicodingpemula.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

  companion object {
    const val EXTRA_DATA = "extra_data"
  }

  private lateinit var bindingDetail: ActivityDetailBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    bindingDetail = ActivityDetailBinding.inflate(layoutInflater)
    setContentView(bindingDetail.root)

    supportActionBar?.elevation = 0f
    supportActionBar?.setHomeButtonEnabled(true)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    val dataShare = if (Build.VERSION.SDK_INT >= 33) {
      intent.getParcelableExtra(EXTRA_DATA, Teams::class.java)
    } else {
      @Suppress("DEPRECATION")
      intent.getParcelableExtra(EXTRA_DATA)
    }
    if (dataShare != null) {
      bindingDetail.txtTitle.text = dataShare.name
      bindingDetail.txtDesc.text = dataShare.info
      bindingDetail.imgLogo.setImageResource(dataShare.logo)
    }
  }
}