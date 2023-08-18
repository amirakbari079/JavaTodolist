public class Todo {
    String title;
    boolean done;

    public Todo(String title,Boolean done) {
        this.title = title;
        this.done = done;
    }

    @Override
    public String toString() {
        return title + " " + done + "\n";
    }
}
