package com.spring.mybatis.handler;

import com.spring.mybatis.entity.Address;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressTypeHandler extends BaseTypeHandler<Address> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Address address, JdbcType jdbcType) throws SQLException {
        if (address == null) {
            return;
        }
        String province = address.getProvince();
        String city = address.getCity();
        String area = address.getArea();
        String street = address.getStreet();

        StringBuilder builder = new StringBuilder();
        builder.append(province).append(",").append(city).append(",").append(area).append(",").append(street);
        preparedStatement.setString(i, builder.toString());

    }

    @Override
    public Address getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String columnValue = resultSet.getString(s);
        return getAddress(columnValue);
    }

    @Override
    public Address getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String columnValue = resultSet.getString(i);
        return getAddress(columnValue);
    }

    @Override
    public Address getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String columnValue = callableStatement.getString(i);
        return getAddress(columnValue);
    }

    private Address getAddress(String columnValue) {
        if (StringUtils.isEmpty(columnValue) || !columnValue.contains(",")) {
            return null;
        }
        String province = columnValue.split(",")[0];
        String city = columnValue.split(",")[1];
        String area = columnValue.split(",")[2];
        String street = columnValue.split(",")[3];
        return Address.builder().province(province).city(city).area(area).street(street).build();

    }
}
