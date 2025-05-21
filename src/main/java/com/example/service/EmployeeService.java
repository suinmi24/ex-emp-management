package com.example.service;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 従業員情報一覧を全件検索する業務処理を行う.
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 従業員情報を全件取得する.
     *
     * @return 取得した従業員情報
     */
    public List<Employee> showList(){
        return employeeRepository.findAll();
    }

    /**
     * 指定したidの従業員情報を取得する.
     *
     * @param id 検索したいid
     * @return 取得した従業員情報
     */
    public Employee showDetail(Integer id){
        return employeeRepository.findById(id);
    }

    /**
     * 従業員情報を更新する.
     *
     * @param employee 更新する従業員情報
     */
    public void update(Employee employee){
        employeeRepository.update(employee);
    }
}
