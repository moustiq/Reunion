package com.test.maru.di;

import com.test.maru.api.ReunionApi;
import com.test.maru.api.ReunionApiService;

public class DI {

    private static final ReunionApiService service;

    static {
        service = new ReunionApi();
    }


    public static ReunionApiService getReunionApiService() {
        return service;
    }

    public static ReunionApiService getService() {
        return new ReunionApi();
    }

}
