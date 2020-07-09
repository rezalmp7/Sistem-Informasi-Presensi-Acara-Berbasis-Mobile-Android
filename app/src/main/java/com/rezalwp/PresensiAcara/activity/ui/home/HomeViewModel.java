package com.rezalwp.PresensiAcara.activity.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Sistem Informasi Presensi Acara \n\n Aplikasi ini menggunakan REST API dari  \n\nhttps://kecankgood.000webhostapp.com/ " +
                "\n\n tolong bersabar jika loading lambat dan" +
                "\n dan harus refresh secara manual");
    }

    public LiveData<String> getText() {
        return mText;
    }
}