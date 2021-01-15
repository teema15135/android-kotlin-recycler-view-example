package com.teema.my.recyclerviewexample.data.post

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class PostDeserializer : JsonDeserializer<Post> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Post {
        val jsonObj = json as JsonObject

        return Post(
            jsonObj.get("userId").asInt,
            jsonObj.get("id").asInt,
            jsonObj.get("title").asString,
            jsonObj.get("body").asString
        )
    }
}