package com.example.xyzreader.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private String[] body;
    Context context;

    public ArticleAdapter(String body, Context context){
         this.body= body.split("\\r\\n"); // "[\\r\\n]+" removes too much, no line breaks. hard to read.
         this.context = context;
    }


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.body_list_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return body.length;
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder{

        TextView textbody;


        public ArticleViewHolder(View itemView) {
            super(itemView);
            textbody = itemView.findViewById(R.id.body_item);
        }

        public void bind(int position){
            textbody.setText(body[position]);
        }
    }
}
