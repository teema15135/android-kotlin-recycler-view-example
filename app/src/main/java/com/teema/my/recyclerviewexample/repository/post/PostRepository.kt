package com.teema.my.recyclerviewexample.repository.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.teema.my.recyclerviewexample.data.post.Post

interface PostRepository {
    var _postList : MutableLiveData<ArrayList<Post>>
    val postList : LiveData<ArrayList<Post>>
        get() = _postList

    fun fetchPostList()

}