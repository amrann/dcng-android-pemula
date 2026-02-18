package com.compose.dicodingpemula

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.compose.dicodingpemula.databinding.ActivityAboutBinding
import com.compose.dicodingpemula.databinding.ActivityDetailBinding

class AboutActivity : AppCompatActivity() {
  private lateinit var bindingAbout: ActivityAboutBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    bindingAbout = ActivityAboutBinding.inflate(layoutInflater)
    setContentView(bindingAbout.root)

    supportActionBar?.elevation = 0f
    supportActionBar?.setHomeButtonEnabled(true)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    bindingAbout.txtName.text = "Meraaan"
    bindingAbout.txtEmail.text = "bandolencorp[at]gmail[dot]com"
  }
}