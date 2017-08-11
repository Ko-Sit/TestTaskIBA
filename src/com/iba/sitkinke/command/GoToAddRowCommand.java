package com.iba.sitkinke.command;

import javax.servlet.http.HttpServletRequest;

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
        return page;
    }
}
