package cn.zacash.android.hilt.di

import cn.zacash.android.hilt.data.LoggerDataSource
import cn.zacash.android.hilt.data.LoggerLocalDataSource
import cn.zacash.android.hilt.data.LoggerMemoryDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class MemoryLogger

@Qualifier
annotation class DatabaseLogger

@InstallIn(ApplicationComponent::class)
@Module
abstract class LoggingDatabaseModule {

    @DatabaseLogger
    @Singleton
    @Binds
    abstract fun bindDatabaseLogger(impl: LoggerLocalDataSource): LoggerDataSource

}

@InstallIn(ActivityComponent::class)
@Module
abstract class LoggingMemoryModule {

    @MemoryLogger
    @ActivityScoped
    @Binds
    abstract fun bindMemoryLogger(impl: LoggerMemoryDataSource): LoggerDataSource
}