package com.tomascasta.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora()
        }
    }
}
@Composable
fun Calculadora() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier.weight(1f).padding(30.dp).fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ){
            Texto("0", Color.White, size = 80f , alignment = Alignment.TopEnd)
        }

        Column(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.fillMaxWidth()){
                BotonCalculadora("C", modifier = Modifier.weight(2f))
                BotonCalculadora("⌫", modifier = Modifier.weight(1f))
                BotonCalculadora("/", modifier = Modifier.weight(1f))
            }

            Row(modifier = Modifier.fillMaxWidth()){
                BotonCalculadora("7", modifier = Modifier.weight(1f))
                BotonCalculadora("8", modifier = Modifier.weight(1f))
                BotonCalculadora("9", modifier = Modifier.weight(1f))
                BotonCalculadora("*", modifier = Modifier.weight(1f))
            }
            Row(modifier = Modifier.fillMaxWidth()){
                BotonCalculadora("4", modifier = Modifier.weight(1f))
                BotonCalculadora("5", modifier = Modifier.weight(1f))
                BotonCalculadora("6", modifier = Modifier.weight(1f))
                BotonCalculadora("-", modifier = Modifier.weight(1f))
            }


            Row(modifier = Modifier.fillMaxWidth()){
                BotonCalculadora("1", modifier = Modifier.weight(1f))
                BotonCalculadora("2", modifier = Modifier.weight(1f))
                BotonCalculadora("3", modifier = Modifier.weight(1f))
                BotonCalculadora("+", modifier = Modifier.weight(1f))
            }

            Row(modifier = Modifier.fillMaxWidth()){
                BotonCalculadora("0", modifier = Modifier.weight(2f))
                BotonCalculadora(".", modifier = Modifier.weight(1f))
                BotonCalculadora("=", modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun BotonCalculadora(
    buttonSimbolo: String,
    modifier: Modifier = Modifier){

    val colorFondo = when (buttonSimbolo) {
        "⌫", "/", "*", "-", "+" -> Color.Gray
        "C", "=" -> Color.LightGray
        else -> Color.DarkGray
    }

    Button(
        onClick = {},
        modifier = modifier.padding(3.dp).size(80.dp).clip(CircleShape),
        colors = ButtonDefaults.buttonColors(containerColor = colorFondo)){
        Texto(text = buttonSimbolo, Color.White, size = 35f)
    }
}

@Composable
fun Texto(
    text : String,
    color: Color = Color.Black,
    size : Float= 30f,
    alignment: Alignment = Alignment.Center,
    fontWeight: FontWeight = FontWeight.Normal
){
    Text(text, color = color, fontSize = size.sp, fontWeight = fontWeight)
}

@Preview
@Composable
fun PreviewCalculadora(){
    Calculadora()
}