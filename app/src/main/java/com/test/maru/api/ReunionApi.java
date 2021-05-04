package com.test.maru.api;

import com.test.maru.model.Reunion;

import java.util.List;

import static com.test.maru.api.ReunionList.generateReunion;

public class ReunionApi implements ReunionApiService {

    private final List<Reunion> mReunions;

    public ReunionApi() {
        mReunions = generateReunion();
    }

    public List<Reunion> getReunions() {
        return mReunions;
    }

    public void deleteReunion(Reunion reunion) {
        mReunions.remove(reunion);
    }

    public void createReunion(Reunion reunion) {
        mReunions.add(reunion);

    }


}
