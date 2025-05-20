package com.example.form;

/**
 * ログイン画面に使用するフォーム
 */
public class LoginForm {

    /** メールアドレス */
    private String mailAddress;

    /** パスワード */
    private String password;

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
        return "LoginForm{" +
                "mailAddress='" + mailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
