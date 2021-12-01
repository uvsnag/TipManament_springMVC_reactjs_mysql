package com.tip.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tip.model.CategoryMaster;

public class CategoryMasterMapper implements RowMapper<CategoryMaster> {

    public CategoryMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("Id");
        String name = rs.getString("Name");
        String description = rs.getString("Description");
        String deleteDate = rs.getString("DeleteDate");
        String updateDate = rs.getString("UpdateTime");
 
        return new CategoryMaster(id, name, description,  deleteDate, updateDate);
    }
}