package com.example.apigithub.di

import com.example.apigithub.data.api.GitHubApiService
import com.example.apigithub.data.repository.GitHubRepositoryImpl
import com.example.apigithub.domain.repository.GitHubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGitHubRepository(gitHubService: GitHubApiService): GitHubRepository {
        return GitHubRepositoryImpl(gitHubService)
    }
    @Provides
    @Singleton
    fun provideGitHubApiService(retrofit: Retrofit): GitHubApiService {
        return retrofit.create(GitHubApiService::class.java)

    }
}
