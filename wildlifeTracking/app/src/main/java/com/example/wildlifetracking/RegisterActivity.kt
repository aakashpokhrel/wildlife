package com.example.wildlifetracking

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.wildlifetracking.entity.User
import com.example.wildlifetracking.repository.UserRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity : AppCompatActivity() {
    private lateinit var edtfname: TextInputEditText
    private lateinit var edtlname: TextInputEditText
    private lateinit var edtusername: TextInputEditText
    private lateinit var edtpassword: TextInputEditText
    private lateinit var btnRegistration: Button
    private lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_register)

        edtfname = findViewById(R.id.edtfname)
        edtlname = findViewById(R.id.edtlname)
        edtusername = findViewById(R.id.edtusername)

        edtpassword = findViewById(R.id.edtpassword)
        btnRegistration = findViewById(R.id.btnRegistration)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
        }

        btnRegistration.setOnClickListener {
            val fname = edtfname.text.toString()
            val lname = edtlname.text.toString()
            val username = edtusername.text.toString()
            val password = edtpassword.text.toString()


            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)

            if (password != password) {
                edtpassword.error = "Password does not match"
                edtpassword.requestFocus()
                return@setOnClickListener
            }else{
                val user = User(fname = fname,lname = lname, username =  username, password =  password)
                CoroutineScope(Dispatchers.IO).launch {
//                    UserDB.getInstance(this@RegisterActivity).getUserDAO().registerUser(user)
                    try {
                        val userRepository = UserRepository()
                        val response = userRepository.registerUser(user)
                        if(response.success == true){
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "Register SuccessFull", Toast.LENGTH_SHORT
                                ).show()
                                showHighPriorityNotification()
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@RegisterActivity,
                                "Username cannot be duplicate", Toast.LENGTH_SHORT
                            ).show()

                        }
                    }
                }
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun showHighPriorityNotification() {
        val notificationManager = NotificationManagerCompat.from(this)
        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_1)
            .setSmallIcon(R.drawable.notification)
            .setContentInfo("High priority notification")
            .setContentText("You have been registered as user in Tickets!!")
            .setColor(Color.BLUE)
            .build()
        notificationManager.notify(1, notification)
    }
}