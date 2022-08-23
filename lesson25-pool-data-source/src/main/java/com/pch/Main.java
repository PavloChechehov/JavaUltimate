package com.pch;


import lombok.SneakyThrows;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

import static com.pch.DatabaseCredentials.PASSWORD;
import static com.pch.DatabaseCredentials.URL;
import static com.pch.DatabaseCredentials.USER;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
//        var dataSource = initilizeDataSource();
        var dataSource = initializePooledDataSource();

        var startTime = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            try (var connection = dataSource.getConnection()) {

                connection.setAutoCommit(false);

                try (var statement = connection.createStatement()) {

                    var rs = statement.executeQuery("select * from persons");

                    while (rs.next()) {

                        var id = rs.getLong("id");
                        var firstName = rs.getString("first_name");
                        var lastName = rs.getString("last_name");

                        var person = new Person(id, firstName, lastName);

                        System.out.println(person);
                    }
                }

                connection.rollback();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        var finishTime = (System.nanoTime() - startTime) / 1000_000;
        System.out.println(finishTime + "ms");

    }

    private static DataSource initilizeDataSource() {
        var dataSource = new PGSimpleDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    private static DataSource initializePooledDataSource() {
        var pooledDataSource = new PooledDataSource(URL, USER, PASSWORD);
        return pooledDataSource;
    }
}
