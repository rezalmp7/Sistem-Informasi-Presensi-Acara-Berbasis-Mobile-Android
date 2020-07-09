package com.rezalwp.PresensiAcara.activity.ui.presence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rezalwp.PresensiAcara.R;
import com.rezalwp.PresensiAcara.activity.HomeActivity;
import com.rezalwp.PresensiAcara.helper.Config;
import com.rezalwp.PresensiAcara.model.ResponseErrorModel;
import com.rezalwp.PresensiAcara.rest.ApiConfig;
import com.rezalwp.PresensiAcara.rest.ApiService;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail_presence);
            Objects.requireNonNull(getSupportActionBar()).hide();
            TextView tvNama = findViewById(R.id.tv_nama_peserta);
            TextView tvNoHp = findViewById(R.id.tv_noHp_peserta);
            TextView tvKategori = findViewById(R.id.tv_kategori_peserta);
            TextView tvInstitut = findViewById(R.id.tv_institut_peserta);
            TextView tvNoTiket = findViewById(R.id.tv_noTiket_peserta);
            TextView tvIdPanitia = findViewById(R.id.tv_idPanitia_peserta);
            TextView tvTglInput = findViewById(R.id.tv_tglInput_peserta);
            TextView tvWaktu = findViewById(R.id.tv_waktu_peserta);
            TextView tvPresensi = findViewById(R.id.tv_presensi_peserta);
            Button btnDelete = findViewById(R.id.btn_delete);

            String nama = getIntent().getStringExtra(Config.BUNDLE_NAMA);
            String noHp = getIntent().getStringExtra(Config.BUNDLE_NOHP);
            String kategori = getIntent().getStringExtra(Config.BUNDLE_KATEGORI);
            String institut = getIntent().getStringExtra(Config.BUNDLE_INSTITUT);
            String noTiket = getIntent().getStringExtra(Config.BUNDLE_NOTIKET);
            String idPanitia = getIntent().getStringExtra(Config.BUNDLE_IDPANITIA);
            String tglInput = getIntent().getStringExtra(Config.BUNDLE_TGLINPUT);
            String waktu = getIntent().getStringExtra(Config.BUNDLE_WAKTU);
            String presensi = getIntent().getStringExtra(Config.BUNDLE_PRESENSI);

            tvNama.setText(nama);
            tvNoHp.setText(noHp);
            tvKategori.setText(kategori);
            tvInstitut.setText(institut);
            tvNoTiket.setText(noTiket);
            tvIdPanitia.setText(idPanitia);
            tvTglInput.setText(tglInput);
            tvWaktu.setText(waktu);
            tvPresensi.setText(presensi);

            final String idPresence = getIntent().getStringExtra(Config.BUNDLE_ID);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ApiService apiService = ApiConfig.getApiService();
                    apiService.deletePeserta(idPresence)
                            .enqueue(new Callback<ResponseErrorModel>() {
                                @Override
                                public void onResponse(Call<ResponseErrorModel> call, Response<ResponseErrorModel> response) {
                                    if (response.isSuccessful()){
                                        Toast.makeText(DetailPresenceActivity.this, "Sukses Delete", Toast.LENGTH_SHORT).show();
                                                finishAffinity();
                                        startActivity(new Intent(getApplicationContext(),
                                                HomeActivity.class));
                                    }
                                }

                                @Override
                                public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                                    Toast.makeText(DetailPresenceActivity.this, "Gagal Delete"
                                            + t.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            });
    }
}
