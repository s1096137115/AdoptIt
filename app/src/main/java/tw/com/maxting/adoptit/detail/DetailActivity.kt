package tw.com.maxting.adoptit.detail

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback
import org.koin.android.viewmodel.ext.android.viewModel
import tw.com.maxting.adoptit.data.Adopt
import tw.com.maxting.adoptit.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransform()
        setContentView(binding.root)
        getExtra()
        observeViewModel()
    }

    private fun setTransform() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        binding.ivPicture.transitionName = "shared_element_container"
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 500
            addTarget(binding.ivPicture)
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            duration = 500
            addTarget(binding.ivPicture)
        }
    }

    private fun observeViewModel() {
        viewModel.apply {
            adopt.observe(this@DetailActivity, Observer { adopt ->
                showDetailInfo(adopt)
                Glide.with(this@DetailActivity)
                        .load(adopt.albumFile)
                        .centerInside()
                        .into(binding.ivPicture)
            })
        }
    }

    private fun getExtra() {
        intent?.getParcelableExtra<Adopt>(Adopt.toString())
                ?.also {
                    viewModel.adopt.value = it
                }
    }

    private fun showDetailInfo(adopt: Adopt) {
        binding.tvId.text = adopt.animalId.toString()
        binding.tvSubid.text = adopt.animalSubid

        val sex = when (adopt.animalSex) {
            "M" -> "公"
            "F" -> "母"
            else -> ""
        }
        val colour = adopt.animalColour
        val bodyType = when (adopt.animalBodytype) {
            "SMALL" -> "小型"
            "MEDIUM" -> "中型"
            "BIG" -> "大型"
            else -> ""
        }
        val age = when (adopt.animalAge) {
            "CHILD" -> "幼年"
            "ADULT" -> "成年"
            else -> ""
        }
        binding.tvAppearance.text = "$sex, $colour, $bodyType, $age"
        binding.tvFoundplace.text = adopt.animalFoundplace
        binding.tvShelterName.text = adopt.shelterName
        binding.tvShelterAddress.text = adopt.shelterAddress
        binding.tvTel.text = adopt.shelterTel
    }
}
