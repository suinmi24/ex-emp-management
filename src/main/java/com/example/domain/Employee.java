package com.example.domain;

import java.util.Date;

/**
 * 従業員情報を表すドメイン.
 */

public class Employee {

    /** ID */
    private Integer id;

    /** 名前 */
    private String name;

    /** 画像 */
    private String image;

    /** 性別 */
    private String gender;

    /** 入社日 */
    private java.util.Date hireDate;

    /** メールアドレス */
    private String mailAddress;

    /** 郵便番号 */
    private String zipCode;

    /** 住所 */
    private String address;

    /** 電話番号 */
    private String telephone;

    /** 給料 */
    private Integer Salary;

    /** 特性 */
    private String Characteristics;

    /** 扶養人数 */
    private Integer dependentsCount;

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

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setCharacteristics(String characteristics) {
        Characteristics = characteristics;
    }

    public String getCharacteristics() {
        return Characteristics;
    }

    public void setDependentsCount(Integer dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    public Integer getDependentsCount() {
        return dependentsCount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", hireDate=" + hireDate +
                ", mailAddress='" + mailAddress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", Salary=" + Salary +
                ", Characteristics='" + Characteristics + '\'' +
                ", dependentsCount=" + dependentsCount +
                '}';
    }
}
