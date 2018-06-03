package oi_systems.h4h;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        TextView signUpText = (TextView) findViewById(R.id.signUpText);
        TextView forgotPassText = (TextView) findViewById(R.id.forgotPassText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText emailText = findViewById(R.id.emailText);
                EditText passwordText = findViewById(R.id.passwordText);

                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                Database data = ((Database) getApplicationContext());

                if(email.isEmpty() || password.isEmpty()){
                    showAlert("Neįvestas el. pašto adresas arba slaptažodis!");
                    return;
                }

                if(!data.findAccountEmail(email)){
                    showAlert("Su nurodytu el. paštu naudotojas neegzistuoja");
                    return;
                }
                /*
                int ID = data.getIdByEmail(email);
                System.out.println(ID);
                if(!data.checkPassword(ID, password)){
                    showAlert("Neteisingas slaptažodis");
                    return;
                }*/
                emailText.setText("");
                passwordText.setText("");
                Intent intent = new Intent(getApplicationContext(), MyProfileActivity.class);
                startActivity(intent);
                // add extra information
                // startIntent.putExtra("oi-systems.h4h.id", "HELLO WORLD!");
                /*
                    if(getIntent().hasExtra("oi-systems.h4h.SOMETHING")){
                    string text = getIntent().getString("oi-systems.h4h.SOMETHING");
                    }

                */

            }
        });

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        forgotPassText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReminderActivity.class);
                startActivity(intent);
            }
        });


    }

    public void showAlert(String message){
        AlertDialog alertDialog = new Alert(this, message).getAlert();
        alertDialog.show();
    }
}
