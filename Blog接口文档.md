

V3	 2020-07-18    修改了部分接口的字段，新增点赞功能

V2 	2021-07-14	在部分接口新增了修改时间字段

V1	2021-07-13	 初始化用户界面接口文档

# Blog接口文档

[toc]

## 首页√

URL/GET

```
/getIndex
```

发送数据

```
无
```

返回数据

```json
{
    "code": 200,
    "message": "请求成功",
    "info": {
        "title": "xiao lou 的博客",
        "motto": "1111"
    }
}
```

## 文章列表

URL/GET

```

```

发送数据(分页查询)

```
?page=0&number=10
```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":[{
    	"articleTitle":"",
    	"brief":"",
    	"homePage":"https://www.uiofield.top/file/22222/index.png",
    	"gmtCreate":"2020-04-22 20:00:00",	// V3修改字段名
    	"gmtModified":"2020-04-22 20:00:00", // V2新增，V3修改字段名
    	"label":["Java","SpringBoot"],
    	"articleId":"22222",
    	"totalPageView":99999
  ]
}
```

注意点：

> page不传默认为0
>
> number后端会有限制，若过大则返回一个限制的最大数量
>
> 用户进入首页后，应该在展示首页后，默认在后台异步请求文章列表接口
>
> homePage可能为null，若为null则加载默认图片（由前端缓存）

## 获得指定文章详细内容√

URL/GET

```

```

发送数据

```
表单数据
?articleId=22222
```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":{
    "author":"",
    "gmtTime":"2020-04-22 20:00:00",
		"gmtModified":"2020-04-22 20:00:00", // V2新增，V3修改字段名
    "browseTimes":5000,	// V3修改字段名 
    "title":"深入理解Java",
    "content":"",
    "starCount":111, 	// V3新增字段，表示点赞数量
    "starBySelf":true,	// V3新增，表示该用户是否已经点赞过了，未登录则默认为false
    "comment":[{
      	"observer":"xiaoming",
    		"gmtCreate":"2020-04-22 20:00:00",	// V3修改字段名
      	"content":"666",
      	"headPortraits":"https://www.uiofield.top/file/2222/head.png"
    	}
    ]
  }
}
```

> 注意点：头像数据应异步请求

## 归档

URL/GET

```

```

发送数据

```
无
```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info": {
    "totalArticle":20,
    "statistics":[{
      	"time":"2021",
      	"article":{
          "title":"JVM详解",
          "gmtCreate":"2020-04-22 20:00:00",	// V3修改字段名
		    	"gmtModified":"2020-04-22 20:00:00", // V2新增，V3修改字段名
        }
    	}
    ]
  }
}
```

## 友链

URL/GET

```

```

发送数据

```
无
```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info": 
}
```

## 搜索

URL/GET

```

```

发送数据

```

```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```



## 验证码邮件√

URL/GET

```
/permisssion/sendCode
```

发送数据

```
?email=406453373@qq.com&type=1
```

携带在URL中

> type=1表示登陆时获取验证码
>
> type=2表示注册时获取验证码

返回数据

```json
{
    "code": 200,
    "message": "请求成功",
    "info": "有效时间：5分钟"
}
```

## 访客账号注册√

使用该账号将允许留言

URL/POST

```
/permission/register
```

发送数据

```json
{
    "email":"406453373@qq.com",
    "password":"123456",
    "verifyCode":"374133",	// 验证码
    "inviteCode":"2222",	// 邀请码
    "username":"test-小娄"
}
```

注意点

>验证码为邮箱验证码
>
>username为用户名，不为账号，账号为用户注册时邮箱
>
>inviteCode为邀请码

返回数据

```json
{
    "code": 200,
    "message": "请求成功",
    "info": null
}
```

## 密码登陆√

> 该接口仅为用户使用

URL/POST

```
/permission/login
```

发送数据

```json
{
		"email":"406453373@qq.com",
		"password":"123456"
}
```

返回数据

```json
{
    "code": 200,
    "message": "请求成功",
    "info": {
        "token": "eyJhbGciOiJIUzI1NiIsIkpXVCI6IkpXVCIsInR5cCI6IkpXVCJ9.eyJpZCI6MTQyMjkwMjY2OTkxMTExNzgyNSwiaWF0IjoxNjI4NDEyNTA5LCJqdGkiOiIwNTNlNGM2MDg3YjQ0MWI0YjMxYWEwOTg0ZjU1N2YxZiJ9.qGT0y_bUASLyfpDQ8nUI8OL80d7UrmTmIYTw1CJ2Z8s",
        "isAdmin": false
    }
}
```

> info内信息为token，携带在http header上

## 邮箱登陆√

该接口为用户和管理员复用

URL/POST

```
/permission/loginByEmail
```

发送数据

```json
{
	"email":"406453373@qq.com",
  "code":"910478"
}
```

返回数据

```json
{
    "code": 200,
    "message": "请求成功",
    "info": {
        "token": "eyJhbGciOiJIUzI1NiIsIkpXVCI6IkpXVCIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2Mjg0MTI1OTgsImp0aSI6ImIwODg0NjU0MzUzOTQwNzE5YjRlZmVhMDJmOGNiYTg2In0.DJHtDc3jIS5kob6pyD_-M4c1nVsbUBaETpFoZdwnVhE",
        "isAdmin": true
    }
}
```

## 

## 访客点赞√

URL/GET

```
/myBlog/starSwitch
```

发送数据

```
{
    "articleId":1
}
```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```

## About Me

类似自我介绍

URL/GET

```

```

发送数据

```

```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```

# 后台管理

## 上传博客√

URL/POST

```
/admin/addArticle
```

发送数据

```json
{
	"title":"test-blog2",
  "label":"Java",
  "content":"test-content",
  "intro":"intro-test",
  "indexImage":"https://www.uiofield.top/blog-file/222222/index.png"
}
```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info": null
}
```

## 生成邀请码√

URL/POST

```
/admin/getInviteCode
```

发送数据

```json
null
```

返回数据

```json
{
    "code": 200,
    "message": "请求成功",
    "info": "ddb12dc5-cfa3-40c4-aefd-075f55a3ed6b"
}
```

## 设置Motto√

URL/POST

```
/admin/setMotto
```

发送数据

```json
{
    "content":"Think big, Go deep"
}
```

返回数据

```json
{
    "code": 200,
    "message": "请求成功",
    "info": null
}
```

## 发布博客轨迹图

类似github的contributions times

URL/GET

```
1
```

发送数据

```
1
```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```





URL/GET

```

```

发送数据

```

```

返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```

URL/GET

```

```

发送数据

```

```

返回数据

```json
{  "code":"200",  "message":"请求成功",  "info":}
```





