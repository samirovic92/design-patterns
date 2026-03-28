package behavioral.ChainofResponsibility;

import behavioral.ChainofResponsibility.handlers.HelpDeskHandle;
import behavioral.ChainofResponsibility.handlers.SeniorEngineerHandler;
import behavioral.ChainofResponsibility.handlers.TechnicalSupportHandler;
import org.junit.jupiter.api.Test;

import static behavioral.ChainofResponsibility.SupportTicket.Priority.CRITICAL;
import static behavioral.ChainofResponsibility.SupportTicket.Priority.LOW;
import static behavioral.ChainofResponsibility.SupportTicket.Priority.MEDIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase_ChainOfResponsibilityTest {

    @Test
    public void handle_support_ticket_by_helpDesk() {
        // Given
        var ticket = new SupportTicket("Wifi Issue", "Cannot connect to Wi-Fi", LOW);
        var supportHandler = new HelpDeskHandle();
        supportHandler.setNext(new TechnicalSupportHandler())
                .setNext(new SeniorEngineerHandler());

        // When
        supportHandler.handle(ticket);

        // Then
        assertEquals(SupportTicket.User.SUPPORT_AGENT, ticket.getHandledBy());
    }

    @Test
    public void handle_support_ticket_by_technicalSupport() {
        // Given
        var ticket = new SupportTicket("Software Crash", "Application crashes on startup", MEDIUM);
        var supportHandler = new HelpDeskHandle();
        supportHandler.setNext(new TechnicalSupportHandler())
                .setNext(new SeniorEngineerHandler());

        // When
        supportHandler.handle(ticket);

        // Then
        assertEquals(SupportTicket.User.TECHNICAL_SUPPORT, ticket.getHandledBy());
    }

    @Test
    public void handle_support_ticket_by_seniorEngineer() {
        // Given
        var ticket = new SupportTicket("Data Loss", "Critical data loss after update", CRITICAL);
        var supportHandler = new HelpDeskHandle();
        supportHandler.setNext(new TechnicalSupportHandler())
                .setNext(new SeniorEngineerHandler());

        // When
        supportHandler.handle(ticket);

        // Then
        assertEquals(SupportTicket.User.SENIOR_ENGINEER, ticket.getHandledBy());
    }
}
