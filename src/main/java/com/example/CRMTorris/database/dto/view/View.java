package com.example.CRMTorris.database.dto.view;

import java.util.HashMap;
import java.util.Map;

public class View {
    public static final Map<String, Class> MAPPING = new HashMap<>();

    static {
        MAPPING.put("ADMIN", Admin.class);
        MAPPING.put("WORKER", Worker.class);
    }

    public static class Worker {

    }

    public static class Admin extends Worker {

    }
}
