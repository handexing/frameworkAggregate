# 框架学习


> 觉得不错的朋友可以点下star,watch,fork也算是对我的鼓励了。

## 一、quartz框架的使用
- 简单的定时任务配置
- 动态定时任务配置
- 定时任务的添加，修改cron，开启、停止等功能。

## 二、使用Jsoup爬取数据

- 语法学习 [jsoup中文教程](http://www.open-open.com/jsoup/)
- 实战爬取数据(简单的静态网页解析)
- 爬去京东数据实战 [爬去京东数据](https://github.com/handexing/JdBee)

## 三、spring框架学习

## 四、Apache mina

## 五、restFul 案例
- JAX-RS (JSR-311) 是为 Java EE 环境下的 RESTful 服务能力提供的一种规范。它能提供对传统的基于 SOAP 的 Web 服务的一种可行替代。

### 注解说明
- @Path：注释提供了一个 value属性，用来表明此资源所在的路径。（可用于类头或方法头上）
- @GET、@POST、@PUT、@DELETE 以及 @HEAD 均是 HTTP 请求方法指示符注释。

> HTTP GET：获取/列出/检索单个资源或资源集合。
> HTTP POST：新建资源。
> HTTP PUT：更新现有资源或资源集合。
> HTTP DELETE：删除资源或资源集合。

- @Produces：注释代表的是一个资源可以返回的 MIME 类型。
- @Consumes：注释代表的是一个资源可以接受的 MIME 类型。
- @PathParam("userId")：该注释将参数注入方法参数的路径，在本例中就是用户 id。其他可用的注释有 @FormParam、@QueryParam 等。
- @Context： 使用该注释注入上下文对象，比如 Request、Response、UriInfo、ServletContext 等。

> 运行访问 `http://127.0.0.1:8888/restful_demo/rs/user/1`

> 会不定时学习框架，持续学习。觉得不错的朋友可以点下star,watch,fork也算是对我的鼓励了。QQ群：爱码仕 - 49422384