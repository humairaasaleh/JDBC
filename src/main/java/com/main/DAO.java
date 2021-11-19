package com.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
//	CREATE
	T create(T input);
//	DELETE
	int delete(int animalId);
//	UPDATE
	T update(T input, int animalId);
//	READ ALL
	List<T> readAll();
//	READ BY ID
	T readByID(int animalId);
//	FROM RESULT SET
	T animalsFromResultSet(ResultSet resultset) throws SQLException;

}
