package com.example.kisileruygulamasi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    public KisilerDaoRepository krepo;
    public MutableLiveData<List<Kisiler>> kisilerListesi;

    @Inject
    public AnasayfaViewModel(KisilerDaoRepository krepo){
        this.krepo = krepo;
        kisileriYukle();
        kisilerListesi = krepo.kisilerListesi;
    }

    public void ara(String aramaKelimesi){
        krepo.ara(aramaKelimesi);
    }

    public void sil(int kisi_id){
        krepo.sil(kisi_id);
    }

    public void kisileriYukle(){
        krepo.kisileriYukle();
    }
}
