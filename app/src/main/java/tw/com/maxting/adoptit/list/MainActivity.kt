package tw.com.maxting.adoptit.list

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback
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
        setTransform()
        setContentView(binding.root)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setTransform() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setExitSharedElementCallback(
                MaterialContainerTransformSharedElementCallback()
        )
        window.sharedElementsUseOverlay = true
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
