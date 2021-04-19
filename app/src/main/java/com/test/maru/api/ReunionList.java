package com.test.maru.api;

import android.graphics.Color;

import com.test.maru.model.Reunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReunionList {

    public static List<Reunion> REUNION = Arrays.asList(

            new Reunion("15:20", "salle 1", "OC", Arrays.asList("corentin@gmail.com")),
            new Reunion("15:30", "salle 2", "OC", Arrays.asList("Louis@gmail.com")),
            new Reunion("16:20", "salle 3", "OC", Arrays.asList("julien@gmail.com")),
            new Reunion("17:20", "salle 4", "OC", Arrays.asList("charlie@gmail.com")),
            new Reunion("18:20", "salle 5", "OC", Arrays.asList("margaux@gmail.com")),
            new Reunion("18:20", "salle 6", "OC", Arrays.asList("margaux@gmail.com","charlie@gmail.com"))

    );

    public static List<Reunion> generateReunion() {
        return new ArrayList<>(REUNION);
    }

}
