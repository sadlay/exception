package cn.layanan.exception.demo.controller;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:57 2019/8/7
 * @Modified By:IntelliJ IDEA
 */

@Validated
public class Test {
    private String userName;

    @NotEmpty
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
