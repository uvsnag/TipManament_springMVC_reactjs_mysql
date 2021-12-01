package com.tip.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.tip.common.Common;
import com.tip.mapper.TipMapper;
import com.tip.model.Tip;

@Repository
@Transactional
public class TipDAO extends JdbcDaoSupport {

	@Autowired
	public TipDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<Tip> findAll() {

		String sql = "select * from tips_management.tips where DeleteDate is null order by Id";
		System.out.println(sql);
		Object[] params = new Object[] {};
		TipMapper mapper = new TipMapper();

		List<Tip> tips = this.getJdbcTemplate().query(sql, mapper, params);

		return tips;
	}
	public List<Tip> findbyContens(String content) {
		
		String sql = "select * from tips_management.tips where Contents like ? or Name like ?;";
		System.out.println(sql);
		Object[] params = new Object[] {"%"+content+"%", "%"+content+"%"};
		TipMapper mapper = new TipMapper();
		
		List<Tip> tips = this.getJdbcTemplate().query(sql, mapper, params);
		
		return tips;
	}

	public List<Tip> findByIdType(Integer idType) {

		String sql = "select * from tips_management.tips where IdType = ? and DeleteDate is null order by Id";
		System.out.println(sql);
		Object[] params = new Object[] { idType };
		TipMapper mapper = new TipMapper();

		List<Tip> tips = this.getJdbcTemplate().query(sql, mapper, params);
		return tips;
	}
	public List<Tip> findByIdTypeIncludingDeleted(Integer idType) {
		
		String sql = "select * from tips_management.tips where IdType = ? order by Id";
		System.out.println(sql);
		Object[] params = new Object[] { idType };
		TipMapper mapper = new TipMapper();
		
		List<Tip> tips = this.getJdbcTemplate().query(sql, mapper, params);
		return tips;
	}

	public Tip findById(Integer id) {

		String sql = "select * from tips_management.tips where Id = ? and DeleteDate is null";
		System.out.println(sql);
		Object[] params = new Object[] { id };
		TipMapper mapper = new TipMapper();

		List<Tip> tips = this.getJdbcTemplate().query(sql, mapper, params);
		if(CollectionUtils.isEmpty(tips)) {
			return null;
		}
		return tips.get(0);
	}
	public Tip findByIdIncludingDeleted(Integer id) {
		
		String sql = "select * from tips_management.tips where Id = ? ;";
		System.out.println(sql);
		Object[] params = new Object[] { id };
		TipMapper mapper = new TipMapper();
		
		List<Tip> tips = this.getJdbcTemplate().query(sql, mapper, params);
		if(CollectionUtils.isEmpty(tips)) {
			return null;
		}
		return tips.get(0);
	}

	public int insert(Tip tip) {
		String sql = "INSERT INTO tips_management.tips(Id, Name, Contents, IdType, DeleteDate, UpdateTime) VALUES (null, ?, ?, ?, ?, ?);";
		System.out.println(sql);
		Object[] params = new Object[] { tip.getName(), tip.getContents(), tip.getIdType(), tip.getDeleteDate(),
				tip.getUpdateDate(), };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int update(Tip tip) {

		String sql = "update tips_management.tips set Name = ?, Contents = ?, IdType=?, UpdateTime = ? where (Id = ?)";
		System.out.println(sql);
		Object[] params = new Object[] { tip.getName(), tip.getContents(), tip.getIdType(),
				tip.getUpdateDate(), tip.getId() };
		return this.getJdbcTemplate().update(sql, params);

	}

	public int delete(Integer id) {
		String sql = "delete from tips_management.tips where Id = ?";
		System.out.println(sql);
		Object[] params = new Object[] { id };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deleteTemp(Integer id) {
		String sql = "update tips_management.tips set DeleteDate = ?, UpdateTime = ? where (Id = ?);";

		System.out.println(sql);
		Object[] params = new Object[] { Common.getCurrentDateAsStr(),Common.getCurrentDateAsStr(),
				id };
		return this.getJdbcTemplate().update(sql, params);
	}
	
	public int restore(Integer id) {
		String sql = "update tips_management.tips set DeleteDate = ?, UpdateTime = ? where (Id = ?);";

		System.out.println(sql);
		Object[] params = new Object[] { null, Common.getCurrentDateAsStr(),
				id };
		return this.getJdbcTemplate().update(sql, params);
	}

}