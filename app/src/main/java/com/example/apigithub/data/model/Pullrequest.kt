package com.example.apigithub.data.model

data class PullRequest(
    val id: Long,
    val title: String,
    val body: String,
    val user: Owner,
    val createdAt: String,
    val htmlUrl: String
)