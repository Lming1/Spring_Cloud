//package com.example.demo;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//
//@Component
//public class CustomerService {
//
//    private final JdbcTemplate jdbcTemplate;
//
//
//    public CustomerService(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public Collection<Customer> findAll() {
//        RowMapper<Customer> rowMapper =
//                (rs, rowNum) -> new Customer(rs.getLong("id"),
//                        rs.getString("email"));
//        return this.jdbcTemplate.query("select * from CUSTOMERS", rowMapper);
//    }
//}
