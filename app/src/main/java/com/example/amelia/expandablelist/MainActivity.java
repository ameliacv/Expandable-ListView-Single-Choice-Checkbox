package com.example.amelia.expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView mList;
    private ExpandableListAdapter mAdapter;
    List<Wild> listDataHeader;
    HashMap<Wild, List<Animal>> listDataChild;
    private static CheckBox lastChecked = null;
    private static int lastCheckedPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Wild wild = new Wild();
        wild.id = 1;
        wild.name = "Ganas";

        Wild wild1 = new Wild();
        wild1.id = 2;
        wild1.name = "Tidak Ganas";

        listDataHeader = new ArrayList<>();
        listDataHeader.add(wild);
        listDataHeader.add(wild1);

        Animal animal = new Animal();
        animal.id = 1;
        animal.isSelected = false;
        animal.name = "Jerapah";

        Animal animal1 = new Animal();
        animal1.id = 2;
        animal.isSelected = false;
        animal1.name = "Kuda";

        Animal animal2 = new Animal();
        animal2.id = 3;
        animal.isSelected = false;
        animal2.name = "Ular";

        Animal animal3 = new Animal();
        animal3.id = 4;
        animal.isSelected = false;
        animal3.name = "Lele";

        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(animal1);

        List<Animal> animals1 = new ArrayList<>();
        animals1.add(animal2);
        animals1.add(animal3);

        listDataChild = new HashMap<Wild, List<Animal>>();
        listDataChild.put(wild, animals);
        listDataChild.put(wild1, animals1);

//        Log.d("amel", listDataChild.toString());


        mList = findViewById(R.id.list);
        mAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        mList.setAdapter(mAdapter);
        mList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    for (int i = 0; i < mAdapter.getChildrenCount(groupPosition); i++) {
                        if (childPosition != i)
                            mAdapter.getChild(groupPosition, i).isSelected = false;
                    }

                mAdapter.getChild(groupPosition, childPosition).isSelected = !mAdapter.getChild(groupPosition, childPosition).isSelected;

                mAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }


}
