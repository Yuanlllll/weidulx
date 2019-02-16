package com.example.weidu.login.presenter;


import com.example.weidu.bean.ShowBean;
import com.example.weidu.login.model.ILoginModel;
import com.example.weidu.login.model.LoginModel;
import com.example.weidu.login.view.LoginView;

public class LoginPresenter  {
    LoginModel loginModel=new LoginModel();
    LoginView loginView;
    public LoginPresenter(LoginView loginView){
        this.loginView=loginView;
    }
    public void getData(){
        loginModel.GetData(new ILoginModel.LoginCallBack() {
                @Override
                public void succ(ShowBean oj) {
                loginView.succ(oj);
            }
        });
    }
    //解除绑定
    public void detach() {
        this.loginView = null;
    }




}
