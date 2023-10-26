package com.example.kisileruygulamasi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiKayitViewModel extends ViewModel {
    public KisilerDaoRepository krepo;

    @Inject
    public KisiKayitViewModel(KisilerDaoRepository krepo) {
        this.krepo = krepo;
    }

    public void kaydet(String kisi_ad){
        krepo.kaydet(kisi_ad);
    }
}
