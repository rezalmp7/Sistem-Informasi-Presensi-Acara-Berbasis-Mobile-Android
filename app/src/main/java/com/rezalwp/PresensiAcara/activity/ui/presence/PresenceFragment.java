package com.rezalwp.PresensiAcara.activity.ui.presence;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rezalwp.PresensiAcara.R;
import com.rezalwp.PresensiAcara.adapter.PresenceAdapter;
import com.rezalwp.PresensiAcara.model.PresenceModel;

import java.util.ArrayList;
import java.util.List;

public class PresenceFragment extends Fragment {

    private String TAG = "mvvm";
    private RecyclerView rv;

    private PresenceAdapter presenceAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_presence, container, false);
        List<PresenceModel> presenceModels = new ArrayList<>();
        rv = root.findViewById(R.id.rv);
        rv.setAdapter(presenceAdapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        PresenceViewModel presenceViewModel = ViewModelProviders.of(this).get(PresenceViewModel.class);
        presenceViewModel.getPresence().observe(this, new Observer<List<PresenceModel>>() {
            @Override
            public void onChanged(List<PresenceModel> presenceModels) {
                presenceAdapter = new PresenceAdapter(getActivity(), presenceModels);
                rv.setAdapter(presenceAdapter);
            }
        });
        return root;
    }
}
