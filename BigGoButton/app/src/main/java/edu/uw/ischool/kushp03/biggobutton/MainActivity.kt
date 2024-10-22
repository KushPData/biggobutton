package edu.uw.ischool.kushp03.biggobutton

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.graphics.Color
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var count = 0
        val button:Button = findViewById(R.id.button)

        button.setOnClickListener {
            count += 1
            val text: String
            if(count == 1) {
                text = "You have pushed me 1 time!"
                button.text = text
            } else {
                text = "You have pushed me $count times!"
                button.text = text
            }

            button.setTextColor(colorGenerator())
            button.setBackgroundColor(colorGenerator())
        }
    }

    private fun colorGenerator(): Int {
        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)

        return Color.rgb(red, green, blue)
    }
}