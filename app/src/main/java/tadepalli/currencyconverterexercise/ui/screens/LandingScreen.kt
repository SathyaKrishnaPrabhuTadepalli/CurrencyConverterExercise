package tadepalli.currencyconverterexercise.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    landingScreenViewModel: LandingScreenViewModel
) {
    LandingScreenContent(
        modifier = modifier,
        currencyName1 = "USD",
        currencyName2 = "INR",
        onFlipClicked = {
        }
    )
}

@Composable
fun LandingScreenContent(
    modifier: Modifier = Modifier,
    currencyName1: String = "",
    currencyName2: String = "",
    onFlipClicked: () -> Unit
) {
    Column(
        modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        CurrencyNameAndTextField(
            currencyName = currencyName1,
            currencyValue = "",
            inputEnabled = true,
            onValueChange = {
            }
        )
        CurrencyNameAndTextField(
            currencyName = currencyName2,
            currencyValue = "",
            inputEnabled = false,
            onValueChange = {
            }
        )
        FlipAction(
            modifier = Modifier.fillMaxWidth(),
            onFlipClicked = {
                onFlipClicked()
            }
        )
    }
}


@Composable
fun CurrencyNameAndTextField(
    modifier: Modifier = Modifier,
    currencyName: String,
    currencyValue: String,
    inputEnabled: Boolean,
    onValueChange: (String) -> Unit,
) {
    var textInput by remember { mutableStateOf(currencyValue) }
    Row(
        modifier = modifier,
    ) {
        Text(
            text = currencyName,
            modifier = Modifier.padding(top = 16.dp, end = 8.dp),
        )
        TextField(
            value = textInput,
            onValueChange = {
                textInput = it
                onValueChange(it)
            },
            enabled = inputEnabled,
            singleLine = true,
            modifier = Modifier.padding(top = 16.dp, end = 8.dp, start = 8.dp, bottom = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun FlipAction(
    modifier: Modifier = Modifier,
    onFlipClicked: () -> Unit
) {
    Row(
        modifier = modifier,
    ) {
        Button(
            modifier = Modifier.weight(1f).padding(all = 8.dp),
            onClick = {
                onFlipClicked()
            },
        ) {
            Text(text = "Flip Currency")
        }
    }
}