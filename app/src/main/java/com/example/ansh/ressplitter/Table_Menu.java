package com.example.ansh.ressplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Table_Menu extends AppCompatActivity {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_buttons,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_button_cart:
                startActivity(new Intent(this, Cart.class));
           //   Toast toast=  Toast.makeText(getApplicationContext(),"fine",Toast.LENGTH_SHORT);
            //  toast.show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
