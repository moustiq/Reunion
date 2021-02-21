package com.test.maru.reunion_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.test.maru.R;
import com.test.maru.api.ReunionApi;
import com.test.maru.model.Reunion;

import butterknife.BindView;
import butterknife.OnClick;

public class AddReunionActivity extends AppCompatActivity {

    @BindView(R.id.heure)
    EditText heureInput;
    @BindView(R.id.lieu)
    EditText lieuInput;
    @BindView(R.id.sujet)
    EditText sujetInput;
    @BindView(R.id.mail)
    EditText mailInput;

    private ReunionApi mReunionApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);
        mReunionApiService = new ReunionApi();
    }

    @OnClick(R.id.creer)
    void addReunion() {
        Reunion reunion = new Reunion(heureInput.getEdi)
    }


}