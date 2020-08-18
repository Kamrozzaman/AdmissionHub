package com.example.admissionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class guidelines extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines);

        expandableListView = findViewById(R.id.guidelinesExpandableListViewId);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this,listGroup,listItem);
        expandableListView.setAdapter(adapter);
        initListData();
    }

    private void initListData() {
        listGroup.add(getString(R.string.guideline1));
        listGroup.add(getString(R.string.guideline2));
        listGroup.add(getString(R.string.guideline3));
        listGroup.add(getString(R.string.guideline4));
        listGroup.add(getString(R.string.guideline5));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.guideline1);
        for(String item : array)
        {
            list1.add(item);
        }

        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.guideline2);
        for(String item : array)
        {
            list2.add(item);
        }

        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.guideline3);
        for(String item : array)
        {
            list3.add(item);
        }

        List<String> list4 = new ArrayList<>();
        array = getResources().getStringArray(R.array.guideline4);
        for(String item : array)
        {
            list4.add(item);
        }

        List<String> list5 = new ArrayList<>();
        array = getResources().getStringArray(R.array.guideline5);
        for(String item : array)
        {
            list5.add(item);
        }

        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        listItem.put(listGroup.get(3),list4);
        listItem.put(listGroup.get(4),list5);
        adapter.notifyDataSetChanged();
    }
}
