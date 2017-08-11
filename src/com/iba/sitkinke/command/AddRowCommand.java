package com.iba.sitkinke.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iba.sitkinke.constants.Parameters;
import com.iba.sitkinke.constants.PathConfigs;
import com.iba.sitkinke.containers.SchemaContainer;
import com.iba.sitkinke.entity.Customer;
import com.iba.sitkinke.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 11.08.2017.
 */
public class AddRowCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty(PathConfigs.MAIN_PAGE);
        List<Customer> customers = SchemaContainer.get();

        int id = Integer.parseInt(request.getParameter(Parameters.ID));
        int age = Integer.parseInt(request.getParameter(Parameters.AGE));
        String name = request.getParameter(Parameters.NAME);
        Customer customer = new Customer(id, age, name);

        customers.add(customer);
        request.setAttribute(Parameters.CUSTOMERS, customers);

        return page;
    }
}
