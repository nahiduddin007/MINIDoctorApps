package com.example.nahiduddinahammed.minidoctorproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ConsultantListView extends AppCompatActivity {
    private Context context;
    private ListView listView;
    private String[] consult;
    private int[] flags ={R.drawable.neurology,R.drawable.pain,
            R.drawable.heart,R.drawable.diabetics,
            R.drawable.headneck,R.drawable.eye,
            R.drawable.sex,R.drawable.dermatologist,
            R.drawable.baby,R.drawable.kidney};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_list_view);

        listView=findViewById(R.id.ListViewId);
        consult=getResources().getStringArray(R.array.Consultant_doctor);



        //final String[] consultant = getResources().getStringArray(R.array.Consultant_doctor);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(ConsultantListView.this,R.layout.list_sample,R.id.textViewId,consultant);






        CustomAdapter adapter = new CustomAdapter(this,consult, flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String value = consult[position];
                Toast.makeText(ConsultantListView.this,value,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ConsultantListView.this,DoctorsPageActivity.class);
                startActivity(intent);


            }
        });






    }
}
