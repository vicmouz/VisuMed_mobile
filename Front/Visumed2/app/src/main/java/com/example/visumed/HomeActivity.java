package com.example.visumed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.visumed.auth.FirebaseAuthListener;
import com.example.visumed.auth.SignInActivity;
import com.example.visumed.fragmentos.HomeFragment;
import com.example.visumed.fragmentos.PerfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FirebaseAuth mAuth;
    FirebaseAuthListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.mAuth = FirebaseAuth.getInstance();
        this.authListener = new FirebaseAuthListener(this);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        getSupportActionBar().setElevation(0);

        BottomNavigationView navigationView = findViewById(R.id.menu_bottom);
        navigationView.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.container_frag, new HomeFragment()).commit();
    }

    public void buttonSignOutClick(View view) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null) {
            mAuth.signOut();
            Intent intent = new Intent(HomeActivity.this, SignInActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(HomeActivity.this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_perfil:
                fragment = new PerfilFragment();
                break;
        }

        if(fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_frag, fragment).commit();
            return true;
        }

        return false;
    }

    public void detalheRemedio(View view) {
        Intent intent = new Intent(this, DrugDetailsActivity.class);
        startActivity(intent);
    }
}
