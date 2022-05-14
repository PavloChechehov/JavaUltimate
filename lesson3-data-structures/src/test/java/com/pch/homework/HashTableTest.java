package com.pch.homework;

import com.pch.Account;
import com.pch.Accounts;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    public void putTest() {
        HashTable<String, String> table = new HashTable<>(4);
        List<Account> accounts = Accounts.generateAccountList(10);

        accounts.forEach(account -> table.put(account.getEmail(), account.getBirthday().toString()));

        assertEquals(10, table.size());
    }

    @Test
    public void getTest() {
        HashTable<String, String> table = new HashTable<>();

        List<Account> accounts = Accounts.generateAccountList(10);

        accounts.forEach(account -> table.put(account.getEmail(), account.getBirthday().toString()));

        Account account = accounts.get(0);
        System.out.println(account.getEmail() + ":" + account.getBirthday().toString());

        assertEquals(account.getBirthday().toString(), table.get(account.getEmail()));
    }

    @Test
    public void containsTest() {
        HashTable<String, String> table = new HashTable<>();

        Account account = Accounts.generateAccount();
        table.put(account.getEmail(), account.getBirthday().toString());

        System.out.println(account.getEmail() + ":" + account.getBirthday().toString());

        assertTrue(table.containsKey(account.getEmail()));
    }

    @Test
    public void putNullKey() {
        HashTable<String, String> table = new HashTable<>();
        assertThrows(NullPointerException.class, () -> table.put(null, "hello"));
    }

    @Test
    public void putNewValueToTheExistingKey() {
        HashTable<String, String> table = new HashTable<>();
        table.put("Pavlo", "Engineer");

        assertEquals(1, table.size());
        assertEquals("Engineer", table.get("Pavlo"));

        table.put("Pavlo", "Sportsman");
        assertEquals(1, table.size());
        assertEquals("Sportsman", table.get("Pavlo"));
    }
}