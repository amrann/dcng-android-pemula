package com.compose.dicodingpemula

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Teams(
  val name: String,
  val info: String,
  val logo: Int
) : Parcelable
