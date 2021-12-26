package ru.sikuda.mobile.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.sikuda.mobile.splash.splash.SplashFragment
//import ua.cn.stu.room.screens.splash.SplashFragment
// import ua.cn.stu.room.screens.splash.SplashViewModel

/**
 * Entry point of the app.
 *
 * Splash activity contains only window background, all other initialization logic is placed to
 * [SplashFragment] and [SplashViewModel].
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //Repositories.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

}