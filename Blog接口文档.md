

V3	 2020-07-18    修改了部分接口的字段，新增点赞功能

V2 	2021-07-14	在部分接口新增了修改时间字段

V1	2021-07-13	 初始化用户界面接口文档

# Blog接口文档

[toc]

## 首页

#### URL/GET

```

```

#### 发送数据

```
无
```

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":{
  	"title":"",
	  "motto":"",
  }
}
```

## 文章列表

#### URL/GET

```

```

#### 发送数据(分页查询)

```
?page=0&number=10
```

#### 返回数据

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

## 获得指定文章详细内容

#### URL/GET

```

```

#### 发送数据

```
表单数据
?articleId=22222
```

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":{
    "author":"",
    "gmtTime":"2020-04-22 20:00:00",
    "browseTimes":5000,	// V3修改字段名 
    "title":"深入理解Java",
    "content":"",
    "starCount":111, 	// V3新增字段，表示点赞数量
    "starBySelf":true,	// V3新增，表示该用户是否已经点赞过了，未登录则默认为false
    "comment":[{
      	"observer":"xiaoming",
    		"gmtCreate":"2020-04-22 20:00:00",	// V3修改字段名
	    	"gmtModified":"2020-04-22 20:00:00", // V2新增，V3修改字段名
      	"content":"666",
      	"headPortraits":"https://www.uiofield.top/file/2222/head.png"
    	}
    ]
  }
}
```

> 注意点：头像数据应异步请求

## 归档

#### URL/GET

```

```

#### 发送数据

```
无
```

#### 返回数据

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

#### URL/GET

```

```

#### 发送数据

```
无
```

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info": 
}
```

## 搜索

#### URL/GET

```

```

#### 发送数据

```

```

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```



## 访客账号申请

使用该账号将允许留言

#### URL/POST

```

```

#### 发送数据

```json
{
	"username":"",
  "email":"",
  "password":"",
  "invitationCode":"",	// 游客注册邀请码
  "verificationCode":""	// 邮箱验证码
}
```

注意点

>验证码为邮箱验证码
>
>username为用户名，不为账号，账号为用户注册时邮箱

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info": 60
}
```

> info内数据为间隔时间（秒）

## 访客登陆

#### URL/POST

```

```

#### 发送数据

```json
{
		"email":"",
		"password":""
}
```

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```

## 访客点赞

#### URL/GET

```

```

#### 发送数据

```

```

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```









# 后台管理

## Admin登陆

#### URL/GET

```

```

#### 发送数据

```json
{
	"email":"",
	"password":"",
  "verificationCode":""
}
```

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```

## 上传博客

#### URL/GET

```

```

#### 发送数据

```

```

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```







#### URL/GET

```

```

#### 发送数据

```

```

#### 返回数据

```json
{
  "code":"200",
  "message":"请求成功",
  "info":
}
```





