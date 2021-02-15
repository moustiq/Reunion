package com.test.maru.api;

import com.test.maru.model.Reunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReunionList {

    public static List<Reunion> REUNION = Arrays.asList(

    );

    public static List<Reunion> generateReunion() {
        return new ArrayList<>(REUNION);
    }

}
