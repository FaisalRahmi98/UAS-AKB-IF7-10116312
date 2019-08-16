//15-08-2019, 10116312, Faisal Rahmi, AKB-7/IF-7
package com.faisal.tugas_uas_akb_if7_10116312;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {


    SharedPreferences sharedpreferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);

        final ProfilFragment profilFragment = new ProfilFragment();
        final KontakFragment kontakFragment = new KontakFragment();
        final TemanFragment temanFragment = new TemanFragment();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.idprofil){
                    setFragment(profilFragment);
                    return true;
                } else if(id == R.id.idkontak){
                    setFragment(kontakFragment);
                    return true;
                } else if(id == R.id.idteman){
                    setFragment(temanFragment);
                    return true;
                }
                return false;
            }
        });

        navigationView.setSelectedItemId(R.id.idprofil);
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    public void keluar(View view) {
        sharedpreferences = getSharedPreferences(DaftarActivity.MyFREFERENCES, Context.MODE_PRIVATE);
        String st = "off";
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(DaftarActivity.StatusLogin, st);
        editor.commit();

        Intent intent = new Intent(MenuActivity.this, MasukActivity.class);
        startActivity(intent);
        finish();
    }

    public void openTambah(View view) {
        Intent intent = new Intent(MenuActivity.this, TambahTemanActivity.class);
        startActivity(intent);
    }
    public void openTampil(View view) {
        Intent intent = new Intent(MenuActivity.this, TampilTemanActivity.class);
        startActivity(intent);
    }
    public void openEmail(View view) {
        String url = "mailto:rahmi.faisal@gmail.com";
        Intent email = new Intent(Intent.ACTION_VIEW);
        email.setData(Uri.parse(url));
        startActivity(email);
    }
    public void openTelp(View view) {
        String nomor = "083823516946";
        Intent panggil = new Intent(Intent.ACTION_DIAL);
        panggil.setData(Uri.fromParts("tel", nomor, null));
        startActivity(panggil);
    }
    public void openIg(View view) {
        String url = "https://www.instagram.com/faisal.rahmi/";
        Intent ig = new Intent(Intent.ACTION_VIEW);
        ig.setData(Uri.parse(url));
        startActivity(ig);
    }
}
