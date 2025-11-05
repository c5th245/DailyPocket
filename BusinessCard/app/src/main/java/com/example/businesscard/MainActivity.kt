 package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        name = "Albren A. Cundangan Jr.",
                        position = "UC TVL ICT CCT Student",
                        cInf1 = stringResource(R.string._09105014206),
                        cInf2 = stringResource(R.string.ren_aru_bu),
                        cInf3 = stringResource(R.string.albrencundanganjr_gmail_com),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    position: String,
    cInf1: String,
    cInf2: String,
    cInf3: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = name,
            modifier = modifier
        )
        Text(
            text = position,
            fontSize = 20.sp,
            modifier = Modifier.padding(
                top = 8.dp
            )
        )
        Text(
            text = cInf1,
            fontSize = 16.sp,
            modifier = Modifier.padding(
                top = 8.dp
            )
        )
        Text(
            text = cInf2,
            fontSize = 16.sp,
            modifier = Modifier.padding(
                top = 16.dp
            )
        )
        Text(
            text = cInf3,
            fontSize = 16.sp,
            modifier = Modifier.padding(
                top = 4.dp
            )
        )
    }
}

@Preview(showBackground = true, name = "Business Card Preview")
@Composable
fun GreetingPreview()
     {
    BusinessCardTheme {
        BusinessCard(
            name = "Albren A. Cundangan Jr.",
            position = "UC TVL ICT CCT Student",
            cInf1 = stringResource(R.string._09105014206),
            cInf2 = stringResource(R.string.ren_aru_bu),
            cInf3 = stringResource(R.string.albrencundanganjr_gmail_com),
            modifier = Modifier.padding(16.dp)
        )
    }
}