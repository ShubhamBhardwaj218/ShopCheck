package com.shubham.shopcheck

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.listdisplay.view.*

class ItemAdapter(nctx:Context, val items:ArrayList<Itemdb> ): RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    val nctx1=nctx
    class ViewHolder(itemView :View):RecyclerView.ViewHolder(itemView)
    {
        val itemselect= itemView.itemselect
    }
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
    val v=LayoutInflater.from(p0.context).inflate(R.layout.activity_main2,p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ItemAdapter.ViewHolder, p1: Int) {
        val item: Itemdb= items[p1]
        p0.itemselect.text=item.itemselect
    }

}