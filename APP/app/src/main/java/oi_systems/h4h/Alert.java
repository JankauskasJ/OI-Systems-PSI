package oi_systems.h4h;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Šarūnas on 2018-06-03.
 */

public class Alert{

    private AlertDialog.Builder alertDialogBuilder;

    public Alert(Context context, String message){
        alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        return ;
    }

    public AlertDialog getAlert(){
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);

        return alertDialog;
    }

    private void closeActivity(){

    }
}
