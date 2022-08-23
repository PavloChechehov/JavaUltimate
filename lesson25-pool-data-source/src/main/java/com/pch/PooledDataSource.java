package com.pch;

import lombok.SneakyThrows;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PooledDataSource extends PGSimpleDataSource {
    // todo: 1. store a queue of connections (this is a pool)
    // todo: 2. initialize a datasource with 10 physical connection
    // todo: 3. override method getConnection so it uses a pool

    private final Queue<Connection> queue;
    public static final int DEFAULT_INITIAL_CONNECTIONS = 10;

    @SneakyThrows
    public PooledDataSource(String url, String user, String pass) {
        super.setURL(url);
        super.setUser(user);
        super.setPassword(pass);

        queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < DEFAULT_INITIAL_CONNECTIONS; i++) {
            Connection connection = new ConnectionProxy(super.getConnection(), queue);
            queue.add(connection);
        }

    }


    @Override
    @SneakyThrows
    public Connection getConnection() {
        return queue.poll();
    }

}
