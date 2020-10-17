package com.multithread.characters.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.multithread.characters.R
import com.multithread.characters.databinding.ActivityHoimeBinding
import com.multithread.characters.databinding.ActivityMainBinding
import com.multithread.characters.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_hoime.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoime)
        setUpUi()
        setUpObserver()
    }

    private fun setUpObserver() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CharacterAdapter(arrayListOf())

    }

    private fun setUpUi() {
        TODO("Not yet implemented")
    }
}