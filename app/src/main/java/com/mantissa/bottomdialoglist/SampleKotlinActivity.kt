package com.mantissa.bottomdialoglist

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.mantissa.bottomsheetdialog.BottomDialogList
import java.util.*

class SampleKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val icons = ArrayList<Int>()
        val titles = ArrayList<String>()
        val events: ArrayList<View.OnClickListener> = ArrayList()


        titles.add("Item number 1")
        icons.add(android.R.drawable.ic_dialog_alert)
        events.add(View.OnClickListener { v ->
            Toast.makeText(this, "Hello World 1", Toast.LENGTH_LONG).show()
        })

        titles.add("Item number 2")
        icons.add(android.R.drawable.ic_dialog_dialer)
        events.add(View.OnClickListener { v ->
            Toast.makeText(this, "Hello World 2", Toast.LENGTH_LONG).show()
        })

        titles.add("Item number 3")
        icons.add(android.R.drawable.ic_dialog_email)
        events.add(View.OnClickListener { v ->
            Toast.makeText(this, "Hello World 3", Toast.LENGTH_LONG).show()
        })

        //this conditional exist to use the getColor function
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            BottomDialogList.Builder()
                .setItemsIcons(icons)
                .setItemsTitles(titles)
                .setItemsClickListeners(events)
                .setIconsColorTint(getColor(R.color.abc_hint_foreground_material_light))
                .show(getSupportFragmentManager())
        }
    }
}
