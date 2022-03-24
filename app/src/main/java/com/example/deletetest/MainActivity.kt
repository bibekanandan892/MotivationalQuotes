
// =============================================================================
//// ---------------------------------------------------------------------------
//// Creation Date: 24-Mar-2022
//// Author: Bibekananda Nayak
//// Version: 1.0
//// Class Name: MainActivity
//// description: This is the main Activity class where we do all the logical
////              operation for our project
//// ---------------------------------------------------------------------------
// =============================================================================

package com.example.deletetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.deletetest.databinding.ActivityMainBinding
import com.example.deletetest.models.QuoteModel
import com.example.deletetest.viewmodel.MainViewModel
import com.example.deletetest.viewmodel.MainViewModelFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    // initialize the binding for ActivityMainBinding
    private lateinit var binding: ActivityMainBinding
    // initialize new object for MiinViewModel
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialize binding with layoutInflater
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // initialize the new MainViewModel class and pass the application context to the MainViewModelFactory
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)



    }

    // this function is set the quote text and quote author on the TextView
    fun setQuote(quoteModel: QuoteModel){
        binding.quoteText.text = quoteModel.text
        binding.quoteAuthor.text = quoteModel.author
    }
    // this function is get the Previous Quote and set in to textView
    fun onPrevious(view: View) {
        try {
            setQuote(mainViewModel.preQuote())
        }catch (e: Exception){
            val toast = Toast.makeText(applicationContext, "No Previous", Toast.LENGTH_LONG)
            toast.show()
            e.printStackTrace()
        }
    }
    // this function is get the next Quote and set in to textView
    fun onNext(view: View) {
        try {
            setQuote(mainViewModel.nextQuote())        }catch (e: Exception){
            val toast = Toast.makeText(applicationContext, "No Previous", Toast.LENGTH_LONG)
            toast.show()
            e.printStackTrace()
        }
    }
    // this function is start the share activity with the Quote message
    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,mainViewModel.getQuote().text)
        startActivity(intent)
    }

}