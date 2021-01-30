package challenges.solution;

public class FraudulentActivityNotification {

    static int activityNotifications(int[] expenditure, int d) {
        int notificationCount = 0;
        int[] expenditureHistory = new int[500];

        for (int i = 0; i < d; i++) {
            expenditureHistory[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {
            double median = getMedian(d, expenditureHistory);
            if (expenditure[i] >= 2 * median) {
                notificationCount++;
            }
            expenditureHistory[expenditure[i]]++;
            expenditureHistory[expenditure[i - d]]--;
        }
        return notificationCount;
    }

    private static double getMedian(int d, int[] data) {
        double median = 0;
        if (d % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (m1 == null && count >= d / 2) {
                    m1 = j;
                }
                if (count >= d / 2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (count > d / 2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }
}
