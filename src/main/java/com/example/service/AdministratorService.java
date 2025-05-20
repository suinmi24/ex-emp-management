package com.example.service;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理者情報を操作するサービス.
 */
@Service
@Transactional
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * 管理者情報を挿入する.
     *
     * @param administrator 登録したい管理者情報
     */
    public void insert(Administrator administrator){
        administratorRepository.insert(administrator);
    }

    /**
     * ログイン処理をする.
     *
     * @param mailAddress ログイン画面で入力したメールアドレス
     * @param password ログイン画面で入力したパスワード
     * @return 管理者情報
     */
    public Administrator login(String mailAddress, String password){
        return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
    }
}
