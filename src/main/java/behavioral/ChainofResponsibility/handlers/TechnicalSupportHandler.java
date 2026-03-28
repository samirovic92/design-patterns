package behavioral.ChainofResponsibility.handlers;

import behavioral.ChainofResponsibility.BaseSupportHandler;
import behavioral.ChainofResponsibility.SupportTicket;

import static behavioral.ChainofResponsibility.SupportTicket.Priority.MEDIUM;

public class TechnicalSupportHandler extends BaseSupportHandler {

    @Override
    public void handle(SupportTicket ticket) {
        if (MEDIUM.equals(ticket.getPriority())) {
            resolve(
                    "Technical Support",
                    "Provided advanced troubleshooting steps.",
                    ticket,
                    SupportTicket.User.TECHNICAL_SUPPORT
            );
        } else {
            passeToNext(ticket);
        }
    }
}
