package com.example.controller;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理者登録画面を表示する処理を行う.
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private HttpSession session;

    /**
     * ログイン画面に移動する.
     *
     * @param form フォーム
     * @return ログイン画面
     */
    @GetMapping("/")
    public String toLogin(LoginForm form){
        return "administrator/login";
    }

    /**
     * ログインするメソッド
     * @param form フォーム
     * @param model リクエストスコープ
     * @return 従業員一覧ページに移動(エラーの場合は不正メッセージが表示される)
     */
    @PostMapping("/login")
    public String login(LoginForm form, Model model){
        Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
        if(administrator == null){
            model.addAttribute("error", "メールアドレスまたはパスワードが不正です。");
            return "administrator/login";
        } else {
            session.setAttribute("administratorName", administrator.getName());
            return "redirect:/employee/showList";
        }
    }

    /**
     *ログアウトするメソッド
     * @param form フォーム
     * @return ログイン画面に戻る
     */
    @GetMapping("/logout")
    public String logout(LoginForm form){
        session.invalidate();
        return "redirect:/";
    }

    /**
     * 管理者情報登録画面に移動する.
     *
     * @param form フォーム
     * @return 管理者情報登録画面
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form){
        return "administrator/insert";
    }

    /**
     * 管理者情報を登録する.
     * @param form フォーム
     * @return ログイン画面
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form){
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);
        administratorService.insert(administrator);
        return "redirect:/";
    }

}