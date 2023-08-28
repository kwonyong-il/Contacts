package com.example.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ItemBinding

class Adapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.itemImg.setImageResource(mItems[position].img)
        holder.binding.itemName.text = (mItems[position].name)
        holder.binding.itemPhoneNumber.text = (mItems[position].number)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
    }
}