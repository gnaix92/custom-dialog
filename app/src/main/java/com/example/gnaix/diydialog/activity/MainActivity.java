package com.example.gnaix.diydialog.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.gnaix.diydialog.R;
import com.example.gnaix.diydialog.adapter.MenuAdapter;
import com.example.gnaix.diydialog.util.ViewFind;

public class MainActivity extends AppCompatActivity implements ExpandableListView.OnChildClickListener {
    private ExpandableListView lvExpandable;

    private static String[] groups = {
            "Default Inner Dialog"
    };

    private static String[][] childs = {
            //"Default Inner Dialog"
            {
                    "NormalDialog Default(two btns)"
            }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initIntances();

    }

    private void initIntances() {
        //获取顶层View
        View decorView = getWindow().getDecorView();
        lvExpandable = ViewFind.find(decorView, R.id.elv_menu);

        MenuAdapter menuAdapter = new MenuAdapter(this, groups, childs);
        lvExpandable.setAdapter(menuAdapter);

        for (int i = 0; i < groups.length; i++) {
            lvExpandable.expandGroup(i);
        }
        lvExpandable.setOnChildClickListener(this);
        lvExpandable.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        switch (groupPosition) {
            //Default Inner Dialog
            case 0:
                switch (childPosition) {
                    case 0:
                        normalDialogStyleOne();
                        break;
                }
                break;
        }
        return true;
    }

    private void normalDialogStyleOne() {

    }
}
