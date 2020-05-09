> #### 项目介绍

实现仿京东商城搜索功能，项目采用SpringBoot构建。前端Thymeleaf+Vue+axios。

> #### 可能遇到的问题

遇到只能搜索单个汉字问题
在postman中访问http://127.0.0.1:9200/jd_goods，提交方式为PUT
请求体为：

```
{
    "settings": {
        "number_of_shards": 5,
        "number_of_replicas": 1
    },
    "mappings": {
        "properties": {
            "title": {
                "type": "text",
                "analyzer": "ik_max_word"
            }
        }
    }
}
```

可以实现中文检索功能

> 项目启动后访问地址：http://localhost:9090

视频学习请访问 https://www.bilibili.com/video/BV17a4y1x7zq?p=1
