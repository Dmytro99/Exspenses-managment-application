package com.intelliarts.demkovych;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import java.util.Scanner;
import java.util.logging.LogManager;

public class Converter {


//    public void convert() {
//        Scanner reader = new Scanner(System.in);
//        LogManager.getLogManager().reset();
//
//        System.out.print("Input Currency to what you want to convert: ");
//        String currency = reader.nextLine();
//        CurrencyConversion dollarConversion = MonetaryConversions.getConversion(currency);
//
//        System.out.print("Input currency1: ");
//        String currency1 = reader.nextLine();
//        System.out.print("Input amount: ");
//        int amount = reader.nextInt();
//        MonetaryAmount tenEuro = Money.of(amount, currency1);
//
//        MonetaryAmount inDollar = tenEuro.with(dollarConversion);
//        System.out.println(inDollar);
//    }


}
