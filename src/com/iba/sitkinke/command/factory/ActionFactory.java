package com.iba.sitkinke.command.factory;

import javax.servlet.http.HttpServletRequest;

import com.iba.sitkinke.command.ActionCommand;
import com.iba.sitkinke.command.EmptyCommand;
import com.iba.sitkinke.command.client.CommandEnum;


public class ActionFactory {
  public ActionCommand defineCommand(HttpServletRequest request) {
    ActionCommand current = new EmptyCommand();
    String action = request.getParameter("command");

    if (action == null || action.isEmpty()) {
        System.out.println("Action is empty or null.");
        return current;
    }
    try {
      CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());

      current = currentEnum.getCurrentCommand();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    }
    return current;
  }
}