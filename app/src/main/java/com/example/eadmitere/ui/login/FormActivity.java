package com.example.eadmitere.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eadmitere.DBConnector;
import com.example.eadmitere.MainActivity;
import com.example.eadmitere.R;
import com.example.eadmitere.SecondFragment;
import com.example.eadmitere.User;

public class FormActivity extends AppCompatActivity {

    private Button but;
    private EditText email;
    private EditText nume;
    private EditText prenume;
    private EditText mediaSC;
    private EditText mediaBAC;




    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        but=(Button) findViewById(R.id.login);
        email=(EditText) findViewById(R.id.email);
        nume=(EditText) findViewById(R.id.nume);
        prenume=(EditText) findViewById(R.id.prenume);
        mediaSC=(EditText) findViewById(R.id.media);
        mediaBAC=(EditText) findViewById(R.id.mediabac);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBConnector db=new DBConnector(getApplicationContext());
                db.addUser(new User(email.getText().toString(),nume.getText().toString(),prenume.getText().toString(),mediaSC.getText().toString(),mediaBAC.getText().toString()));
                Toast.makeText(FormActivity.this, "Succes", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(FormActivity.this, MainActivity.class);
                startActivity(intent);
                return;
            }
        });
    }
}
