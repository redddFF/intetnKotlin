package com.example.myapplicationintent

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ShareCompat

class SecondActivity : AppCompatActivity() {

    lateinit var secondNom : TextView
    lateinit var SecondDate : TextView
    lateinit var SecondMail : TextView
    lateinit var secondClasse : TextView
    lateinit var shareit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        secondNom = findViewById(R.id.secondNom)
        SecondDate = findViewById(R.id.SecondDate)
        SecondMail= findViewById(R.id.SecondMail)
        secondClasse= findViewById(R.id.secondClasse)
        shareit = findViewById(R.id.shareit)


        val bundle = intent.extras

        if (bundle != null){
            secondNom.text = "Nom = ${bundle.getString("Nom")}"
            SecondDate.text = "Date de naissance= ${bundle.getString("Date")}"
            SecondMail.text = "Email = ${bundle.getString("mail")}"
            secondClasse.text = "Class = ${bundle.getString("classe")}"
        }

        shareit.setOnClickListener {
val mimeType = "text/plain"
val shareIntent =ShareCompat.IntentBuilder(this)
shareIntent.setType(mimeType)
    .setChooserTitle("Share text Using")
    .startChooser()






       /* val intent = Intent(Intent.ACTION_SEND)
        val title =   resources.getString(R.string.app_name)
        val chooser = Intent.createChooser(intent, title)
        try {
            startActivity(chooser)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(applicationContext,"good job ",Toast.LENGTH_SHORT).show()
        }*/
    }
    }

}