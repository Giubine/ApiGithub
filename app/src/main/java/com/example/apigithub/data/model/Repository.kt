package com.example.apigithub.data.model

data class Repository(
    val id: Long,
    val name: String,
    val description: String?,
    val stargazersCount: Int,
    val forksCount: Int,
    val owner: Owner
)