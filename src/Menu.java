import java.util.Scanner;

public class Menu {
    Scanner userInput = new Scanner(System.in);
    TodoManager todoManager = new TodoManager();

    public void showMenu() {
        System.out.println("1-Add new todo");
        System.out.println("2-Edite todo");
        System.out.println("3-Todo List");
        System.out.println("4-Exit");
        System.out.print("Enter your choice: ");

        switch (userInput.next()) {
            case "1":
                System.out.print("Todo Title(do not use space character): ");
                todoManager.addNewTodo(userInput.next());
                System.out.println("--- *********** ---");
                showMenu();
                break;
            case "2":
                System.out.println("--- *********** ---");
                todoManager.todoLoader();
                System.out.print("Todo number: ");
                todoManager.editeTodo(userInput.next());
                backToMenu();
                break;
            case "3":
                System.out.println("--- *********** ---");
                todoManager.todoLoader();

                backToMenu();

                break;
            case "4":
                System.out.println("Exite");
                break;
            default:
                showMenu();
                break;
        }
        System.out.println("--- *********** ---");


    }

    public void backToMenu() {
        System.out.print("Back to menu(enter yes or no): ");
        Boolean yesOrNo = userInput.next().equals("yes");
        if (yesOrNo)
            showMenu();

    }

}
