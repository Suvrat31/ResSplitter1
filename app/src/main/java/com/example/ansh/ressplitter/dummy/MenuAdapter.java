package com.example.ansh.ressplitter.dummy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ansh.ressplitter.R;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {

    ArrayList<MenuItem> items;
    public MenuAdapter(ArrayList<MenuItem> items) {
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.menu_item_layout,null);
        TextView textViewName = view.findViewById(R.id.text_view_menu_item_name);
        TextView textViewPrice = view.findViewById(R.id.text_view_menu_item_price);

        textViewName.setText(items.get(position).getItemName());
        textViewPrice.setText(String.valueOf(items.get(position).getPrice()));
        return view;
    }
}
