package com.jesus.pizint.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jesus.pizint.R;
import com.jesus.pizint.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Collections;

import Frontend_Pantallas.Public_NoticeOff;
import Frontend_Pantallas.publicacionAdapter;
import Frontend_Pantallas.subirBD;

public class HomeFragment extends Fragment {
    Button pag;

    private FragmentHomeBinding binding;
    private publicacionAdapter pAdapter;
    private RecyclerView pRecyclerView;
    private ArrayList<subirBD> pPublicacionesList = new ArrayList<>();
    private DatabaseReference mDatabase;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        pRecyclerView = (RecyclerView) root.findViewById(R.id.recyclerViewBD);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDatabase = FirebaseDatabase.getInstance().getReference("subirBD");

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        pag = (Button) root.findViewById(R.id.publicnotice1);
        pag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente_pag = new Intent(getActivity(), Public_NoticeOff
                        .class);
                startActivity(siguiente_pag);
            }
        });
        getPublicacionFromFirebase();
        return root;
    }

    private void getPublicacionFromFirebase(){
        mDatabase.child("Publicacion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot ds: snapshot.getChildren()){
                        String titulo = ds.child("titulo").getValue().toString();
                        String contenido = ds.child("contenido").getValue().toString();
                        pPublicacionesList.add(new subirBD(null,titulo,contenido,null));
                    }
                    Collections.reverse(pPublicacionesList);
                    pAdapter = new publicacionAdapter(pPublicacionesList,R.layout.recycler_bd_view);
                    pRecyclerView.setAdapter(pAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}