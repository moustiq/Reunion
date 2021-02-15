package com.test.maru.api;

import com.test.maru.model.Reunion;

import java.util.List;

public class ReunionApiService {

    private List<Reunion> mReunions = ReunionList.generateReunion();

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
