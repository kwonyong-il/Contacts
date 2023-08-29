package com.example.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ItemBinding
import com.example.contacts.databinding.ItemFavoriteBinding

class Adapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val BasicView = 0
        const val FavoriteView = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            BasicView -> {
                val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BasicHolder(binding)
            }
            FavoriteView -> {
                val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                FavoriteHolder(binding)
            }
            else -> throw IllegalArgumentException("Error")
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mItems[position]

        when (holder) {
            is BasicHolder -> {
                holder.binding.itemImg.setImageResource(item.img)
                holder.binding.itemName.text = item.name
                holder.binding.itemPhoneNumber.text = item.number
                holder.binding.favoriteBtn.setOnClickListener {
                    item.isFavorite = !item.isFavorite
                    notifyItemChanged(position)
                }
            }
            is FavoriteHolder -> {
                holder.binding.itemFavoriteImg.setImageResource(item.img)
                holder.binding.itemFavoriteName.text = item.name
                holder.binding.itemFavoritePhoneNumber.text = item.number
                holder.binding.favoriteBtnFill.setOnClickListener {
                    item.isFavorite = false
                    notifyItemChanged(position)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (mItems[position].isFavorite) {
            FavoriteView
        } else {
            BasicView
        }
    }
    inner class BasicHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)
    inner class FavoriteHolder(val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return mItems.size
    }
}
