package tw.com.maxting.adoptit.di

import org.koin.dsl.module

val utilModule = module {

}

val viewModelModule = module {

}

val appModule = listOf(utilModule, viewModelModule)