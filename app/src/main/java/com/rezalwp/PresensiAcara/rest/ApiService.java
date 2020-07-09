package com.rezalwp.PresensiAcara.rest;

import com.rezalwp.PresensiAcara.model.PresenceModel;
import com.rezalwp.PresensiAcara.model.ResponseErrorModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api")
    Call<List<PresenceModel>> getPresence(@Query("presensi") String presensi);

    @FormUrlEncoded
    @POST("api")
    Call<ResponseErrorModel> postPeserta(@Field("nama") String nama,
                                         @Field("noHp") String noHp,
                                         @Field("kategori") String kategori,
                                         @Field("institut") String institut,
                                         @Field("noTiket") String noTiket);
    @FormUrlEncoded
    @POST("apiHapus")
    Call<ResponseErrorModel> deletePeserta(@Field("id") String id);

    @FormUrlEncoded
    @POST("apiKehadiran")
    Call<ResponseErrorModel> postKehadiran(@Field("noTiket") String noTiket);
}
