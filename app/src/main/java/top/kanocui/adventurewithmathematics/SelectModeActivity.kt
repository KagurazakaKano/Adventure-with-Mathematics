package top.kanocui.adventurewithmathematics


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import top.kanocui.adventurewithmathematics.scenes.bank.BankScene1
import top.kanocui.adventurewithmathematics.scenes.bank.BankScene2
import top.kanocui.adventurewithmathematics.scenes.market.MarketScene1
import top.kanocui.adventurewithmathematics.scenes.market.MarketScene2

class SelectModeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Please select the mode you want to play!"
        setContentView(R.layout.game_mode_selection)

        val marketScene1Button = findViewById<Button>(R.id.market_scene1)
        val marketScene2Button = findViewById<Button>(R.id.market_scene_2)
        val bankScene1Button = findViewById<Button>(R.id.bank_scene_1)
        val bankScene2Button = findViewById<Button>(R.id.bank_scene_2)

        marketScene1Button.setOnClickListener {
            val intent = Intent(this, MarketScene1::class.java)
            startActivity(intent)
        }

        marketScene2Button.setOnClickListener {
            val intent = Intent(this, MarketScene2::class.java)
            startActivity(intent)
        }

        bankScene1Button.setOnClickListener {
            val intent = Intent(this, BankScene1::class.java)
            startActivity(intent)
        }

        bankScene2Button.setOnClickListener {
            val intent = Intent(this, BankScene2::class.java)
            startActivity(intent)
        }
    }
}
