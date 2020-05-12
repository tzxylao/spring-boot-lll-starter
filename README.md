## 简介
Spring Boot lll starter项目是个基于企业级实战脱胎出来的，适用于管理平台和微服务快速搭建的基础架构模板，致力于大量减少程序员业务代码的编写工作，少走弯路

## 特性和功能
- 提供了从Controller层到mapperXml层代码**一键生成功能**
- 统一请求和响应参数封装
- 统一异常处理
- 常用基础方法抽象封装
- 使用jackson进行序列表配置
- 集成tkMyBatis、通用Mapper插件、PageHelper分页插件，实现单表业务零SQL
- swagger2开发文档集成，启动后访问`localhost:8081/swagger-ui.html`
- feign RPC调用
- [业务统一码](#1)
- [日志接口封装](#2)
- [Sentinal限流熔断](#3)

## 快速开发
###
快速观看操作步骤↓

[**视频操作**](https://v.youku.com/v_show/id_XNDY1MjcxNDI2NA==.html?spm=a2h0c.8166622.PhoneSokuUgc_1.dtitle)

### 第一步
项目目标是适用于**管理平台及微服务**
若开发微服务可删除`background`保留剩下的；
若开发管理平台后台，则可删除`order`、`user`模块，保留`base`及`background`，然后请对background模块进行改名，但请保留基本格式(**否则自动代码生成不生效**)：
- 模块名
  - 模块名-service
    - com.公司名.项目名.模块名service
  - 模块名-service-impl
    - com.公司名.项目名.模块名serviceimpl

### 第二步
自动生成代码工具为`code-generator`模块，其中`ModifiedConstant`类进行基础配置修改，`ExecuteGenerate`该类负责自动生成代码

自动生成代码支持两种格式，有一定差别，修改`ModifiedConstant`的`MODE`字段，分别支持普通后台和微服务，修改`PROJECT`支持不同模块的生成

### 第三步
本项目微服务采用Nacos作为注册中心及配置中心，若只使用`background`后台管理项目，则只需要用到配置中心的功能，此时你也可以选择不使用Nacos，
只需要将`spring.cloud.nacos.config.enabled`设置为false，就会用到项目下的`application-local.yml`的配置文件

若你选择使用`Nacos`作为配置中心，需要知道一个规则，每个项目对应的配置在`Nacos`如何配置如下，详细配置规则点[这里](https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html)

![UTOOLS1587970821545.png](https://user-gold-cdn.xitu.io/2020/4/27/171ba6fcfde5810a?w=1350&h=248&f=png&s=31544)


## 技术选型
1. SpringCloud Alibaba
2. tkMybatis+MyBatis PageHelper分页插件
3. Druid Spring Boot Starter
4. Nacos配置及注册中心
5. hutool工具集
6. lombok
7. feign
8. Spring Cloud Gateway 网关
9. sentinel限流
10. 其它技术，如Redis，ElasticSearch等请随业务需要自行添加

## 代码目录

- spring-boot-lll-starter
  - auth 认证服务器，用来获取token
  - base 基础包，随项目升级自行进行迭代
    - aop 全局aop包 目前有业务码及日志打印的处理
    - business 业务处理器及接口
    - common 一些项目基石的基本类及公共工具
    - config 全项目配置文件
    - exception 自定义异常类及异常全局处理
    - mybatis mybatis的基石抽象类
  - code-generator 代码自动生成工具，自成模块
    - generate 代码生成文件源码
    - util 生成代码用到的工具
    - ModifiedConstant 代码生成配置，代码生成前请配置该文件
    - ExecuteGenerate 代码生成执行类，里面有几个生成例子
  - background 后台项目
    - background-service 后台项目实体类及接口
      - pojo 多层次的实体类分类，包括请求、删除、返回结果等等
      - service 服务接口层
    - background-service-impl 后台项目实现主体
      - business 统一业务类
        - clazz 添加业务实现类
        - BusinessEnum 每添加一个业务实现类，在枚举中塞一个编码
      - config 本项目配置文件
      - controller 控制层
      - mapper Dao层
      - service 服务实现层
  - order 订单项目，作为微服务演示调用方，结构与`background`一致
  - user 订单项目，作为微服务演示被调用方，结构与`background`一致

## 说明
1. 你会看到我的自动生成代码显得比较复杂，有那么多查询返回的自定义类，业务初期你可能一个简单的单表查询就能解决所有字段的查询，
但需求是一直在变的，很快你就要面对重新定义返回类，入参类等等，所以我决定在代码生成初期就尽可能的细分代码
2. 生成基本接口有：增、删、改、查单个及查列表，其中查单个和查列表根据企业实战很有可能随业务变动会变成不止查询一张表，所以我留了mapper层由用户自己实现
3. 之所以用jackson进行序列化配置，也是因为用fastjson的时候常遇到坑，如果你习惯使用fastjson这两者也不冲突，你可以在业务代码里使用fastjson
4. 推荐多用Precondition类来抛出异常，由全局异常处理判断如何处理
5. base包我不打算打成额外Jar包，我希望随业务增长，使用者可以把base包作为基础包不断自行迭代
6. **业务统一码**：<span id="1">根据企业实战，我们业务后期常会遇到一种情况，好多接口的调用都可能会需要操作相同的业务，比如用户的很多行为，都可能改变用户状态，
我的业务码设计就是为了解决这种情况`Result.ok().addBusinessClass(Result.wrap(BusinessEnum.A001.getClazz())) `通过这样添加业务码统一去解决同一件事，你可以处理的参数为入参和出参
</span>

## 更多详细文档
- [Token认证模块](https://github.com/tzxylao/spring-boot-lll-starter/wiki/1.-Token%E8%AE%A4%E8%AF%81%E6%A8%A1%E5%9D%97)
- <span id="2">[日志接口使用说明](https://github.com/tzxylao/spring-boot-lll-starter/wiki/2.-%E6%97%A5%E5%BF%97%E6%8E%A5%E5%8F%A3%E4%BD%BF%E7%94%A8%E8%AF%B4%E6%98%8E)</span>
- <span id="3">[sentinel限流](https://github.com/tzxylao/spring-boot-lll-starter/wiki/4.-Sentinal%E9%99%90%E6%B5%81%E8%AF%B4%E6%98%8E)</span>