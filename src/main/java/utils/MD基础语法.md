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
> markdown是好的写作方式。

#### 嵌套引用
> markdown是好的写作方式。
>
> > 前提是要写。
>
> 行动就成功了一半。
#### 列表
* Red
* Green
* Blue
#### 有序列表
1. Bird
2. McHale
3. Parish


#### 分隔线

---------------------------------------

#### 链接
[an example](http://baidu.com/)

[an optional title example](http://google.com/ "Optional Title")

#### 表格
| Item     | Value | Qty   |
| :------- | ----: | :---: |
| Computer | $1600 |  5    |
| Phone    | $12   |  12   |
| Pipe     | $1    |  234  |

#### 代码区域（四个空格）
    这是一个代码区块。
    private ArrBalMngr _getArrBalMngr() {
        if (arrBalMngr == null) {
            arrBalMngr = (ArrBalMngr) CbbApplicationContext.getBean(ArrBalMngr.class, arrBalMngr);
        }
        return arrBalMngr;
    }

#### 图像
![Alt optional title img](./icon.png "征途是星辰大海")

## 高级语法 暂时不用