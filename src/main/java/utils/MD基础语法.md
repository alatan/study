## 基本语法
#### 标题
##### 这是 H5 #####

#### 段落
这是一个段落。

这是另一个段落。

#### 斜体
*这是斜体*

#### 粗体
**这是粗体**

***这是粗体+斜体***

#### 删除线
~~就像这样~~

#### 引用
> This is a blockquote with two paragraphs. Lorem ipsum dolor sit amet,
consectetuer adipiscing elit. Aliquam hendrerit mi posuere lectus.
Vestibulum enim wisi, viverra nec, fringilla in, laoreet vitae, risus.

#### 嵌套引用
> This is the first level of quoting.
>
> > This is nested blockquote.
>
> Back to the first level.
#### 列表
* Red
* Green
* Blue
#### 有序列表
1. Bird
2. McHale
3. Parish

#### 代码区域（四个空格）
    这是一个代码区块。
    private ArrBalMngr _getArrBalMngr() {
        if (arrBalMngr == null) {
            arrBalMngr = (ArrBalMngr) CbbApplicationContext.getBean(ArrBalMngr.class, arrBalMngr);
        }
        return arrBalMngr;
    }
#### 分隔线

---------------------------------------

#### 链接
[an example](http://baidu.com/)

[an optional title example](http://google.com/ "Optional Title")

#### 图像
![Alt img](/path/to/img.jpg)

![Alt optional title img](/path/to/img.jpg "Optional Title")

#### 表格
| Item     | Value | Qty   |
| :------- | ----: | :---: |
| Computer | $1600 |  5    |
| Phone    | $12   |  12   |
| Pipe     | $1    |  234  |

## 高级语法 暂时不用