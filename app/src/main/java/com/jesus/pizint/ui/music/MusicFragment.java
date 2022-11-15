package com.jesus.pizint.ui.music;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jesus.pizint.R;
import com.jesus.pizint.databinding.FragmentMusicBinding;

import Frontend_Pantallas.Public_NoticeOff;

public class MusicFragment extends Fragment{
    Button pag;

    private FragmentMusicBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MusicViewModel musicViewModel =
                new ViewModelProvider(this).get(MusicViewModel.class);
        binding = FragmentMusicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMusic;
        musicViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        pag = (Button) root.findViewById(R.id.publicnotice2);
        pag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente_pag = new Intent(getActivity(), Public_NoticeOff
                        .class);
                startActivity(siguiente_pag);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}