package com.example.apigithub.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apigithub.data.model.GitHubResponse
import com.example.apigithub.domain.usecase.GetRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) : ViewModel() {

    private val _repositories = MutableLiveData<GitHubResponse>()
    val repositories: LiveData<GitHubResponse> get() = _repositories

    fun fetchRepositories(query: String, sort: String, page: Int) {
        viewModelScope.launch {
            getRepositoriesUseCase.execute(query, sort, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    _repositories.postValue(response)
                }, { throwable ->

                })
        }
    }
}
