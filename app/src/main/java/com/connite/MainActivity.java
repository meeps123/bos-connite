package com.connite;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ExpandableHeightListView ehlv_ActivityItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateActivityItemList();
    }

    public void updateActivityItemList() {
        ArrayList<ActivityItemData> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(
                    new ActivityItemData(
                            "Test Activity",
                            "Test Description",
                            "Test Location",
                            1,
                            1,
                            "https://i.pinimg.com/originals/25/70/46/257046ef41da1b60c4505161754cd8f5.png"));
        }
        ArrayAdapter<ActivityItemData> adapter = new ActivityItemDataAdapter(this, 0, arrayList);
        ehlv_ActivityItemList = findViewById(R.id.ehlv_ActivityItemList);
        ehlv_ActivityItemList.setAdapter(adapter);
        ehlv_ActivityItemList.setExpanded(true);
    }

    public void startSuggestionsActivity(View view) {
        Toast.makeText(this, "Suggestions", Toast.LENGTH_SHORT).show();
    }

    public void startUserInfoActivity(View view) {
        Toast.makeText(this, "User Info", Toast.LENGTH_SHORT).show();
    }
}
