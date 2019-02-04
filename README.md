# Bottom Dialog List

Easy to build bottomsheet menu with flexible handlers.

<img src="https://raw.githubusercontent.com/MurtadhaS/BottomDialogList/master/showcase/image_1.png" width=200/>

# How do I use it?

Simply initalize the icons, titles, onClick handlers list and use the builder with the corresponding options:

        var icons: ArrayList<Int>
        var titles: ArrayList<String>
        val events: ArrayList<(v: View) -> Unit>

        icons = ArrayList()
        titles = ArrayList()
        events = ArrayList()


        titles.add("Item number 1")
        icons.add(android.R.drawable.ic_dialog_alert)
        events.add { v ->
            Toast.makeText(this, "Hello World 1", Toast.LENGTH_LONG).show();
        }

        titles.add("Item number 2")
        icons.add(android.R.drawable.ic_dialog_dialer)
        events.add { v ->
            Toast.makeText(this, "Hello World 2", Toast.LENGTH_LONG).show();
        }

        titles.add("Item number 3")
        icons.add(android.R.drawable.ic_dialog_email)
        events.add { v ->
            Toast.makeText(this, "Hello World 3", Toast.LENGTH_LONG).show();
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            DialogBottomSheetFragment.Builder()
                .setItemsIcons(icons)
                .setItemsTitles(titles)
                .setItemsClickListeners(events)
                .setIconsColorTint(getColor(R.color.abc_hint_foreground_material_light))
                .setTextFontColor(getColor(R.color.abc_hint_foreground_material_light))
                .setBackgroundColor(getColor(R.color.abc_hint_foreground_material_light))
                .setDialogMessage("Please select the options you want")
                .show(getSupportFragmentManager())
        }
