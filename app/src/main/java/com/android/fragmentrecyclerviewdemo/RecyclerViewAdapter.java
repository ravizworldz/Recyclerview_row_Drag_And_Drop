package com.android.fragmentrecyclerviewdemo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewModel>
            implements  RecyclerRowMoveCallback.RecyclerViewRowTouchHelperContract{
        private List<DataModel> dataList;

        public void setDataList(List<DataModel> dataList) {
            this.dataList = dataList;

        }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);

        return new MyViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewModel holder, int position) {
        holder.textViewTitle.setText(dataList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onRowMoved(int from, int to) {
        if(from < to) {
            for(int i = from; i < to; i++) {
                Collections.swap(dataList, i, i+1);
            }
        } else {
            for (int i = from; i > to; i--) {
                Collections.swap(dataList, i, i-1);
            }
        }
        notifyItemMoved(from, to);
    }

    @Override
    public void onRowSelected(MyViewModel myViewHolder) {
        myViewHolder.itemView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void onRowClear(MyViewModel myViewHolder) {
        myViewHolder.itemView.setBackgroundColor(Color.WHITE);
    }

    class MyViewModel extends RecyclerView.ViewHolder {

        TextView textViewTitle;

        public MyViewModel(View view) {
            super(view);
            textViewTitle = view.findViewById(R.id.textViewTitle);

        }
    }
}
