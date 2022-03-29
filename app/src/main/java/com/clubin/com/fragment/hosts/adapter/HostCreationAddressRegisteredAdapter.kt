package com.clubin.com.fragment.hosts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R

class HostCreationAddressRegisteredAdapter(val mContext: Context,
                                           val list: MutableList<String>,
                                           val clickListener: (String, Int) -> Unit): RecyclerView.Adapter<HostCreationAddressRegisteredAdapter.ViewHolder>()
 {

    val inflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.custom_row_host_address_registered, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      //  val item = list[position]
        var item : String = list[position]
        holder?.itemView?.setOnClickListener { clickListener(item, position) }
    }


     override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val bannerImage = itemView.findViewById<ImageView>(R.id.bannerImage)
        val addressTxt = itemView.findViewById<TextView>(R.id.addressTxt)

    }
}