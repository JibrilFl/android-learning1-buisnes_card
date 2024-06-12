package com.example.buisnes_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisnes_card.ui.theme.Buisnes_cardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Buisnes_cardTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    Box (
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color(0xFD97AD8B))
                    ) {
                        Home()
                        AllContacts()
                    }
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.main_photo)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image (
            painter = image,
            contentDescription = null,
            modifier = modifier
                .width(150.dp)
        )

        Text (
            text = stringResource(R.string.buisnes_dev_name),
            fontWeight = FontWeight(700),
            fontSize = 25.sp,
            modifier = modifier
                .padding(top = 8.dp, bottom = 6.dp)
        )

        Text (
            text = stringResource(R.string.card_subtitle),
            color = Color(0xFF0B8541),
            fontWeight = FontWeight(700),
            fontSize = 14.sp
        )
    }
}

@Composable
fun Contacts(
    image: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    val imagePhone = painterResource(image)

    Row (
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Image (
            painter = imagePhone,
            contentDescription = null,
            modifier = modifier
                .width(20.dp)
                .height(20.dp)
        )
        Spacer(modifier = modifier.width(8.dp))

        Text (
            text = text,
            modifier = Modifier.weight(1.5f),
            color = Color(0xFF0B8541),
            fontWeight = FontWeight(700)
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun AllContacts(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 35.dp)
    ) {
        Contacts(
            image = R.drawable.phone,
            text = stringResource(R.string.phone_number)
        )
        Contacts(
            image = R.drawable.share,
            text = stringResource(R.string.tag_dev)
        )
        Contacts(
            image = R.drawable.mail,
            text = stringResource(R.string.email)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Buisnes_cardTheme {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFD97AD8B))
        ) {
            Home()
            AllContacts()
        }
    }
}