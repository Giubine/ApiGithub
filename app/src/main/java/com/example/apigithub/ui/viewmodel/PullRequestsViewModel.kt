package com.example.apigithub.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apigithub.data.model.PullRequest
import com.example.apigithub.domain.usecase.GetPullRequestsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PullRequestsViewModel @Inject constructor(
    private val getPullRequestsUseCase: GetPullRequestsUseCase
) : ViewModel() {

    private val _pullRequests = MutableLiveData<List<PullRequest>>()
    val pullRequests: LiveData<List<PullRequest>> get() = _pullRequests

    fun fetchPullRequests(owner: String, repo: String) {
        viewModelScope.launch {
            getPullRequestsUseCase.execute(owner, repo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    _pullRequests.postValue(response)
                }, { throwable ->
                    // Handle errors here
                })
        }
    }
}
