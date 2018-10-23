package com.example.ansh.ressplitter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class ResDetails extends AppCompatActivity {

    public Button join, create;

    boolean exist= false;
    EditText codeinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_details);
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("TableCode");
//JOIN
        join = findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ResDetails.this);
                // Setting Dialog Title

                //alertDialog.setView(codeinput);
                LayoutInflater li = LayoutInflater.from(getBaseContext());
                View promptsView = li.inflate(R.layout.join_edittext, null);

                // set prompts.xml to alertdialog builder
                alertDialog.setView(promptsView);


                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.join_code_edittext);

                exist= false;
                alertDialog.setTitle("Enter Table Code: ");
                //Taking COde INput
                //codeinput= new EditText(ResDetails.this);
                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("JOIN", new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface dialog,int which) {
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(userInput.getText().toString()) && !exist && !userInput.getText().toString().isEmpty()) {

                                    User user = new User();
                                    user.setName("Ansh123211");

                                    reference.child(userInput.getText().toString()).child("User2").child("Orders").child("Default").setValue("default") ;
                                    reference.child(userInput.getText().toString()).child("User2").child("Amount").child("Default").setValue("default") ;

                                  //  reference.child(userInput.getText().toString()).child(user.getName()).setValue("Def");
                                    Intent intent = new Intent(getApplicationContext(), Table_Menu.class);
                                    startActivity(intent);

                                    // Write your code here to invoke YES event
                                    Toast.makeText(getApplicationContext(),userInput.getText().toString(), Toast.LENGTH_SHORT).show();

                                    exist= true;
                                }
                                else
                                    Toast.makeText(getApplicationContext(),"Incorrect Code", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        // Write your code here to invoke YES event
                       // Toast.makeText(getApplicationContext(), "Table Joined", Toast.LENGTH_SHORT).show();
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();

            }
        });

//CREATE

        create=findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ResDetails.this);

               final String code = generateString(6);
                // Setting Dialog Title
                alertDialog.setTitle("Your Table Code");

                // Setting Dialog Message
                alertDialog.setMessage("CODE: " + code );

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Join Table", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        if(true) {


                            reference.child(code).child("User1").child("Orders").child("Default").setValue("default") ;
                            reference.child(code).child("User1").child("Amount").child("Default").setValue("default") ;
                            Intent intent = new Intent(getApplicationContext(), Table_Menu.class);
                            Toast.makeText(getApplicationContext(), "Adding you to the Table", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                            // Write your code here to invoke YES event


                        }
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();
            }
        });
    }
    public void openMenu(){
        Intent intent = new Intent (this, Table_Menu.class);
    }

    public String generateString(int length){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i =0;i< length;i++)
        {
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    }


