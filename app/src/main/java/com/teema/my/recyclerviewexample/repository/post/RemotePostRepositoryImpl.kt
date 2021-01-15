package com.teema.my.recyclerviewexample.repository.post

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.teema.my.recyclerviewexample.data.Post
import javax.inject.Inject

class RemotePostRepositoryImpl @Inject constructor(
    private val appContext: Context
) : PostRepository {

    companion object {
        const val URL = "https://jsonplaceholder.typicode.com/posts"
    }

    val queue = Volley.newRequestQueue(appContext)

    override var _postList: MutableLiveData<ArrayList<Post>> = MutableLiveData(ArrayList())

    override fun fetchPostList() {
        queue.add(
            JsonArrayRequest(Request.Method.GET, URL, null,
                { response ->
                    Log.d("RemotePostRepository", response.toString())
                },
                { }
            ))
        queue.start()
    }
}