package com.example.paco.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimalsAdapter extends BaseAdapter {


    protected Activity activity;
    protected ArrayList<Animal> animals;

    public AnimalsAdapter (Activity activity, ArrayList<Animal> animals) {
        this.activity = activity;
        this.animals = animals;
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    public void clear() {
        animals.clear();
    }

    public void addAll(ArrayList<Animal> category) {
        for (int i =0 ; i < category.size(); i++) {
            animals.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return animals.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int index, View v, ViewGroup parent) {

        if (v == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.listview_item, null);
        }

        Animal animal = animals.get(index);

        ImageView image = v.findViewById(R.id.imgAnimal);
        image.setImageResource(animal.getIdImage());

        TextView name = v.findViewById(R.id.txtName);
        name.setText(animal.getName());

        TextView description = v.findViewById(R.id.txtDes);
        description.setText(animal.getDescription());

        return v;
    }
}
