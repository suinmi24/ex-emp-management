package com.example.form;

/**
 * 従業員情報更新時に使用するフォーム
 */
public class UpdateEmployeeForm {

    /** 従業員id */
    private String id;

    /** 扶養人数 */
    private String dependentsCount;

    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    public String getDependentsCount() {
        return dependentsCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UpdateEmployeeForm{" +
                "id='" + id + '\'' +
                ", dependentsCount='" + dependentsCount + '\'' +
                '}';
    }
}
