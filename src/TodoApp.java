import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Todo> todoList = new ArrayList<>();
    private static int todoCounter = 1;

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createTodo();
                case 2 -> updateTodo();
                case 3 -> deleteTodo();
                case 4 -> listTodos();
                case 5 -> {
                    System.out.println("Dastur tugadi.");
                    return;
                }
                default -> System.out.println("Noto'g'ri tanlov, qayta urinib ko'ring.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n==== TODO App ====");
        System.out.println("1. Yangi vazifa qo'shish");
        System.out.println("2. Vazifani o'zgartirish");
        System.out.println("3. Vazifani o'chirish");
        System.out.println("4. Vazifalarni ko'rish");
        System.out.println("5. Chiqish");
        System.out.print("Tanlovingiz: ");
    }

    private static void createTodo() {
        System.out.print("Vazifa matnini kiriting: ");
        String task = scanner.nextLine();
        Todo todo = new Todo(todoCounter++, task);
        todoList.add(todo);
        System.out.println("Vazifa qo'shildi.");
    }

    private static void updateTodo() {
        listTodos();
        System.out.print("O'zgartirish uchun vazifa ID sini kiriting: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                System.out.print("Yangi matnni kiriting: ");
                String newTask = scanner.nextLine();
                todo.setTask(newTask);
                System.out.print("Bajarilgan holatni belgilang (true/false): ");
                boolean isCompleted = scanner.nextBoolean();
                todo.setCompleted(isCompleted);
                System.out.println("Vazifa yangilandi.");
                return;
            }
        }
        System.out.println("Bunday ID mavjud emas.");
    }

    private static void deleteTodo() {
        listTodos();
        System.out.print("O'chirish uchun vazifa ID sini kiriting: ");
        int id = scanner.nextInt();

        for (int i = 0; i < todoList.size(); i++) {
            if (todoList.get(i).getId() == id) {
                todoList.remove(i);
                System.out.println("Vazifa o'chirildi.");
                return;
            }
        }
        System.out.println("Bunday ID mavjud emas.");
    }

    private static void listTodos() {
        if (todoList.isEmpty()) {
            System.out.println("Hozircha hech qanday vazifa yo'q.");
        } else {
            System.out.println("\n=== Vazifalar Ro'yxati ===");
            for (Todo todo : todoList) {
                System.out.println(todo);
            }
        }
    }
}