package com.intelliarts.demkovych;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import java.util.*;
import java.util.logging.LogManager;
import java.util.stream.Collectors;

public class Menu {
    String date;
    String nameOfProduct;
    int amountOfMoney;
    String currency;
    int input;
    String clear;


    List<Data> data = new ArrayList<>();


    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner reader = new Scanner(System.in, "UTF-8");

    Locale locale;
    ResourceBundle bundle;


    //---------------------------------Action for programme----------------------------------------
    private void addData() {
        do {

            System.out.print("\nInput date : ");
            date = reader.nextLine();
            if (!date.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")) {
                System.out.println("Date format is dd-mm-yyyy(day-month-year)!\nPlease try again... ");
                break;
            }

            System.out.print("Input your product : ");
            nameOfProduct = reader.nextLine();

            System.out.print("Input currency : ");
            currency = reader.nextLine();

            System.out.print("Input amount of money, which you spent for this product : ");
            amountOfMoney = reader.nextInt();

            System.out.println("\nInput 0 to finish adding... \n");
            input = reader.nextInt();

            data.add(new Data(date, nameOfProduct, currency, amountOfMoney));
            sortByDate();

            data = data.stream().distinct().collect(Collectors.toList());

        } while (input != 0);

    }

    private void clear() {
        System.out.println("Input the date which you want to delete : ");
        clear = reader.nextLine();
        if (!clear.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")) {
            System.out.println("Date format is dd-mm-yyyy(day-month-year)!\nPlease try again... ");
        } else {
            System.out.println("The information was successfully delete.");
        }

        data.removeIf(s -> s.getDate().equalsIgnoreCase(clear));
    }

    private void sortByDate() {
        data.sort(Comparator.comparing(Data::getDate).reversed());

    }

    private void showList() {
        Object[] array = data.toArray();
        for (Object result : data) {
            System.out.print(result + " \n");
        }
    }

    public void convert() {
        int sum = 0;
        for (int i = 0; i < data.size(); i++) {
            Data dataObject = data.get(i);
            sum += dataObject.getMoney();

        }

        LogManager.getLogManager().reset();

        System.out.print("Input Currency to what you want to convert: ");
        String currencyInWhichConvert = reader.nextLine();
        CurrencyConversion dollarConversion = MonetaryConversions.getConversion(currencyInWhichConvert);

        MonetaryAmount from = Money.of(sum, currency);

        MonetaryAmount in = from.with(dollarConversion);
        System.out.println(in);

    }

    private void switchLanguageToUkrainian() {
        locale = new Locale("uk");
        bundle = ResourceBundle.getBundle("MyMenu", locale);
        setMenu();
        show();
    }

    private void switchLanguageToEnglish() {
        locale = new Locale("en");
        bundle = ResourceBundle.getBundle("MyMenu", locale);
        setMenu();
        show();
    }

    //-----------------------------------------------------------------------------------------


    //---------------------------------Actions with Menu----------------------------------------
    private void setMenu() {

        menu = new LinkedHashMap<>();
        menu.put("1", bundle.getString("1"));
        menu.put("2", bundle.getString("2"));
        menu.put("3", bundle.getString("3"));
        menu.put("4", bundle.getString("4"));
        menu.put("5", bundle.getString("5"));
        menu.put("6", bundle.getString("6"));
        menu.put("Q", bundle.getString("Q"));
    }

    public Menu() {
        locale = new Locale("en");
        bundle = ResourceBundle.getBundle("MyMenu", locale);
        setMenu();
        methodsMenu = new LinkedHashMap<>();

        methodsMenu.put("1", this::addData);
        methodsMenu.put("2", this::clear);
        methodsMenu.put("3", this::showList);
        methodsMenu.put("4", this::convert);
        methodsMenu.put("5", this::switchLanguageToUkrainian);
        methodsMenu.put("6", this::switchLanguageToEnglish);

    }

    private void outputMenu() {
        System.out.print("\n\n***********************************************");
        System.out.println("\n*                    MENU                     *");
        System.out.println("===============================================");
        for (String key : menu.keySet()) {
            if (key.length() == 1) {
                System.out.println(menu.get(key));
            }
        }
        System.out.println("===============================================");
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = reader.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equalsIgnoreCase("Q"));
    }
//    -----------------------------------------------------------------------------------------
}
