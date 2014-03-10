package com.ashish.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDAO")
public class OffersDao {

	private NamedParameterJdbcTemplate	jdbc;

	public NamedParameterJdbcTemplate getJdbc() {
		return jdbc;
	}

	public OffersDao() {
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Offer> getOffers() {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource("name", "ashish");
		return jdbc.query("select * from offers", parameterSource, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				return offer;
			}

		});
	}

	public boolean create(Offer offer) {
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offers (name,text,email) value (:name,:text,:email)", param) == 1;
	}

	@Transactional
	public int[] create(List<Offer> offers) {

		SqlParameterSource[] parameterSources = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("insert into offers (id,name,text,email) value (:id,:name,:text,:email)", parameterSources);

	}

	public int delete(int id) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", id);
		return jdbc.update("delete from offers where id=:id", paramMap);
	}

	public Offer getOffer(int id) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
		return jdbc.queryForObject("select * from offers where id=:id", parameterSource, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				return offer;
			}

		});
	}

}
