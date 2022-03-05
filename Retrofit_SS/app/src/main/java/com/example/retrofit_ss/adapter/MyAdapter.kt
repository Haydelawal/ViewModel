package com.example.retrofit_ss.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_ss.R
import com.example.retrofit_ss.databinding.RowLayoutBinding
import com.example.retrofit_ss.model.Post

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(val binding: RowLayoutBinding
    ): RecyclerView.ViewHolder(binding.root)

    private var myList = emptyList<Post>()

//    private  var binding: RowLayoutBinding  ? = null

//    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.userIdTxt.text = myList[position].userId.toString()
        holder.binding.idTxt.text  = myList[position].id.toString()
        holder.binding.titleTxt.text = myList[position].title
        holder.binding.bodyTxt.text = myList[position].body

    }

    override fun getItemCount(): Int {
        return myList.size

    }

    fun setData(newList: List<Post>) {
        myList = newList
        notifyDataSetChanged()
    }

}