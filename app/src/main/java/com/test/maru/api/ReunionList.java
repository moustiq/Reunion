package com.test.maru.api;

import com.test.maru.model.Reunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReunionList {

    public static List<Reunion> REUNION = Arrays.asList(
            new Reunion("15:20", "Paris", "OC", "corentin@gmail.com"),
            new Reunion("15:30", "B", "OC", "corentin@gmail.com"),
            new Reunion("16:20", "C", "OC", "corentin@gmail.com"),
            new Reunion("17:20", "D", "OC", "corentin@gmail.com"),
            new Reunion("18:20", "E", "OC", "corentin@gmail.com")

    );

    public static List<Reunion> generateReunion() {
        return REUNION;
    }

}
