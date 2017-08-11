package com.iba.sitkinke.command.client;

import com.iba.sitkinke.command.ActionCommand;
import com.iba.sitkinke.command.AddRowCommand;
import com.iba.sitkinke.command.DeleteRowCommand;
import com.iba.sitkinke.command.GoToAddRowCommand;
import com.iba.sitkinke.command.SendXmlCommand;

public enum CommandEnum {
    SENDXML(new SendXmlCommand()),
    DELETE(new DeleteRowCommand()),
    GOTOADD(new GoToAddRowCommand()),
    ADDROW(new AddRowCommand());

    ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand() {
        return command;
    }
}