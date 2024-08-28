package com.threeoldguys.pocandroidtef

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Nfc
import androidx.compose.material.icons.filled.Print
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.threeoldguys.pocandroidtef.ui.theme.POCAndroidTEFTheme
import br.com.setis.safra.integracaosafra.Gerenciador

class MainActivity : ComponentActivity() {

    private lateinit var gerenciador: Gerenciador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val backgroundColor = Color(0xFFC7BFA5).toArgb()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = backgroundColor
        window.navigationBarColor = backgroundColor
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true

        setContent {
            POCAndroidTEFTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFC7BFA5))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = androidx.compose.ui.Alignment.Start
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxSize()
                .weight(0.3f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = androidx.compose.ui.Alignment.Start
        ) {
            ActionButton(
                text = "Pagar",
                icon = Icons.Default.CreditCard,
                onClick = { /* Ação para pagar */ }
            )

            ActionButton(
                text = "Imprimir",
                icon = Icons.Default.Print,
                onClick = { /* Ação para imprimir */ }
            )

            ActionButton(
                text = "Ler NFC",
                icon = Icons.Default.Nfc,
                onClick = { /* Ação para leitura de NFC */ }
            )
        }
    }
}

@Composable
fun ActionButton(text: String, icon: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4C3824),
            contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    POCAndroidTEFTheme {
        MainScreen()
    }
}
