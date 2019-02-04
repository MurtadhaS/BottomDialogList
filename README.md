# Bottom Dialog List

Easy to build bottomsheet menu with flexible handlers.

<img src="https://raw.githubusercontent.com/MurtadhaS/BottomDialogList/master/showcase/image_1.png" width=200/>

# How do I use it?

Simply initalize the icons, titles & the onClick handlers list and use the builder with the corresponding options:


            BottomDialogList.Builder()
                .setItemsIcons(icons)
                .setItemsTitles(titles)
                .setItemsClickListeners(events)
                .setIconsColorTint(getColor(R.color.abc_hint_foreground_material_light))
                .setTextFontColor(getColor(R.color.abc_hint_foreground_material_light))
                .setBackgroundColor(getColor(R.color.abc_hint_foreground_material_light))
                .setDialogMessage("Please select the options you want")
                .show(getSupportFragmentManager())
       
