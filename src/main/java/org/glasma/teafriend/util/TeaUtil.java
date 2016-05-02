package org.glasma.teafriend.util;

import org.glasma.teafriend.model.Tea;

import java.util.Arrays;
import java.util.List;

public class TeaUtil {
    public static final List<Tea> TEA_LIST = Arrays.asList(
            new Tea(1, "Молочный оолонг", "Светлый улун", "Китай", "Очень вкучный"),
            new Tea(2, "Дахунпао", "Темный улун", "Китай", "Очень вкучный"),
            new Tea(3, "Белая обезьяна", "Белый", "Китай", "Очень вкучный"),
            new Tea(4, "Ассам Мангалам", "Черный", "Индия", "Очень вкучный"),
            new Tea(5, "Мэнхай Даи", "Шен Пуэр", "Китай", "Очень вкучный")
    );

    public static List<Tea> getTeaList(){
        return TEA_LIST;
    }
}
