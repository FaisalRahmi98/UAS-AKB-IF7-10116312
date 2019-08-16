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

public class DaftarActivity extends AppCompatActivity {
    EditText edit1,edit2,edit3;
    Button button1;

    public static final String MyFREFERENCES = "MyPrefs";
    public static final String Username = "usernameKey";
    public static final String Password = "passwordKey";
    public static final String StatusLogin = "statusLoginKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);


        edit1 = (EditText) findViewById(R.id.editText5);
        edit2 = (EditText) findViewById(R.id.editText7);
        edit3 = (EditText) findViewById(R.id.editText6);

        button1 = (Button) findViewById(R.id.button3);

        sharedpreferences = getSharedPreferences(MyFREFERENCES, Context.MODE_PRIVATE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edit1.getText().toString();
                String pass = edit2.getText().toString();
                String konpass = edit3.getText().toString();
                String st = "off";

                String tempUser = sharedpreferences.getString("usernameKey", "Username");
                if(user.equals(tempUser)) {
                    Toast.makeText(DaftarActivity.this, "Username Sudah Digunakan", Toast.LENGTH_LONG).show();
                    edit1.setText(null);
                    edit2.setText(null);
                    edit3.setText(null);
                } else {
                    if(!pass.equals(konpass)){
                        Toast.makeText(DaftarActivity.this, "Konfirmasi Password Tidak Sesuai", Toast.LENGTH_LONG).show();
                    } else {
                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString(Username, user);
                        editor.putString(Password, pass);
                        editor.putString(StatusLogin, st);
                        editor.commit();

                        Toast.makeText(DaftarActivity.this, "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(DaftarActivity.this, MasukActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    public void openMasuk(View view) {
        Intent intent = new Intent(DaftarActivity.this, MasukActivity.class);
        startActivity(intent);
        finish();
    }
}
