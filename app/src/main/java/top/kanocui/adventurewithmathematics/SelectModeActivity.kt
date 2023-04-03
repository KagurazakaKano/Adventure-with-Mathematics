package top.kanocui.adventurewithmathematics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SelectModeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Please select the mode you want to play!"
        setContentView(R.layout.game_mode_selection)
    }
}
