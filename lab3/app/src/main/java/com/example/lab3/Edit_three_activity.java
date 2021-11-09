package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_three_activity extends AppCompatActivity {

    private Button button, cancel;
    private EditText answer1;
    private String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_three);


        Intent intent = getIntent();

        comment = intent.getStringExtra(MainActivity.Comment);

        this.answer1 = (EditText) this.findViewById(R.id.edittext3_1);

        this.answer1.setText(comment.toString());

        this.button = (Button)findViewById(R.id.button3_1);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                String comment = answer1.getText().toString();
                returnIntent.putExtra(MainActivity.Comment,comment);
                Edit_three_activity.this.setResult(Activity.RESULT_OK, returnIntent);
                Edit_three_activity.this.finish();
            }
        });

        this.cancel = (Button)findViewById(R.id.button3_2);
        this.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_three_activity.this.setResult(Activity.RESULT_CANCELED);
                Edit_three_activity.this.finish();
            }
        });





    }
}