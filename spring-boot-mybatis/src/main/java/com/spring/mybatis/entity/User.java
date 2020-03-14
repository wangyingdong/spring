package com.spring.mybatis.entity;

import javax.persistence.*;

import com.spring.mybatis.handler.AddressTypeHandler;
import com.spring.mybatis.handler.SexTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.EnumTypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //数据库自增的主键
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "avatar")
    private String avatar;

    @Transient ///数据库表中不存在的字段
    private String readonly;

    @Transient ///数据库表中不存在的字段
    @ColumnType(typeHandler = AddressTypeHandler.class)
    private Address address;

    @Transient ///数据库表中不存在的字段
    @ColumnType(typeHandler = SexTypeHandler.class)
    private Sex sex;
}