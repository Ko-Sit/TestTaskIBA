package com.iba.sitkinke.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.iba.sitkinke.XmlWorker;
import com.iba.sitkinke.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 10.08.2017.
 */
public class SendXmlCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.main");
        String documentName = request.getParameter("file");
        Part filePart = null; // Retrieves <input type="file" name="file">
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
        String result = XmlWorker.printAttributes(fileContent);

        return page;
    }
}
