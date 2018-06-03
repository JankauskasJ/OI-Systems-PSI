package oi_systems.h4h;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signUpButton = (Button) findViewById(R.id.signUpButton);

        //Database data = ((Database) getApplicationContext());


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = findViewById(R.id.signUpName);
                EditText surnameText = findViewById(R.id.signUpSurname);
                EditText emailText = findViewById(R.id.signUpEmail);
                EditText passText = findViewById(R.id.signUpPass);
                EditText pass2Text = findViewById(R.id.signUpPass2);
                EditText addressText = findViewById(R.id.signUpAddress);
                EditText phoneText = findViewById(R.id.signUpPhone);

                String name = nameText.getText().toString();
                String surname = surnameText.getText().toString();
                String email = emailText.getText().toString();
                String pass = passText.getText().toString();
                String pass2 = pass2Text.getText().toString();
                String address = addressText.getText().toString();
                String phone = phoneText.getText().toString();

                Database data = ((Database) getApplicationContext());

                if(name.isEmpty() ||
                        surname.isEmpty() ||
                        email.isEmpty() ||
                        pass.isEmpty() ||
                        pass2.isEmpty() ||
                        address.isEmpty() ||
                        phone.isEmpty()){
                    showAlert("Nevisi laukai užpildyti!");
                    return;
                }

                if(data.findAccountEmail(email)){
                    showAlert("Toks el. pašto adresas jau egzistuoja!");
                    return;
                }

                if(!pass.equals(pass2)){
                    showAlert("Nesutampa slaptažodžiai!");
                    passText.setText("");
                    pass2Text.setText("");
                    return;
                }

                data.accounts.add(new Account(name, surname, email, pass, address, phone));

                signUpSucces("Sėkmingai užsiregistravote!");

            }
        });
    }

    public void showAlert(String message){
        AlertDialog alertDialog = new Alert(this, message).getAlert();
        alertDialog.show();
    }

    public void signUpSucces(String message){
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
