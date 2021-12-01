package com.tip.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.jdbc.core.RowMapper;

import com.tip.model.Tip;

public class TipMapper implements RowMapper<Tip> {
 
//    public static final String BASE_SQL = //
//            "Select e.index, e.name, e.date_of_birth, e.address, e.id_dep "//
//                    + " from public.test_employee e ";
 
//    @Override
    public Tip mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("Id");
        String name = rs.getString("Name");
        String contents = rs.getString("Contents");
        Integer idType = rs.getInt("IdType");
        String deleteDate = rs.getString("DeleteDate");
        String updateDate = rs.getString("UpdateTime");
 
        return new Tip(id, name, contents, idType, deleteDate, updateDate);
    }
 
}
