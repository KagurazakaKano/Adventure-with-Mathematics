package top.kanocui.adventurewithmathematics

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.game_start_menu)

        val startGameButton: Button = findViewById(R.id.start_game_button)

        startGameButton.setOnClickListener {
            val intent = Intent(this, SelectModeActivity::class.java)
            startActivity(intent)
        }
    }
}