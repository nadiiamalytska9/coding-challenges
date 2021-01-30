package challenges.solution;

public class JumpingCloud {
    public static int jumpingOnClouds(int cloudsCount, int[] clouds) {
        int minimumStepsToWin = 0;
        for (int i = 0; i < cloudsCount - 1; i++) {
            if (i < cloudsCount - 2 && clouds[i + 2] == 0) {
                i++;
            }
            minimumStepsToWin++;
        }
        return minimumStepsToWin;
    }
}
