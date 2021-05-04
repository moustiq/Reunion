package com.test.maru.api;


import com.test.maru.model.Reunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReunionList {

    public static List<Reunion> REUNION = Arrays.asList(

            new Reunion("15:20", "salle 1", "OC", Collections.singletonList("corentin@gmail.com")),
            new Reunion("15:30", "salle 2", "OC", Collections.singletonList("Louis@gmail.com")),
            new Reunion("16:20", "salle 3", "OC", Collections.singletonList("julien@gmail.com")),
            new Reunion("17:20", "salle 4", "OC", Collections.singletonList("charlie@gmail.com")),
            new Reunion("18:20", "salle 5", "OC", Collections.singletonList("margaux@gmail.com")),
            new Reunion("18:20", "salle 6", "OC", Arrays.asList("margaux@gmail.com", "charlie@gmail.com"))

    );

    public static List<Reunion> generateReunion() {
        return new ArrayList<>(REUNION);
    }

}
