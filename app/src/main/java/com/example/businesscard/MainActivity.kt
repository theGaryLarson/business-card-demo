package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    placard("Gary M. Larson", "Android Developer")
                }
            }
        }
    }
}

@Composable
fun displayBusinessCard(name: String, title: String, phone: String,
                        email: String, socialMedia: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {

        placard(name, title)
        Spacer(Modifier.height(75.dp))
        contactInfo(
            phone = phone,
            socialMedia = socialMedia,
            email = email
        )
    }
}
@Composable
fun placard(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding( bottom = 4.dp, start = 8.dp, end = 8.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .size(125.dp)
                .background(Color(7, 48, 66))
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color(61, 220, 132),
            modifier = modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun contactInfo(phone: String, socialMedia: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        contactDetail(icon = Icons.Rounded.Call, contactInfo = phone)
        contactDetail(icon = Icons.Rounded.Email, contactInfo = email)
//        contactDetail(painterResource(id = R.drawable.linked_in), contactInfo = socialMedia)
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .padding(4.dp)

        ) {
            Icon(
                painterResource(id = R.drawable.linked_in),
                contentDescription = "contact source",
                tint = Color(7, 48, 66),
                modifier = modifier.padding(end = 8.dp)
            )
            Text(
                text = socialMedia,
                fontSize = 11.sp,
                modifier = modifier.align(Alignment.CenterVertically)
            )
        }
    }

}

@Composable
fun contactDetail(icon: ImageVector, contactInfo:String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(4.dp)

    ) {
        Icon(
            icon,
            contentDescription = "contact source",
            tint = Color(7, 48, 66),
            modifier = modifier
                .padding(end = 8.dp)

        )
        Text(
            text = contactInfo,
            fontSize = 11.sp,
            modifier = modifier.align(Alignment.CenterVertically)
        )
    }
}




@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        displayBusinessCard(name = "Gary M. Larson", title = "Android Developer", phone = "206.332.9617", email = "gary.larson.dev@gmail.com", socialMedia = "linkedin.com/in/theGaryLarson/")
    }
}