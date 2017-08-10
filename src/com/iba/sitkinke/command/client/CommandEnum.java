package com.iba.sitkinke.command.client;

import com.iba.sitkinke.command.ActionCommand;
import com.iba.sitkinke.command.SendXmlCommand;

public enum CommandEnum {
    SENDXML(new SendXmlCommand());

    ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand() {
        return command;
    }
}