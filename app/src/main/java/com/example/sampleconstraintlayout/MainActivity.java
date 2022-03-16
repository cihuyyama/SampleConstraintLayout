package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edemail, edpassword;
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.daftar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), DaftarMenu.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btSignin);
        edemail = findViewById(R.id.edEmail);
        edpassword = findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                if (nama.equals("iqbal") && password.equals("iqbal123")){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Sukses",Toast.LENGTH_LONG);
                    t.show();
                    Bundle b = new Bundle();
                    b.putString("a",nama.trim());
                    b.putString("b",password.trim());
                    Intent i = new Intent(getApplicationContext(),ActivityKedua.class);
                    i.putExtras(b);
                    startActivity(i);
                }
                else if (password.equals("iqbal123")){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email anda Salah",Toast.LENGTH_LONG);
                    t.show();
                }
                else if (nama.equals("iqbal")){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Password anda Salah",Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password anda Salah",Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }
}