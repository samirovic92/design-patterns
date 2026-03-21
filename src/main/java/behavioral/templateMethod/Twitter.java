package behavioral.templateMethod;

import static java.util.Objects.nonNull;

public class Twitter extends Network {

    public Twitter(String userName, String password) {
        super(userName, password);
    }

    @Override
    protected void sendData(String message) {
        System.out.println("Posting to Twitter: " + message);
    }

    @Override
    protected boolean logIn() {
        return nonNull(this.userName) && nonNull(this.password);
    }
}
