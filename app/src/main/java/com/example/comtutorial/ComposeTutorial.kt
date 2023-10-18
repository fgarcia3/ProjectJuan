package com.example.comtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comtutorial.ui.theme.ComTutorialTheme

data class Driver(val name: String, val team: String, val number: Int)

class ComposeTutorial : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyView()
                }
            }
        }
    }
}

@Composable
fun MyView() {
    Column {
        Sim(
            Driver(
                name = "Balta",
                team = "XBB",
                number = 88
            )
        )


        Sim(
            Driver(
                name = "Alexis",
                team = "Piki",
                number = 22
            )
        )
    }
}

@Composable
fun Sim(driver: Driver) {
    ComTutorialTheme {
        Surface {

        }
    }
    Row(modifier = Modifier.height(100.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .border(1.5.dp, color = Color.Black, shape = CircleShape)
                .background(Color.Green)
                .size(100.dp)
                .clip(CircleShape)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Green)
                .fillMaxSize()
        ) {
            Text(text = driver.name)
            Text(text = driver.team)
            Text(text = "Dorsal: ${driver.number}")
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Ver detalles del piloto")
            }
        }
    }
}

@Composable
fun DriversView(drivers: List<Driver>) {
    LazyColumn() {
        items(drivers) { driver ->
            Sim(driver)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyView()
}

@Preview
@Composable
fun PreviewDriversview() = DriversView(
    drivers = listOf(
        Driver("Armando", "Piki", 8),
        Driver("Rolf", "Piki", 12)
    )
)