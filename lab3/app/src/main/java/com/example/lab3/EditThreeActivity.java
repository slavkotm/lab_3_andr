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

public class EditThreeActivity extends OptionsMenuForThreeActivity {
    private EditText answerOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_three);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        String comment = extras.getString(MainActivity.Comment);

        this.answerOne = (EditText) this.findViewById(R.id.edittext3_1);

        this.answerOne.setText(comment.toString());

        Button button = (Button) findViewById(R.id.button3_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(MainActivity.Comment, answerOne.getText().toString());
                EditThreeActivity.this.setResult(Activity.RESULT_OK, returnIntent);
                EditThreeActivity.this.finish();
            }
        });

        Button cancel = (Button) findViewById(R.id.button3_2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditThreeActivity.this);
                builder.setMessage("Make a choice");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditThreeActivity.this.setResult(Activity.RESULT_CANCELED);
                        EditThreeActivity.this.finish();
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