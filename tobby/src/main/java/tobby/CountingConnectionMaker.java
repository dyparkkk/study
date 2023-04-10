package tobby;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker{
    int cnt = 0;
    private ConnectionMaker connectionMaker;

    public CountingConnectionMaker(ConnectionMaker realConnectionMaker){
        this.connectionMaker = realConnectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        cnt++;
        return connectionMaker.makeConnection();
    }
}
