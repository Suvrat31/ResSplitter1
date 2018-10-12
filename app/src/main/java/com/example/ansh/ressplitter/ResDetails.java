package com.example.ansh.ressplitter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResDetails extends AppCompatActivity {

    public Button join, create;

    EditText codeinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_details);
//JOIN
        join = findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ResDetails.this);

                // Setting Dialog Title
                alertDialog.setTitle("Enter Table Code: ");
                //Taking COde INput
                codeinput= new EditText(getApplicationContext());
                alertDialog.setView(codeinput);
                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("JOIN", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        if(true) {

                            Intent intent = new Intent(getApplicationContext(), Menu.class);
                            startActivity(intent);
                            // Write your code here to invoke YES event
                            Toast.makeText(getApplicationContext(), "Adding you to the Table", Toast.LENGTH_SHORT).show();

                        }
                        // Write your code here to invoke YES event
                        Toast.makeText(getApplicationContext(), "Table Joined", Toast.LENGTH_SHORT).show();
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

                // Setting Dialog Title
                alertDialog.setTitle("Your Table Code");

                // Setting Dialog Message
                alertDialog.setMessage("CODE: XYZ");


                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Join Table", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        if(true) {

                            Intent intent = new Intent(getApplicationContext(), Menu.class);
                            startActivity(intent);
                            // Write your code here to invoke YES event
                            Toast.makeText(getApplicationContext(), "Adding you to the Table", Toast.LENGTH_SHORT).show();

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
        Intent intent = new Intent (this, Menu.class);
    }

}
