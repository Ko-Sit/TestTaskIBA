package com.iba.sitkinke.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.iba.sitkinke.entity.Customer;

/**
 *
 * Created by upsit on 10.08.2017.
 */
public class Main {

    public static void main(String[] args) {
        try {

            File file = new File("D:\\IdeaProjects\\IBATest\\src\\com\\iba\\sitkinke\\files\\staff.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
