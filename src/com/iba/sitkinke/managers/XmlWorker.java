package com.iba.sitkinke.managers;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.iba.sitkinke.constants.Parameters;
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
            NodeList nList = doc.getElementsByTagName(Parameters.CUSTOMER);
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    id = Integer.parseInt(eElement.getAttribute(Parameters.ID));
                    age = Integer.parseInt(eElement.getElementsByTagName(Parameters.AGE).item(0).getTextContent());
                    name = eElement.getElementsByTagName(Parameters.NAME).item(0).getTextContent();
                    customer = new Customer(id, age, name);
                    customers.add(customer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static File getXmlFile(List<Customer> list) {
        File outputFile = null;
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement(Parameters.CUSTOMERS);
            doc.appendChild(rootElement);

            Element customer;
            for (Customer cust: list) {
                customer = doc.createElement(Parameters.CUSTOMER);
                rootElement.appendChild(customer);

                customer.setAttribute(Parameters.ID, String.valueOf(cust.getId()));

                Element age = doc.createElement(Parameters.AGE);
                age.appendChild(doc.createTextNode(String.valueOf(cust.getAge())));
                customer.appendChild(age);

                Element name = doc.createElement(Parameters.NAME);
                name.appendChild(doc.createTextNode(cust.getName()));
                customer.appendChild(name);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            outputFile = new File(Parameters.FILE_NAME_DEFAULT);
            StreamResult result = new StreamResult(outputFile);

            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        return outputFile;
    }

}
