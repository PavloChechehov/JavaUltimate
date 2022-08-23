package com.pch;


import lombok.experimental.Delegate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Queue;

public class ConnectionProxy implements Connection {

    // todo: 1. store a physical connection and a pool reference
    // todo: 2. override method close
    // todo: 3. delegate all method invocations to a physical connection

    @Delegate(excludes = Exclude.class)
    private Connection physicalConnection;
    private Queue<Connection> connectionsPool;

    public ConnectionProxy(Connection physicalConnection, Queue<Connection> connectionsPool) {
        this.physicalConnection = physicalConnection;
        this.connectionsPool = connectionsPool;
    }

    @Override
    public void close() throws SQLException {
        connectionsPool.add(this);
    }

    private interface Exclude {
        void close();
    }
}
