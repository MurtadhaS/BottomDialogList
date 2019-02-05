# Bottom Dialog List

Easy to build bottomsheet menu with flexible handlers.

<img src="https://raw.githubusercontent.com/MurtadhaS/BottomDialogList/master/showcase/image_1.png" width=200/>

# Download
You can add the following line to your application build.gradle file dependencies to include the library:
 
## Gradle 
             implementation 'com.mantissa.bottomdialoglist:BottomDialogList:1.0.1'

or you can use Maven

## Maven

            <dependency>
            <groupId>com.mantissa.bottomdialoglist</groupId>
            <artifactId>BottomDialogList</artifactId>
            <version>1.0.1</version>
            <type>pom</type>
            </dependency>

# How do I use it?

Simply initalize the icons, titles & the onClick handlers list and use the builder with the corresponding options:


            BottomDialogList.Builder()
                            .setItemsIcons(icons)
                            .setItemsTitles(titles)
                            .setItemsClickListeners(events)
                            .setBackgroundColor(COLOR)
                            .setTextFontColor(COLOR)
                            .setIconsColorTint(COLOR)
                            .setDismissOnItemClicked(true)
                            .setDialogMessage("Select One Option")
                            .show(getSupportFragmentManager())
                            
                            
 You can initialize and add elements to the events list as below:
 
 ## Java 8
 
            ArrayList<View.OnClickListener> events = new ArrayList<>();
            events.add(v -> {
            Toast.makeText(this, "Hello World 1", Toast.LENGTH_LONG).show();
            });
 
 ## Kotlin
 
            val events: ArrayList<View.OnClickListener> = ArrayList()
            events.add(View.OnClickListener { v ->
            Toast.makeText(this, "Hello World 1", Toast.LENGTH_LONG).show()
            })
       
