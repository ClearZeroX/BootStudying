package com.zlc.designpatterns.proxy.staticProxy;

/**
 * @desc : 代理对象, 静态代理
 **/
public class UserDaoProxy implements IUserDao {

    //接收保存目标对象
    private IUserDao target;
    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("=====开始事务=====");
        target.save(); //执行目标方法
        System.out.println("=====结束事务=====");
    }
}
