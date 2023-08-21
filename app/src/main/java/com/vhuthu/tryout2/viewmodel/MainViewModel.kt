package com.vhuthu.tryout2.viewmodel

import androidx.lifecycle.ViewModel
import com.vhuthu.tryout2.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository : MainRepository): ViewModel() {

    val data = mainRepository.getDetails()
}