package com.example.nahiduddinahammed.minidoctorproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {



    private Context mCtx;
    private List<Medicine> medicineList;

    public MedicineAdapter(Context mCtx, List<Medicine> medicineList) {
        this.mCtx = mCtx;
        this.medicineList = medicineList;
    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout,null);
        return new MedicineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {
        Medicine medicine = medicineList.get(position);
        holder.dragfor.setText(medicine.getDrugFor());
        holder.dragclass.setText(medicine.getDragClass());
        holder.brandname.setText(medicine.getBrandeName());
        holder.contains.setText(medicine.getContains());
        holder.dosageform.setText(medicine.getDosageForm());
        holder.price.setText(medicine.getPrice());



    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }

    public class MedicineViewHolder extends RecyclerView.ViewHolder {

        TextView dragfor, dragclass, brandname,contains,dosageform,price;





        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);



           dragfor= itemView.findViewById(R.id.DragFor);
           dragclass = itemView.findViewById(R.id.DrugsClass);
            brandname = itemView.findViewById(R.id.BrandName);
            contains= itemView.findViewById(R.id.Contains);
            dosageform = itemView.findViewById(R.id.DosageForm);
            price = itemView.findViewById(R.id.Price);

        }
    }
}
