package com.iba.sitkinke.containers;

import java.util.Comparator;
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

    public static void sort(int value) {
        switch (value) {
            case 0:
                list.sort(Comparator.comparingInt(Customer::getId));
                break;
            case 1:
                list.sort(Comparator.comparingInt(Customer::getAge));
                break;
            case 2:
                list.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
            default:
                break;
        }
    }
}
