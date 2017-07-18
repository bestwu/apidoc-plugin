###道闸：： 1.租赁续租管理模块
#####测试的时候前缀：http://139.224.29.103:8091


####1.1->添加客户端道闸规则记录--(目前只处理租赁)

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| client_ruleid| 客户端规则唯一标识（主键）| 否| 无 |字符串|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| area_code| 停车场地址区域编码 | 否| 无 |字符串|
| group_id| 客户端所属分组ID| 否| 无 |字符串|
| type| 类型（0：未指定 1：临停  2：租赁） | 否| 无 |整型|
| money| 默认通用型单价(单位分)| 否| 无 |整型|
| state| 是否开启（0：关闭 1：开启）| 否| 无 |整型|
| str_json| 其它属性JSON| 否| 无 |字符串|
| intro| APP端显示的 描述 | 否| 无 |字符串|
| permit_time|租赁允许时间段（08：00-19：00）| 否| 无 |字符串|
| client_loginname|客户端修改人登录帐号| 否| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id+area_code)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

<font color=#0000ff size=6>注意事项</font>
####请求路径

[http://139.224.29.103/v1/add_client_gate_rule.php](http://139.224.29.103/v1/add_client_gate_rule.php)

######返回结果

    {
        "data": {
            "area_code": "510107",
            "cgr_id": 0,
            "client_loginname": "user01",
            "client_ruleid": "67ab4ebf98cc4d56a3ea21e5af80d28b",
            "ctime": 1499926897242,
            "group_id": "A001",
            "intro": "测试。。。",
            "money": 2000,
            "note": "",
            "permit_time": "08：00-19：00",
            "pi_id": 1001,
            "state": 1,
            "str_json": "park_rule:{key:value}",
            "type": 2,
            "utime": 1499926897242
        },
        "errorcode": "",
        "errormsg": "客户端道闸规则记录添加成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|cgr_id|主键ID|long|
|client_ruleid|客户端规则唯一标识（主键）|String|
|pi_id|停车场主键ID|long|
|area_code|停车场区域编码|String|
|group_id|客户端所属分组ID|String|
|type|类型（0：未指定1：临停2：租赁）|int|
|money|默认通用型单价(单位分)|int|
|state|是否开启（0：关闭1：开启）|int|
|str_json|其它属性JSON|String|
|intro|APP端显示的描述|String|
|permit_time|租赁允许时间段（08：00-19：00）|String|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|client_loginname|客户端修改人登录帐号|String|
|note|备注|String|
|is_del|逻辑删除（0：正常1：删除）|int|



####1.2->修改客户端道闸规则记录--(目前只处理租赁)

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| client_ruleid| 客户端规则唯一标识（主键）| 否| 无 |字符串|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| area_code| 停车场地址区域编码 | 否| 无 |字符串|
| group_id| 客户端所属分组ID| 是| 无 |字符串|
| type| 类型（0：未指定 1：临停  2：租赁） | 是| 无 |整型|
| money| 默认通用型单价(单位分)| 是| 无 |整型|
| state| 是否开启（0：关闭 1：开启）| 是| 无 |整型|
| str_json| 其它属性JSON| 是| 无 |字符串|
| intro| APP端显示的 描述 | 是| 无 |字符串|
| permit_time|租赁允许时间段（08：00-19：00）| 是| 无 |字符串|
| client_loginname|客户端修改人登录帐号| 是| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id+area_code+client_ruleid)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

<font color=#0000ff size=6>注意事项</font>
####请求路径

[http://139.224.29.103/v1/add_client_gate_rule.php](http://139.224.29.103/v1/add_client_gate_rule.php)

######返回结果

    {
        "data": {
            "area_code": "510107",
            "cgr_id": 1,
            "client_loginname": "user02",
            "client_ruleid": "67ab4ebf98cc4d56a3ea21e5af80d28b",
            "ctime": 1499926897000,
            "group_id": "S001",
            "intro": "测试1。。。",
            "is_del": 0,
            "money": 3000,
            "note": "",
            "permit_time": "08：00-20：00",
            "pi_id": 1001,
            "state": 1,
            "str_json": "park_rule:{key1:value1}",
            "type": 2,
            "utime": 1499931345075
        },
        "errorcode": "",
        "errormsg": "客户端道闸规则记录修改成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|cgr_id|主键ID|long|
|client_ruleid|客户端规则唯一标识（主键）|String|
|pi_id|停车场主键ID|long|
|area_code|停车场区域编码|String|
|group_id|客户端所属分组ID|String|
|type|类型（0：未指定1：临停2：租赁）|int|
|money|默认通用型单价(单位分)|int|
|state|是否开启（0：关闭1：开启）|int|
|str_json|其它属性JSON|String|
|intro|APP端显示的描述|String|
|permit_time|租赁允许时间段（08：00-19：00）|String|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|client_loginname|客户端修改人登录帐号|String|
|note|备注|String|
|is_del|逻辑删除（0：正常1：删除）|int|

####1.3->删除客户端道闸规则记录--(目前只处理租赁)

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| client_ruleid| 客户端规则唯一标识（主键）| 否| 无 |字符串|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| area_code| 停车场地址区域编码 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id+area_code+client_ruleid)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

<font color=#0000ff size=6>注意事项</font>
####请求路径

[http://139.224.29.103/v1/delete_client_gate_rule.php](http://139.224.29.103/v1/delete_client_gate_rule.php)

######返回结果

    {
        "data": "",
        "errorcode": "",
        "errormsg": "客户端道闸规则记录删除成功",
        "errorno": "0"
    }

####1.4->查询客户端道闸规则记录--(目前只处理租赁)

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| client_ruleid| 客户端规则唯一标识（主键）| 否| 无 |字符串|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| area_code| 停车场地址区域编码 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id+area_code+client_ruleid)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

<font color=#0000ff size=6>注意事项</font>
####请求路径

[http://139.224.29.103/v1/add_client_gate_rule.php](http://139.224.29.103/v1/add_client_gate_rule.php)

######返回结果

    {
        "data": {
            "area_code": "510107",
            "cgr_id": 1,
            "client_loginname": "user02",
            "client_ruleid": "67ab4ebf98cc4d56a3ea21e5af80d28b",
            "ctime": 1499926897000,
            "group_id": "S001",
            "intro": "运行正常1。。。",
            "is_del": 0,
            "money": 3000,
            "note": "",
            "permit_time": "08：00-20：00",
            "pi_id": 1001,
            "state": 1,
            "str_json": "park_rule:{key1:value1}",
            "type": 2,
            "utime": 1499932872000
        },
        "errorcode": "",
        "errormsg": "客户端道闸规则记录查询成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|cgr_id|主键ID|long|
|client_ruleid|客户端规则唯一标识（主键）|String|
|pi_id|停车场主键ID|long|
|area_code|停车场区域编码|String|
|group_id|客户端所属分组ID|String|
|type|类型（0：未指定1：临停2：租赁）|int|
|money|默认通用型单价(单位分)|int|
|state|是否开启（0：关闭1：开启）|int|
|str_json|其它属性JSON|String|
|intro|APP端显示的描述|String|
|permit_time|租赁允许时间段（08：00-19：00）|String|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|client_loginname|客户端修改人登录帐号|String|
|note|备注|String|
|is_del|逻辑删除（0：正常1：删除）|int|