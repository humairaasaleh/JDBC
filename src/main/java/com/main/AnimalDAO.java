package com.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AnimalDAO implements DAO<Animals> {

	@Override
	public Animals create(Animals input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int animalId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Animals update(Animals input, int animalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Animals> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animals readByID(int animalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animals animalsFromResultSet(ResultSet resultset) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
