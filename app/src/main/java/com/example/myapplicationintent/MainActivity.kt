 package com.example.myapplicationintent

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar


class MainActivity : AppCompatActivity() {

    lateinit var etName: EditText
    lateinit var etDate: EditText
    lateinit var etMail: EditText
    lateinit var etclasse: EditText
    lateinit var btnSend: Button
    lateinit var main: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etDate = findViewById(R.id.etDate)
        etMail = findViewById(R.id.etMail)
        etclasse = findViewById(R.id.etclasse)
        main = findViewById(R.id.main)
        btnSend = findViewById(R.id.btnSend)


        etDate.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    etDate.setText(dat)
                }, year, month, day
            )

            datePickerDialog.show()
        }


        btnSend.setOnClickListener {
            val etName = etName.text.toString()
            val etDate = etDate.text.toString()
            val etMail = etMail.text.toString()
            val etclasse = etclasse.text.toString()

            val bundle = Bundle()

            bundle.putString("Nom", etName)
            bundle.putString("Date", etDate)
            bundle.putString("mail", etMail)
            bundle.putString("classe", etclasse)

            if (TextUtils.isEmpty(etName) || TextUtils.isEmpty(etDate) || TextUtils.isEmpty(etMail) || TextUtils.isEmpty(
                    etclasse
                )
            ) {
                Toast.makeText(applicationContext, "Empty field!! ", Toast.LENGTH_SHORT).show()

                val snackbar = Snackbar.make(main, "Empty field !!", Snackbar.LENGTH_LONG)
                    .setAction("UNDO") {
                        val snackbar = Snackbar.make(main, "Restored", Snackbar.LENGTH_LONG)
                    }
                snackbar.show()
            } else {
                val builder = AlertDialog.Builder(this)

                builder.setMessage("Continue ?")
                builder.setTitle("Alert !")
                builder.setCancelable(false)

                builder.setPositiveButton("Yes") {

                        dialog, which ->

                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }

                builder.setNegativeButton("No") { dialog, which ->
                    dialog.cancel()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }
    }
}









