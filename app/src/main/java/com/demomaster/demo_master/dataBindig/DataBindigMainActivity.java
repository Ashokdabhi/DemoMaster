package com.demomaster.demo_master.dataBindig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.demomaster.R;

public class DataBindigMainActivity extends AppCompatActivity {

    private TextView nameText;
    private TextView emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_bindig_main);

        nameText = findViewById(R.id.txt_name);
        emailText = findViewById(R.id.txt_email);

        nameText.setText(getCurentStudent().getStudentName());
        emailText.setText(getCurentStudent().getStudentEmail());

    }

    private Student getCurentStudent() {
        Student student = new Student();
        student.setStudentName("Ashok");
        student.setStudentEmail("dalvadiashok@gmail.com");
        return student;
    }
}
