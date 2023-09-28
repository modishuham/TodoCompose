package com.example.todocompose.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todocompose.db.NoteDao
import com.example.todocompose.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val noteDao: NoteDao) : ViewModel() {

    var notes = MutableStateFlow<List<Note>>(emptyList())

    fun saveNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteDao.insert(note)
        }
    }

    fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            notes.value = noteDao.getAllNotes()
        }
    }
}