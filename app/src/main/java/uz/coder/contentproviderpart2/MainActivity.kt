package uz.coder.contentproviderpart2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cursor = contentResolver.query(
            Uri.parse("content://uz.coder.contentproviderlesson/user"),
            null,
            null,
            null,
            null,
            null
        )
        while (cursor?.moveToNext() == true){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val age = cursor.getInt(cursor.getColumnIndexOrThrow("age"))
            val user = User(id, name, age)
            Log.d("TAG", "onCreate: $user")
        }
    }
}