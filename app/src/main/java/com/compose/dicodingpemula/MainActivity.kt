package com.compose.dicodingpemula

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
  private lateinit var rvTeams: RecyclerView
  private val list = ArrayList<Teams>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    rvTeams = findViewById(R.id.rv_teams)
    rvTeams.setHasFixedSize(true)

    list.addAll(getListTeams())
    showRecyclerList()
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return super.onCreateOptionsMenu(menu)
  }

  @SuppressLint("Recycle")
  private fun getListTeams(): ArrayList<Teams> {
    val dataName = resources.getStringArray(R.array.arr_club_name)
    val dataInfo = resources.getStringArray(R.array.arr_club_info)
    val dataLogo = resources.obtainTypedArray(R.array.arr_club_logo)
    val listTeams = ArrayList<Teams>()
    for (i in dataName.indices) {
      val team = Teams(dataName[i], dataInfo[i], dataLogo.getResourceId(i, -1))
      listTeams.add(team)
    }
    return listTeams
  }

  private fun showRecyclerList() {
    rvTeams.layoutManager = LinearLayoutManager(this)
    val listTeamAdapter = ListTeamsAdapter(list)
    rvTeams.adapter = listTeamAdapter

    listTeamAdapter.setOnItemClickCallback(object : ListTeamsAdapter.OnItemClickCallback {
      override fun onItemClicked(data: Teams) {
        showSelectedTeam(data)
      }
    })
  }

  private fun showSelectedTeam(team: Teams) {
    Toast.makeText(this, "Kamu memilih " + team.name, Toast.LENGTH_SHORT).show()
  }
}