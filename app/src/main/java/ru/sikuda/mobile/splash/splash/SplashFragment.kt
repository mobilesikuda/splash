package ru.sikuda.mobile.splash.splash

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock.sleep
import android.view.View
import androidx.fragment.app.Fragment
import ru.sikuda.mobile.splash.MainActivity
import ru.sikuda.mobile.splash.R
import ru.sikuda.mobile.splash.databinding.FragmentSplashBinding
import ru.sikuda.mobile.splash.MainActivityArgs

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding
    lateinit private var viewModel: SplashViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)
        viewModel = SplashViewModel()

        // just some animations example
        renderAnimations()
        //viewModel.Wait()

        //viewModel.launchMainScreenEvent.observeEvent(viewLifecycleOwner) { launchMainScreen(true) }
        viewModel.launchMainScreenEvent.observe(viewLifecycleOwner){
            launchMainScreen(it)
        }
    }

    private fun launchMainScreen(isSignedIn: Boolean) {
        val intent = Intent(requireContext(), MainActivity::class.java)

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

        val args = MainActivityArgs(isSignedIn)
        intent.putExtras(args.toBundle())
        startActivity(intent)
    }

    private fun renderAnimations() {
        binding.loadingIndicator.alpha = 0f
        binding.loadingIndicator.animate()
            .alpha(0.7f)
            .setDuration(1000)
            .start()

        binding.pleaseWaitTextView.alpha = 0f
        binding.pleaseWaitTextView.animate()
            .alpha(1f)
            .setStartDelay(100)
            .setDuration(1000)
            .start()

    }
}