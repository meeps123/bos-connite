package com.connite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public RelativeLayout rootLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        rootLayout = viewGroup.findViewById(R.id.rl_homeFragmentContainer);
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
        ArrayAdapter<ActivityItemData> adapter = new ActivityItemDataAdapter(getContext(), 0, arrayList);
        ExpandableHeightListView ehlv_ActivityItemList = rootLayout.findViewById(R.id.ehlv_ActivityItemList);
        ehlv_ActivityItemList.setAdapter(adapter);
        ehlv_ActivityItemList.setExpanded(true);
        return viewGroup;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            FragmentInterface fragmentInterface = (FragmentInterface) getActivity();
            fragmentInterface.onHomeFragmentCreated(rootLayout);
        } catch (ClassCastException e) {
            Log.e("ERROR", getActivity() + " must implement FragmentInterface");
        }
    }
}
