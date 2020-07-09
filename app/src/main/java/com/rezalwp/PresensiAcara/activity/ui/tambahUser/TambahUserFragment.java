package com.rezalwp.PresensiAcara.activity.ui.tambahUser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.rezalwp.PresensiAcara.R;
import com.rezalwp.PresensiAcara.model.ResponseErrorModel;

public class TambahUserFragment extends Fragment {

    private TambahUserViewModel tambahUserViewModel;
    private EditText edtNama;
    private EditText edtNoHp;
    private EditText edtKategori;
    private EditText edtInstitut;
    private EditText edtNoTiket;
    private Button btnSimpan;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tambahUserViewModel =
                ViewModelProviders.of(this).get(TambahUserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tambah_user, container, false);

        edtNama = root.findViewById(R.id.edt_nama);
        edtNoHp = root.findViewById(R.id.edt_noHp);
        edtKategori = root.findViewById(R.id.edt_kategori);
        edtInstitut = root.findViewById(R.id.edt_institut);
        edtNoTiket = root.findViewById(R.id.edt_noTiket);
        btnSimpan = root.findViewById(R.id.btn_simpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahUserViewModel.postDataPesertas(
                        edtNama.getText().toString().trim(),
                        edtNoHp.getText().toString().trim(),
                        edtKategori.getText().toString().trim(),
                        edtInstitut.getText().toString().trim(),
                        edtNoTiket.getText().toString().trim()
                        ).observe(getActivity(), new Observer<ResponseErrorModel>() {
                    @Override
                    public void onChanged(ResponseErrorModel responseErrorModel) {
                        Toast.makeText(getActivity(), "Sukses", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        return root;
    }
}
