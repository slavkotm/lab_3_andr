package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Edit_one_Activity extends AppCompatActivity {

    private Button button, cancel;
    private EditText answer1, answer2;
    private String fname_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_one);


        Bundle extras = getIntent().getExtras();
        fname_name = extras.getString(MainActivity.Firstname_name);


        String [] spl_on_strings = fname_name.split(" ", 2);


        this.answer1 = (EditText) this.findViewById(R.id.edittext1_1);
        this.answer2 = (EditText) this.findViewById(R.id.edittext1_2);


        this.answer1.setText(spl_on_strings[0]);
        this.answer2.setText(spl_on_strings[1]);

        this.button = (Button)findViewById(R.id.button1_1);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                String firstname = answer1.getText().toString();
                String name = answer2.getText().toString();
                returnIntent.putExtra(MainActivity.Firstname_name,firstname + " " + name);
                Edit_one_Activity.this.setResult(Activity.RESULT_OK, returnIntent);
                Edit_one_Activity.this.finish();
            }
        });

        this.cancel = (Button)findViewById(R.id.button1_2);
        this.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_one_Activity.this.setResult(Activity.RESULT_CANCELED);
                Edit_one_Activity.this.finish();
            }
        });
    }


}