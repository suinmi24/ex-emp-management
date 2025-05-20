package com.example.controller;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 従業員情報を検索する処理を行う.
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員一覧を出力する.
     *
     * @param model リクエストスコープ
     * @return 従業員一覧を表示する画面への移動
     */
    @GetMapping("/showList")
    public String showList(Model model){
        List<Employee> employeeList = employeeService.showList();
        model.addAttribute(employeeList);
        return "employee/list";
    }

    /**
     * 従業員情報を検索する処理.
     *
     * @param id 検索したいid
     * @param model リクエストスコープ
     * @param form フォーム
     * @return 従業員詳細画面
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form){
        Integer intId = Integer.parseInt(id);
        Employee employee = employeeService.showDetail(intId);
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    /**
     * 従業員詳細(ここでは扶養人数のみ)を更新する.
     *
     * @param form フォーム
     * @return 従業員一覧画面
     */
    @PostMapping("/update")
    public String update(UpdateEmployeeForm form){
        Integer intId = Integer.parseInt(form.getId());
        Employee employee = employeeService.showDetail(intId);
        Integer intDep = Integer.parseInt(form.getDependentsCount());
        employee.setDependentsCount(intDep);
        employeeService.update(employee);
        return "redirect:/employee/showList";
    }
}
