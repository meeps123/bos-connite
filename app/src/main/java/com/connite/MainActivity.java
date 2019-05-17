package com.connite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ExpandableHeightListView ehlv_ActivityItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkFirstTimeRun();
        updateActivityItemList();
    }

    public void updateActivityItemList() {
        ArrayList<ActivityItemData> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(
                    new ActivityItemData(
                            "Swimming",
                            "Swimming builds endurance, muscle strength, and maintains a healthy heart and lungs.",
                            "Lorong 6 Toa Payoh, Swimming Complex, Singapore 319392",
                            1,
                            1,
                            "https://lh5.googleusercontent.com/p/AF1QipNG0TFYMjChYBEpanHyTTffOBF-UQkPAvB7E9zi=w203-h114-k-no"));
        }
        ArrayAdapter<ActivityItemData> adapter = new ActivityItemDataAdapter(this, 0, arrayList);
        ehlv_ActivityItemList = findViewById(R.id.ehlv_ActivityItemList);
        ehlv_ActivityItemList.setAdapter(adapter);
        ehlv_ActivityItemList.setExpanded(true);
    }

    public void startSuggestionsActivity(View view) {
        Intent intent = new Intent(this, SuggestionsActivity.class);
        startActivity(intent);
    }

    public void startUserInfoActivity(View view) {
        Intent intent = new Intent(this, UserInfoActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void checkFirstTimeRun() {
        
    }
}
