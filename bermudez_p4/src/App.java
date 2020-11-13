public class App {
    /*
    A user shall be able to create a new task list
    A user shall be able to load an existing task list
    A user shall be able to view the current task list
    A user shall be able to save the current task list
    A user shall be able to add an item to the current task list
    A user shall be able to edit an item in the current task list
    A user shall be able to remove an item from the current task list
    A user shall be able to mark an item in the current task list as completed
    A user shall be able to unmark an item in the current task list as completed
     */

    /*
    You must handle input errors, including:
    invalid titles, invalid due dates (TaskItem's responsibility)
    trying to access a task that doesn't exist (App's responsibility? ----
    ---Happens when choosing a task, for example choosing task 5 when there are only 2 tasks)
    You must also handle the case when there are no tasks to edit, remove, mark, unmark, or save. (App's responsibility)
    None of these expected errors should crash the program.
     */

    /*
    Use google or the textbook to find out how to deal with files. Save this step for last as it's kind of self-isolated in a way
     */

    /*
    Recommendation: Start with writing out your program in pseudocode. Maybe write
    some of your tests while doing so, by writing those tests as if your classes
    and functions existed, then go code the classes you need. After that, maybe
    start your coding by working on the TaskItem class. Then worry about creating
    a list of those items. Then worry about the application class and actually
    interacting with the user.
     */

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
