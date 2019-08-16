//16-08-2019, 10116312, Faisal Rahmi, AKB-7/IF-7
package com.faisal.tugas_uas_akb_if7_10116312;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class TampilTemanActivity extends AppCompatActivity {

    Realm realm;
    EditText nim, nama, kelas, telp, email, sosmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_teman);
        /*
        TextView textView = (TextView) findViewById(R.id.hasilView);
        Realm realm = Realm.getDefaultInstance();
        RealmResults <User> results = realm.where(User.class).findAll();
        String text = "";
        for(User c:results){
            text = text+c.getNim()+"\n";
            text = text+c.getNama()+"\n";
            text = text+c.getKelas()+"\n";
            text = text+c.getNotelp()+"\n";
            text = text+c.getEmail()+"\n";
            text = text+c.getSosmed()+"\n\n\n";
        }
        textView.setText(text);
        */
    }

    public void kembali(View view) {
        Intent intent = new Intent(TampilTemanActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
