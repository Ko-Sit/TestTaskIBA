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
public class DeleteRowCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.main");

        int id = Integer.parseInt(request.getParameter("id"));
        int custId;
        List<Customer> customers = SchemaContainer.get();
        for (Customer customer : customers) {
            custId = customer.getId();
            if ( custId == id) {
                customers.remove(customer);
                break;
            }
        }

        request.setAttribute("customers", customers);
        return page;
    }
}
