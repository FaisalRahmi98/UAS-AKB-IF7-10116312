package com.faisal.tugas_uas_akb_if7_10116312;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {

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
}
