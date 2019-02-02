package com.example.nahiduddinahammed.minidoctorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedicinePageActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    MedicineAdapter adapter;

    List<Medicine> medicineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_page);


        medicineList = new ArrayList<>();

        recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        medicineList.add(
                new Medicine(
                        "Drugs for peptic ulcer",
                        "H2 antagonists",
                        "FAMO",
                        "Famotidine 20mg & 40mg/tablet",
                        "Tablet",
                        "151.71 TK",
                        R.drawable.doc));

        medicineList.add(
                new Medicine(
                        "Drugs for hypertension",
                        "Angiotensin-converting enzyme (ACE) inhibitors",
                        "CATOPIL",
                        "Captopril USP 12.5mg & 25mg/tablet",
                        "Tablet",
                        " 175.00 TK",
                        R.drawable.doc));

        medicineList.add(
                new Medicine(
                        "Drugs for congestive heart failure (CHF)",
                        "Positive Inotropic drugs",
                        "AGOXIN",
                        "Digoxin 0.25mg/tablet",
                        "Tablet",
                        "109.00 TK",
                        R.drawable.doc));

        medicineList.add(
                new Medicine(
                        "Drugs for arrhythmias",
                        "Membrane stabilizing agent (Sodium channel blockers)",
                        "NORBIT",
                        "Disopyramide phosphate 100 mg/capsule",
                        "Capsule",
                        "240.00 TK",
                        R.drawable.doc));

        medicineList.add(
                new Medicine(
                        "Drugs for emetics",
                        "Prokinetic drugs",
                        "ADEGUT",
                        "Domperidone maleate 10mg/tablet",
                        "Tablet",
                        "75.00 TK",
                        R.drawable.doc));

        medicineList.add(
                new Medicine(
                        "Drugs for asthma & prophylaxis",
                        "Short-acting selective beta2-adrenoceptor stimulants",
                        "ALVOLEX",
                        "Salbutamol 2mg/5ml syrup",
                        "Syrup",
                        "16.00 TK",
                        R.drawable.doc));

        medicineList.add(
                new Medicine(
                        "Drugs for constipation",
                        "Osmotic purgatives",
                        "DEVOLAC",
                        "lactulose USP 3.35gm/concentrate oral solution; 1 tsf (5ml)",
                        "Oral solution",
                        "195.00 TK",
                        R.drawable.doc));

        medicineList.add(
                new Medicine(
                        "Drugs for cough & cold",
                        "Cough expectorants & mucolytics",
                        "AMBROX",
                        "Ambroxol hydrochloride BP 15mg/5ml syrup",
                        "Syrup",
                        "30.00 TKJ",
                        R.drawable.doc));

        medicineList.add(
                new Medicine(
                        "Drugs for diarrhoea",
                        "Anti-diarrhoeal Antiprotozoal",
                        "ZOXAN",
                        "Nitazoxanide INN 500mg/tablet",
                        "Tablet",
                        "180.00 TK",
                        R.drawable.doc));

        medicineList.add(
                new Medicine(
                        "Drugs for viral infections",
                        "Herpes simplex & Varicella-zoster virus infections",
                        "VIRUX",
                        "Acyclovir 200mg/5ml suspension",
                        "Suspension",
                        "125.00 TK",
                        R.drawable.doc));








        adapter = new MedicineAdapter(this,medicineList);
        recyclerView.setAdapter(adapter);
    }
}
