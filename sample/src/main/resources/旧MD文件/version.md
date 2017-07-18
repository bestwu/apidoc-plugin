###1.版本管理模块

####1.1->获取版本升级
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| uid| 用户ID | 否| 无 |字符串|
| version| 版本：例如v1.0| 否| 无 |字符串|
| versioncode| 版本编号：例如 1| 否| 无 |整型|
| sign| MD5数字签名(dtype+versioncode)按参数的首字母升序顺序进行组装| 否| 无 |字符串|
####请求路径
[http://app.qc-wbo.com/v1/gainupgrade.php](http://app.qc-wbo.com/v1/gainupgrade.php)
######返回结果
    {
        "data": {
            "content": "1:优化播放器。",
            "md5": "",文件的MD5校验
            "type": "android", android ios
            "update": 1, 是否有升级 是否有更新  1 –是 0 –否 
            "url": "http://smaradio.changhong.com/downloads/upgrade/SmaRadioMobile_v1.2.0.apk",
            "version": "v1.0", 外部版本显示号
            "versioncode": 2, 内部版本升级的 整数的 编号
            is_forced:0 是否强制更新0：不强制更新1：强制更新
        },
        "errormsg": "",
        "errorno": "0"
    }



