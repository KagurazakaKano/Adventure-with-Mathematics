package top.kanocui.adventurewithmathematics.scenes.market

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import top.kanocui.adventurewithmathematics.R
import kotlin.random.Random

class MarketScene2: AppCompatActivity() {
    private var count = 0

    private lateinit var itemImageView: ImageView
    private lateinit var questionTextView: TextView

    private var correctAnswerCount : Int = 0

    private var answerOptionsToChoose = arrayOfNulls<TextView?>(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.market_scene_2)

        itemImageView = findViewById(R.id.itemImageView)
        questionTextView = findViewById(R.id.questionTextView)
        answerOptionsToChoose[0] = findViewById(R.id.option1)
        answerOptionsToChoose[1] = findViewById(R.id.option2)
        answerOptionsToChoose[2] = findViewById(R.id.option3)
        answerOptionsToChoose[3] = findViewById(R.id.option4)

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

        val index = Random.nextInt(listOfObjects.size)
        val randomImage = listOfObjects[index]
        val question = "How many ${textList[index]} do you see?"
        questionTextView.text = question

        val answerOptions = listOf(
            Random.nextInt(1, 2),
            Random.nextInt(3, 4),
            Random.nextInt(5, 7),
            Random.nextInt(8, 9)
        ).shuffled()
        for(i in 0 .. 3) {
            answerOptionsToChoose[i]?.text = answerOptions[i].toString()
        }

        correctAnswerCount = answerOptions[Random.nextInt(answerOptions.size)]
        setImage(randomImage, correctAnswerCount, itemImageView)
    }

    private fun setImage(randomImage: Int, correctAnswerCount: Int, view: ImageView) {
        val bitmap = BitmapFactory.decodeResource(view.context.resources, randomImage)
        val width = bitmap.width
        val height = bitmap.height
        val combinedWidth = width * correctAnswerCount
        val combinedHeight = height
        val combinedBitmap = Bitmap.createBitmap(combinedWidth, combinedHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(combinedBitmap)
        for (i in 0 until correctAnswerCount) {
            val left = i * width
            val top = 0
            canvas.drawBitmap(bitmap, left.toFloat(), top.toFloat(), null)
        }
        view.setImageBitmap(combinedBitmap)
    }

    fun onButtonClick(view: View) {
        val button = view as Button
        val tag = button.text as String
        val correctAns = tag.toInt() == correctAnswerCount
        Toast.makeText(
            this,
            if (correctAns) "You are right!" else "You are wrong!",
            Toast.LENGTH_SHORT
        ).show()
        initElements()
        count++
    }
}
