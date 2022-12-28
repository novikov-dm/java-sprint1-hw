class MonthData {
    int[] days = new int[30];

    // количество пройденных шагов по дням
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    // общее количество шагов за месяц
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    // максимальное количество шагов в месяце
    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    // лучшая серия: максимальное количество подряд идущих дней,
    // в течение которых количество шагов за день было равно или выше целевого
    int bestSeries(int goalByStepsPerDay) {
        int bestSession = 0;
        int countBest = 0;
        for (int i = 0; i < 30; i++) {
            // поиск максимальной серии
            if (days[i] >= goalByStepsPerDay) {
                countBest += 1;
            } else {
                if (countBest > bestSession) {
                    bestSession = countBest;
                }
                countBest = 0;
            }
        }
        if (countBest > bestSession) {
            bestSession = countBest;
        }
        return bestSession;
    }
}
