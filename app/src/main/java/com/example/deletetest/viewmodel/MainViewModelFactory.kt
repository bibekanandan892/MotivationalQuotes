
// =============================================================================
//// ---------------------------------------------------------------------------
//// Creation Date: 24-Mar-2022
//// Author: Bibekananda Nayak
//// Version: 1.0
//// Class Name: MainViewModelFactory
//// description: This class is return the MainViewModel with Context as parameter
//// ---------------------------------------------------------------------------
// =============================================================================

package com.example.deletetest.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(context) as T
    }
}