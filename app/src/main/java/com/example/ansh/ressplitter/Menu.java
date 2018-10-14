package com.example.ansh.ressplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    ListView listView;
   public Button button;

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

        button = (button)findViewById(R.id.);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(this, Cart.class);
                startActivity(intent);
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
