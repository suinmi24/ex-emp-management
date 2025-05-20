package com.example.domain;

/**
 * 管理者情報を表すドメイン.
 */

public class Administrator {

    /** ID */
    private Integer id;

    /** 名前 */
    private String name;

    /** メールアドレス */
    private String mailAddress;

    /** パスワード */
    private String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
