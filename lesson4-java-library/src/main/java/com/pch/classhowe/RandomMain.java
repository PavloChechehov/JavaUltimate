package com.pch.classhowe;

import com.pch.Account;
import com.pch.Accounts;
import com.pch.homework.RandomFieldComparator;

import java.util.Comparator;

public class RandomMain {
    public static void main(String[] args) {
        Comparator<Account> accountComparator = new RandomFieldComparator<>(Account.class);
        System.out.println(accountComparator);
        Accounts.generateAccountList(10)
                .stream()
                .sorted(accountComparator)
                .forEach(System.out::println);
    }
}
