package com.mantissa.bottomsheetdialog

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mantissa.bottomsheetdialog.adapters.DialogListItemAdapter
import com.mantissa.bottomsheetdialog.models.DialogItem
import java.util.*

class BottomDialogList : BottomSheetDialogFragment() {

    var dismissOnItemClick: Boolean? = null
    var backgroundColor: Int? = null
    var textFontColor: Int? = null
    var iconsColor: Int? = null
    var dialogMessage: String? = null

    lateinit var dialogItemList: MutableList<DialogItem>
    lateinit var itemsTitles: ArrayList<String>
    lateinit var itemsIcons: ArrayList<Int>
    lateinit var clickEvents: ArrayList<(v: View) -> Unit>

    lateinit var adapter: DialogListItemAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (getArguments() != null) {
            dialogItemList = ArrayList<DialogItem>()

            itemsIcons = getArguments()!!.getIntegerArrayList("itemsIcons")
            itemsTitles = getArguments()!!.getStringArrayList("itemsTitles")
            clickEvents = getArguments()!!.getSerializable("itemsClickEvents") as ArrayList<(v: View) -> Unit>
            dismissOnItemClick = getArguments()?.getBoolean("dismissOnItemClicked")
            backgroundColor = arguments?.getSerializable("backgroundColor") as? Int
            textFontColor = arguments?.getSerializable("fontColor") as? Int
            iconsColor = arguments?.getSerializable("iconsColor") as? Int
            dialogMessage = arguments?.getSerializable("dialogMessage") as? String

            for (index in itemsTitles.indices) {
                dialogItemList.add(DialogItem(
                    getContext()?.getResources()?.getDrawable(itemsIcons[index]),
                    itemsTitles[index]
                ) { view1 ->
                    clickEvents[index].invoke(view1)
                    if (dismissOnItemClick!!) dismiss()
                })
            }

            adapter = DialogListItemAdapter(getContext(), dialogItemList, textFontColor, backgroundColor, iconsColor)

            val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_user_lists)
            val textViewMessage = view.findViewById<TextView>(R.id.text_dialog_title)

            recyclerView.setLayoutManager(LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false))
            recyclerView.setAdapter(adapter)

            dialogMessage?.let {
                textViewMessage.visibility = VISIBLE
                textViewMessage.text = it
                textFontColor?.let { textViewMessage.setTextColor(it) }
            }

        }
    }


    fun addElement(drawable: Drawable, title: String, listener: View.OnClickListener) {
        dialogItemList.add(DialogItem(drawable, title, listener))
        notifyDataChanged()
    }

    fun notifyDataChanged() {
        adapter.notifyDataSetChanged()
    }

    class Builder {
        private val arguments: Bundle

        val DIALOG_FRAGMENT_TAG: String = "DIALOG_FRAGMENT_TAG"

        init {
            arguments = Bundle()
        }

        fun show(fragmentManager: FragmentManager): BottomDialogList {
            val fragment = BottomDialogList()
            fragment.setArguments(arguments)
            fragment.show(fragmentManager, DIALOG_FRAGMENT_TAG)
            return fragment
        }

        fun setItemsTitles(itemsTitles: ArrayList<String>): Builder {
            arguments.putStringArrayList("itemsTitles", itemsTitles)
            return this
        }

        fun setItemsIcons(itemsIcons: ArrayList<Int>): Builder {
            arguments.putIntegerArrayList("itemsIcons", itemsIcons)
            return this
        }

        fun setItemsClickListeners(clickListener: ArrayList<(v: View) -> Unit>): Builder {
            arguments.putSerializable("itemsClickEvents", clickListener)
            return this
        }

        fun setDismissOnItemClicked(dismiss: Boolean?): Builder {
            arguments.putSerializable("dismissOnItemClicked", dismiss)
            return this
        }

        fun setBackgroundColor(color: Int): Builder {
            arguments.putSerializable("backgroundColor", color)
            return this
        }

        fun setTextFontColor(color: Int): Builder {
            arguments.putSerializable("fontColor", color)
            return this
        }

        fun setIconsColorTint(color: Int): Builder {
            arguments.putSerializable("iconsColor", color)
            return this
        }

        fun setDialogMessage(message: String): Builder {
            arguments.putSerializable("dialogMessage", message)
            return this
        }
    }
}