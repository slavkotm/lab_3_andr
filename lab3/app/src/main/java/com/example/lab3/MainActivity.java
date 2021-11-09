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
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button, button2, button3;
    private TextView textview_firstname_name;
    private TextView textview_address;
    private TextView textview_comment;
    public static final String Firstname_name = "firstname_name";
    public static final String Address = "address";
    public static final String Comment = "comment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview_firstname_name = (TextView)findViewById(R.id.textview1);
        textview_address = (TextView) findViewById(R.id.textview2);
        textview_comment = (TextView) findViewById(R.id.textview3);

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            assert data != null;
                            String firstname_name = data.getStringExtra(Firstname_name);
                            if(firstname_name != null)
                                MainActivity.this.textview_firstname_name.setText(firstname_name);
                            String address = data.getStringExtra(Address);
                            if(address != null)
                                MainActivity.this.textview_address.setText(address);
                            String comment = data.getStringExtra(Comment);
                            if(comment != null)
                                MainActivity.this.textview_comment.setText(comment);
                        }
                    }
                }
        );


        this.button = (Button)findViewById(R.id.button1);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Edit_one_Activity.class);
                String stringText = MainActivity.this.textview_firstname_name.getText().toString();
                intent.putExtra(Firstname_name, stringText);
                someActivityResultLauncher.launch(intent);
            }
        });

        this.button2 = (Button)findViewById(R.id.button2);
        this.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Edit_two_activity.class);
                String stringText = MainActivity.this.textview_address.getText().toString();
                intent.putExtra(Address, stringText);
                someActivityResultLauncher.launch(intent);
            }
        });

        this.button3 = (Button)findViewById(R.id.button3);
        this.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Edit_three_activity.class);
                String stringText = MainActivity.this.textview_comment.getText().toString();
                intent.putExtra(Comment, stringText);
                someActivityResultLauncher.launch(intent);
            }
        });
    }

}