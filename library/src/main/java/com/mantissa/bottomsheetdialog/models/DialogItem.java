package com.mantissa.bottomsheetdialog.models;

import android.graphics.drawable.Drawable;
import android.view.View;


public class DialogItem {

    Drawable iconId;
    String listItemName;
    View.OnClickListener clickListener;


    public DialogItem(Drawable iconId, String listItemName, View.OnClickListener clickListener) {
        this.iconId = iconId;
        this.listItemName = listItemName;
        this.clickListener = clickListener;
    }


    public Drawable getIconId() {
        return iconId;
    }

    public void setIconId(Drawable iconId) {
        this.iconId = iconId;
    }

    public String getListItemName() {
        return listItemName;
    }

    public void setListItemName(String listItemName) {
        this.listItemName = listItemName;
    }

    public View.OnClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
