package tw.com.maxting.adoptit.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import tw.com.maxting.adoptit.api.AdoptService
import tw.com.maxting.adoptit.main.MainViewModel
import tw.com.maxting.adoptit.singleton.Repository

val utilModule = module {
    single { provideAdoptService() }
    single { Repository(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
}

val appModule = listOf(utilModule, viewModelModule)

fun provideAdoptService(): AdoptService {
    return Retrofit.Builder()
            .baseUrl(AdoptService.BASE_URL)
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .build()
            .run { create(AdoptService::class.java) }
}