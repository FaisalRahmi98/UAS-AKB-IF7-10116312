//16-08-2019, 10116312, Faisal Rahmi, AKB-7/IF-7
package com.faisal.tugas_uas_akb_if7_10116312;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class TambahTemanActivity extends AppCompatActivity {
    Realm realm;
    EditText nim, nama, kelas, telp, email, sosmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_teman);

        /*
        Button button = (Button) findViewById(R.id.button8);
        nim = (EditText) findViewById(R.id.editNim);
        nama = (EditText) findViewById(R.id.editNama);
        kelas = (EditText) findViewById(R.id.editKelas);
        telp = (EditText) findViewById(R.id.editTelp);
        email = (EditText) findViewById(R.id.editEmail);
        sosmed = (EditText) findViewById(R.id.editSosmed);

        realm.init(this);
        realm = Realm.getDefaultInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();

                User user = realm.createObject(User.class, nim.getText().toString());
                user.setNama(nama.getText().toString());
                user.setKelas(kelas.getText().toString());
                user.setNotelp(telp.getText().toString());
                user.setEmail(email.getText().toString());
                user.setSosmed(sosmed.getText().toString());

                realm.commitTransaction();
            }
        });

        */
    }

    public void openMenu(View view) {
        Intent intent = new Intent(TambahTemanActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
