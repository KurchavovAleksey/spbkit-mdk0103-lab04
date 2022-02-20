package com.spbkit.kurchavov204.lab04twoactivites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var editText1: EditText? = null
    var chkBox1: CheckBox? = null
    var chkBox2: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText)
        chkBox1 = findViewById(R.id.checkBox1)  // Курчавов Алексей 204 группа СПБКИТ
        chkBox2 = findViewById(R.id.checkBox2)

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {  // Курчавов Алексей 204 группа СПБКИТ
                val intentReceived: Intent? = result.data
                val screenState = intentReceived?.getSerializableExtra(IntentContentNames.ScreenState.name) as ScreenState
                editText1?.setText(screenState.txtEdit1State)
                chkBox1?.isChecked = screenState.chkBox1State  // Курчавов Алексей 204 группа СПБКИТ
                chkBox2?.isChecked = screenState.chkBox2State
            }
        }

        findViewById<Button>(R.id.buttonExit).setOnClickListener(ExitButtonHandler(this))
        findViewById<Button>(R.id.buttonSecondActivity).setOnClickListener {  // Курчавов Алексей 204 группа СПБКИТ
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(
                IntentContentNames.ScreenState.name,
                ScreenState(
                    chkBox1?.isChecked == true,  // Курчавов Алексей 204 группа СПБКИТ
                    chkBox2?.isChecked == true,
                    editText1?.text.toString()
                )
            )  // Курчавов Алексей 204 группа СПБКИТ
            resultLauncher.launch(intent)
        }

        findViewById<Button>(R.id.buttonDialog).setOnClickListener {  // Курчавов Алексей 204 группа СПБКИТ
            val builder = AlertDialog.Builder(this)
            val inWindowTextEdit = EditText(this).apply { text = editText1?.text }
  // Курчавов Алексей 204 группа СПБКИТ
            val dialogCallback = {
                editText1?.text = inWindowTextEdit.text
            }
            builder.create()
            builder.setTitle(getString(R.string.edit_text))
            builder.setCancelable(true)
            builder.setView(inWindowTextEdit)  // Курчавов Алексей 204 группа СПБКИТ
            builder.setNegativeButton(getString(R.string.cancel)) { _, _ -> }
            builder.setPositiveButton(getString(R.string.ok)) { dialog, id ->
                dialogCallback()
            }  // Курчавов Алексей 204 группа СПБКИТ
            builder.show()
        }

    }
}