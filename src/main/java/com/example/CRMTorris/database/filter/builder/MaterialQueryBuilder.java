package com.example.CRMTorris.database.filter.builder;

import com.example.CRMTorris.database.filter.MaterialFilter;

public class MaterialQueryBuilder {

    private final static String PRESET = "SELECT m FROM Material m WHERE ";
    private final static String FULL = ""

    private final MaterialFilter filter;

    public MaterialQueryBuilder(MaterialFilter filter) {
        this.filter = filter;
    }

    public MaterialQueryBuilder build() {
        StringBuilder builder = new StringBuilder(PRESET);
        if (filter.isFull()) {

        }
    }
}
