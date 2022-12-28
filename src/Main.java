import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
                // здесь будет логика команды 1
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                // здесь будет логика команды 2
                stepTracker.printStatistic();
            } else if (i == 3) {
                // здесь будет логика команды 3
                stepTracker.changeStepGoal();
            } else if (i == 0) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие и введите цифру выбранного действия:");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выйти из приложения.");
    }
}
