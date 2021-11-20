package co.org.poli.appusuarios;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.net.URL;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ElementViewHolder>{

    private User[] localDataset;

    public static class ElementViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private TextView textViewDesc;

        public ElementViewHolder (@NonNull View itemView ){
            super(itemView);
            textViewName = itemView.findViewById(R.id.tvName);
            textViewDesc = itemView.findViewById(R.id.tvDesc);
        }

        public TextView getTextView(){
            return textViewName;
        }
        public TextView getTextViewDesc(){
            return textViewDesc;
        }

    }

    public UserAdapter(User[] inputDataset){
        this.localDataset = inputDataset;
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element, parent, false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
        holder.getTextView().setText(localDataset[position].getName());
        holder.getTextViewDesc().setText(localDataset[position].getDescription());
    }

    @Override
    public int getItemCount() {
        return localDataset.length;
    }
}
