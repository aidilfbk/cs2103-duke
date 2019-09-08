package duke.command;

import duke.model.Task;
import duke.storage.Storage;
import duke.ui.Ui;

import java.time.format.DateTimeFormatter;
import java.util.List;

abstract class AddCommand implements Command {
    protected final String command;
    protected final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    protected final Task task;

    public AddCommand(String command) {
        this.command = command;
        task = instantiateTask();
        assert task != null;
    }

    protected abstract Task instantiateTask();

    public void execute(List<Task> tasks, Ui ui, Storage storage) {
        tasks.add(task);

        storage.save(tasks);
        ui.displaySuccessfullyAddedTask("Got it. I've added this task: ", task, tasks.size());

    }
}
