import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        manager.load();
        boolean running = true;

        while(running){
            System.out.println("\n1. Add 2. List 3. Complete 4. Delete 5. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice){

                case "1" :
                    System.out.print("Task title: ");
                    String title = scanner.nextLine();
                    manager.add(title);
                    break;

                case "2" :
                    manager.list();
                    break;

                case "3":
                    int number = readNumber(scanner);
                    manager.complete(number);
                    break;

                case "4":
                    int delNumber = readNumber(scanner);
                    manager.delete(delNumber);
                    break;

                case "5":
                    running = false;

                default :
                    System.out.println("Invalid choice.");
            }
        }
        manager.save();
        System.out.println("Goodbye");
    }
    private static int readNumber(Scanner scanner) {
        System.out.print("Task number: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please type a number.");
            return -1;
        }
    }
}