package io.github.mikegehard.stufffriendssay.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dev.rubbersidedowntech.stufffriendssay.goodbyes.goodbye
import dev.rubbersidedowntech.stufffriendssay.greetings.hello

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.helloText)
        textView.text = "${hello()}\n\n${goodbye()}"
    }
}
