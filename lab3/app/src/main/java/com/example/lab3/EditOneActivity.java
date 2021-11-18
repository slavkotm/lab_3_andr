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

public class EditOneActivity extends OptionsMenuForOneActivity {
    private EditText answerOne, answerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_one);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        String[] splitOnWords = extras.getString(MainActivity.FirstnameName).split(" ", 2);

        this.answerOne = (EditText) this.findViewById(R.id.edittext1_1);
        this.answerTwo = (EditText) this.findViewById(R.id.edittext1_2);

        this.answerOne.setText(splitOnWords[0]);
        this.answerTwo.setText(splitOnWords[1]);

        Button button = (Button) findViewById(R.id.button1_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(MainActivity.FirstnameName,answerOne.getText().toString() + " " + answerTwo.getText().toString());
                EditOneActivity.this.setResult(Activity.RESULT_OK, returnIntent);
                EditOneActivity.this.finish();
            }
        });

        Button buttonCancel = (Button) findViewById(R.id.button1_2);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditOneActivity.this);
                builder.setMessage("Make a choice");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditOneActivity.this.setResult(Activity.RESULT_CANCELED);
                        EditOneActivity.this.finish();
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