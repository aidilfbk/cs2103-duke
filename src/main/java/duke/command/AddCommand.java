package duke.command;

import duke.model.Task;
import duke.storage.Storage;
import duke.ui.Ui;

import java.time.format.DateTimeFormatter;
import java.util.List;

abstract class AddCommand implements Command {
    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    protected final String command;
    protected final Task task;

    public AddCommand(String command) {
        this.command = command;
        task = instantiateTask();
        assert task != null;
    }

    protected abstract Task instantiateTask();

    @Override
    public void execute(List<Task> tasks, Ui ui, Storage storage) {
        tasks.add(task);

        storage.save(tasks);
        ui.displaySuccessfullyAddedTask("Got it. I've added this task: ", task, tasks.size());

    }
}