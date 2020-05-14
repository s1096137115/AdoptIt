package tw.com.maxting.adoptit.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tw.com.maxting.adoptit.R
import tw.com.maxting.adoptit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.text.text = "test"
    }
}
