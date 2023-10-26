package com.example.kisileruygulamasi.di;

import android.content.Context;

import androidx.room.Room;

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;
import com.example.kisileruygulamasi.room.KisilerDao;
import com.example.kisileruygulamasi.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDaoRepository provideKisilerDaoRepository(KisilerDao kdao){
        return new KisilerDaoRepository(kdao);
    }

    @Provides
    @Singleton
    public KisilerDao provideKisilerDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class,"room.sqlite")
                .createFromAsset("room.sqlite").build();
        return vt.getKisilerDao();
    }
}
