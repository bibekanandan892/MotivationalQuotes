// =============================================================================
//// ---------------------------------------------------------------------------
//// Creation Date: 24-Mar-2022
//// Author: Bibekananda Nayak
//// Version: 1.0
//// Class Name: MainViewModel
//// description: This class is store all the variable data for our View and
//// the give to the Main Activity
//// ---------------------------------------------------------------------------
// =============================================================================


package com.example.deletetest.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.deletetest.models.QuoteModel
import com.google.gson.Gson

class MainViewModel (val context: Context): ViewModel() {
    private var quoteList: Array<QuoteModel> = emptyArray()
    private var index =0
    init{
        quoteList = loadQuoteFromAssets()
    }
    // the function is return Array of QuoteModel
    private fun loadQuoteFromAssets(): Array<QuoteModel> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
         return  gson.fromJson(json,Array<QuoteModel>::class.java)

    }
    // this function is return the Gson object of Quote of current index
    fun getQuote() = quoteList[index]
    // this function is return the Gson object of Quote of next index
    fun nextQuote() = quoteList[++index]
    // this function is return the Gson object of Quote of previous index
    fun preQuote() = quoteList[--index]

}