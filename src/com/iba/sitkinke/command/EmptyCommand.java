package com.iba.sitkinke.command;

import javax.servlet.http.HttpServletRequest;

import com.iba.sitkinke.resource.ConfigurationManager;

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
         String page = ConfigurationManager.getProperty("path.page.index");
         return page;
    }
}