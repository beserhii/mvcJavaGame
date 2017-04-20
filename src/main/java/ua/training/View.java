package ua.training;

import java.util.Arrays;

public class View {

    public static final String MSG_TRANSCENDS_LIMIT="Число выходит за предельное значение - ";
    public static final String MSG_QUESTION="Отгадайте число (от 0 до 100) ";
    public static final String MSG_MAX="(100). ";
    public static final String MSG_MIN="(0). ";
    public static final String MSG_INPUT="Введите число. ";
    public static final String MSG_AGAIN="Попробуйте еще раз. ";
    public static final String MSG_ERROR="Ошибка! ";
    public static final String MSG_UP="Больше. ";
    public static final String MSG_DOWN="Меньше. ";
    public static final String MSG_BINGO="Число угадано! ";


    public static void message(String ... message){
        System.out.println(concatMessage(message));
    }

    public static String concatMessage(String...message){
        String result="";
        for (String s : message) {
            result+=s;
        }
        return result;
    }
}
