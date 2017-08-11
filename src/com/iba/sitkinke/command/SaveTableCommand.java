package com.iba.sitkinke.command;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iba.sitkinke.constants.PathConfigs;
import com.iba.sitkinke.containers.SchemaContainer;
import com.iba.sitkinke.managers.XmlWorker;
import com.iba.sitkinke.entity.Customer;
import com.iba.sitkinke.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 11.08.2017.
 */
public class SaveTableCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty(PathConfigs.INDEX_PAGE);

        List<Customer> customers = SchemaContainer.get();
        File file = XmlWorker.getXmlFile(customers);

        SchemaContainer.clear();
        return page;
    }
}
