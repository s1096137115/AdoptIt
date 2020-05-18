package tw.com.maxting.adoptit.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel
import tw.com.maxting.adoptit.R
import tw.com.maxting.adoptit.databinding.ActivityMainBinding
import tw.com.maxting.adoptit.util.MarginItemDecoration

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<MainViewModel>()

    private val adapter by lazy {
        ListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = this@MainActivity.adapter
            setHasFixedSize(true)
            addItemDecoration(MarginItemDecoration(
                    resources.getDimension(R.dimen.grid_padding).toInt()))

        }
    }

    private fun observeViewModel() {
        viewModel.apply {
            loadAdoptPaged().observe(this@MainActivity, Observer(adapter::submitList))
        }
    }
}
