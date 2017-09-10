###APP ：： 1.用户管理模块



####1.1->发送验证码

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 手机号码 | 否| 无 |字符串|
| vclass| 发送验证码类型:1:注册 2：修改密码 3：修改绑定手机| 否| 无 |字符串|
| sign| MD5数字签名(dtype+tel+vclass)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/sendcode.php](http://139.224.29.103/v1/sendcode.php)

######返回结果

    {

        "data": {

            "tel": "15882345446",

            "verify_list": "e5908f7072183cd2329e341a633c1229",

            "resend_time": "120"

        },

        "errormsg": "发送成功!",

        "errorno": "0"

    }

#########返回字段说明

|名称|值描述|限制长度|参数类型|
|--------|----|--------|-------|
| resend_time| 验证码再次发送的时间| 无 |字符串|
| verify_list| 验证序列码| 无 |字符串|





####1.2->重发送验证码

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 手机号码 | 否| 无 |字符串|
| vclass| 发送验证码类型:1:注册 2：修改密码 3：修改绑定手机| 否| 无 |字符串|
| verify_list| 上一次验证序列码 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+tel+vclass+verify_list)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/resendcode.php](http://139.224.29.103/v1/resendcode.php)

######返回结果

    {

        "data": {

            "tel": "15882345446",

            "verify_list": "e5908f7072183cd2329e341a633c1229",

            "resend_time": "120"

        },

        "errormsg": "发送成功!",

        "errorno": "0"

    }

#########返回字段说明

|名称|值描述|限制长度|参数类型|
|--------|----|--------|-------|
| resend_time| 验证码再次发送的时间| 无 |字符串|
| verify_list| 验证序列码| 无 |字符串|





####1.3->用户注册

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 手机号码 | 否| 无 |字符串|
| vclass| 发送验证码类型:1:注册 2：修改密码 3：修改绑定手机| 否| 无 |字符串|
| verify_code| 手机验证码 | 否| 无 |字符串|
| verify_list| 验证序列码 | 否| 无 |字符串|
| password| 密码| 否| 6-16字符 |字符串|
| repassword| 确认密码| 否| 6-16字符 |字符串|
| sign| MD5数字签名(dtype+tel+vclass+verify_code+verify_list+password+repassword)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/reg.php](http://139.224.29.103/v1/reg.php)

######返回结果

    {
        "data": {
            "bind_tel": "",
            "coupon_num": 0,
            "ctime": 1470033065000,
            "driving_licence": "110107194011241250",
            "note": "",
            "pay_source": 0,
            "ui_address": "",
            "ui_age": 0,
            "ui_autopay": 0,
            "ui_avatar": "http://smaradio1.changhong.com/img/avatar/2016/head15882345446_46845.png",
            "ui_degree": "",
            "ui_email": "251878350@qq.com",
            "ui_flag": 0,
            "ui_high": 0,
            "ui_id": 1,
            "ui_integrity": 0,
            "ui_intro": "",
            "ui_level": 0,
            "ui_mood": "",
            "ui_name": "敬小虎",
            "ui_nickname": "浩瀚星空",
            "ui_online": 0,
            "ui_password": "e10adc3949ba59abbe56e057f20f883e",
            "ui_rmb": 0,
            "ui_score": 0,
            "ui_sex": "male",
            "ui_state": 0,
            "ui_tel": "15882345446",
            "ui_token": "0b5427ae6874b1a3e2dd9f1e30172c16",
            "ui_vc": 0,
            "utime": 1470033065000,
            "uuid": "383aaf1d448f118ab311470033065343",
            "ui_logo":0
        },
        "errormsg": "注册成功",
        "errorno": "0"
    }

#########返回字段说明

|名称|值描述|限制长度|参数类型|
|--------|----|--------|-------|
| ui_nickname| 用户昵称| 无 |字符串|
| ui_avatar| 用户头像| 无 |字符串|
| ui_mood| 用户心情| 无 |字符串|
| ui_desc| 用户描述| 无 |字符串|





####1.4.1->用户登录

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 手机号码 | 否| 无 |字符串|
| password| 密码6-16字符| 否| 无 |字符串|
| tel_version| 手机型号(例如 HW)| 是| 无 |字符串|
| sign| MD5数字签名(dtype+tel+password)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/login.php](http://139.224.29.103/v1/login.php)

######返回结果

    {
        "data":  {
        "bind_tel": "18608305952",
        "coupon_num": 0,
        "ctime": 1483015981000,
        "driving_licence": "",
        "lock_expect_money": 0,
        "lock_money": 0,
        "lock_rent_money": 0,
        "note": "",
        "pay_source": 4,
        "ui_address": "",
        "ui_age": 0,
        "ui_autopay": 1,
        "ui_avatar": "",
        "ui_degree": "",
        "ui_email": "",
        "ui_flag": 1,
        "ui_high": 0,
        "ui_id": 62,
        "ui_integrity": 0,
        "ui_intro": "",
        "ui_level": 0,
        "ui_mood": "",
        "ui_name": "",
        "ui_nickname": "cs",
        "ui_online": 0,
        "ui_password": "29ad0e3fd3db681fb9f8091c756313f7",
        "ui_rmb": 0,
        "ui_score": 0,
        "ui_sex": "male",
        "ui_state": 0,
        "ui_tel": "18608305952",
        "ui_token": "3d511ee89dc469c396251d60dd247ec0",
        "ui_vc": 892498,
        "utime": 1483015981000,
        "uuid": "2016122920537026",
        "ui_logo":0
    },
        "errormsg": "登录成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id||long|
|uuid|用户uuid|String|
|ui_tel|手机号码/用户账号|String|
|ui_password|用户密码(MD5散列)|String|
|ui_nickname|用户昵称|String|
|ui_avatar|用户头像|String|
|ui_sex|用户性别:male男women女no未知|String|
|driving_licence|驾驶证号码|String|
|ui_name|姓名|String|
|ui_address|住址|String|
|bind_tel|绑定手机号码|String|
|ui_vc|爱泊币（100爱泊=1元）|long|
|ui_rmb|爱泊币（100爱泊=1元）|long|
|coupon_num|优费卷数量|long|
|ui_state|用户状态:0：正常1：禁用|int|
|ui_autopay|是否自动支付：0：不是1：是|int|
|pay_source|支付类型1:支付l宝2：微信3：银联|int|
|ui_level|用户等级|int|
|ui_score|用户积分|long|
|ui_mood|用户心情|String|
|ui_intro|个人简介|String|
|ui_age|用户年龄|int|
|ui_token|用户授权码|String|
|ui_email|用户邮箱|String|
|ui_high|用户身高|int|
|ui_degree||String|
|ctime||java.util.Date|
|utime||java.util.Date|
|ui_flag|注册来源0:android1:ios2:web|int|
|ui_online|l累计在线时长(分钟)|long|
|ui_integrity|用户诚信度按100来计算|int|
|note|备注|String|
|lock_money|锁定金额|int|
|lock_expect_money|锁定预约金额|int|
|lock_rent_money|锁定租赁金额|int|
|eu_id|ETC基本信息表主键ID|long|
|eu_nd|ETC唯一标识符|String|
|etc_autopay|是否开启ETC支付0:没有开启1：开启|int|
|bank_no|选择的默认银行卡卡号|String|
|ui_logo|吾泊加V标志(0:没有1：显示W)|int|



















####1.5->用户重置密码

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 手机号码 | 否| 无 |字符串|
| vclass| 发送验证码类型:1:注册 2：修改密码 3：修改绑定手机| 否| 无 |字符串|
| verify_code| 手机验证码 | 否| 无 |字符串|
| verify_list| 上一次验证序列码 | 否| 无 |字符串|
| password| 密码| 否| 6-16字符 |字符串|
| repassword| 确认密码| 否| 无 |字符串|
| tel_version| 手机型号(例如 HW)| 是| 无 |字符串|
| sign| MD5数字签名(dtype+tel+vclass+verify_code+verify_list+password+repassword)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/change_pass.php](http://139.224.29.103/v1/change_pass.php)

######返回结果

    {
        "data":  {
        "bind_tel": "18608305952",
        "coupon_num": 0,
        "ctime": 1483015981000,
        "driving_licence": "",
        "lock_expect_money": 0,
        "lock_money": 0,
        "lock_rent_money": 0,
        "note": "",
        "pay_source": 4,
        "ui_address": "",
        "ui_age": 0,
        "ui_autopay": 1,
        "ui_avatar": "",
        "ui_degree": "",
        "ui_email": "",
        "ui_flag": 1,
        "ui_high": 0,
        "ui_id": 62,
        "ui_integrity": 0,
        "ui_intro": "",
        "ui_level": 0,
        "ui_mood": "",
        "ui_name": "",
        "ui_nickname": "cs",
        "ui_online": 0,
        "ui_password": "29ad0e3fd3db681fb9f8091c756313f7",
        "ui_rmb": 0,
        "ui_score": 0,
        "ui_sex": "male",
        "ui_state": 0,
        "ui_tel": "18608305952",
        "ui_token": "3d511ee89dc469c396251d60dd247ec0",
        "ui_vc": 892498,
        "utime": 1483015981000,
        "uuid": "2016122920537026",
        "ui_logo":0
    },
        "errormsg": "更改密码成功",
        "errorno": "0"
    }




####1.6->用户重置绑定手机

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 重置手机号码 | 否| 无 |字符串|
| uid| 用户ID | 否| 无 |长整型|
| password| 密码| 否| 无 |字符串|
| sign| MD5数字签名(dtype+tel+uid+password)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/change_tel.php](http://139.224.29.103/v1/change_tel.php)

######返回结果

    {
        "data": {
        "bind_tel": "18608305952",
        "coupon_num": 0,
        "ctime": 1483015981000,
        "driving_licence": "",
        "lock_expect_money": 0,
        "lock_money": 0,
        "lock_rent_money": 0,
        "note": "",
        "pay_source": 4,
        "ui_address": "",
        "ui_age": 0,
        "ui_autopay": 1,
        "ui_avatar": "",
        "ui_degree": "",
        "ui_email": "",
        "ui_flag": 1,
        "ui_high": 0,
        "ui_id": 62,
        "ui_integrity": 0,
        "ui_intro": "",
        "ui_level": 0,
        "ui_mood": "",
        "ui_name": "",
        "ui_nickname": "cs",
        "ui_online": 0,
        "ui_password": "29ad0e3fd3db681fb9f8091c756313f7",
        "ui_rmb": 0,
        "ui_score": 0,
        "ui_sex": "male",
        "ui_state": 0,
        "ui_tel": "18608305952",
        "ui_token": "3d511ee89dc469c396251d60dd247ec0",
        "ui_vc": 892498,
        "utime": 1483015981000,
        "uuid": "2016122920537026",
        "ui_logo":0
    },
        "errormsg": "更改手机号成功",
        "errorno": "0"
    }






####1.7->用户修改基本信息

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| nickname| 用户昵称| 是| 无 |字符串|
| name| 用户姓名| 是| 无 |字符串|
| driving_licence| 用户驾驶证号码| 是| 无 |字符串|
| qq| 用户qq| 是| 无 |字符串|
| mood| 用户心情|是| 无 |字符串|
| sex| 用户性别 : male 男   women 女   no  未知|是| 无 |字符串|
| email| 用户邮箱|是| 无 |字符串|
| avatar| 用户头像|是| 无 |文件|
| ui_autopay| 是否自动支付 ：0 ：不是 1：是|是| 无 |字符串|
| pay_source| 支付类型1:支付宝 2：微信 3：银联 4：钱包|是| 无 |整型|
| etc_autopay| 是否开启ETC自动支付  ：0 ：不开启  1：开启|是| 无 |整型|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/change_userinfo.php](http://139.224.29.103/v1/change_userinfo.php)

#####注意事项

######如果请求参数niname有涉及到中文的，get方式请求的，niname需要进行URL的utf-8编码，如果是post方式请求则不需要。

######返回结果
同上1.5接口




####1.8->获取用户自己的详细信息
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|
####请求路径
[http://139.224.29.103/v1/read_myinfo.php](http://139.224.29.103/v1/read_myinfo.php)
######返回结果
{
    "data": {
        "bank_no": "",
        "bind_tel": "13540971654",
        "coupon_num": 0,
        "ctime": 1487397924000,
        "driving_licence": "",
        "etc_autopay": 0,
        "eu_id": 0,
        "eu_nd": "",
        "lock_expect_money": 0,
        "lock_money": 0,
        "lock_rent_money": 0,
        "note": "",
        "pay_source": 0,
        "ui_address": "",
        "ui_age": 0,
        "ui_autopay": 0,
        "ui_avatar": "",
        "ui_degree": "",
        "ui_email": "",
        "ui_flag": 0,
        "ui_high": 0,
        "ui_id": 122,
        "ui_integrity": 0,
        "ui_intro": "",
        "ui_level": 0,
        "ui_logo": 0,
        "ui_mood": "",
        "ui_name": "",
        "ui_nickname": "",
        "ui_online": 0,
        "ui_password": "b8661e35992f36111e1e184f5f659a5b",
        "ui_rmb": 0,
        "ui_score": 0,
        "ui_sex": "no",
        "ui_state": 0,
        "ui_tel": "13540971654",
        "ui_token": "8a96e96124617b78a8657b7c59725978",
        "ui_vc": 0,
        "utime": 1487397924000,
        "uuid": "2017021814058960"
    },
    "errorcode": "",
    "errormsg": "读取我的信息成功",
    "errorno": "0"
}
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id||long|
|uuid|用户uuid|String|
|ui_tel|手机号码/用户账号|String|
|ui_password|用户密码(MD5散列)|String|
|ui_nickname|用户昵称|String|
|ui_avatar|用户头像|String|
|ui_sex|用户性别:male男women女no未知|String|
|driving_licence|驾驶证号码|String|
|ui_name|姓名|String|
|ui_address|住址|String|
|bind_tel|绑定手机号码|String|
|ui_vc|爱泊币（100爱泊=1元）|long|
|ui_rmb|爱泊币（100爱泊=1元）|long|
|coupon_num|优费卷数量|long|
|ui_state|用户状态:0：正常1：禁用|int|
|ui_autopay|是否自动支付：0：不是1：是|int|
|pay_source|默认支付类型1:支付宝2：微信3：银联4：钱包|int|
|ui_level|用户等级|int|
|ui_score|用户积分|long|
|ui_mood|用户心情|String|
|ui_intro|个人简介|String|
|ui_age|用户年龄|int|
|ui_token|用户授权码|String|
|ui_email|用户邮箱|String|
|ui_high|用户身高|int|
|ui_degree||String|
|ctime||java.util.Date|
|utime||java.util.Date|
|ui_flag|注册来源0:android1:ios2:web|int|
|ui_online|l累计在线时长(分钟)|long|
|ui_integrity|用户诚信度按100来计算|int|
|note|备注|String|
|lock_money|锁定金额|int|
|lock_expect_money|锁定预约金额|int|
|lock_rent_money|锁定租赁金额|int|
|eu_id|ETC基本信息表主键ID|long|
|eu_nd|ETC唯一标识符|String|
|etc_autopay|是否开启ETC支付0:没有开启1：开启|int|
|bank_no|选择的默认银行卡卡号|String|
|ui_logo|吾泊加V标志(0:没有1：显示W)|int|
|ui_face_imgs|用户人脸图片地址集合(逗号分割)|String|
|ui_face_feature|用户人脸图片特征数据集合|String|
|ui_finger_imgs|用户指纹图片地址集合(逗号分割)|String|
|ui_finger_feature|用户指纹特征数据集合|String|
|ui_face_state|人脸识别状态（0:未采集到人脸1：已经采集到人脸且关闭人脸支付2：开启人脸支付）|int|
|ui_finger_state|指纹识别状态（0:未采集到指纹1：已经采集到指纹且关闭指纹支付2：开启指纹支付）|int|









####1.9->用户反馈
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| content| 反馈内容(URLENCODE utf-8)| 是| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|
####请求路径
[http://139.224.29.103/v1/feedback.php](http://139.224.29.103/v1/feedback.php)
######返回结果
    {
        "data": "",
        "errormsg": "用户反馈成功",
        "errorno": "0"
    }


####2.0->管理后台用户登录

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| loginname| 账号 | 否| 无 |字符串|
| password| 密码5-20字符 （MD5散列）| 否| 无 |字符串|
| sign| MD5数字签名(dtype+loginname)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/adminlogin.php](http://139.224.29.103/v1/adminlogin.php)

######返回结果
    {
        "data": {
            "create_time": 1469174450759,
            "gender": 1,
            "id": 1,
            "name": "admin",
            "password": "",
            "privilege_id": 1,
            "status": 1,
            "update_time": 1472463133426,
            "user_email": "17608005983@qq.com",
            "user_id": "admin",
            "user_phone": "17608005981"
        },
        "errorcode": "",
        "errormsg": "登录成功",
        "errorno": "0"
    }
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|id||int|
|user_id|4-10位的数字和字母(不区分大小写)，创建时用户自己填写，需做唯一性校验，用作登陆用户名|String|
|name|用户的昵称|String|
|password||String|
|privilege_id|指向权限表|int|
|status|用户的状态，如可用，不可用|byte|
|gender|用户的性别|byte|
|create_time|此用户被创建的时间|long|
|update_time||long|
|user_phone|电话号码|String|
|user_email|邮件|String|

####2.1->人脸识别图片提取

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| avatar| 用户人脸图片|是| 无 |文件|
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/recode_userface_img.php](http://139.224.29.103/v1/recode_userface_img.php)
    {
        "data": {
            "bank_no": "",
            "bind_tel": "18583768030",
            "coupon_num": 0,
            "ctime": 1481523879000,
            "driving_licence": "",
            "etc_autopay": 0,
            "eu_id": 0,
            "eu_nd": "",
            "lock_expect_money": 0,
            "lock_money": 0,
            "lock_rent_money": 0,
            "note": "",
            "pay_source": 0,
            "ui_address": "",
            "ui_age": 0,
            "ui_autopay": 0,
            "ui_avatar": "",
            "ui_degree": "",
            "ui_email": "",
            "ui_face_feature": "",
            "ui_face_imgs": "http://app.qc-wbo.com/file/img/avatar/2017/head18583768030_48635.png",
            "ui_face_state": 1,
            "ui_finger_feature": "",
            "ui_finger_imgs": "",
            "ui_finger_state": 0,
            "ui_flag": 1,
            "ui_high": 0,
            "ui_id": 40,
            "ui_integrity": 0,
            "ui_intro": "",
            "ui_level": 0,
            "ui_logo": 0,
            "ui_mood": "",
            "ui_name": "",
            "ui_nickname": "jYVqNHzu",
            "ui_online": 0,
            "ui_password": "a3b3eeb72be2f3cf7d4dbd5cbf9662a8",
            "ui_rmb": 0,
            "ui_score": 0,
            "ui_sex": "no",
            "ui_state": 0,
            "ui_tel": "18583768030",
            "ui_token": "8a6a09aa22083918b54bd978443007ca",
            "ui_vc": 0,
            "utime": 1481523879000,
            "uuid": "2016121214247768"
        },
        "errorcode": "",
        "errormsg": "人脸识别图片提取成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id||long|
|uuid|用户uuid|String|
|ui_tel|手机号码/用户账号|String|
|ui_password|用户密码(MD5散列)|String|
|ui_nickname|用户昵称|String|
|ui_avatar|用户头像|String|
|ui_sex|用户性别:male男women女no未知|String|
|driving_licence|驾驶证号码|String|
|ui_name|姓名|String|
|ui_address|住址|String|
|bind_tel|绑定手机号码|String|
|ui_vc|爱泊币（100爱泊=1元）|long|
|ui_rmb|爱泊币（100爱泊=1元）|long|
|coupon_num|优费卷数量|long|
|ui_state|用户状态:0：正常1：禁用|int|
|ui_autopay|是否自动支付：0：不是1：是|int|
|pay_source|默认支付类型1:支付宝2：微信3：银联4：钱包|int|
|ui_level|用户等级|int|
|ui_score|用户积分|long|
|ui_mood|用户心情|String|
|ui_intro|个人简介|String|
|ui_age|用户年龄|int|
|ui_token|用户授权码|String|
|ui_email|用户邮箱|String|
|ui_high|用户身高|int|
|ui_degree||String|
|ctime||java.util.Date|
|utime||java.util.Date|
|ui_flag|注册来源0:android1:ios2:web|int|
|ui_online|l累计在线时长(分钟)|long|
|ui_integrity|用户诚信度按100来计算|int|
|note|备注|String|
|lock_money|锁定金额|int|
|lock_expect_money|锁定预约金额|int|
|lock_rent_money|锁定租赁金额|int|
|eu_id|ETC基本信息表主键ID|long|
|eu_nd|ETC唯一标识符|String|
|etc_autopay|是否开启ETC支付0:没有开启1：开启|int|
|bank_no|选择的默认银行卡卡号|String|
|ui_logo|吾泊加V标志(0:没有1：显示W)|int|
|ui_face_imgs|用户人脸图片地址集合(逗号分割)|String|
|ui_face_feature|用户人脸图片特征数据集合|String|
|ui_finger_imgs|用户指纹图片地址集合(逗号分割)|String|
|ui_finger_feature|用户指纹特征数据集合|String|
|ui_face_state|人脸识别状态（0:未采集到人脸1：已经采集到人脸且关闭人脸支付2：开启人脸支付）|int|
|ui_finger_state|指纹识别状态（0:未采集到指纹1：已经采集到指纹且关闭指纹支付2：开启指纹支付）|int|

####2.2->修改用户 人脸识别开关状态

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| ui_face_state| 人脸识别状态（0:未采集到人脸  1：已经采集到人脸且关闭人脸支付   2：开启人脸支付  ）|否| 无 |整型|
| sign| MD5数字签名(ui_id+ui_face_state)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/update_userface_state.php](http://139.224.29.103/v1/update_userface_state.php)
    {
        "data": {
            "bank_no": "",
            "bind_tel": "18583768030",
            "coupon_num": 0,
            "ctime": 1481523879000,
            "driving_licence": "",
            "etc_autopay": 0,
            "eu_id": 0,
            "eu_nd": "",
            "lock_expect_money": 0,
            "lock_money": 0,
            "lock_rent_money": 0,
            "note": "",
            "pay_source": 0,
            "ui_address": "",
            "ui_age": 0,
            "ui_autopay": 0,
            "ui_avatar": "",
            "ui_degree": "",
            "ui_email": "",
            "ui_face_feature": "",
            "ui_face_imgs": "http://app.qc-wbo.com/file/img/avatar/2017/head18583768030_70493.png",
            "ui_face_state": 2,
            "ui_finger_feature": "",
            "ui_finger_imgs": "",
            "ui_finger_state": 0,
            "ui_flag": 1,
            "ui_high": 0,
            "ui_id": 40,
            "ui_integrity": 0,
            "ui_intro": "",
            "ui_level": 0,
            "ui_logo": 0,
            "ui_mood": "",
            "ui_name": "",
            "ui_nickname": "jYVqNHzu",
            "ui_online": 0,
            "ui_password": "a3b3eeb72be2f3cf7d4dbd5cbf9662a8",
            "ui_rmb": 0,
            "ui_score": 0,
            "ui_sex": "no",
            "ui_state": 0,
            "ui_tel": "18583768030",
            "ui_token": "8a6a09aa22083918b54bd978443007ca",
            "ui_vc": 0,
            "utime": 1481523879000,
            "uuid": "2016121214247768"
        },
        "errorcode": "",
        "errormsg": "人脸识别开关状态修改成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id||long|
|uuid|用户uuid|String|
|ui_tel|手机号码/用户账号|String|
|ui_password|用户密码(MD5散列)|String|
|ui_nickname|用户昵称|String|
|ui_avatar|用户头像|String|
|ui_sex|用户性别:male男women女no未知|String|
|driving_licence|驾驶证号码|String|
|ui_name|姓名|String|
|ui_address|住址|String|
|bind_tel|绑定手机号码|String|
|ui_vc|爱泊币（100爱泊=1元）|long|
|ui_rmb|爱泊币（100爱泊=1元）|long|
|coupon_num|优费卷数量|long|
|ui_state|用户状态:0：正常1：禁用|int|
|ui_autopay|是否自动支付：0：不是1：是|int|
|pay_source|默认支付类型1:支付宝2：微信3：银联4：钱包|int|
|ui_level|用户等级|int|
|ui_score|用户积分|long|
|ui_mood|用户心情|String|
|ui_intro|个人简介|String|
|ui_age|用户年龄|int|
|ui_token|用户授权码|String|
|ui_email|用户邮箱|String|
|ui_high|用户身高|int|
|ui_degree||String|
|ctime||java.util.Date|
|utime||java.util.Date|
|ui_flag|注册来源0:android1:ios2:web|int|
|ui_online|l累计在线时长(分钟)|long|
|ui_integrity|用户诚信度按100来计算|int|
|note|备注|String|
|lock_money|锁定金额|int|
|lock_expect_money|锁定预约金额|int|
|lock_rent_money|锁定租赁金额|int|
|eu_id|ETC基本信息表主键ID|long|
|eu_nd|ETC唯一标识符|String|
|etc_autopay|是否开启ETC支付0:没有开启1：开启|int|
|bank_no|选择的默认银行卡卡号|String|
|ui_logo|吾泊加V标志(0:没有1：显示W)|int|
|ui_face_imgs|用户人脸图片地址集合(逗号分割)|String|
|ui_face_feature|用户人脸图片特征数据集合|String|
|ui_finger_imgs|用户指纹图片地址集合(逗号分割)|String|
|ui_finger_feature|用户指纹特征数据集合|String|
|ui_face_state|人脸识别状态（0:未采集到人脸1：已经采集到人脸且关闭人脸支付2：开启人脸支付）|int|
|ui_finger_state|指纹识别状态（0:未采集到指纹1：已经采集到指纹且关闭指纹支付2：开启指纹支付）|int|

