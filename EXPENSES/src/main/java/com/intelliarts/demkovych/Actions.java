package com.intelliarts.demkovych;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import java.util.*;
import java.util.logging.LogManager;
import java.util.stream.Collectors;

public class Actions {
    Data dataCopy;
    String date;
    String nameOfProduct;
    int amountOfMoney;
    String currency;
    int input;
    String clear;

    List<Data> data = new ArrayList<>();

    Scanner reader = new Scanner(System.in);

    public void addData() {
        do{

            System.out.print("\nInput date : ");
            date = reader.nextLine();

            System.out.print("Input your product : ");
            nameOfProduct = reader.nextLine();

            System.out.print("Input currency : ");
            currency = reader.nextLine();

            System.out.print("Input amount of money, which you spent for this product : ");
            amountOfMoney = reader.nextInt();
            System.out.print("");

            System.out.println("Input 0 to finish... \n     OR     \nInput 1-9 to continue...");
            input = reader.nextInt();

            data.add(new Data(date, nameOfProduct, currency, amountOfMoney));
            sortByDate();

            data = data.stream().distinct().collect(Collectors.toList());
            clear = reader.nextLine();
            clear();
//            convert();
            }while (input != 0);

        showList();
//        resultOfAmount();
        }



//        =================================================================================================

    public void clear() {
        data.removeIf(s -> s.getDate().equalsIgnoreCase(clear));

    }
//        =================================================================================================

    public void showList() {
        Object[] array = data.toArray();
        for (Object result : data) {
            System.out.print(result + " \n");
        }

    }
//        =================================================================================================

    public void sortByDate() {
        data.sort(Comparator.comparing(Data::getDate).reversed());
    }


//    public int resultOfAmount() {
//        int sum = 0;
//        for (int i = 0; i < data.size(); i++) {
//            Data dataObject = data.get(i);
//            sum += dataObject.getMoney();
//
//        }
//        System.out.println(sum);
//        return sum;
//    }


//    public void convert() {
//        int sum = 0;
//        for (int i = 0; i < data.size(); i++) {
//            Data dataObject = data.get(i);
//            sum += dataObject.getMoney();
//
//        }
//
//        LogManager.getLogManager().reset();
//
//        System.out.print("Input Currency to what you want to convert: ");
//        String currencyInWhichConvert = reader.nextLine();
//        CurrencyConversion dollarConversion = MonetaryConversions.getConversion(currencyInWhichConvert);
//
//        MonetaryAmount from = Money.of(sum, currency);
//
//        MonetaryAmount in = from.with(dollarConversion);
//        System.out.println(in);
//
//    }

}




