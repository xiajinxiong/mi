# mi
小米商城
地址http://139.155.135.210
采用Servlets/Jsp
## 运行方法：
```
git clone https://github.com/xiajinxiong/mi.git
```
### 新建Maven项目
将src文件夹和pom.xml文件夹替换为git clone得到的结果，引入依赖。
### 手动安装alipay sdk
下载https://repo1.maven.org/maven2/com/alipay/sdk/alipay-sdk-java/3.7.110.ALL/alipay-sdk-java-3.7.110.ALL.jar
然后运行
```
mvn install:install-file -Dfile=jar包地址 -DgroupId=com.alipay.sdk -DartifactId=alipay-sdk-java -Dversion=3.7.110.ALL
 -Dpackaging=jar
```
### 准备支付宝电脑网站支付的沙箱环境
详情请参考https://docs.open.alipay.com/270/105899/
### 更改支付宝密钥
在mi/src/main/java/com/sure/mi/config/AlipayConfig.java，修改merchant_private_key和alipay_public_key。
密钥得到的方法是登录蚂蚁金服开发平台，进入https://openhome.alipay.com/platform/appDaily.htm?tab=info，查看支付宝公钥，设置应用公钥。
在AlipayConfig.java里将公钥改为***支付宝公钥***，将私钥改为***应用公钥***对应的密钥。详情请参考支付宝文档。
### 创建mysql数据库
并执行sqlsql.sql

