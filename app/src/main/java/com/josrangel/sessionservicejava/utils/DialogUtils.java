package com.josrangel.sessionservicejava.utils;

import android.app.AlertDialog;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.josrangel.sessionservicejava.R;

public class DialogUtils {

    private DialogUtils() {
    }

    public static void makeDialog(Context context) {
        AlertDialog.Builder adBuilder = new AlertDialog.Builder(context);
        adBuilder.setTitle(R.string.app_name)
                .setMessage(context.getString(R.string.incorrect_user))
                .setNegativeButton(context.getString(R.string.ok), (dialog, which) -> dialog.dismiss());

        AlertDialog alertDialog = adBuilder.create();
        alertDialog.show();
    }

    public static void makeDialogLogout(Context context) {
        AlertDialog.Builder adBuilder = new AlertDialog.Builder(context);
        adBuilder.setTitle(R.string.app_name)
                .setMessage(context.getString(R.string.downtime_reached))
                .setNegativeButton(context.getString(R.string.ok), (dialog, which) -> {
                    dialog.dismiss();
                    ((AppCompatActivity)context).finish();
                });

        AlertDialog alertDialog = adBuilder.create();
        alertDialog.show();
    }
}
