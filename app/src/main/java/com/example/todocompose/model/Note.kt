package com.example.todocompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

fun getNotes(): ArrayList<Note> {
    val list = ArrayList<Note>()
    list.add(Note(title = "note1", description = "description"))
    list.add(Note(title = "note2", description = "description"))
    list.add(Note(title = "note3", description = "description"))
    list.add(Note(title = "note4", description = "description"))
    list.add(Note(title = "note5", description = "description"))
    list.add(Note(title = "note6", description = "description"))
    list.add(Note(title = "note7", description = "description"))
    list.add(Note(title = "note8", description = "description"))
    list.add(Note(title = "note9", description = "description"))
    list.add(Note(title = "note10", description = "description"))
    list.add(Note(title = "note11", description = "description"))
    list.add(Note(title = "note12", description = "description"))
    return list
}
