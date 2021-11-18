package com.example.lab3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends OptionsMenuForMainActivity {
    private TextView textviewFirstnameName;
    private TextView textviewAddress;
    private TextView textviewComment;
    public static final String FirstnameName = "firstname_name";
    public static final String Address = "address";
    public static final String Comment = "comment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textviewFirstnameName = (TextView)findViewById(R.id.textview1);
        textviewAddress = (TextView)findViewById(R.id.textview2);
        textviewComment = (TextView)findViewById(R.id.textview3);

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            assert data != null;
                            String firstname_name = data.getStringExtra(FirstnameName);
                            if(firstname_name != null)
                                MainActivity.this.textviewFirstnameName.setText(firstname_name);
                            String address = data.getStringExtra(Address);
                            if(address != null)
                                MainActivity.this.textviewAddress.setText(address);
                            String comment = data.getStringExtra(Comment);
                            if(comment != null)
                                MainActivity.this.textviewComment.setText(comment);
                        }
                    }
                }
        );

        Button buttonOne = (Button) findViewById(R.id.button1);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditOneActivity.class);
                String stringText = MainActivity.this.textviewFirstnameName.getText().toString();
                intent.putExtra(FirstnameName, stringText);
                someActivityResultLauncher.launch(intent);
            }
        });

        Button buttonTwo = (Button) findViewById(R.id.button2);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditTwoActivity.class);
                String stringText = MainActivity.this.textviewAddress.getText().toString();
                intent.putExtra(Address, stringText);
                someActivityResultLauncher.launch(intent);
            }
        });

        Button buttonThree = (Button) findViewById(R.id.button3);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditThreeActivity.class);
                String stringText = MainActivity.this.textviewComment.getText().toString();
                intent.putExtra(Comment, stringText);
                someActivityResultLauncher.launch(intent);
            }
        });
    }
}