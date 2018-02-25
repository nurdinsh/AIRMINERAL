package com.example.nurdiansyah.sc3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast toast = Toast.makeText(this, "Mohammad Nurdiansyah 1106130153", Toast.LENGTH_LONG);
        toast.show();

        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        Button maulogin = (Button)findViewById(R.id.Btlogin);

        maulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("EAD") && pass.equals("MOBILE")) {
                    Toast.makeText(getApplicationContext(), "Anda berhasil masuk", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else if(user.equals("")&& pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "jangan kasih kosong sob", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getApplicationContext(), "salah sob", Toast.LENGTH_LONG).show();

                }
            }

        });
    }
}
