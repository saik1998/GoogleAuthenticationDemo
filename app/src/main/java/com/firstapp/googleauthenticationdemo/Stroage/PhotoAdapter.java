package com.firstapp.googleauthenticationdemo.Stroage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firstapp.googleauthenticationdemo.R;

import java.util.List;

public class PhotoAdapter extends BaseAdapter {
    Context context;
    List<PhotoModel> photoModelList;
    LayoutInflater layoutInflater;

    public PhotoAdapter(Context context, List<PhotoModel> photoModelList) {
        this.context = context;
        this.photoModelList = photoModelList;

        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return photoModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View root=layoutInflater.inflate(R.layout.custom_photo,null);
        ImageView imageView=root.findViewById(R.id.img1);
        TextView textView=root.findViewById(R.id.filename);

        textView.setText(photoModelList.get(i).getName());
        Glide.with(context)
                .load(photoModelList.get(i).getImage())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
        return root;
    }
}
