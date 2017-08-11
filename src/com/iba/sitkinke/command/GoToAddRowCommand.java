package com.iba.sitkinke.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iba.sitkinke.constants.Parameters;
import com.iba.sitkinke.constants.PathConfigs;
import com.iba.sitkinke.resource.ConfigurationManager;

/**
 *
 * Created by upsit on 11.08.2017.
 */
public class GoToAddRowCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty(PathConfigs.ADD_ROW_PAGE);

        int order = Integer.parseInt(request.getParameter(Parameters.SORT_TYPE));
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(Parameters.SORT_TYPE, order);

        return page;
    }
}
