package com.iba.sitkinke.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.iba.sitkinke.SchemaContainer;
import com.iba.sitkinke.XmlWorker;
import com.iba.sitkinke.entity.Customer;
import com.iba.sitkinke.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 11.08.2017.
 */
public class SaveTableCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");

        List<Customer> customers = SchemaContainer.get();
        File file = XmlWorker.getXmlFile(customers);

        SchemaContainer.clear();
        return page;
    }
}
