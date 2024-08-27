package com.jyotsna.pinchgesture2app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Call the superclass's implementation of onCreate to perform default initialization

        // Set the content view for the activity to the layout resource file activity_main.xml
        setContentView(R.layout.activity_main)
    }
}
