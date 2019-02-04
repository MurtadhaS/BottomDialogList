package com.mantissa.bottomdialoglist;


import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.mantissa.bottomsheetdialog.BottomDialogList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import java.util.ArrayList;
import java.util.List;

public class SampleJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> icons = new ArrayList<Integer>();
        ArrayList<String> titles = new ArrayList<String>();
        ArrayList<View.OnClickListener> events = new ArrayList<>();

        titles.add("Item number 1");
        icons.add(android.R.drawable.ic_dialog_alert);
        events.add(v -> {
            Toast.makeText(this, "Hello World 1", Toast.LENGTH_LONG).show();
        });

        titles.add("Item number 2");
        icons.add(android.R.drawable.ic_dialog_dialer);
        events.add(v -> {
            Toast.makeText(this, "Hello World 2", Toast.LENGTH_LONG).show();
        });

        titles.add("Item number 3");
        icons.add(android.R.drawable.ic_dialog_email);
        events.add( v -> {
            Toast.makeText(this, "Hello World 3", Toast.LENGTH_LONG).show();
        });

        //this conditional exist to use the getColor function
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            new BottomDialogList.Builder()
                    .setItemsIcons(icons)
                    .setItemsTitles(titles)
                    .setItemsClickListeners(events)
                    .setDismissOnItemClicked(true)
                    .setIconsColorTint(getColor(R.color.abc_hint_foreground_material_light))
                    .show(getSupportFragmentManager());
        }
    }
}
