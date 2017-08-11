package com.iba.sitkinke.command;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.iba.sitkinke.SchemaContainer;
import com.iba.sitkinke.XmlWorker;
import com.iba.sitkinke.entity.Customer;
import com.iba.sitkinke.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 10.08.2017.
 */
public class SendXmlCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.main");
        Part filePart = null;
        try {
            filePart = request.getPart("file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ServletException e) {
            e.printStackTrace();
        }

        InputStream fileContent = null;

        try {
            fileContent = filePart.getInputStream();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        List<Customer> customers = XmlWorker.getEntities(fileContent);
        SchemaContainer.put(customers);
        request.setAttribute("customers", customers);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("filename", filePart.getSubmittedFileName());
        return page;
    }
}
