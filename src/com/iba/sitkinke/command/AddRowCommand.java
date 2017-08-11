package com.iba.sitkinke.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iba.sitkinke.SchemaContainer;
import com.iba.sitkinke.entity.Customer;
import com.iba.sitkinke.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 11.08.2017.
 */
public class AddRowCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.main");
        List<Customer> customers = SchemaContainer.get();

        int id = Integer.parseInt(request.getParameter("id"));
        int age = Integer.parseInt(request.getParameter("age"));
        String name = request.getParameter("name");
        Customer customer = new Customer(id, age, name);

        customers.add(customer);
        request.setAttribute("customers", customers);

        return page;
    }
}
