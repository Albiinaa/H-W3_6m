package com.geeks.hw_2_m7
import android.app.Application
import androidx.room.Room
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp:Application() {
    private val appModule = module {
        single { TaskValidator() }
        single<TaskRepository> { TaskRepositoryImpl(get()) }
        single { AddTaskUseCase(get(), get()) }
        single { Room.databaseBuilder(get(),AppDatabase::class.java, "task_db").build().taskDao() }
    }
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApp)
            modules(appModule)
        }
        }

    private fun androidContext(myApp: MyApp) {

    }
}

