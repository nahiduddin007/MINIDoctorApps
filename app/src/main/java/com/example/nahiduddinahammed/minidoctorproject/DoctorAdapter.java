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

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

     private Context mCtx;
     private List<Doctor> doctorsList;

    public DoctorAdapter(Context mCtx, List<Doctor> doctorsList) {
        this.mCtx = mCtx;
        this.doctorsList = doctorsList;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.medicine_layout_details,null);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {

        Doctor doctor = doctorsList.get(position);
        holder.textViewName.setText(doctor.getName());
        holder.textViewConsultant.setText(doctor.getConsultant());
        holder.textViewPhone.setText(doctor.getPhone());
        holder.textViewHospital.setText(doctor.getHospital());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(doctor.getImage()));

    }

    @Override
    public int getItemCount() {
      return doctorsList.size();
    }

    class DoctorViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewName, textViewConsultant, textViewPhone, textViewHospital;


        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewConsultant = itemView.findViewById(R.id.textViewConsultant);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
            textViewHospital = itemView.findViewById(R.id.textViewHospital);

        }
    }
}
