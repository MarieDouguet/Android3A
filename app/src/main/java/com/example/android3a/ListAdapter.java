package com.example.android3a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


    private List<Countries> values;
    private OnCovidListener mOnCovidListener;

    public ListAdapter(List<Countries> values, OnCovidListener mOnCovidListener) {
        this.values = values;
        this.mOnCovidListener = mOnCovidListener;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView txtHeader;
        TextView txtFooter;
        View layout;
        OnCovidListener onCovidListener;

        ViewHolder(View v, OnCovidListener onCovidListener) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            this.onCovidListener = onCovidListener;

            v.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            onCovidListener.onCovidClick(getAdapterPosition());
        }
    }

    public interface OnCovidListener{
        void onCovidClick (int position);
    }

    public void add(int position, Countries item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<Countries> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v, mOnCovidListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Countries currentCountry = values.get(position);
        holder.txtHeader.setText(currentCountry.getCountry());
        holder.txtFooter.setText(currentCountry.getCountryCode());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}