package com.teema.my.recyclerviewexample.dagger.module

import android.content.Context
import com.teema.my.recyclerviewexample.repository.post.FakePostRepositoryImpl
import com.teema.my.recyclerviewexample.repository.post.PostRepository
import com.teema.my.recyclerviewexample.repository.post.RemotePostRepositoryImpl
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
//        return FakePostRepositoryImpl()
    }
}