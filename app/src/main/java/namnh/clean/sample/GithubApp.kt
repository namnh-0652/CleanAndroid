package namnh.clean.sample

import android.app.Application
import namnh.clean.data.di.dataMapperModule
import namnh.clean.data.di.networkModule
import namnh.clean.data.di.repositoryModule
import namnh.clean.domain.usecase.useCaseModule
import namnh.clean.sample.di.appModule
import namnh.clean.sample.di.presentationMapperModule
import namnh.clean.sample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GithubApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules =
            listOf(
                appModule,
                // domain
                useCaseModule,
                // data
                repositoryModule,
                networkModule,
                dataMapperModule,
                // presentation
                presentationMapperModule,
                viewModelModule
            )
        startKoin {
            androidLogger()
            androidContext(this@GithubApp)
            modules(modules)
        }
    }
}
