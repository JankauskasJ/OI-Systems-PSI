package oi_systems.h4h;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView mainList;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainList = (ListView) findViewById(R.id.mainListView);
        items = getJobs();

        ItemAdapter itemAdapter = new ItemAdapter(this, items);

        mainList.setAdapter(itemAdapter);

        Button myprofileButton = (Button) findViewById(R.id.myProfileButton3);
        Button menuButton = (Button) findViewById(R.id.meniuButton3);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), JobInfoActivity.class);
                startActivity(intent);
            }
        });

        myprofileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public String[] getJobs(){
        return new String[]{"Padžiauti skalbinius", "Pabūti lauke su kate", "Nupirkti maisto prekių"};
    }
}
