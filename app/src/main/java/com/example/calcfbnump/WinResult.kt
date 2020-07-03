        package com.example.calcfbnump

        import android.content.Intent
        import androidx.appcompat.app.AppCompatActivity
        import android.os.Bundle
        import kotlinx.android.synthetic.main.activity_win_result.*
        import kotlinx.android.synthetic.main.*

        class WinResult : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_win_result)

                supportActionBar?.setDisplayHomeAsUpEnabled(true)

                val Intent = intent

                var Res = Intent.getStringExtra("concatenationResult")

                textViewResult.text = Res.toString()


            }
        }
