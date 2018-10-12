package com.example.ansh.ressplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private CustomAdapter customAdapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]
            {R.drawable.a, R.drawable.b,
            R.drawable.c};
    private String[] myImageNameList = new String[]{"Res 1", "Res 2",
            "Res 3", };
    private String[] myImageAddressList = new String[]{"UPES,Bidholi", "UPES, Kandoli",
            "Rajpur Road", };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
        imageModelArrayList = populateList();
        Log.d("hjhjh",imageModelArrayList.size()+"");
        customAdapter = new CustomAdapter(this,imageModelArrayList);
        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        Intent intent = new Intent(view.getContext(), ResDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent = new Intent(view.getContext(), ResDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                            Intent intent = new Intent(view.getContext(), ResDetails.class);
                            startActivity(intent);
                    break;
                    }
                }
            }
        });

    }

    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setName(myImageNameList[i]);
            imageModel.setName(myImageAddressList[i]);
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }
        return list;
    }

}