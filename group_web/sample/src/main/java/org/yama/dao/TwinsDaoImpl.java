package org.yama.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.yama.model.Twins;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwinsDaoImpl implements TwinsDao{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    //Setter
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getTwinCnt() {
        String sql = "select COUNT(*) from twins";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Twins> getTwinsList() {
        String sql = "select * from twins";
        List<Twins> list = jdbcTemplate.query(sql, new TwinsRowMapper());

        return list;
    }
}
