package com.omrilhn.bizcardapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.omrilhn.bizcardapp.ui.theme.BizCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(),
                    color = Color.White
                ) {
                    CreateBizCard()

                }
            }
        }
    }
}

@Composable
fun CreateBizCard()
{
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            colors  = CardDefaults.cardColors(
                containerColor = Color.White))
            {
                Column(modifier = Modifier
                    .height(300.dp)
                    .width(400.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally){

                    CreateImageProfile()
                    Divider(thickness = 0.5.dp, color = Color.Blue)
                    CreateInfo()
                    Button(onClick = {
                        buttonClickedState.value  != buttonClickedState.value //When its true set it to false vise versa
                    }) {
                        Text("Portfolio",
                            style = MaterialTheme.typography.labelSmall)
                    }
                    if(buttonClickedState.value)
                    {
                        Content()
                    }else{
                        Box(){
                            
                        }
                    }
                }
            }
    }
}
@Preview
@Composable
fun Content()
{
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(width = 2.dp,color = Color.LightGray)){
            Portfolio(data = listOf("Project1","Project2","Project3",
                "Project3",
                "Project3"  ))

        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){ item ->
            //item: every one of the elements
            Text(item)
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp))
    {
        Text(
            text = "Omer I.",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "@theilhnCompose",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier)//With that parameter type it is optional whether you add parameter or not
 {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 5.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)//Set ALPHA on the foreground of the image
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardAppTheme {
        CreateBizCard()
    }
}