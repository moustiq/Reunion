package com.test.maru.utils;

import com.test.maru.api.ReunionApiService;
import com.test.maru.di.DI;
import com.test.maru.model.Reunion;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Reunion> result = new ArrayList<>();

    public static void search(String filter) {

        ReunionApiService mReunionApiService = DI.getReunionApiService();
        List<Reunion> mReunions = mReunionApiService.getReunions();
        ArrayList<Reunion> listReunion = new ArrayList<>();

        for (Reunion r : mReunions) {

            if (r.getHeure().contains(filter)) {
                listReunion.add(r);
                continue;
            }

            if (r.getLieu().contains(filter)) {
                listReunion.add(r);
            }
        }
        result = listReunion;

    }


}
