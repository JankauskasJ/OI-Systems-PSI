package oi_systems.h4h;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MenuActivity extends Activity {

    ListView menuList;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Resources res = getResources();
        menuList = (ListView) findViewById(R.id.menuListView);
        items = res.getStringArray(R.array.menu_items);

        ItemAdapter itemAdapter = new ItemAdapter(this, items);

        menuList.setAdapter(itemAdapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                if(i == 0){
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else if(i == 1){
                    //intent = new Intent(getApplicationContext(), MyProfileActivity.class);
                }
                else if(i == 2){
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else if(i == 3){
                    //intent = new Intent(getApplicationContext(), MyProfileActivity.class);
                }
                else if(i == 4){
                    //intent = new Intent(getApplicationContext(), MyProfileActivity.class);
                }
                else if(i == 5){
                    //intent = new Intent(getApplicationContext(), MyProfileActivity.class);
                }
            }
        });


        Button myprofileButton = (Button) findViewById(R.id.myProfileButton2);
        Button mainButton = (Button) findViewById(R.id.mainButton2);

        myprofileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyProfileActivity.class);
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
