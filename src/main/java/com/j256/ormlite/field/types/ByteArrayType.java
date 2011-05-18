package com.j256.ormlite.field.types;

import java.sql.SQLException;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;

/**
 * Type that persists a byte[] object.
 * 
 * @author graywatson
 */
public class ByteArrayType extends BaseDataType {

	private static final ByteArrayType singleTon = new ByteArrayType();

	public static ByteArrayType createType() {
		return singleTon;
	}

	private ByteArrayType() {
		super(SqlType.BYTE_ARRAY, new Class<?>[0]);
	}

	@Override
	public Object resultToJava(FieldType fieldType, DatabaseResults results, int columnPos) throws SQLException {
		return (byte[]) results.getBytes(columnPos);
	}

	@Override
	public Object parseDefaultString(FieldType fieldType, String defaultStr) throws SQLException {
		throw new SQLException("byte[] type cannot have default values");
	}

	@Override
	public boolean isAppropriateId() {
		return false;
	}

	@Override
	public boolean isSelectArgRequired() {
		return true;
	}
}
