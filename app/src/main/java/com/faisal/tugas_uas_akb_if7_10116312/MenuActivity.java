package com.faisal.tugas_uas_akb_if7_10116312;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class MenuActivity extends AppCompatActivity {


    SharedPreferences sharedpreferences;
    Button button;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        /*
        text1 = (TextView) findViewById(R.id.textView13);

        button = (Button) findViewById(R.id.button2);
        sharedpreferences = getSharedPreferences(DaftarActivity.MyFREFERENCES, Context.MODE_PRIVATE);
        String tempUser = sharedpreferences.getString(DaftarActivity.Username, "Username");

        text1.setText(tempUser);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = "off";
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(DaftarActivity.StatusLogin, st);
                editor.commit();

                Intent intent = new Intent(MenuActivity.this, MasukActivity.class);
                startActivity(intent);
                finish();
            }
        });

        */

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
