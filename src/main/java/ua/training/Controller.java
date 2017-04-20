package ua.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    Model model;
    View view;

    List<Integer> statistic = new ArrayList<>();

    public Controller(Model model, View view) {

        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        view.message(View.MSG_QUESTION);
        System.out.println(model.getValue());
        inputNumber(sc);
        viewStatistic();
    }

    public void inputNumber(Scanner scanner){
        while (!scanner.hasNextInt()){
            view.message(view.MSG_ERROR, view.MSG_INPUT);
            scanner.next();
        }
        int inputValue=scanner.nextInt();
        while (true){
            if (checkLimit(inputValue) && checkMatch(inputValue)){
                return ;
            }
            inputValue=scanner.nextInt();
        }
    }

    public boolean checkMatch(int value){
        statistic.add(value);
        if (checkLimit(value)){
            if (value==model.getValue()){
                view.message(view.MSG_BINGO);
                return true;
            }
            if (value>model.getValue()){
                model.setMaxLimit(value-1);
                view.message(view.MSG_DOWN,view.MSG_AGAIN, view.MSG_INPUT, "(",String.valueOf(model.getMinLimit())," - ",String.valueOf(model.getMaxLimit()),")");
            }
            if (value<model.getValue()){
                model.setMinLimit(value+1);
                view.message(view.MSG_UP,view.MSG_AGAIN, view.MSG_INPUT, "(",String.valueOf(model.getMinLimit())," - ",String.valueOf(model.getMaxLimit()),")");
            }
        }
        return false;
    }

    public boolean checkLimit(int value){
       if (value>model.maxLimit){
            view.message(view.MSG_ERROR,view.MSG_TRANSCENDS_LIMIT, model.getMaxLimit().toString(), ". ", view.MSG_AGAIN,view.MSG_INPUT);
            return false;
        } else if (value<model.minLimit){
            view.message(view.MSG_ERROR,view.MSG_TRANSCENDS_LIMIT, model.getMinLimit().toString(), ". ",view.MSG_AGAIN,view.MSG_INPUT);
            return false;
        }
        return true;
    }

    public void viewStatistic(){

        for (int i = 1; i < statistic.size(); i++) {
            view.message(String.valueOf(i+" - "+statistic.get(i).intValue()));
        }
    }
}
