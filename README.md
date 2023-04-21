# SoulBBS
## 介绍
仅用于学习的毕业设计项目，使用以 Java 语言为基础的 SSM 框架。数据库的选择为 MySQL，用 Druid 作连接池，用 MyBatis 进行数据操作 ，服务器用的是 Apache Tomcat-9.0.44 ，用 IntelliJ IDEA 2021.3.2（Ultimate Edition）开发工具。
## 功能结构设计
本论坛系统主要分为管理员与个人用户两大模块。所有功能围绕这两大模块进行设计。系统功能结构框架图如下：
![image](https://user-images.githubusercontent.com/51551352/232688896-a97131bf-ddbe-44e1-86c3-8c8ef41b1d44.png)
## 数据库设计
在本魂类游戏文化交流论坛系统中，共设计了 7 个实体。个人用户可以通过用户注册后查看个人信息、关注其他用户。所有个人用户均可以发布帖子和评论留言，并且可以查看公告信息。个人用户只能够修改或者删除自己发布的帖子，同时也只能够删除自己的评论或者自己帖子下的评论。管理员受限于管理权限，一共拥有管理员、帖子、公告、用户四种权限。

数据库E-R图设计如下，本 E-R 图不列出实体的所有属性：
![image](https://user-images.githubusercontent.com/51551352/232689536-9d4cd121-48fd-4f30-bf4a-5741ad953d7b.png)
## 系统结构
系统的结构主要由三部分组成：Java 源代码、数据库文件、系统页面代码。其
中 Java 源代码中分为 controller（表现）、dao（mapper接口）、entity（实体）、mapper（持久）、
service（业务）五个部分。总体上为Controller、Service、Mapper三层结构。

具体系统结构如图所示：

![image](https://user-images.githubusercontent.com/51551352/232691086-e3318c93-41d9-4051-aee9-47b72856275e.png)
## 项目截图：
### 登录、注册、找回密码
![微信图片_20230418143659](https://user-images.githubusercontent.com/51551352/232692306-984df56b-d629-493e-be14-b353fe118487.png)
![微信图片_20230418143722](https://user-images.githubusercontent.com/51551352/232692317-218f3bff-60b2-4040-b8c6-ef5557f871b4.png)
![微信图片_20230418143725](https://user-images.githubusercontent.com/51551352/232692331-a6e41beb-9904-4a90-ae9f-83ac373041b4.png)
### 主页、帖子列表
![微信图片_20230418143730](https://user-images.githubusercontent.com/51551352/232693038-51650855-078c-40a7-91a4-db1d561cdf6e.png)
![微信图片_20230418143750](https://user-images.githubusercontent.com/51551352/232693308-2ca8c5bd-ba06-44f8-8a3d-a09ffc13f0cb.jpg)
![微信图片_20230418143803](https://user-images.githubusercontent.com/51551352/232693322-919d17b8-ac9b-420b-9c64-217d6e9ce421.jpg)
### 个人信息修改
![微信图片_20230418143735](https://user-images.githubusercontent.com/51551352/232693150-e66133a6-9300-496e-8fad-8358b71c117c.jpg)
![微信图片_20230418143743](https://user-images.githubusercontent.com/51551352/232693156-a3003abd-b7ed-4d22-b61c-8ef491842ad2.jpg)
### 文章详情、评论区
![微信图片_20230418143812](https://user-images.githubusercontent.com/51551352/232701349-4a9373fa-800e-4244-89c3-6346c59b42d2.jpg)
![微信图片_20230418143820](https://user-images.githubusercontent.com/51551352/232693384-e27422c6-0e9a-46c5-a7c3-32d6197fd78a.jpg)
### 管理员后台
![微信截图_20230418151705](https://user-images.githubusercontent.com/51551352/232701065-3c2a8791-2850-46ee-97d0-2f8c924c0831.png)
![微信图片_20230418143827](https://user-images.githubusercontent.com/51551352/232701498-93bd9f09-83dc-44a5-9038-529c7ab0c3bf.jpg)
![微信图片_20230418143831](https://user-images.githubusercontent.com/51551352/232701671-2420eb79-c779-4f5e-a364-de0a9957139e.jpg)
