import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData;

    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца от 0 до 11 (включительно)");
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Номер месяца введён неверно, он должен быть от 0 до 11.");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        // ввод и проверка дня
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Номер дня введён неверно, он должен быть от 1 до 30.");
            return;
        }
        System.out.println("Введите количество шагов");
        // ввод и проверка количества шагов
        int steps = scanner.nextInt();
        if (steps < 1) {
            System.out.println("Количество шагов введено неверо, это должно быть число больше 0.");
            return;
        }
        // сохранение данных
        MonthData monthData = monthToData[month];
        monthData.days[day] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите количество шагов, которое вы планируете проходить за день");
        // ввод и проверка количества шагов
        int steps = scanner.nextInt();
        if (steps < 1) {
            System.out.println("Количество шагов введено неверо, это должно быть число больше 0.");
            return;
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        //printMonth();
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Номер месяца введён неверно, он должен быть от 0 до 11.");
            return;
        }

        MonthData monthData = monthToData[month]; // получение соответствующего месяца
                // вывод общей статистики
        monthData.printDaysAndStepsFromMonth();
                // вывод суммы шагов за месяц
        System.out.println("За выбранный месяц вы прошли " + monthData.sumStepsFromMonth());
                // вывод максимального пройденного количества шагов за месяц
        System.out.println("Максимальное количество шагов за день составило " + monthData.maxSteps());
                // подсчёт и вывод среднее количество шагов за месяц
        System.out.println("Среднее количество шагов составило " + (monthData.sumStepsFromMonth() / 30));
                // вывод пройденной за месяц дистанции в км
        System.out.println("За месяц вы прошли " + converter.convertToKm(monthData.sumStepsFromMonth()));
                // вывод количества сожжённых килокалорий за месяц
        System.out.println("За месяц вы сожгли " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
                // вывод лучшей серии
        System.out.println("Лучшая серия шагов " + monthData.bestSeries(goalByStepsPerDay));
                System.out.println(); //дополнительный перенос строки
    }


} 