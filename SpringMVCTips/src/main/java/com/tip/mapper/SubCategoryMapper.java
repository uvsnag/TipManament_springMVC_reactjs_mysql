package com.tip.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tip.model.SubCategory;

public class SubCategoryMapper implements RowMapper<SubCategory> {

    public SubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("Id");
        String name = rs.getString("Name");
        String description = rs.getString("Description");
        Integer idMaster = rs.getInt("IdMasterCategory");
        String deleteDate = rs.getString("DeleteDate");
        String updateDate = rs.getString("UpdateTime");
 
        return new SubCategory(id, name, description, idMaster, deleteDate, updateDate);
    }
}
