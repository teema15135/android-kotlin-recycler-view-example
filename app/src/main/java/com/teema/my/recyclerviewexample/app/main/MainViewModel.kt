package com.teema.my.recyclerviewexample.app.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teema.my.recyclerviewexample.data.post.Post
import com.teema.my.recyclerviewexample.repository.post.PostRepository

class MainViewModel @ViewModelInject constructor(private val postRepository: PostRepository) :
    ViewModel() {

    private val _postList: MutableLiveData<ArrayList<Post>> = MutableLiveData()
    val postList: LiveData<ArrayList<Post>>
        get() = _postList

    fun firstLoad() {
        postRepository.postList.observeForever {
            _postList.value = it
        }
    }

    fun loadPostList() {
        postRepository.fetchPostList()
    }

}