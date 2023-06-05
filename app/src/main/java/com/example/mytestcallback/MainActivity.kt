package com.example.mytestcallback

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytestcallback.ui.theme.MyTestCallBackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTestCallBackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   //MyApp()
                    Greeting(onTestClicked = {
                        Toast.makeText(this, "Coucou", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val context = LocalContext.current
    var shouldShowOnboarding by remember { mutableStateOf(true) }




    // OnboardingScreen(onContinueClicked = { /*TODO*/ })
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Composable
fun Greeting(onTestClicked: () -> Unit , modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedButton(
            colors = ButtonDefaults.buttonColors(
                contentColorFor(backgroundColor = MaterialTheme.colorScheme.inversePrimary)
            ),
            modifier = Modifier,
            onClick =  onTestClicked
        ) {
            Text(
                text = "Hello"
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    MyTestCallBackTheme {
       Greeting(onTestClicked = {})
        //OnboardingScreen(onContinueClicked = { /*TODO*/ })
    }
}