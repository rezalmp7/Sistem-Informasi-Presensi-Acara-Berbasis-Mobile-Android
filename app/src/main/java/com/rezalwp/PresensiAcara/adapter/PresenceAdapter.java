package com.rezalwp.PresensiAcara.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rezalwp.PresensiAcara.R;
import com.rezalwp.PresensiAcara.activity.HomeActivity;
import com.rezalwp.PresensiAcara.activity.ui.presence.DetailPresenceActivity;
import com.rezalwp.PresensiAcara.helper.Config;
import com.rezalwp.PresensiAcara.model.PresenceModel;
import com.rezalwp.PresensiAcara.model.ResponseErrorModel;
import com.rezalwp.PresensiAcara.rest.ApiConfig;
import com.rezalwp.PresensiAcara.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenceAdapter extends RecyclerView.Adapter<PresenceAdapter.PresenceViewHolder> {

    private Context context;
    private List<PresenceModel> presenceModels;

    public PresenceAdapter(Context context, List<PresenceModel> presenceModels) {
        this.context = context;
        this.presenceModels = presenceModels;
    }

    @NonNull
    @Override
    public PresenceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_presence, parent, false);
        return new PresenceViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull PresenceViewHolder holder,final int position) {
        if(presenceModels.get(position).getPresensiPeserta().contains("absen")) {
            holder.batas.setBackgroundColor(R.color.colorPrimaryWhite);
            holder.containerDatang.setVisibility(View.VISIBLE);
        }
        holder.tvNamaPeserta.setText(presenceModels.get(position).getNamaPeserta());
        holder.tvNoTiketPeserta.setText(presenceModels.get(position).getNoTiketPeserta());
        holder.tvPresensiPeserta.setText(presenceModels.get(position).getPresensiPeserta());

        holder.btnDatang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = ApiConfig.getApiService();
                apiService.postKehadiran(presenceModels.get(position).getNoTiketPeserta())
                        .enqueue(new Callback<ResponseErrorModel>() {
                            @Override
                            public void onResponse(Call<ResponseErrorModel> call, Response<ResponseErrorModel> response) {
                                Toast.makeText(context, "Sukses",
                                        Toast.LENGTH_SHORT).show();
                                ((HomeActivity)context).setup();
                            }

                            @Override
                            public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                                Toast.makeText(context, "" + t.getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        holder.cvPresence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPresenceActivity.class);
                intent.putExtra(Config.BUNDLE_ID, presenceModels.get(position).getIdPeserta());
                intent.putExtra(Config.BUNDLE_NAMA,
                        presenceModels.get(position).getNamaPeserta());
                intent.putExtra(Config.BUNDLE_NOHP,
                        presenceModels.get(position).getNoHpPeserta());
                intent.putExtra(Config.BUNDLE_KATEGORI,
                        presenceModels.get(position).getKategoriPeserta());
                intent.putExtra(Config.BUNDLE_INSTITUT,
                        presenceModels.get(position).getKategoriPeserta());
                intent.putExtra(Config.BUNDLE_NOTIKET,
                        presenceModels.get(position).getNoTiketPeserta());
                intent.putExtra(Config.BUNDLE_IDPANITIA,
                        presenceModels.get(position).getIdPanitiaPeserta());
                intent.putExtra(Config.BUNDLE_TGLINPUT,
                        presenceModels.get(position).getTglInputPeserta());
                intent.putExtra(Config.BUNDLE_WAKTU,
                        presenceModels.get(position).getWaktuPeserta());
                intent.putExtra(Config.BUNDLE_PRESENSI,
                        presenceModels.get(position).getPresensiPeserta());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presenceModels.size();
    }

    public class PresenceViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNamaPeserta;
        private TextView tvNoTiketPeserta;
        private TextView tvPresensiPeserta;
        private View batas;
        private LinearLayout containerDatang;
        private Button btnDatang;
        private CardView cvPresence;

        public PresenceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaPeserta = itemView.findViewById(R.id.tv_nama_peserta);
            tvNoTiketPeserta = itemView.findViewById(R.id.tv_noTiket_peserta);
            tvPresensiPeserta = itemView.findViewById(R.id.tv_presensi_peserta);
            containerDatang = itemView.findViewById(R.id.container_datang);
            batas = itemView.findViewById(R.id.batas);
            btnDatang = itemView.findViewById(R.id.btn_datang);
            cvPresence = itemView.findViewById(R.id.cv_presence);
        }
    }
}
