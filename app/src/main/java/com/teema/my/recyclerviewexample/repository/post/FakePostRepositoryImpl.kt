package com.teema.my.recyclerviewexample.repository.post

import androidx.lifecycle.MutableLiveData
import com.teema.my.recyclerviewexample.data.Post
import javax.inject.Inject

class FakePostRepositoryImpl @Inject constructor() : PostRepository {

    override var _postList: MutableLiveData<ArrayList<Post>> = MutableLiveData(ArrayList())

    override fun fetchPostList() {
        _postList.value =
            arrayListOf(
                Post(1, 1, "A", "B"),
                Post(1, 2, "C", "D"),
                Post(1, 3, "E", "F")
            )
    }
}