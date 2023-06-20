package com.example.onthicodelan5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onthicodelan5.R;
import com.example.onthicodelan5.model.Lop;

import java.util.List;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.LopViewHolder> {
    private Context mContext;
    private List<Lop> mList;

    public LopAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Lop> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public LopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lop, parent, false);
        return new LopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LopViewHolder holder, int position) {
        Lop lop = mList.get(position);
        holder.txtMaLop.setText(String.valueOf(lop.getMalop()));
        holder.txtTenLop.setText(String.valueOf(lop.getTenlop()));
        holder.txtMoTa.setText(String.valueOf(lop.getMota()));

    }

    @Override
    public int getItemCount() {
        if (mList != null) return mList.size();
        return 0;
    }

    public class LopViewHolder extends RecyclerView.ViewHolder {
        private TextView txtMaLop, txtTenLop, txtMoTa;

        public LopViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaLop = itemView.findViewById(R.id.it_l_txt1);
            txtTenLop = itemView.findViewById(R.id.it_l_txt2);
            txtMoTa = itemView.findViewById(R.id.it_l_txt3);
        }
    }
}
