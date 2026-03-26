package behavioral.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase_CommandTest {

    @Test
    public void execute_insert_and_undo_command() {
        // Given
        var textEditor = new TextEditor();
        var invoker = new CommandInvoker();
        var insertCommand = new InsertTextCommand(textEditor, "Hello, World!", 0);

        // When
        invoker.executeCommand(insertCommand);

        // Then
        assertEquals("Hello, World!", textEditor.getText());

        // When
        invoker.undo();

        // Then
        assertEquals("", textEditor.getText());
    }

    @Test
    public void execute_delete_and_undo_command() {
        // Given
        var textEditor = new TextEditor();
        textEditor.insert("Hello, World!", 0);
        var invoker = new CommandInvoker();
        var deleteCommand = new DeleteTextCommand(textEditor, 7, 5);

        // When
        invoker.executeCommand(deleteCommand);

        // Then
        assertEquals("Hello, !", textEditor.getText());

        // When
        invoker.undo();

        // Then
        assertEquals("Hello, World!", textEditor.getText());
    }
}
