package com.teema.my.recyclerviewexample.repository.post

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePostRepository(@ApplicationContext appContext: Context): PostRepository {
        return RemotePostRepositoryImpl(appContext)
    }
}