package com.example.lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditTwoActivity extends OptionsMenuForTwoActivity {
    private EditText answerOne, answerTwo, answerThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_two);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        String [] splitOnWords = extras.getString(MainActivity.Address).split(",", 3);

        this.answerOne = (EditText) this.findViewById(R.id.edittext2_1);
        this.answerTwo = (EditText) this.findViewById(R.id.edittext2_2);
        this.answerThree = (EditText) this.findViewById(R.id.edittext2_3);

        this.answerOne.setText(splitOnWords[0]);
        this.answerTwo.setText(splitOnWords[1]);
        this.answerThree.setText(splitOnWords[2]);

        Button button = (Button) findViewById(R.id.button2_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(MainActivity.Address,answerOne.getText().toString() + "," + answerTwo.getText().toString() + "," + answerThree.getText().toString());
                EditTwoActivity.this.setResult(Activity.RESULT_OK, returnIntent);
                EditTwoActivity.this.finish();
            }
        });

        Button cancel = (Button) findViewById(R.id.button2_2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditTwoActivity.this);
                builder.setMessage("Make a choice");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditTwoActivity.this.setResult(Activity.RESULT_CANCELED);
                        EditTwoActivity.this.finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}