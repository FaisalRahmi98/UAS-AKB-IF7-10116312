//15-08-2019, 10116312, Faisal Rahmi, AKB-7/IF-7
package com.faisal.tugas_uas_akb_if7_10116312;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MasukActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);


        button = (Button) findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(DaftarActivity.MyFREFERENCES, Context.MODE_PRIVATE);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempUser = sharedpreferences.getString(DaftarActivity.Username, "Username");
                String tempPass = sharedpreferences.getString(DaftarActivity.Password, "Password");

                EditText ET1 = (EditText) findViewById(R.id.editText3);
                EditText ET2 = (EditText) findViewById(R.id.editText4);

                String us = ET1.getText().toString();
                String ps = ET2.getText().toString();

                if((us.equals(tempUser)) && (ps.equals(tempPass))){
                    String st = "on";
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(DaftarActivity.StatusLogin, st);
                    editor.commit();

                    Intent intent = new Intent(MasukActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(MasukActivity.this, "Login Gagal", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void openDaftar(View view) {
        Intent intent = new Intent(MasukActivity.this, DaftarActivity.class);
        startActivity(intent);
    }
}
