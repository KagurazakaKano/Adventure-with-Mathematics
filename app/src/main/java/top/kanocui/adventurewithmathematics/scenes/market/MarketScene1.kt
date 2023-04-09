package top.kanocui.adventurewithmathematics.scenes.market

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import top.kanocui.adventurewithmathematics.R
import kotlin.random.Random



class MarketScene1: AppCompatActivity(){
    private var count = 0

    private lateinit var instructionText: TextView
    private var imageViews = arrayOfNulls<ImageView?>(4)

    private var currentElements = mutableMapOf<Int, Int>()

    private fun chooseImageIndex(): Int {
        return Random.nextInt(MAX_OPTIONS)
    }

    private fun chooseTextIndex(): Int {
        return Random.nextInt(textList.size)
    }

    fun onImageClick(view: View) {
        val imageView = view as ImageView
        val tag = imageView.tag as String
        val correctAns = "Please select ${tag}!" == instructionText.text
        Toast.makeText(
            this,
            if (correctAns) "You are right!" else "You are wrong!",
            Toast.LENGTH_SHORT
        ).show()
        initElements()
        count++
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.market_scene_1)

        instructionText = findViewById(R.id.instruction_text)
        imageViews[0] = findViewById(R.id.image1)
        imageViews[1] = findViewById(R.id.image2)
        imageViews[2] = findViewById(R.id.image3)
        imageViews[3] = findViewById(R.id.image4)

        startGame()
    }

    private fun startGame() {
        initElements()
    }

    private fun initElements() {
        if(count >= ROUNDS_MAX) {
            finish()
            return
        }

        for (i in 0..3) {
            var textIndex = chooseTextIndex()
            while (currentElements.containsValue(textIndex)) {
                textIndex = chooseTextIndex()
            }
            imageViews[i]?.setImageResource(listOfObjects[textIndex])
            imageViews[i]?.tag = textList[textIndex]
            currentElements[i] = textIndex
        }

        val imageIndex = chooseImageIndex()
        instructionText.text = "Please select ${imageViews[imageIndex]?.tag}!"
    }
}