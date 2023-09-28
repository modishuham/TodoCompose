package com.example.todocompose.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.todocompose.TodoApplication
import com.example.todocompose.model.Note
import com.example.todocompose.ui.theme.BackgroundColor
import com.example.todocompose.ui.theme.Pink80
import com.example.todocompose.ui.theme.Red
import dagger.hilt.android.qualifiers.ApplicationContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNoteScreen(
    navController: NavHostController? = null,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
) {
    val title = remember { mutableStateOf("") }
    val titleError = remember { mutableStateOf(false) }
    val description = remember { mutableStateOf("") }
    val descriptionError = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            OutlinedTextField(
                value = title.value,
                onValueChange = {
                    title.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                label = { Text("Title") }
            )
            if (titleError.value) {
                Text(text = "Can't empty", color = Red)
            }
            OutlinedTextField(
                value = description.value, onValueChange = {
                    description.value = it
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                label = { Text("Description") }
            )
            if (descriptionError.value) {
                Text(text = "Can't empty", color = Red)
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onClick = {
                    saveData(
                        title.value,
                        description.value,
                        titleError,
                        descriptionError,
                        homeScreenViewModel
                    )
                }) {
                Text(text = "Save Note")
            }
        }
    }
}

private fun saveData(
    title: String,
    description: String,
    titleError: MutableState<Boolean>,
    descriptionError: MutableState<Boolean>,
    homeScreenViewModel: HomeScreenViewModel
) {
    titleError.value = title.isEmpty()
    descriptionError.value = description.isEmpty()
    if (title.isNotEmpty() && description.isNotEmpty()) {
        homeScreenViewModel.saveNote(Note(title, description))
        Toast.makeText(TodoApplication.appContext, "Note saved", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CreateNoteScreen()
}