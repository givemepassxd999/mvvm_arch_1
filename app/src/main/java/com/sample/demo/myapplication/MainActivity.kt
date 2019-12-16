package com.sample.demo.myapplication

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var infoFactory: InfoFactory
    private lateinit var infoRepository: InfoRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        infoRepository = InfoRepository()
        infoFactory = InfoFactory(infoRepository)
        infoViewModel = ViewModelProviders.of(this, infoFactory).get(InfoViewModel::class.java)

        get_info.setOnClickListener {
            val dialog = ProgressDialog.show(
                this, "",
                "Loading. Please wait...", true
            )
            dialog.show()
            infoViewModel.callInfo().observe(this, Observer {
                dialog.dismiss()
                Toast.makeText(this, "user name:${it.userName} user age:${it.userAge}", Toast.LENGTH_SHORT).show()
            })
        }
    }
}
