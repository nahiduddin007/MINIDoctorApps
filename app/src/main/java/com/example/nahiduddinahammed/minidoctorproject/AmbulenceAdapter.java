package com.example.nahiduddinahammed.minidoctorproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AmbulenceAdapter extends RecyclerView.Adapter<AmbulenceAdapter.AmbulenceViewHolder> {



    private Context mCtx;
    private List<Ambulence> ambulenceList;

    public AmbulenceAdapter(Context mCtx, List<Ambulence> ambulenceList) {
        this.mCtx = mCtx;
        this.ambulenceList = ambulenceList;
    }

    @NonNull
    @Override
    public AmbulenceAdapter.AmbulenceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.ambulence_layout_details,null);
        return new AmbulenceAdapter.AmbulenceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmbulenceAdapter.AmbulenceViewHolder holder, int position) {
        Ambulence ambulence = ambulenceList.get(position);
        holder.locationname.setText(ambulence.getName());
        holder.locationaddress.setText(ambulence.getAddrees());
        holder.phonenumber.setText(ambulence.getNumber());
    }

    @Override
    public int getItemCount() {
        return ambulenceList.size();
    }

    public class AmbulenceViewHolder extends RecyclerView.ViewHolder {


        TextView locationname, locationaddress, phonenumber;


        public AmbulenceViewHolder(@NonNull View itemView) {
            super(itemView);





            locationname= itemView.findViewById(R.id.LocationName);
            locationaddress = itemView.findViewById(R.id.ambulenceAdddress);
            phonenumber = itemView.findViewById(R.id.AmbulencePhonenum);
        }
    }
}
