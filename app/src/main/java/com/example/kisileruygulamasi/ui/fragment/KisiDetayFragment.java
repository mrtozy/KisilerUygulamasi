package com.example.kisileruygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisileruygulamasi.R;
import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding;
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding;
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel;
import com.example.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiDetayFragment extends Fragment {
    private FragmentKisiDetayBinding binding;
    private KisiDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKisiDetayBinding.inflate(inflater, container, false);

        binding.toolbarKisiDetay.setTitle("Kişi Detay");

        KisiDetayFragmentArgs bundle = KisiDetayFragmentArgs.fromBundle(getArguments());
        Kisiler gelenKisi = bundle.getKisi();

        binding.editTextKisiAd.setText(gelenKisi.getName());


        binding.buttonGuncelle.setOnClickListener(view -> {
            String kisi_ad = binding.editTextKisiAd.getText().toString();


            viewModel.guncelle(gelenKisi.getId(),kisi_ad);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiDetayViewModel.class);
    }
}