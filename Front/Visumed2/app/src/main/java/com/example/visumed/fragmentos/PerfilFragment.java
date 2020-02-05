package com.example.visumed.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.visumed.DrugstoreList;
import com.example.visumed.R;
import com.example.visumed.ScannerActivity;
import com.example.visumed.auth.SignInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class PerfilFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, null);

        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void buttonSignOutClick(View view) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            mAuth.signOut();
            Intent intent = new Intent(getActivity(), SignInActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getActivity(), "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    public void verFarmacias(View view){
        Intent intent = new Intent(getActivity(), DrugstoreList.class);
        startActivity(intent);
    }

    public void escanearMedicamento(View view) {
        Intent intent = new Intent(getActivity(), ScannerActivity.class);
        startActivity(intent);
    }
}
