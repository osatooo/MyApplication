package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.button_imgbtn)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(this)
        val button2 = findViewById<Button>(R.id.appcompat_button)
        button2.setOnClickListener(this)
        val button3 = findViewById<Button>(R.id.material_button)
        button3.setOnClickListener(this)
        findViewById<ImageButton>(R.id.image_button).setOnClickListener(this)
        findViewById<AppCompatImageButton>(R.id.appcompat_image_button).setOnClickListener(this)

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            val className = button.accessibilityClassName
//            Log.d("accessibilityClassName", className.toString())
//        }
//        button.setBackgroundResource(R.drawable.ic_android_black_24dp)
//        val a = button2.setBackgroundResource(R.drawable.ic_android_black_24dp)
//        button3.setBackgroundResource(R.drawable.ic_android_black_24dp)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button -> Toast.makeText(this,"button pushed.",Toast.LENGTH_SHORT).show()
            R.id.appcompat_button -> Toast.makeText(this,"appcompatbutton pushed.",Toast.LENGTH_SHORT).show()
            R.id.material_button -> Toast.makeText(this,"materialbutton pushed.",Toast.LENGTH_SHORT).show()
            R.id.image_button -> Toast.makeText(this,"imagebutton pushed.",Toast.LENGTH_SHORT).show()
            R.id.appcompat_image_button -> Toast.makeText(this,"appcompatimagebutton pushed.",Toast.LENGTH_SHORT).show()
        }
    }
}

