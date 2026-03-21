package behavioral.templateMethod;

public abstract class Network {
    protected String userName;
    protected String password;

    protected Network(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean post(String message) {
        if (logIn()) {
            sendData(message);
            return true;
        }
        return false;
    }

    protected abstract void sendData(String message);

    protected abstract boolean logIn();
}
