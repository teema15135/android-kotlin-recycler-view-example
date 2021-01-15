package com.teema.my.recyclerviewexample.data.post

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teema.my.recyclerviewexample.databinding.ItemPostBinding

class PostAdapter(private var items: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private lateinit var binding: ItemPostBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun setItems(items: ArrayList<Post>) {
        this.items = items
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(var viewBinding: ItemPostBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(post: Post) {
            itemView.apply {
                viewBinding.userIdText.text = post.userId.toString()
                viewBinding.titleText.text = post.title
                viewBinding.bodyText.text = post.body
            }
        }

    }
}