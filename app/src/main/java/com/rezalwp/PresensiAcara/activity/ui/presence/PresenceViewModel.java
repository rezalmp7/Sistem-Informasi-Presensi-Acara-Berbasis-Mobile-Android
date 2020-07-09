package com.rezalwp.PresensiAcara.activity.ui.presence;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rezalwp.PresensiAcara.model.PresenceModel;
import com.rezalwp.PresensiAcara.rest.ApiConfig;
import com.rezalwp.PresensiAcara.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenceViewModel extends ViewModel {

    private String TAG = "retrofit";
    private MutableLiveData<List<PresenceModel>> presenceModelMutableLiveData;

    public LiveData<List<PresenceModel>> getPresence() {
        if(presenceModelMutableLiveData == null) {
            presenceModelMutableLiveData = new MutableLiveData<List<PresenceModel>>();

            loadDataPresence();
        }
        return presenceModelMutableLiveData;
    }

    private void loadDataPresence() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getPresence("datang")
                .enqueue(new Callback<List<PresenceModel>>() {
                    @Override
                    public void onResponse(Call<List<PresenceModel>> call, Response<List<PresenceModel>> response) {
                        if (response.isSuccessful()) {
                            presenceModelMutableLiveData.setValue(response.body());
                            Log.d(TAG, "onResponse: " + response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PresenceModel>> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getLocalizedMessage() + "|" +
                                t.getMessage());
                    }
                });
    }
}