package behavioral.command;

public class DeleteTextCommand implements Command {
    private TextEditor textEditor;
    private String deletedText;
    private int position;

    public DeleteTextCommand(TextEditor textEditor, int position, int length) {
        this.textEditor = textEditor;
        this.position = position;
        this.deletedText = textEditor.getText().substring(position, position + length);
    }

    @Override
    public void execute() {
        this.textEditor.delete(position, deletedText.length());
    }

    @Override
    public void undo() {
        this.textEditor.insert(deletedText, position);
    }
}
