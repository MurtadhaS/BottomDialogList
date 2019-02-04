package com.mantissa.bottomsheetdialog.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mantissa.bottomsheetdialog.R
import com.mantissa.bottomsheetdialog.databinding.ItemDialogBinding
import com.mantissa.bottomsheetdialog.models.DialogItem


class DialogListItemAdapter(
    internal var context: Context?,
    internal var dialogItems: List<DialogItem>,
    internal var textFontColor: Int?,
    internal var backGroundColor: Int?,
    internal var iconsColor: Int?
) : RecyclerView.Adapter<DialogListItemAdapter.DialogItemViewHolder>() {
    lateinit var binding: ItemDialogBinding


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): DialogItemViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_dialog, viewGroup, false)
        return DialogItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DialogItemViewHolder, index: Int) {
        holder.binding.imageItemIcon.setColorFilter(Color.WHITE)
        holder.binding.actionListener = this
        holder.binding.dialogItem = dialogItems[index]
        holder.binding.root.setOnClickListener { _ -> dialogItems[index].clickListener }
        textFontColor?.let {
            holder.binding.textItemTitle.setTextColor(it)
        }
        backGroundColor?.let {
            holder.binding.root.background = ColorDrawable(it)
        }
        iconsColor?.let {
            holder.binding.imageItemIcon.setColorFilter(it)
        }
    }

    override fun getItemCount(): Int {
        return dialogItems.size
    }


    inner class DialogItemViewHolder(internal var binding: ItemDialogBinding) : RecyclerView.ViewHolder(binding.root)
}
