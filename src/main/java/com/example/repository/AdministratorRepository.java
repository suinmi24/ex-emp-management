package com.example.repository;


import com.example.domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


/**
 * administratorsテーブルを操作するリポジトリ.
 */

@Repository
public class AdministratorRepository {

    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mail_address"));
        administrator.setPassword(rs.getString("password"));
        return administrator;
    };


    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 管理者情報を挿入する.
     *
     * @param administrator 追加する管理者情報
     */
    public void insert(Administrator administrator){
        String sql = "INSERT INTO administrators (name, mail_address, password) VALUES (:name, :mailAddress, :password)";
        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
        template.update(sql, param);
    }


    /**
     * メールアドレスとパスワードから管理者情報を取得する.
     *
     * @param mailAddress 検索するメールアドレス
     * @param password 検索するパスワード
     * @return 管理者情報(1件も該当するものが存在しない場合は、nullを返す)
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
        String sql = "SELECT id, name, mail_address, password FROM administrators WHERE mail_address = :mailAddress AND password = :password";
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
        try {
            return template.queryForObject(sql, param, ADMINISTRATOR_ROW_MAPPER);
        } catch (Exception e) {
            return null;
        }
    }
}
