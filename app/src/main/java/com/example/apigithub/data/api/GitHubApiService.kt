package com.example.apigithub.data.api

import com.example.apigithub.data.model.GitHubResponse
import com.example.apigithub.data.model.PullRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApiService {
    @GET("search/repositories")
    fun getRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): Single<GitHubResponse>

    @GET("repos/{owner}/{repo}/pulls")
    fun getPullRequests(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Single<List<PullRequest>>
}
