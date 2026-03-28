package behavioral.ChainofResponsibility;

import lombok.Getter;

import java.util.UUID;

@Getter
public class SupportTicket {
    private final UUID id;
    private final String title;
    private final String description;
    private final Priority priority;
    private User handledBy;

    public SupportTicket(String title, String description, Priority priority) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void handleBy(User user) {
        this.handledBy = user;
    }

    public enum User {
        SUPPORT_AGENT, TECHNICAL_SUPPORT, SENIOR_ENGINEER
    }

    public enum Priority {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    @Override
    public String toString() {
        return String.format("[Ticket #%s] %-10s | %s", id, priority, description);
    }
}
