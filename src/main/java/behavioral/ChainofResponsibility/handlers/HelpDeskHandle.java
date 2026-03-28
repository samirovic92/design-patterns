package behavioral.ChainofResponsibility.handlers;

import behavioral.ChainofResponsibility.BaseSupportHandler;
import behavioral.ChainofResponsibility.SupportTicket;

import static behavioral.ChainofResponsibility.SupportTicket.Priority.LOW;

public class HelpDeskHandle extends BaseSupportHandler {

    @Override
    public void handle(SupportTicket ticket) {
        if (LOW.equals(ticket.getPriority())) {
            resolve(
                    "Help Desk",
                    "Provided basic troubleshooting steps.",
                    ticket,
                    SupportTicket.User.SUPPORT_AGENT
            );
        } else {
            passeToNext(ticket);
        }

    }
}
