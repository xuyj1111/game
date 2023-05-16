# okay（画线弹射游戏）
<span style="color: red;">【未完成，还差小球撞击反弹判断】</span>
## 开发环境
- Intellij IDEA
- Java SE
- MySQL

## 项目文件
- constant：常量类
- dto：对象
- entity：实体类，对应数据库表
- enums：枚举类
- jdbc：简单封装了jdbc（新手时期没学持久化框架）
- job：定时任务
- page：游戏的界面
    - admin：管理员界面
    - base：构建界面的自定义基础类
    - defined：自定义关卡界面（绘图板）
    - init：初始界面
    - listener：全局监听类
    - login：登陆界面
    - play：游戏界面（或预览）
    - register：注册界面
    - user：用户界面
- util：工具类
  - BeanFactory：放了一堆静态类
  - DrawBoardUtil：绘图板工具类
  - RayCasUtil：射线法实现工具类（用于判断各种图形重合）

## 游戏玩法
详细说明见 [desc.md](https://github.com/xuyj1111/game/blob/master/okay/src/main/resources/file/desc.md)
