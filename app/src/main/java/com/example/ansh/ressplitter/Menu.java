package com.example.ansh.ressplitter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ansh.ressplitter.dummy.MenuAdapter;
import com.example.ansh.ressplitter.dummy.MenuItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        listView = findViewById(R.id.list_view_menu);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("restaurant");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<MenuItem> items = new ArrayList<>();
                for(DataSnapshot ds:dataSnapshot.getChildren()) {
                    items.add(ds.getValue(MenuItem.class));
                }
                MenuAdapter adapter = new MenuAdapter(items);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



//        ArrayList<MenuItem> items = new ArrayList<>();
//        MenuItem item = new MenuItem();
//        item.setItemName("Item 1");
//        item.setPrice(23);
//        item.setRestrId(3445);
//
//        items.add(item);
//
//
//        listView.setAdapter(adapter);
    }
}
