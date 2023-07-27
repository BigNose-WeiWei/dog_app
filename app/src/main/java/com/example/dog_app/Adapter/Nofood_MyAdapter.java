package com.example.dog_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dog_app.Model.Nofood;
import com.example.dog_app.R;

import java.util.ArrayList;

public class Nofood_MyAdapter  extends BaseAdapter implements Filterable {
    Context c;
    ArrayList<Nofood> originaArray,tempArray;
    CustomFilter cs;
    public  Nofood_MyAdapter (Context c, ArrayList<Nofood> originaArray){
        this.c = c;
        this.originaArray=originaArray;
        this.tempArray= originaArray;
    }

    @Override
    public Object getItem(int i) {
        return originaArray.get(i);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row  = inflater.inflate(R.layout.nofood_use,null);
        TextView ti = row.findViewById(R.id.te);
        ImageView il = row.findViewById(R.id.im);
        TextView be = row.findViewById(R.id.be);
        ti.setText(originaArray.get(i).getName());
        il.setImageResource(originaArray.get(i).getImage());
        be.setText(originaArray.get(i).getBecause());
        return row;
    }

    @Override
    public int getCount() {
        return originaArray.size();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Filter getFilter() {
        if (cs == null){
            cs = new CustomFilter();
        }
        return cs;
    }
    class CustomFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint != null && constraint.length() >0 ) {
                constraint = constraint.toString().toUpperCase();

                ArrayList<Nofood> filters = new ArrayList<>();
                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i).getName().toUpperCase().contains(constraint)) {
                        Nofood about = new Nofood(tempArray.get(i).getName(), tempArray.get(i).getImage(), tempArray.get(i).getBecause());
                        filters.add(about);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }
            else {
                results.count = tempArray.size();
                results.values = tempArray;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            originaArray = (ArrayList<Nofood>)filterResults.values;
            notifyDataSetChanged();
        }
    }
}

