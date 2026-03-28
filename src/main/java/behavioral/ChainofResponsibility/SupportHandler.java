package behavioral.ChainofResponsibility;

public interface SupportHandler {

    SupportHandler setNext(SupportHandler handler);
    void handle(SupportTicket ticket);
}
