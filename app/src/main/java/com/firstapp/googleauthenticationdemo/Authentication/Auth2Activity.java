package com.firstapp.googleauthenticationdemo.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firstapp.googleauthenticationdemo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Auth2Activity extends AppCompatActivity {
    EditText mail;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    String mailStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth2);

        mail=findViewById(R.id.mail);

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
    }

    public void reset(View view) {
        progressDialog.show();
        progressDialog.setMessage("Reset link Sending!");

        mailStr=mail.getText().toString();

        firebaseAuth.sendPasswordResetEmail(mailStr).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progressDialog.dismiss();
                if(!task.isSuccessful())
                {
                    Toast.makeText(Auth2Activity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Auth2Activity.this, "Reset link Send Success", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(Auth2Activity.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}