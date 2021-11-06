package com.example.lab3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.textview = (TextView)findViewById(R.id.edittext1_1);

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            String answer = data.getStringExtra("answer");
                            MainActivity.this.textview.setText(answer);
                        }
                        if(result.getResultCode() == Activity.RESULT_CANCELED) {
                            Intent data = result.getData();
                            String answer = data.getStringExtra("answer");
                            MainActivity.this.textview.setText(answer);
                        }
                    }
                }
        );


        this.button = (Button)findViewById(R.id.button1);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Edit_one_Activity.class);
                String stringText = MainActivity.this.textview.getText().toString();
                intent.putExtra("text_for_edit", stringText);
                someActivityResultLauncher.launch(intent);
            }
        });
    }

}