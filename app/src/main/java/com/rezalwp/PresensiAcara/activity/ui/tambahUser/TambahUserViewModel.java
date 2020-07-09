package com.rezalwp.PresensiAcara.activity.ui.tambahUser;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rezalwp.PresensiAcara.model.ResponseErrorModel;
import com.rezalwp.PresensiAcara.rest.ApiConfig;
import com.rezalwp.PresensiAcara.rest.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahUserViewModel extends ViewModel {
    private String TAG = "retrofit";
    private MutableLiveData<ResponseErrorModel> responseErrorModelMutableLiveData;

    public LiveData<ResponseErrorModel> postDataPesertas(String nama, String noHp, String kategori, String institut, String noTiket) {
        if(responseErrorModelMutableLiveData == null) {
            responseErrorModelMutableLiveData = new MutableLiveData<>();

            postDataPeserta(nama, noHp, kategori, institut, noTiket);
        }
        return responseErrorModelMutableLiveData;
    }

    private void postDataPeserta(String nama, String noHp, String kategori, String institut, String noTiket) {
        ApiService apiService = ApiConfig.getApiService();
        apiService.postPeserta(nama,
                noHp,
                kategori,
                institut,
                noTiket)
                .enqueue(new Callback<ResponseErrorModel>() {
                    @Override
                    public void onResponse(Call<ResponseErrorModel> call, Response<ResponseErrorModel> response) {
                        if (response.isSuccessful()) {
                            Log.d(TAG, "onResponse: SUKSES > " + response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }
}