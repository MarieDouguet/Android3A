package com.example.android3a.presentation.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3a.R;
import com.example.android3a.presentation.model.Countries;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private List<Countries> values;
    private OnItemClickListener listener;

    ListAdapter(List<Countries> values, OnItemClickListener listener) {
        this.values = values;
        this.listener = listener;
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView txtHeader;
        TextView txtFooter;
        View layout;
        Button button;

        ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter =  v.findViewById(R.id.secondLine);
            button = v.findViewById(R.id.favBtn);

        }
    }


    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.txtHeader.setText(values.get(position).getCountry());
        holder.txtFooter.setText(values.get(position).getCountryCode());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(values.get(position));
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Countries values);
    }
     void filteredList(List<Countries> filteredList){
        values = filteredList;
        notifyDataSetChanged();
     }
}