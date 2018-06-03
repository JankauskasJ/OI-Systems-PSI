package oi_systems.h4h;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReminderActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        Button remindButton = (Button) findViewById(R.id.remindButton);
        remindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText emailRemindText = findViewById(R.id.emailRemindText);
                String email = emailRemindText.getText().toString();
                AlertDialog alertDialog;

                if(email.isEmpty()){
                    showAlert("El. pašto adresas nenurodytas!");
                    return;
                }

                Database data = ((Database) getApplicationContext());

                if(!data.findAccountEmail(email)){
                    showAlert("Toks el. pašto adresas neegzistuoja!");
                    return;
                }
                else{
                    emailCorrect("Laiškas išsiųstas nurodytu el. paštu!");
                    return;
                }
            }
        });
    }

    public void showAlert(String message){
        AlertDialog alertDialog = new Alert(this, message).getAlert();
        alertDialog.show();
    }


    public void emailCorrect(String message){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                endActivity();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }
    public void endActivity(){
        finish();
    }
}
