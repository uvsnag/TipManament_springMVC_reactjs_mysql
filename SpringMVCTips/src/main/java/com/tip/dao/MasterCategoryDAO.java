package com.tip.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.tip.common.Common;
import com.tip.mapper.CategoryMasterMapper;
import com.tip.model.CategoryMaster;

@Repository
@Transactional
public class MasterCategoryDAO extends JdbcDaoSupport {

	@Autowired
	public MasterCategoryDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<CategoryMaster> findAll() {

		String sql = "select * from tips_management.category_master where DeleteDate is null order by Id";
		System.out.println(sql);
		Object[] params = new Object[] {};
		CategoryMasterMapper mapper = new CategoryMasterMapper();

		List<CategoryMaster> masterCategotys = this.getJdbcTemplate().query(sql, mapper, params);

		return masterCategotys;
	}
	public List<CategoryMaster> findAllIncludingDeleted() {
		
		String sql = "select * from tips_management.category_master order by Id";
		System.out.println(sql);
		Object[] params = new Object[] {};
		CategoryMasterMapper mapper = new CategoryMasterMapper();
		
		List<CategoryMaster> masterCategotys = this.getJdbcTemplate().query(sql, mapper, params);
		
		return masterCategotys;
	}

	public CategoryMaster findById(Integer id) {

		String sql = "select * from tips_management.category_master where Id = ? and DeleteDate is null";
		System.out.println(sql);
		Object[] params = new Object[] { id };
		CategoryMasterMapper mapper = new CategoryMasterMapper();

		List<CategoryMaster> masterCategotys = this.getJdbcTemplate().query(sql, mapper, params);
		if(CollectionUtils.isEmpty(masterCategotys)) {
			return null;
		}
		return masterCategotys.get(0);
		
	}
	public CategoryMaster findByIdIncludingDeleted(Integer id) {
		
		String sql = "select * from tips_management.category_master where Id = ? ;";
		System.out.println(sql);
		Object[] params = new Object[] { id };
		CategoryMasterMapper mapper = new CategoryMasterMapper();
		
		List<CategoryMaster> masterCategotys = this.getJdbcTemplate().query(sql, mapper, params);
		if(CollectionUtils.isEmpty(masterCategotys)) {
			return null;
		}
		return masterCategotys.get(0);
		
	}

	public int insert(CategoryMaster masterCategoty) {
		String sql = "INSERT INTO tips_management.category_master(Id, Name, Description, DeleteDate, UpdateTime) VALUES (null, ?, ?, ?, ?);";
		System.out.println(sql);
		Object[] params = new Object[] { masterCategoty.getName(), masterCategoty.getDescription(),
				masterCategoty.getDeleteDate(), masterCategoty.getUpdateDate(), };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int update(CategoryMaster masterCategoty) {

		String sql = "update tips_management.category_master set Name = ?, Description = ?,  UpdateTime = ? where Id = ?";
		System.out.println(sql);
		Object[] params = new Object[] { masterCategoty.getName(), masterCategoty.getDescription(), masterCategoty.getUpdateDate(), masterCategoty.getId() };
		return this.getJdbcTemplate().update(sql, params);

	}

	public int delete(Integer id) {
		String sql = "delete from tips_management.category_master where Id = ?";
		System.out.println(sql);
		Object[] params = new Object[] { id };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deleteTemp(Integer id) {
		String sql = "update tips_management.category_master set DeleteDate = ?, UpdateTime = ? where Id = ?";

		System.out.println(sql);
		Object[] params = new Object[] { Common.getCurrentDateAsStr(),Common.getCurrentDateAsStr(),
				id };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int restore(Integer id) {
		
		String sql = "update tips_management.category_master set DeleteDate = ?, UpdateTime = ? where Id = ?";
		System.out.println(sql);
		Object[] params = new Object[] { null, Common.getCurrentDateAsStr(),
				id };
		return this.getJdbcTemplate().update(sql, params);
		
	}
}