package com.test.maru.api;

import com.test.maru.model.Reunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReunionList {

    public static List<Reunion> REUNION = Arrays.asList(
            new Reunion("15:20", "Paris", "OC", "corentin@gmail.com")
    );

    public static List<Reunion> generateReunion() {
        return new ArrayList<>(REUNION);
    }

}
