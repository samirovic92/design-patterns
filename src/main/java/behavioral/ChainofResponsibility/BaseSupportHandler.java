package behavioral.ChainofResponsibility;

import java.util.Objects;

public abstract class BaseSupportHandler implements SupportHandler {

    protected SupportHandler next;

    @Override
    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;
    }

    protected void passeToNext(SupportTicket ticket) {
        if(Objects.isNull(next)) {
            System.out.printf("  ✗ [UNRESOLVED] No handler available for %s%n%n", ticket);
        }
        next.handle(ticket);
    }

    protected void resolve(String handlerName, String action, SupportTicket ticket, SupportTicket.User user) {
        System.out.printf("  ✔ [%-22s] %s%n    → Action : %s%n%n", handlerName, ticket, action);
        ticket.handleBy(user);
    }

}
