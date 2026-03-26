package behavioral.command;

public class InsertTextCommand implements Command {
    private final TextEditor textEditor;
    private final String content;
    private final int position;

    public InsertTextCommand(TextEditor textEditor, String content, int position) {
        this.textEditor = textEditor;
        this.content = content;
        this.position = position;
    }

    @Override
    public void execute() {
        this.textEditor.insert(content, position);
    }

    @Override
    public void undo() {
        this.textEditor.delete(position, content.length());
    }
}
