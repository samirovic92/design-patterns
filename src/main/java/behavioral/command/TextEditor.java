package behavioral.command;

public class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void insert(String text, int position) {
        this.text.insert(position, text);
    }

    public void delete(int position, int length) {
        this.text.delete(position, position + length);
    }

    public String getText() {
        return text.toString();
    }
}
