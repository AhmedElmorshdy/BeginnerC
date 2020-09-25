package com.example.beginnerc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolderData> {
    List<Model>modelList;
    Context context;
    private OnItemClickListener mlistener;

    public ModelAdapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }
    public interface OnItemClickListener{

        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){

        mlistener = listener;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.design,parent,false);
        return new ViewHolderData(view,mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
      Model current = modelList.get(position);
      holder.image.setImageResource(current.getImage());
      holder.description.setText(current.getDescription());
      holder.name.setText(current.getName());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolderData extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView description;

        public ViewHolderData(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener !=null){
                        int position = getAdapterPosition();
                        if (position !=RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }

                }
            });

        }
    }
}
