import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TodoManager {
    File path = new File("C:\\Users\\AMIr\\IdeaProjects\\TodoList\\TodoList.txt");
    Scanner fileScanner;
    String data;
    HashMap<Integer, Todo> todoMap = new HashMap();

    public void addNewTodo(String title) {
        Todo todo = new Todo(title, false);
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(todo.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    Todo todo = null;

    public void todoLoader() {
        ArrayList<String> index = new ArrayList<>();

        Integer counter = 0;
        String doneOrNot;
        try {
            fileScanner = new Scanner(path);
            while (fileScanner.hasNext()) {
                data = fileScanner.nextLine();
                String[] a = data.split(" ");
                todo = new Todo(a[0], Boolean.parseBoolean(a[1]));
                counter++;
                todoMap.put(counter, todo);
            }
            for (int i = 1; i <= todoMap.size(); i++) {
                todo = todoMap.get(i);
                doneOrNot = todo.done ? "✓" : "x";
                System.out.print(String.valueOf(i) + "-" + todo.title + " " + doneOrNot + "\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void editeTodo(String todoNumber) {
        todo = todoMap.get(Integer.parseInt(todoNumber));
        todo.done = !todo.done;
        todoMap.put(Integer.parseInt(todoNumber), todo);

        updateTodoFile(todoMap);

    }

    public void updateTodoFile(HashMap<Integer, Todo> todos) {
        clearFile();
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            for (int i = 1; i <= todoMap.size(); i++) {
                todo = todoMap.get(i);
                fileWriter.write(todo.toString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void clearFile() {
        File directory = new File("C:\\Users\\AMIr\\IdeaProjects\\TodoList\\TodoList.txt");
        FileWriter clear = null;
        try {
            clear = new FileWriter(directory, false);
            clear.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
