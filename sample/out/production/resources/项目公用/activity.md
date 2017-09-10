###1.活动管理模块

####1.1->获取优先的活动
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|
####请求路径
[http://app.qc-wbo.com/v1/weight_activity.php](http://app.qc-wbo.com/v1/weight_activity.php)
######返回结果
    {
        "data": {
            "admin_id": 1,
            "admin_loginname": "admin",
            "ai_id": 1,
            "area_code": "",
            "ctime": 1486436032000,
            "endtime": 1527821613000,
            "img": "",
            "img_jump_url": "",
            "intro": "用户首次安装APP且注册成功赠送5元代金券一张",
            "money": 500,
            "note": "",
            "partner": "琦彩科技",
            "pc_id": 0,
            "people_num": 0,
            "pi_id": 0,
            "pi_name": "",
            "starttime": 1486349606000,
            "state": 0,
            "title": "安装一个APP送5元代金券",
            "type": 0,
            "utime": 1486436036000,
            "weight": 0
        },
        "errorcode": "",
        "errormsg": "获取成功",
        "errorno": "0"
    }
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|ai_id|主键ID|long|
|title|活动标题|String|
|intro|活动简介|String|
|money|活动金额(单位分)|long|
|type|活动类型（例如1：返券2：减免）|int|
|starttime|活动开始时间|java.util.Date|
|endtime|活动结束时间|java.util.Date|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|admin_loginname|创建者账号|String|
|admin_id|创建者主键IDadmin_id|long|
|partner|活动合作伙伴|String|
|people_num|活动参与人数|int|
|note|备注|String|
|state|是否关闭0:正常1：关闭|int|
|pi_id|停车场主键ID|long|
|area_code|停车场区域地址编码|String|
|pc_id|优惠券基本信息表主键ID（外键优惠券基本信息表主键ID）|long|
|weight|权重比(排序)|int|
|pi_name|停车场名称|String|
|img|活动图片地址|String|
|img_jump_url|活动图片跳转地址|String|






