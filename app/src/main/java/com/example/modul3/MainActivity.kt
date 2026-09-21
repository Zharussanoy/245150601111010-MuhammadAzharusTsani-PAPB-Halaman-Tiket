package com.example.modul3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modul3.ui.theme.Modul3Theme
import java.util.Locale

private val BiruUtama = Color(0xFF1E7BFF)
private val HijauTotal = Color(0xFF15803D)
private val MerahReset = Color(0xFFE53E3E)
private val AbuBackground = Color(0xFFF5F7FA)
private val AbuKotak = Color(0xFFF1F3F6)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Modul3Theme {
                PemesananTiket()
            }
        }
    }
}

fun formatRupiah(nilai: Int): String {
    return "Rp" + String.format(Locale.US, "%,d", nilai).replace(",", ".")
}

@Composable
fun PemesananTiket() {

    val hargaTiket = 25000
    var jumlahTiket by rememberSaveable { mutableIntStateOf(1) }

    val total = hargaTiket * jumlahTiket

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AbuBackground)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(BiruUtama)
                .statusBarsPadding()
                .padding(vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "🎟",
                fontSize = 40.sp
            )

            Text(
                text = "Pemesanan Tiket",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Pesan tiket dengan mudah!",
                color = Color(0xFFDCEEFF),
                fontSize = 14.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Harga Tiket",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = formatRupiah(hargaTiket),
                        color = BiruUtama,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "per tiket",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Jumlah Tiket",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Button(
                            onClick = {
                                if (jumlahTiket > 1) {
                                    jumlahTiket--
                                }
                            },
                            modifier = Modifier.size(52.dp),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = BiruUtama)
                        ) {
                            Text(
                                text = "−",
                                fontSize = 24.sp
                            )
                        }

                        Text(
                            text = jumlahTiket.toString(),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 12.dp)
                                .background(AbuKotak, RoundedCornerShape(10.dp))
                                .padding(vertical = 12.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Button(
                            onClick = {
                                jumlahTiket++
                            },
                            modifier = Modifier.size(52.dp),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = BiruUtama)
                        ) {
                            Text(
                                text = "+",
                                fontSize = 24.sp
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Total",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = formatRupiah(total),
                        color = HijauTotal,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                jumlahTiket = 1
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .navigationBarsPadding()
                .height(52.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MerahReset)
        ) {

            Text(
                text = "↻  RESET",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


// PREVIEW
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewPemesananTiket() {

    Modul3Theme {
        PemesananTiket()
    }
}