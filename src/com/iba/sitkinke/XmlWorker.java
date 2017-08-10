package com.iba.sitkinke;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.iba.sitkinke.entity.Customer;

/**
 *
 * Created by upsit on 10.08.2017.
 */
public class XmlWorker {

    public static List<Customer> getEntities(InputStream fileContent) {
        int id;
        int age;
        String name;
        Customer customer;
        List<Customer> customers = new ArrayList();
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileContent);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("customer");
            System.out.println(nList.getLength());
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    id = Integer.parseInt(eElement.getAttribute("id"));
                    age = Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent());
                    name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    customer = new Customer(id, age, name);
                    customers.add(customer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("gg");
        return customers;
    }
}
