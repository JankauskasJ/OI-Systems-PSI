package oi_systems.h4h;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MyProfileActivity extends Activity {

    ListView myProfileListView;
    String[] profileItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        Resources res = getResources();
        myProfileListView = (ListView) findViewById(R.id.mainListView);
        profileItems = res.getStringArray(R.array.profile_items);

        ItemAdapter itemAdapter = new ItemAdapter(this, profileItems);

        myProfileListView.setAdapter(itemAdapter);

        myProfileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                if(i == 0){
                    //intent = new Intent(getApplicationContext(), MenuActivity.class);
                    //startActivity(intent);
                }
                else if(i == 1){
                    //intent = new Intent(getApplicationContext(), MenuActivity.class);
                    //startActivity(intent);
                }
                else if(i == 2){
                    //intent = new Intent(getApplicationContext(), MenuActivity.class);
                    //startActivity(intent);
                }
                else if(i == 3){
                    //intent = new Intent(getApplicationContext(), MenuActivity.class);
                    //startActivity(intent);
                }
                else if(i == 4){
                    //intent = new Intent(getApplicationContext(), MenuActivity.class);
                    //startActivity(intent);
                }
                else if(i == 5){
                    //intent = new Intent(getApplicationContext(), MenuActivity.class);
                    //startActivity(intent);
                }
                else if(i == 6){
                    //intent = new Intent(getApplicationContext(), MenuActivity.class);
                    //startActivity(intent);
                }
                else{
                    finish();
                }
            }
        });

        Button menuButton = (Button) findViewById(R.id.meniuButton);
        Button mainButton = (Button) findViewById(R.id.mainButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
