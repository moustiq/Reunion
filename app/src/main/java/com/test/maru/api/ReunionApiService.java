package com.test.maru.api;

import com.test.maru.model.Reunion;

import java.util.List;

public interface ReunionApiService {

    List<Reunion> getReunions();

    void deleteReunion(Reunion reunion);

    void createReunion(Reunion reunion);

}
