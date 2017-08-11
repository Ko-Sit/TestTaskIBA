package com.iba.sitkinke.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iba.sitkinke.constants.Parameters;
import com.iba.sitkinke.constants.PathConfigs;
import com.iba.sitkinke.containers.SchemaContainer;
import com.iba.sitkinke.entity.Customer;
import com.iba.sitkinke.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 11.08.2017.
 */
public class DeleteRowCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty(PathConfigs.MAIN_PAGE);

        int id = Integer.parseInt(request.getParameter(Parameters.ID));
        int custId;
        List<Customer> customers = SchemaContainer.get();
        for (Customer customer : customers) {
            custId = customer.getId();
            if ( custId == id) {
                customers.remove(customer);
                break;
            }
        }

        int order = Integer.parseInt(request.getParameter("order"));
        SchemaContainer.sort(order);

        request.setAttribute(Parameters.CUSTOMERS, customers);
        return page;
    }
}
