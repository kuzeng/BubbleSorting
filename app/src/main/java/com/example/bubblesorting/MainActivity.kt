package com.example.bubblesorting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bubblesorting.ui.theme.BubbleSortingTheme
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BubbleSortingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BubbleSortApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BubbleSortApp(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TopAppBar(
            title = {
                Text(stringResource(R.string.title))
            }
        )
        TextFieldLayout()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldLayout(modifier: Modifier = Modifier) {
    var input by remember {
        mutableStateOf("")
    }
    var numbers by remember {
        mutableStateOf(listOf<String>())
    }

    var isValid by remember {
        mutableStateOf(true)
    }

    var steps by remember {
        mutableStateOf(listOf<String>())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = input,
                placeholder = {
                    Text(
                        text = stringResource(R.string.inputPrompt),
                        fontSize = 12.sp
                    )
                },
                onValueChange = {
                    input = it
                },
                modifier = modifier.weight(1f)
            )
        }

        Spacer(modifier = modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                isValid = InputUtil.validateNumberInput(input)
                if (isValid) {
                    var strings = input.split(",")
                    val numberArray = strings.map { it.toInt() }
                    steps = BubbleSortUtil.buildBubbleSortStringArray(numberArray.toIntArray())

                    numbers += steps
                    input = ""

                }
            }) {
                Text(text = stringResource(R.string.sort))
            }

            Spacer(modifier = modifier.width(16.dp))

            Button(onClick = {
                input = ""
                numbers = listOf<String>()
                isValid = true

            }) {
                Text(text = stringResource(R.string.reset))
            }

            Spacer(modifier = modifier.width(16.dp))

            Button(onClick = {
                exitProcess(-1)
            }) {
                Text(text = stringResource(R.string.quit))
            }
        }

        if (!isValid) {
            Text(
                text = stringResource(R.string.invalidInputMessage),
                color = Color.Red,
                modifier = Modifier
                    .padding(16.dp)
            )
        }

        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(numbers) {currentName ->
                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BubbleSortingPreview() {
    BubbleSortingTheme {

    }
}