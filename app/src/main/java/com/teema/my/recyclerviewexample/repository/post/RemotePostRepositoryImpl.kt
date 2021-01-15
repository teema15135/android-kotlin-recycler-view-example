package com.teema.my.recyclerviewexample.repository.post

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.teema.my.recyclerviewexample.data.post.Post
import com.teema.my.recyclerviewexample.data.post.PostDeserializer
import javax.inject.Inject

class RemotePostRepositoryImpl @Inject constructor(
    appContext: Context
) : PostRepository {

    companion object {
        const val URL = "https://jsonplaceholder.typicode.com/posts"
    }

    private val queue: RequestQueue = Volley.newRequestQueue(appContext)

    override var _postList: MutableLiveData<ArrayList<Post>> = MutableLiveData(ArrayList())

    override fun fetchPostList() {
        queue.add(
            JsonArrayRequest(Request.Method.GET, URL, null,
                { response ->
                    _postList.value = GsonBuilder()
                        .registerTypeAdapter(Post::class.java, PostDeserializer())
                        .create()
                        .fromJson(response.toString(), Array<Post>::class.java).toList() as ArrayList<Post>
                },
                { }
            ))
        queue.start()
    }
}