package org.yama.dao;

import org.springframework.jdbc.core.RowMapper;
import org.yama.model.Twins;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TwinsRowMapper implements RowMapper<Twins> {
    @Override
    public Twins mapRow(ResultSet rs, int i) throws SQLException {
        Twins twins = new Twins();
        twins.setSunsu_id(rs.getInt("sunsu_id"));
        twins.setSunsu(rs.getString("sunsu"));
        twins.setSalary(rs.getInt("salary"));

        return twins;
    }
}
