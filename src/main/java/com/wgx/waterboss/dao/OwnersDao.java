package com.wgx.waterboss.dao;

import com.wgx.waterboss.bean.Owners;
import oracle.jdbc.OracleTypes;

import java.sql.*;

/**
 * author:wgx
 * version:1.0
 */
public class OwnersDao {

    public void add(Owners owners) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = BaseDao.getConnection();
            String sql = "insert into t_owners values(?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, owners.getId());
            statement.setString(2, owners.getName());
            statement.setLong(3, owners.getAddressid());
            statement.setString(4, owners.getHousenumber());
            statement.setString(5, owners.getWatermeter());
            statement.setDate(6, new Date(owners.getAdddate().getTime()));
            statement.setLong(7, owners.getOwnertypeid());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.close(null, statement, connection);
        }
    }

    public long addByUseProcedure(Owners owners) {
        Connection connection = null;
        CallableStatement statement = null;
        try {
            connection = BaseDao.getConnection();
            statement = connection.prepareCall("{call pro_insertowners(?, ?, ?, ?, ?, ?, ?)}");
            statement.setString(1, owners.getName());
            statement.setLong(2, owners.getAddressid());
            statement.setString(3, owners.getHousenumber());
            statement.setString(4, owners.getWatermeter());
            statement.setDate(5, new Date(owners.getAdddate().getTime()));
            statement.setLong(6, owners.getOwnertypeid());
            //注册传出参数的类型
            statement.registerOutParameter(7, OracleTypes.NUMBER);
            statement.execute();
            return statement.getLong(7);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.close(null, statement, connection);
        }
        return 0;
    }
}
