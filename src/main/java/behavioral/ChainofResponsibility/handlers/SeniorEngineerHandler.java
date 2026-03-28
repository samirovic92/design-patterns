package behavioral.ChainofResponsibility.handlers;

import behavioral.ChainofResponsibility.BaseSupportHandler;
import behavioral.ChainofResponsibility.SupportTicket;

import java.util.List;

import static behavioral.ChainofResponsibility.SupportTicket.Priority.CRITICAL;
import static behavioral.ChainofResponsibility.SupportTicket.Priority.HIGH;

public class SeniorEngineerHandler extends BaseSupportHandler {

    @Override
    public void handle(SupportTicket ticket) {
        if (List.of(HIGH, CRITICAL).contains(ticket.getPriority())) {
            resolve(
                    "Senior Engineer",
                    "Provided expert-level support and resolution.",
                    ticket,
                    SupportTicket.User.SENIOR_ENGINEER);
        } else {
            System.out.println("    ↑ Escalating — no further handlers");
        }

    }
}
