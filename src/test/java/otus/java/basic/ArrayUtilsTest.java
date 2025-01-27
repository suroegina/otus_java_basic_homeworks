package otus.java.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    private ArrayUtils arrayUtils;
    @BeforeEach
    public void init() {
        arrayUtils = new ArrayUtils();
    }

    @ParameterizedTest
    @MethodSource("testData4")
    @DisplayName("Тест метода getArrayAfterOne() с параметризацией - Успешный")
    void getArrayAfterOneNotThrows(int[] array, int[] result) {
        Assertions.assertArrayEquals(arrayUtils.getArrayAfterOne(array),result);
    }

    @MethodSource
    public static Stream<Arguments> testData4() {
        return Stream.of(
                Arguments.of((Object) new int[] {1,2,1,2,2}, (Object) new int[] {2,2}),
                Arguments.of((Object) new int[] {2,2,2,1,3,4}, (Object) new int[] {3,4}),
                Arguments.of((Object) new int[] {2,1,4,1,3,5}, (Object) new int[] {3,5})
                );
    }


    @ParameterizedTest
    @MethodSource("testData3")
    @DisplayName("Тест метода getArrayAfterOne() с параметризацией - Неуспешные (Выброс исключения)")
    void getArrayAfterOneThrows(int[] array) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            arrayUtils.getArrayAfterOne(array);
        }, "Должно выброситься исключение RuntimeException");
    }

    @MethodSource
    public static Stream<Arguments> testData3() {
        return Stream.of(
                Arguments.of((Object) new int[] {2,2,3,4}),
                Arguments.of((Object) new int[] {2,2,4,2,3,5})
                );
    }

    @ParameterizedTest
    @MethodSource("testData1")
    @DisplayName("Тест метода arrayContainsOneTwo() с параметризацией - через assertTrue")
    void arrayContainsOneTwoTrue(int[] array) {
        Assertions.assertTrue(arrayUtils.arrayContainsOneTwo(array));
    }

    @MethodSource
    public static Stream<Arguments> testData1() {
        return Stream.of(
                Arguments.of((Object) new int[] {1,2}),
                Arguments.of((Object) new int[] {1,2,2,1})
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("Тест метода arrayContainsOneTwo() с параметризацией - через assertFalse")
    void arrayContainsOneTwoFalse(int[] array) {
        Assertions.assertFalse(arrayUtils.arrayContainsOneTwo(array));
    }

    @MethodSource
    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of((Object) new int[] {1,1}),
                Arguments.of((Object) new int[] {1,3})
        );
    }

    @ParameterizedTest
    @MethodSource("testData5")
    @DisplayName("Тест метода arrayContainsOneTwo() с параметризацией - через assertEquals")
    void arrayContainsOneTwo(int[] array, boolean isTrue) {
        Assertions.assertEquals(arrayUtils.arrayContainsOneTwo(array), isTrue);
    }

    @MethodSource
    public static Stream<Arguments> testData5() {
        return Stream.of(
                Arguments.of((Object) new int[] {1,1}, false),
                Arguments.of((Object) new int[] {1,3}, false),
                Arguments.of((Object) new int[] {1,2}, true),
                Arguments.of((Object) new int[] {1,2,2,1}, true)
        );
    }


}