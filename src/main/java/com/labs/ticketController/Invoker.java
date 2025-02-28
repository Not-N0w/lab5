package com.labs.ticketController;


import com.labs.common.AbstractInvoker;
import com.labs.common.DataContainer;
import com.labs.ticketController.commands.AddCommand;
import com.labs.ticketController.commands.AddSomeCommand;
import com.labs.ticketController.commands.ShowCommand;
import com.labs.ticketController.commands.UpdateCommand;

public class Invoker extends AbstractInvoker {
    public Invoker() {
        CollectionManager cm = new CollectionManager();
        commands.put("add", new AddCommand(cm));
        commands.put("addSome", new AddSomeCommand(cm));
        commands.put("update", new UpdateCommand(cm));
        commands.put("show", new ShowCommand(cm));
    }
}
