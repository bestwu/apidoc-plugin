###WEB ：： 1.车牌管理模块




####1.0->通过GPS导航获取该经纬度范围内的停车场数据列表（普通车位停车）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| lng| 场地经度 | 否| 无 |双精度浮点型|
| lat| 场地纬度 | 否| 无 |双精度浮点型|
| distance| 距离范围直径(默认500米) 单位米 | 是| 无 |整型|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
####请求路径

[http://139.224.29.103/v1/get_parkinfo_forweb.php](http://139.224.29.103/v1/get_parkinfo_forweb.php)
#####采用JSONP 跨域访问
    $(function(){     
        $.ajax({
            type : "get",
            async:false,
            url : "http://localhost:8080/v1/get_parkinfo_forweb.php?		lat=28.88549&lng=105.45148&distance=1000&area_code=510105",
            dataType : "jsonp",//数据类型为jsonp
            jsonp: "jsonpCallback",//服务端用于接收callback调用的function名的参数
            jsonpCallback:"jsonp_result",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
            success : function(data){
                $("#showcontent").text("Result:"+data.result)
            },
            error:function(){
                alert('fail');
            }
        });
    }); 

######返回结果
    jsonp_result(
        {
            "result": {
                "pi_name": "洪洋农贸市场地下车库",
                "carport_total": 120,
                "carport_yet": 105,
                "carport_space": 15,
                "lng": 105.45148,
                "lat": 28.88549,
                "park_state": "warning",
                "juli": 0
            }
        }
    )