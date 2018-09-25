# cecd-np 国家平台

- springboot版本：1.5.14.RELEASE
- 由于改用SVN进行版本管理，需要自己维护好本地的ignore文件。请大家提交代码的时候，不要添加ide相关配置文件，如*.iml/eclipse、编译文件如target包下的文件、maven，gradle相关文件，如mvn等。**建议只提交src目录下的源代码文件、pom.xml文件、readme文件**
- 大家可以自行维护本文档。
- 添加了springboot-devtools 热部署工具，如果觉得麻烦的，可以在pom文件中注释掉dev-tools的相关依赖就可以了
- 请大家开发完api后，进行单元测试，测试模板和例子我已经上传提交了，大家只要按照DemoControllerTest的写法，模仿着写就行了
- 添加了spring security 导致访问页面需要登录，默认用户：fliu 密码：123456 如果大家不想登录，需要在comfig/SecurityConfig.java 文件中把authenticated() 改成permitall() 这样就不需要权限检查了，大家可以正常访问url




**项目引入Lombok，需要在各自的ide上安装好插件，具体使用方法请自行百度学习**

安装教程：https://www.cnblogs.com/aligege/p/7797642.html

使用教程：https://blog.csdn.net/sunsfan/article/details/53542374