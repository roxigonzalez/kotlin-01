package com.example.homeworklogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.app.AlertDialog


class LoginActivity : AppCompatActivity() {
    private lateinit var mEmailText: EditText
    private lateinit var mMessageText: EditText
    private lateinit var mSendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bind()
        listenEvent()

    }
    fun bind() {
        // code to get email and message from ID
        mEmailText = findViewById(R.id.text_email)
        mMessageText = findViewById(R.id.text_message)
        mSendButton = findViewById(R.id.button_send)
    }
    fun listenEvent() {
        mSendButton.setOnClickListener { _ ->
            // code to send data somewhere :) then start activity of message
            val email = mEmailText.text.toString()
            val message= mMessageText.text.toString()

            if(email.trim().isNullOrBlank() || message.trim().isNullOrBlank()){
                basicAlert()
            } else {
                val intent = Intent(this, MessageActivity::class.java)
                startActivity(intent)
            }
        }
    }
    fun basicAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.Error))
        builder.setMessage(getString(R.string.fill_info))
        builder.setPositiveButton("Ok", null);
        builder.show()
    }
}