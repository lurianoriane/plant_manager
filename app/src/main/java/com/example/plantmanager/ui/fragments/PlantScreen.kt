import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantmanager.R
import com.example.plantmanager.ui.viewmodels.PlantUiState
import com.example.plantmanager.ui.viewmodels.PlantViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun PlantScreen(
    onTimePickerClicked: () -> Unit,
    onConfirmClicked: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val viewModel = getViewModel<PlantViewModel>()
    val uiState by viewModel.uiState.collectAsState(PlantUiState())
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background_color))
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.plant_image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(220.dp)
                .padding(bottom = 50.dp)
        )
        TextField(
            value = uiState.name,
            onValueChange = { viewModel.updateName(it) },
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center
            ),
            label = {
                Text(text = stringResource(R.string.choose_plant_name_text))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Go
            ),
            singleLine = true,
            modifier = Modifier.padding(bottom = 50.dp)
        )
        TextField(
            value = uiState.place,
            onValueChange = { viewModel.updatePlace(it) },
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center
            ),
            label = {
                Text(text = stringResource(R.string.choose_plant_place))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Go
            ),
            singleLine = true,
            modifier = Modifier.padding(bottom = 50.dp)
        )
        Button(
            onClick = {
                scope.launch {
                    viewModel.save()
                    onConfirmClicked()
                }
            },
        ) {
            Text(
                text = stringResource(R.string.save_button),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PlantScreenPreview() {
    PlantScreen(onTimePickerClicked = {}, onConfirmClicked = {})
}


