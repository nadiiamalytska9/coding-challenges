package challenges.solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FraudulentActivityNotificationTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    public void isActivityNotificationsRight(int[] expenditure, int d, int expectedNotificationNumber) {
        int actualNotificationNumber = FraudulentActivityNotification.activityNotifications(expenditure, d);
        assertThat("Expected notification number: [" + expectedNotificationNumber + "]. But received wrong value: [" + actualNotificationNumber + "]",
                expectedNotificationNumber, is(actualNotificationNumber));
    }

    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5, 2),
                Arguments.of(new int[]{1, 2, 3, 4, 4}, 4, 0),
                Arguments.of(new int[]{10, 20, 30, 40, 50}, 3, 1)
        );
    }
}
