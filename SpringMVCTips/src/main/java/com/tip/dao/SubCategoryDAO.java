package com.tip.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.tip.common.Common;
import com.tip.mapper.SubCategoryMapper;
import com.tip.model.SubCategory;

@Repository
@Transactional
public class SubCategoryDAO extends JdbcDaoSupport {

	@Autowired
	public SubCategoryDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<SubCategory> findAll() {

		String sql = "select * from tips_management.sub_category  where DeleteDate is null order by Id";
		Object[] params = new Object[] {};
		SubCategoryMapper mapper = new SubCategoryMapper();
		System.out.println(sql);

		List<SubCategory> subCategorys = this.getJdbcTemplate().query(sql, mapper, params);

		return subCategorys;
	}

	public List<SubCategory> findByIdMaster(Integer idMasterCategory) {

		String sql = "select * from tips_management.sub_category where IdMasterCategory = ? and DeleteDate is null order by Id";
		System.out.println(sql);
		Object[] params = new Object[] { idMasterCategory };
		SubCategoryMapper mapper = new SubCategoryMapper();

		List<SubCategory> subCategorys = this.getJdbcTemplate().query(sql, mapper, params);
		return subCategorys;
	}
	public List<SubCategory> findByIdMasterIncludingDeleted(Integer idMasterCategory) {
		
		String sql = "select * from tips_management.sub_category where IdMasterCategory = ?  order by Id";
		System.out.println(sql);
		Object[] params = new Object[] { idMasterCategory };
		SubCategoryMapper mapper = new SubCategoryMapper();
		
		List<SubCategory> subCategorys = this.getJdbcTemplate().query(sql, mapper, params);
		return subCategorys;
	}

	public SubCategory findById(Integer id) {

		String sql = "select * from tips_management.sub_category where Id = ? and DeleteDate is null";
		System.out.println(sql);
		Object[] params = new Object[] { id };
		SubCategoryMapper mapper = new SubCategoryMapper();

		List<SubCategory> subCategorys = this.getJdbcTemplate().query(sql, mapper, params);
		if(CollectionUtils.isEmpty(subCategorys)) {
			return null;
		}
		return subCategorys.get(0);
	}
	public SubCategory findByIdIncludingDeleted(Integer id) {
		
		String sql = "select * from tips_management.sub_category where Id = ?;";
		System.out.println(sql);
		Object[] params = new Object[] { id };
		SubCategoryMapper mapper = new SubCategoryMapper();
		
		List<SubCategory> subCategorys = this.getJdbcTemplate().query(sql, mapper, params);
		if(CollectionUtils.isEmpty(subCategorys)) {
			return null;
		}
		return subCategorys.get(0);
	}

	public int insert(SubCategory subCategory) {
		String sql = "INSERT INTO tips_management.sub_category(Id, Name, Description, IdMasterCategory, DeleteDate, UpdateTime) VALUES (null, ?, ?, ?, ?, ?);";
		System.out.println(sql);
		Object[] params = new Object[] { subCategory.getName(), subCategory.getDescription(), subCategory.getIdMaster(),
				subCategory.getDeleteDate(), subCategory.getUpdateDate(), };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int update(SubCategory subCategory) {

		String sql = "update tips_management.sub_category set Name = ?, Description = ?, UpdateTime = ? where Id = ?";
		System.out.println(sql +","+subCategory.getName()+","+ subCategory.getDescription()+","+ subCategory.getUpdateDate()+","+ subCategory.getId()  );
		Object[] params = new Object[] { subCategory.getName(), subCategory.getDescription(), subCategory.getUpdateDate(), subCategory.getId() };
		return this.getJdbcTemplate().update(sql, params);

	}

	public int delete(Integer id) {
		String sql = "delete from tips_management.sub_category where Id = ?";
		System.out.println(sql);
		Object[] params = new Object[] { id };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deleteTemp(Integer id) {
		String sql = "update tips_management.sub_category set DeleteDate = ?, UpdateTime = ? where Id = ?;";

		System.out.println(sql);
		Object[] params = new Object[] { Common.getCurrentDateAsStr(),Common.getCurrentDateAsStr(),
				id };
		return this.getJdbcTemplate().update(sql, params);
	}
	public int restore(Integer id) {
		String sql = "update tips_management.sub_category set DeleteDate = ?, UpdateTime = ? where Id = ?;";
		
		System.out.println(sql);
		Object[] params = new Object[] {null, Common.getCurrentDateAsStr(),
				id };
		return this.getJdbcTemplate().update(sql, params);
	}

}