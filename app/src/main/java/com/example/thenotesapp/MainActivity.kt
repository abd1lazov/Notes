package com.example.thenotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.thenotesapp.dataBase.NoteDataBase
import com.example.thenotesapp.repository.NoteRepository
import com.example.thenotesapp.viewModel.NoteViewModel
import com.example.thenotesapp.viewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel(){
        val noteRepository = NoteRepository(NoteDataBase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application,noteRepository)
        noteViewModel = ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}