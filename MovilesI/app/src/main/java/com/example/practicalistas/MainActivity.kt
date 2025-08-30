package com.example.practicalistas

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalistas.R
import com.example.practicalistas.ui.theme.PracticaListasTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaListasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Contactlist(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MessageList(modifier: Modifier = Modifier) {
    val nameList = arrayListOf(
        "Ana", "Juan", "Pedro", "Maria", "Luis", "Carmen", "Jose", "Lucia", "Miguel", "Sofia"
    )
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(nameList) { it ->
            Text(text = it, modifier = modifier.padding(8.dp))
        }
    }
}

@Composable
fun Contactlist(
    modifier: Modifier = Modifier
) {
    val contacts = getContactList()
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(contacts) { it ->
            ContactItem(it)
            HorizontalDivider(thickness = 1.dp)
        }
    }
}

@Composable
fun UrlImage(url: String, modifier: Modifier = Modifier) {
    var bitmap by remember { mutableStateOf<android.graphics.Bitmap?>(null) }
    LaunchedEffect(url) {
        withContext(Dispatchers.IO) {
            try {
                val input = URL(url).openStream()
                bitmap = BitmapFactory.decodeStream(input)
            } catch (e: Exception) {
                bitmap = null
            }
        }
    }
    if (bitmap != null) {
        androidx.compose.foundation.Image(
            bitmap = bitmap!!.asImageBitmap(),
            contentDescription = "Imagen de internet",
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Spacer(modifier = Modifier.size(8.dp))
    Row {
        UrlImage(
            url = contact.image,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Text(
            contact.name + " " + contact.lastName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
    Spacer(modifier = Modifier.size(8.dp))

}

fun getContactList(): ArrayList<Contact> {
    return arrayListOf(
        // Puedes usar cualquier URL de imagen que desees, por ejemplo:
        Contact(1, "Ana", "Perez", "123456789", "https://i.pinimg.com/736x/fd/2a/0f/fd2a0f981c333f3e22f2bc53407a0e37.jpg"),
        Contact(2, "Juan", "Gomez", "987654321", "https://i.pinimg.com/236x/db/05/8b/db058bf3632a98dc3db2f2b929cf40e5.jpg"),
        Contact(3, "Pedro", "Lopez", "456789123", "https://i.pinimg.com/originals/40/8c/e5/408ce55a7b47ca8e1ffcc3a6362a9dba.jpg"),
        Contact(4, "Maria", "Garcia", "789123456", "https://i.pinimg.com/474x/c1/ac/d5/c1acd517aa8260581f933b8cd1079a68.jpg"),
        Contact(5, "Luis", "Martinez", "321654987", "https://i.pinimg.com/originals/38/72/a3/3872a36faa9a98504d9b160493ad4630.jpg"),
        Contact(6, "Carmen", "Sanchez", "654987321", "https://i.pinimg.com/236x/fc/ed/34/fced34a8e6ebb9bb0d4c707f87e1c8d8.jpg"),
        Contact(7, "Jose", "Rodriguez", "147258369", "https://i.pinimg.com/236x/19/85/9f/19859f84f086d7e3e59e8f36369a6831.jpg"),
        Contact(8, "Lucia", "Hernandez", "369258147", "https://i.pinimg.com/236x/4e/be/98/4ebe98a08a1176c974c0229785e8e970.jpg"),
        Contact(9, "Miguel", "Diaz", "258147369", "https://wallpapers.com/images/hd/gaming-profile-pictures-4v1pzuz1uqbshmur.jpg"),
        Contact(10, "Sofia", "Alvarez", "159753486", "https://wallpapers.com/images/hd/gaming-profile-pictures-dmdrdbv3300u7oh5.jpg"),
        Contact(11, "Andres", "Torres", "357159486", "https://i.pinimg.com/236x/03/08/5b/03085b8c3a316617b8e6a0b24f56b960.jpg"),
        Contact(12, "Elena", "Ramirez", "753951486", "https://i.pinimg.com/736x/f0/bf/fd/f0bffd0ff5a838a63eba012dd1d20615.jpg"),
        Contact(13, "Javier", "Flores", "951357486", "https://i.pinimg.com/474x/d8/ab/e5/d8abe5eab0526f84bee527c9ebc406b4.jpg"),
        Contact(14, "Laura", "Vargas", "852456123", "https://i.pinimg.com/474x/4d/db/68/4ddb68bc6c4325e75f1175012a59dcae.jpg"),
        Contact(15, "Diego", "Castro", "456123852", "https://i.pinimg.com/originals/1d/58/ee/1d58ee368ea910aaf2442015c3509a3f.png"),
        Contact(16, "Marta", "Rojas", "123852456", "https://i.pinimg.com/736x/45/b4/4f/45b44fa1350278912e2ed4dcbb3018a5.jpg"),
        Contact(17, "Alvaro", "Mendez", "321654987", "https://i.pinimg.com/originals/19/4b/3b/194b3bc9ea89eec7e499b2723bce39d2.jpg"),
        Contact(18, "Natalia", "Cruz", "987321654", "https://i.pinimg.com/236x/ca/86/66/ca8666c5ee5169bfe9e81d1c99fe0e4e.jpg"),
        Contact(19, "Sergio", "Morales", "654123789", "https://i.pinimg.com/236x/ae/8d/7e/ae8d7edbff7446181db4e929381b46dd.jpg"),
        Contact(20, "Paula", "Ortiz", "789456123", "https://i.pinimg.com/originals/dc/65/ee/dc65ee9c178f007db9c287c5662edd23.jpg"),
    )
}

@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    PracticaListasTheme {
        Contactlist()
    }
}

@Preview(showBackground = true)
@Composable
fun ContactItemPreview() {
    PracticaListasTheme {
        ContactItem(Contact(1, "Ana", "Perez", "123456789", "https://i.pinimg.com/originals/27/b4/42/27b44239c401a17e90a510f4b47f7796.jpg"))
    }
}


@Preview(showBackground = true)
@Composable
fun MessageListPreview() {
    PracticaListasTheme {
        MessageList()
    }
}