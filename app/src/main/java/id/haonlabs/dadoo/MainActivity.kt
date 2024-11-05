package id.haonlabs.dadoo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.haonlabs.dadoo.ui.theme.DadooTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DadooTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          MainApp(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}

@Composable
fun MainApp(modifier: Modifier) {
  var dice by remember { mutableIntStateOf(1) }
  Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = modifier.fillMaxSize()) {
        when (dice) {
          1 -> Image(painter = painterResource(R.drawable.dice_1), contentDescription = "Dice")
          2 -> Image(painter = painterResource(R.drawable.dice_2), contentDescription = "Dice")
          3 -> Image(painter = painterResource(R.drawable.dice_3), contentDescription = "Dice")
          4 -> Image(painter = painterResource(R.drawable.dice_4), contentDescription = "Dice")
          5 -> Image(painter = painterResource(R.drawable.dice_5), contentDescription = "Dice")
          6 -> Image(painter = painterResource(R.drawable.dice_6), contentDescription = "Dice")
          else -> Image(painter = painterResource(R.drawable.dice_1), contentDescription = "Dice")
        }
        Button(modifier = modifier.padding(top = 40.dp), onClick = { dice = (1..6).random() }) {
          Text(text = "Roll")
        }
      }
}

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
  DadooTheme {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
      MainApp(modifier = Modifier.padding(innerPadding))
    }
  }
}
