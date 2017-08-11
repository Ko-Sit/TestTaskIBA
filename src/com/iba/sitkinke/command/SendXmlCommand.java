package com.iba.sitkinke.command;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.iba.sitkinke.constants.Parameters;
import com.iba.sitkinke.constants.PathConfigs;
import com.iba.sitkinke.containers.SchemaContainer;
import com.iba.sitkinke.managers.XmlWorker;
import com.iba.sitkinke.entity.Customer;
import com.iba.sitkinke.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 10.08.2017.
 */
public class SendXmlCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty(PathConfigs.MAIN_PAGE);
        Part filePart = null;
        try {
            filePart = request.getPart(Parameters.FILE);
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
        request.setAttribute(Parameters.CUSTOMERS, customers);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(Parameters.FILE_NAME, filePart.getSubmittedFileName());
        return page;
    }
}
