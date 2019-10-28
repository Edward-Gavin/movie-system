# Spring-boot
用Spring-boot实现个人信息网站（简单的登录注册查询个人信息，修改个人信息功能）
用到了Springboot+mybits和thylemeaf模板引擎，代码简洁明了。
希望对大家有所帮助，并且期望大家在原有代码基础上增加功能。


shift+ctrl+a    find action
shift+ctrl+alt+向上箭头  查找改变的地方
ctrl+alt+z  撤销(还原)，对任何地方都可以，包括项目
ctrl + alt +v（提取变量）（c提取静态变量）（f提取成员变量） （p提取方法参数)（m抽取函数）
ctrl+F8 断点 按F8一行一行运行
shift+F9调试

resume(重新开始继续)：从一个断点跳到另外一个断点，没有断点就结束运行。对应快捷键(F9)
查看所有断点 shift+ctrl+F8
禁止有所有断点（在debug中的mute这个按钮）
条件断点（shift+ctrl+F8加入条件）
表达式求值（alt+F8）
跳转到指定的行（alt+F9）
setValue 调试过程中动态改变值

ctrl+shift+f9运行类似main函数的可运行的地方

复制当前文件F5
移动当前文件F6
批量的复制ctrl+shift+V

ctrl+F12查看代码机构
查看maven依赖，类图（ctrl+shift+alt+U）
ctrl+H查看类结构（层次）
alt+ctrl+H查看方法类结构


@RequestParam与@PathVariable的区别
她们都是将请求（request）里的参数的值绑定到controller里的方法参数里
第一个使用时：URL:http://localhost:8080/path?参数名=参数值
第二个使用时：URL:http://localhost:8080/path/参数值

@RequestBody是用来接受前台返回的数据的（json/xml串（数据）），用来读取http请求的body部分数据----就是我们请求的数据（请求报文（一系列内容）到对象）
（一般放在controlle层的具体请求方法的入参中）
@ResponseBody是后台获得对象后，将这个对象内容用一定的格式输出到前台（对象到响应报文）
（放在controller层的方法上,将controller的方法返回对象，通过适当的转换为指定格式后，写入）

@Param mybatis中的注解，是为了给参数命名。

@RequsetMapping（请求到处理器（controller）功能方法的映射规则）
@RequsetMapping是一个用来处理请求地址映射的注解，可用在类或者方法上，用在类上，表示类中
所有的响应消息都是以该地址父路径


String  -> char
在Java中将String转换为char是非常简单的。
1. 使用String.charAt(index)（返回值为char）可以得到String中某一指定位置的char。
2. 使用String.toCharArray()（返回值为char[]）可以得到将包含整个String的char数组。这样我们就能够使用从0开始的位置索引来访问string中的任意位置的元素。

int -> String 
int i=12345;
String s="";
第一种方法：s=i+"";
第二种方法：s=String.valueOf(i);

String -> int 
s="12345";
int i;
第一种方法：i=Integer.parseInt(s);
第二种方法：i=Integer.valueOf(s).intValue();


关于图片存储的问题：
https://www.cnblogs.com/wangtao_20/p/3440570.html


图片上传功能实现；
https://blog.csdn.net/qq_38762237/article/details/81282444
https://blog.csdn.net/j903829182/article/details/78406778


表单提交的过程中遇到input标签添加disabled属性值后，表单提交不能提交响应的属性：

readonly & disabled区别
readonly和disabled是用在表单中的两个属性，它们都能够做到使用户不能够更改表单域中的内容。
disabled：对于所有的表单元素都有效，包括select, radio, checkbox, button等。如果一个输入项的disabled设为true，则该表单输入项不能获取焦点，用户的所有操作（鼠标点击和键盘输入等）对该输入项都无效，最重要的一点是当提交表单时，这个表单输入项将不会被提交。
readonly：只针对input(text / password)和textarea有效；如果设为true，用户只是不能编辑对应的文本，但是仍然可以聚焦焦点，并且在提交表单的时候，该输入项会作为form的一项提交。
