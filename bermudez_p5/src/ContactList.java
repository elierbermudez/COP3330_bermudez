import java.util.ArrayList;

public class ContactList {
    //All of this is copied over from TaskList
    //A task list shall contain 0 or more task items
    private ArrayList<TaskItem> internalTaskList = new ArrayList<TaskItem>();
    // Use Ctrl + Shift + F10 to format your code. Remember to use Fn on your laptop to make F10 work properly.

    public TaskList() {
        ;
    } //Empty Constructor

    public void addTaskItem(TaskItem externalTaskItem) {
        this.internalTaskList.add(externalTaskItem);
    }

    public void completeTaskItem(int index) {
        this.internalTaskList.get(index).setCompleted();
    }

    public void uncompleteTaskItem(int index) {
        this.internalTaskList.get(index).setUncompleted();
    }

        /*public TaskItem(String inputDueDate, String inputTitle, String inputDescription)
    public void editTaskItem(String inputDueDate, String inputTitle, String inputDescription){

    }*/

    public void editingTaskItemChangesValues(String inputDueDate, String inputTitle, String inputDescrption, int index) {
        editTaskItemDueDate(inputDueDate, index);
        editTaskItemTitle(inputTitle, index);
        editTaskItemDescription(inputDescrption, index);
    }

    public void editTaskItemDescription(String inputDescription, int index) {
        this.internalTaskList.get(index).setDescription(inputDescription);
    }

    public void editTaskItemDueDate(String inputDueDate, int index) {
        this.internalTaskList.get(index).setDueDate(inputDueDate);
    }

    public void editTaskItemTitle(String inputTitle, int index) {
        this.internalTaskList.get(index).setTitle(inputTitle);
    }

    public String getTaskItemDescription(int index) {
        return this.internalTaskList.get(index).getDescription();
    }

    public String getTaskItemDueDate(int index) {
        return this.internalTaskList.get(index).getDueDate();
    }

    public String getTaskItemTitle(int index) {
        return this.internalTaskList.get(index).getTitle();
    }

    public Boolean getTaskItemCompletion(int index) {
        return this.internalTaskList.get(index).getCompleted();
    }

    public TaskItem getTaskItem(int index) {
        return this.internalTaskList.get(index);
    }

    public void removeTaskItem(int index) {
        this.internalTaskList.remove(index);
    }

    public int size() {
        return this.internalTaskList.size();
    }

    //These print statements are possibly unnecessary
    public String getTaskItemAsString(int index) {
        return (getTaskItem(index) + "");
    }

    public String getCompletedTaskItemsAsString() {
        StringBuilder CompletedTaskListString = new StringBuilder();
        int i = 0;
        for (i = 0; i < this.size(); i++) {
            if (getTaskItemCompletion(i)) {
                CompletedTaskListString.append(i + ") ").append(getTaskItemAsString(i)).append("\n");
            }
        }
        return CompletedTaskListString.toString();
    }

    public String getUncompletedTaskItemsAsString() {
        StringBuilder UncompletedTaskListString = new StringBuilder();
        int i = 0;
        for (i = 0; i < this.size(); i++) {
            if (!getTaskItemCompletion(i)) {
                UncompletedTaskListString.append(i + ") ").append(getTaskItemAsString(i)).append("\n");
            }
        }
        return UncompletedTaskListString.toString();
    }

    @Override
    public String toString() {
        StringBuilder TaskListString = new StringBuilder();
        int i = 0;
        for (i = 0; i < this.size(); i++) {
            TaskListString.append(i + ") ").append(this.getTaskItem(i)).append("\n");
        }
        return TaskListString.toString();
    }
}
