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

    /**
     * Do not forget to encapsulate the data
     */
    private List<Model> modelList;
    // No need for this and not a good practice
    //private Context context;
    private OnItemClickListener mlistener;

    public ModelAdapter(List<Model> modelList/*, Context context*/) {
        this.modelList = modelList;
        //this.context = context;
    }

    public interface OnItemClickListener {

        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        mlistener = listener;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false);
        return new ViewHolderData(view, mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
        Model current = modelList.get(position);
        /*
         * there is another good practice here
         */
        holder.bind(current);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolderData extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView description;
        OnItemClickListener listener;

        public ViewHolderData(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            this.listener = listener;
        }

        public void bind(Model current) {
            image.setImageResource(current.getImage());
            description.setText(current.getDescription());
            name.setText(current.getName());

            /*
            ** set the listeners
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }

                }
            });
        }
    }
}
