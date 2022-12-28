package com.example.mcshippers.Profile.presentation.profileDetails.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mcshippers.Profile.model.Athlete
import com.example.mcshippers.Profile.model.Profile
import com.example.mcshippers.databinding.ProfileCardViewBinding
import com.squareup.picasso.Picasso
import java.text.FieldPosition

class ProfleListAdapter(var listner: ProfileListAdapterInterface) : RecyclerView.Adapter<ProfleListAdapter.CustomViewHolder>() {
    class CustomViewHolder(var binding: ProfileCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pendingOrder: Athlete) {
            binding.model = pendingOrder
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        var binding = ProfileCardViewBinding.inflate(LayoutInflater.from(parent.context))
        return ProfleListAdapter.CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        var athlete = differ.currentList!!.get(position)
        holder.bind(athlete)
        holder.binding.root.setOnClickListener {
            listner.onSendOrderClickListner(position)
        }
        Picasso.get().load(athlete.image).into(holder.binding.ivProfile)
    }

    override fun getItemCount(): Int {
        return differ.currentList!!.size
    }

    interface ProfileListAdapterInterface {
        fun onSendOrderClickListner(position: Int)
    }

    private val differCallBack = object : DiffUtil.ItemCallback<Athlete>() {
        override fun areItemsTheSame(oldItem: Athlete, newItem: Athlete): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Athlete,
            newItem: Athlete
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallBack)

}