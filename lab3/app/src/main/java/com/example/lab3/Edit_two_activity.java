package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_two_activity extends AppCompatActivity {

    private Button button, cancel;
    private EditText answer1, answer2, answer3;
    private String address_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_two);




        Intent intent = getIntent();

        address_= intent.getStringExtra(MainActivity.Address);

        String [] spl_on_strings = address_.split(",", 3);


        this.answer1 = (EditText) this.findViewById(R.id.edittext2_1);
        this.answer2 = (EditText) this.findViewById(R.id.edittext2_2);
        this.answer3 = (EditText) this.findViewById(R.id.edittext2_3);


        this.answer1.setText(spl_on_strings[0]);
        this.answer2.setText(spl_on_strings[1]);
        this.answer3.setText(spl_on_strings[2]);



        this.button = (Button)findViewById(R.id.button2_1);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                String country = answer1.getText().toString();
                String city = answer2.getText().toString();
                String number = answer3.getText().toString();
                returnIntent.putExtra(MainActivity.Address,country + "," + city + "," + number);
                Edit_two_activity.this.setResult(Activity.RESULT_OK, returnIntent);
                Edit_two_activity.this.finish();
            }
        });

        this.cancel = (Button)findViewById(R.id.button2_2);
        this.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_two_activity.this.setResult(Activity.RESULT_CANCELED);
                Edit_two_activity.this.finish();
            }
        });



    }
}