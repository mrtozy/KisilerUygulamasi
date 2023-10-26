package com.example.kisileruygulamasi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisileruygulamasi.data.entity.Kisiler;
import com.example.kisileruygulamasi.room.KisilerDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KisilerDaoRepository {
    public MutableLiveData<List<Kisiler>> kisilerListesi = new MutableLiveData<>();
    private KisilerDao kdao;

    public KisilerDaoRepository(KisilerDao kdao){
        this.kdao = kdao;
    }

    public void kaydet(String name){
        Kisiler yeniKisi = new Kisiler(0,name);
        kdao.kaydet(yeniKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void guncelle(int id,String name){
        Kisiler guncellenenKisi = new Kisiler(id,name);
        kdao.guncelle(guncellenenKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void ara(String aramaKelimesi){
        kdao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        kisilerListesi.setValue(kisilers);
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void sil(int id){
        Kisiler silinenKisi = new Kisiler(id,"");
        kdao.sil(silinenKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {
                        kisileriYukle();
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void kisileriYukle(){
        kdao.kisileriYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        kisilerListesi.setValue(kisilers);
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }
}
