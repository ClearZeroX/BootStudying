# 用途
将一个接口转换成另一个接口, 以符合客户的期望  
适配器模式可以让原本不兼容的类进行合作
# 对象适配器和类适配器
类适配器实现需要多重继承, java不支持  
类适配器不是使用组合来适配被适配者, 而是继承被适配者和目标类  
对象适配器: 因为使用组合, 不仅可以适配一个类, 也可以适配该类的任何子类
# 对象适配器实现
适配器实现了目标接口, 并持有被适配者的实例(也可以实现被适配者??)  
双向适配器: 实现两个接口, 可以当做新的来用, 也可以当做旧的来用
客户和被适配者是解耦的, 一个并不知道另一个
1. 客户通过目标接口调用适配器的方法对适配器进行请求  
2. 适配器使用被适配者接口把请求转换成被适配者的一个或者多个调用接口  
3. 客户收到调用的结果, 但并未察觉这一切都是适配器在起作用
# 关联模式
外观模式: 适配器实现多个接口时, 称为外观模式(Facade Pattern)  
装饰者模式: //TODO

# 优点
不需要修改客户端的代码就可以调用新的接口, 将所有改变都封装在一个类中  

# 应用
https://blog.csdn.net/wwwdc1012/article/details/82780560

# 参考
Head First

