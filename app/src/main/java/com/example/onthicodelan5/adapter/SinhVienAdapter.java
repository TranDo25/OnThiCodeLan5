package com.example.onthicodelan5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onthicodelan5.R;
import com.example.onthicodelan5.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder> {
    private Context context;
    private List<SinhVien> mList;

    public SinhVienAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<SinhVien> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinhvien, parent, false);
        return new SinhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
        SinhVien sv = mList.get(position);
        holder.txtMsv.setText(String.valueOf(sv.getMsv()));
        holder.txtHoTen.setText(String.valueOf(sv.getHoten()));
        holder.txtNamSinh.setText(String.valueOf(sv.getNamsinh()));
        holder.txtQueQuan.setText(String.valueOf(sv.getQuequan()));
        holder.txtNamHoc.setText(String.valueOf(sv.getNamhoc()));
    }

    @Override
    public int getItemCount() {
        if(mList != null) return mList.size();
        return 0;
    }

    public class SinhVienViewHolder extends RecyclerView.ViewHolder {
        private TextView txtMsv, txtHoTen, txtNamSinh, txtQueQuan, txtNamHoc;

        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMsv = itemView.findViewById(R.id.txt_msv);
            txtHoTen = itemView.findViewById(R.id.txt_hoten);
            txtNamSinh = itemView.findViewById(R.id.txt_namsinh);
            txtQueQuan = itemView.findViewById(R.id.txt_quequan);
            txtNamHoc = itemView.findViewById(R.id.txt_namhoc);

        }
    }
}
