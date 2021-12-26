package ru.sikuda.mobile.splash.splash

import android.os.SystemClock
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

//import ua.cn.stu.room.model.accounts.AccountsRepository
//import ua.cn.stu.room.utils.MutableLiveEvent
//import ua.cn.stu.room.utils.publishEvent
//import ua.cn.stu.room.utils.share

/**
 * SplashViewModel checks whether user is signed-in or not.
 */
class SplashViewModel() : ViewModel() {

    private var _launchMainScreenEvent = MutableLiveData<Boolean>()
    val launchMainScreenEvent: LiveData<Boolean>
        get() = _launchMainScreenEvent
    //val launchMainScreenEvent = _launchMainScreenEvent.share()

    init {


        viewModelScope.launch {
            delay(2000)
            _launchMainScreenEvent.value = true
//            //_launchMainScreenEvent.publishEvent(accountsRepository.isSignedIn())
//            //_launchMainScreenEvent.publishEvent(true)
        }
    }

    fun Wait(){
        viewModelScope.launch {
            delay(1000)
            _launchMainScreenEvent.value = true
        }
    }
}
