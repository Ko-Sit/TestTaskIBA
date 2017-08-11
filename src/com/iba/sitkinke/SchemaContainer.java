package com.iba.sitkinke;

import java.util.List;

import com.iba.sitkinke.entity.Customer;

/**
 *
 * Created by upsit on 11.08.2017.
 */
public class SchemaContainer {
    private static List list;

    public static List get() {
        return list;
    }

    public static void put(List newList) {
        list = newList;
    }

    public static void clear() {
        list = null;
    }
}
