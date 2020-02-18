package com.jk.stateofjavascript

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_tool.view.*

class ToolsAdapter : ListAdapter<Tool, ToolsAdapter.ToolsViewHolder>(DiffUtilConfig) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_tool, parent, false)
        return ToolsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToolsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ToolsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(tool: Tool) {
            itemView.view_text_title.text = tool.title
            itemView.view_text_description.text = tool.description
        }
    }

    object DiffUtilConfig : ItemCallback<Tool>() {
        override fun areItemsTheSame(oldItem: Tool, newItem: Tool): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: Tool, newItem: Tool): Boolean {
            return oldItem.title == newItem.title
        }
    }
}
