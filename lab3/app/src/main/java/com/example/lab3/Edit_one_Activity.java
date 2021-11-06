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
    private TextView textView;
    private EditText answer1, answer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_one);

        Bundle bundle = this.getIntent().getExtras();


        this.textView = (TextView) this.findViewById(R.id.edittext1_1);
        this.textView.setText(bundle.getString("text_for_edit"));
        String pred_last_result = this.textView.getText().toString();
        String[] sep = pred_last_result.split(" ");


        this.answer1 = (EditText) this.findViewById(R.id.edittext1_1);
        this.answer2 = (EditText) this.findViewById(R.id.edittext1_2);


        this.button = (Button)findViewById(R.id.button1_1);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("answer", Edit_one_Activity.this.answer1.getText().toString() +
                                                        Edit_one_Activity.this.answer2.getText().toString());
                Edit_one_Activity.this.setResult(Activity.RESULT_OK, returnIntent);
                Edit_one_Activity.this.finish();
            }
        });

        this.cancel = (Button)findViewById(R.id.button1_2);
        this.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("answer", pred_last_result);
                Edit_one_Activity.this.setResult(Activity.RESULT_CANCELED, returnIntent);
                Edit_one_Activity.this.finish();
            }
        });
    }


}