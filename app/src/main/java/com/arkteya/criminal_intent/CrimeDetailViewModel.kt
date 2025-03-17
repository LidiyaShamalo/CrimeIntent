package com.arkteya.criminal_intent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import java.util.UUID

class CrimeDetailViewModel() : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData: LiveData<Crime?> =
        crimeIdLiveData.switchMap {crimeID ->
            crimeRepository.getCrime(crimeID)
        }

    fun loadCrime(crimeId: UUID){
        crimeIdLiveData.value = crimeId
    }
}