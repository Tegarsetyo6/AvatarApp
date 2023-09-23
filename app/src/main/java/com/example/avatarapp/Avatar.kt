package com.example.avatarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avatarapp.ui.theme.AvatarAppTheme

class Avatar : ComponentActivity() {
    private var username = "";
    private var password = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("username") ?: "";
        val password = intent.getStringExtra("password") ?: "";

        setContent {
            AvatarAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AvatarScreen()
                }
            }
        }
    }
}

@Composable
fun AvatarScreen(){
    val beard = painterResource(id = R.drawable.beard)
    val body = painterResource(id = R.drawable.body)
    val eyebrow = painterResource(id = R.drawable.eyebrow)
    val eyes = painterResource(id = R.drawable.eyes)
    val hair = painterResource(id = R.drawable.hair)
    val moustache = painterResource(id = R.drawable.moustache)

    val hairVisibility = remember { mutableStateOf(false) }
    val moustacheVisibility = remember { mutableStateOf(false) }
    val eyebrowVisibility = remember { mutableStateOf(false) }
    val beardVisibility = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
            painter = body,
            contentDescription = null,
        )
        Image(
            painter = beard,
            contentDescription = null,
            modifier = Modifier
                .offset(y = 107.dp)
                .alpha(if (beardVisibility.value) 1f else 0f)
        )
        Image(
            painter = eyebrow,
            contentDescription = null,
            modifier = Modifier
                .offset(y = (-80).dp)
                .alpha(if (eyebrowVisibility.value) 1f else 0f)
        )
        Image(
            painter = eyes,
            contentDescription = null,
            modifier = Modifier
                .offset(y = (-55).dp)
        )
        Image(
            painter = hair,
            contentDescription = null,
            modifier = Modifier
                .offset(y = (-150).dp)
                .alpha(if (hairVisibility.value) 1f else 0f)
        )
        Image(
            painter = moustache,
            contentDescription = null,
            modifier = Modifier
                .offset(y = 50.dp)
                .alpha(if (moustacheVisibility.value) 1f else 0f)
        )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.width(120.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Checkbox(
                    checked = hairVisibility.value,
                    onCheckedChange = { hairVisibility.value = it },
                    enabled = true,
                    colors = CheckboxDefaults.colors(Color.Green),
                )
                Text(text = "Rambut", modifier = Modifier.padding(start = 50.dp))
            }

            Box(
                modifier = Modifier.width(120.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Checkbox(
                    checked = eyebrowVisibility.value,
                    onCheckedChange = { eyebrowVisibility.value = it },
                    enabled = true,
                    colors = CheckboxDefaults.colors(Color.Green),
                )
                Text(text = "Alis", modifier = Modifier.padding(start = 50.dp))
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.width(120.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Checkbox(
                    checked = moustacheVisibility.value,
                    onCheckedChange = { moustacheVisibility.value = it },
                    enabled = true,
                    colors = CheckboxDefaults.colors(Color.Green),
                )
                Text(text = "Kumis", modifier = Modifier.padding(start = 50.dp))
            }

            Box(
                modifier = Modifier.width(120.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Checkbox(
                    checked = beardVisibility.value,
                    onCheckedChange = { beardVisibility.value = it },
                    enabled = true,
                    colors = CheckboxDefaults.colors(Color.Green),
                )
                Text(text = "Janggut", modifier = Modifier.padding(start = 50.dp))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Created by Tegar Setyo Wicaksono")
        Text(text = "NIM : 215150400111008")
    }
    


}