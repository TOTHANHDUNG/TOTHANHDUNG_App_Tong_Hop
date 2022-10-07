package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FashionAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Fashion> fashionList;

    public FashionAdapter(Context context, int layout, List<Fashion> fashionList) {
        this.context = context;
        this.layout = layout;
        this.fashionList = fashionList;
    }
    @Override
    public int getCount() {
        return fashionList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMota, txtTien;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();

            //anh xa view
            holder.txtTen = (TextView) view.findViewById(R.id.textViewTen);
            holder.txtMota = (TextView) view.findViewById(R.id.textViewMota);
            holder.imgHinh = (ImageView) view.findViewById(R.id.imgAbum1);
            holder.txtTien = (TextView) view.findViewById(R.id.textViewTien);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        //gan gia tri
        Fashion fashion = fashionList.get(i);
        holder.txtTen.setText(fashion.getTen());
        holder.txtMota.setText(fashion.getMota());
        holder.imgHinh.setImageResource(fashion.getHinh());
        holder.txtTien.setText(fashion.getTien());

        return view;
    }
}
