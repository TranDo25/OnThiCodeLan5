package com.example.onthicodelan5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onthicodelan5.R;
import com.example.onthicodelan5.model.DangKyLop;

import org.w3c.dom.Text;

import java.util.List;

public class DkyLopAdapter extends RecyclerView.Adapter<DkyLopAdapter.DkyLopViewHolder> {
    private Context mContext;
    private List<DangKyLop> mList;

    public DkyLopAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<DangKyLop> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DkyLopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dangkylop, parent, false);
        return new DkyLopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DkyLopViewHolder holder, int position) {
        DangKyLop dangKyLop = mList.get(position);
        holder.txtID.setText(String.valueOf(dangKyLop.getId()));
        holder.txtMaSV.setText(String.valueOf(dangKyLop.getMasv()));
        holder.txtMaLop.setText(String.valueOf(dangKyLop.getMalop()));
        holder.txtKyHoc.setText(String.valueOf(dangKyLop.getKyhoc()));
        holder.txtSoTC.setText(String.valueOf(dangKyLop.getSotc()));
    }

    @Override
    public int getItemCount() {
        if(mList != null) return mList.size();
        return 0;
    }

    public class DkyLopViewHolder extends RecyclerView.ViewHolder {
        private TextView txtID, txtMaLop, txtMaSV, txtKyHoc, txtSoTC;

        public DkyLopViewHolder(@NonNull View itemView) {
            super(itemView);
            txtID = itemView.findViewById(R.id.dkl_id);
            txtMaLop = itemView.findViewById(R.id.dkl_mlop);
            txtMaSV = itemView.findViewById(R.id.dkl_msv);
            txtKyHoc = itemView.findViewById(R.id.dkl_khoc);
            txtSoTC = itemView.findViewById(R.id.dkl_stc);
        }
    }
}
