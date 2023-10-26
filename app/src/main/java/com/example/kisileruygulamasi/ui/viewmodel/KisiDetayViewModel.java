package com.example.kisileruygulamasi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiDetayViewModel extends ViewModel {
    public KisilerDaoRepository krepo;

    @Inject
    public KisiDetayViewModel(KisilerDaoRepository krepo){
        this.krepo = krepo;
    }

    public void guncelle(int kisi_id,String kisi_ad){
        krepo.guncelle(kisi_id,kisi_ad);
    }
}
