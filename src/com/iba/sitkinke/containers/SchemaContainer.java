package com.iba.sitkinke.containers;

import java.util.List;

import com.iba.sitkinke.entity.Customer;

/**
 *
 * Created by upsit on 11.08.2017.
 */
public class SchemaContainer {
    private static List<Customer> list;

    public static List<Customer> get() {
        return list;
    }

    public static void put(List<Customer> newList) {
        list = newList;
    }

    public static void clear() {
        list = null;
    }
}
