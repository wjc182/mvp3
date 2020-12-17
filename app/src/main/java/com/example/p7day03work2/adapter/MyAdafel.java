package com.example.p7day03work2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.p7day03work2.R;
import com.example.p7day03work2.bean.JavaBean;

import java.util.ArrayList;

public class MyAdafel extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<JavaBean.ResultsDTO> list;

    public MyAdafel(Context context, ArrayList<JavaBean.ResultsDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rew_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JavaBean.ResultsDTO dto = list.get(position);
        ViewHolder v= (ViewHolder) holder;
        Glide.with(context).load(dto.getUrl()).into(v.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.rew_image);
        }
    }
}
