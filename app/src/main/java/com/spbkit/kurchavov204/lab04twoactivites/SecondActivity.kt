package com.spbkit.kurchavov204.lab04twoactivites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class SecondActivity : AppCompatActivity() {  // Курчавов Алексей 204 группа СПБКИТ
    var editText1: EditText? = null
    var chkBox1: CheckBox? = null
    var chkBox2: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {  // Курчавов Алексей 204 группа СПБКИТ
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        editText1 = findViewById(R.id.editText)
        chkBox1 = findViewById(R.id.checkBox1)  // Курчавов Алексей 204 группа СПБКИТ
        chkBox2 = findViewById(R.id.checkBox2)

        findViewById<Button>(R.id.buttonExit).setOnClickListener(ExitButtonHandler(this))
        val intentReceived = intent
        val screenStateReceived = intentReceived.getSerializableExtra(IntentContentNames.ScreenState.name) as ScreenState?
  // Курчавов Алексей 204 группа СПБКИТ
        editText1?.setText(screenStateReceived?.txtEdit1State)
        chkBox1?.isChecked = screenStateReceived?.chkBox1State == true
        chkBox2?.isChecked = screenStateReceived?.chkBox2State == true  // Курчавов Алексей 204 группа СПБКИТ

        findViewById<Button>(R.id.buttonBack).setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(  // Курчавов Алексей 204 группа СПБКИТ
                IntentContentNames.ScreenState.name,
                ScreenState(
                    chkBox1?.isChecked == true,
                    chkBox2?.isChecked == true,
                    editText1?.text.toString()  // Курчавов Алексей 204 группа СПБКИТ
                )
            )

            setResult(RESULT_OK, returnIntent)  // Курчавов Алексей 204 группа СПБКИТ
            finish()
        }
    }
}