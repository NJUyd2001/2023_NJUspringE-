# file类接口手册

## 接口列表既使用方法

### 上传文件
端口：`/file/upload`

参数：文件传输流、PID、state和fileType

返回值：文件存储成功后获得的FID，不成功则为空

传参方法参考:
``` js
const axios = require('axios');
const FormData = require('form-data');
const fs = require('fs');
let data = new FormData();
data.append('file', fs.createReadStream('文件上传路径'));   // 文件流参数
data.append('PID', '5');                                   // PID参数
data.append('state', '1376666');                           // state参数
data.append('fileType', 'test');

let config = {
  method: 'post',
  maxBodyLength: Infinity,
  url: 'localhost:1234/file/upload',
  headers: { 
    'Origin': 'localhost:9090',             // postman 模拟9090端口跨域
    'Conten': 'multipart/form-data', 
    ...data.getHeaders()
  },
  data : data
};

axios.request(config)
.then((response) => {
  console.log(JSON.stringify(response.data));
})
.catch((error) => {
  console.log(error);
});

```

### 查找
- 查看所有文件

端口：`/file/select/all`

参数：无

返回值：文件信息数组
``` js
[
    {
        "filePath": "D:\\selab\\file\\1\\whbduib.jpg",
        "fileName": null,
        "uploadTime": "2023-07-01 12:35:29",
        "fid": 1,
        "pid": 1
    },
    {
        "filePath": "D:\\selab\\file\\1\\whbduib.jpg",
        "fileName": null,
        "uploadTime": "2023-07-01 12:41:15",
        "fid": 2,
        "pid": 1
    },
    {
        "filePath": "D:\\selab\\file\\10\\reze.png",
        "fileName": "reze.png",
        "uploadTime": "2023-07-01 16:02:26",
        "fid": 15,
        "pid": 10
    },
    {
        "filePath": "D:\\selab\\file\\5\\IMG_20201020_180533.jpg",
        "fileName": "IMG_20201020_180533.jpg",
        "uploadTime": "2023-07-02 10:48:01",
        "fid": 16,
        "pid": 5
    }
]
```

- 根据PID搜索

端口：`/file/select/byPID`

参数： `data.append('PID', '');` ，与[上传文件的传参方法](#上传文件)类似

- 通过PID、state和fileType搜索
  
端口：`/file/select/byState`

参数：
``` js
  "PID":"",
  "state":"",
  "fileType":""
```

- 根据FID搜索

端口：`/file/select/byFID`

参数：`data.append('FID', '');` ，与[上传文件的传参方法](#上传文件)类似

### 下载

- 通过FID下载

端口：`/file/download`

参数：`data.append('FID', '');` ，与[上传文件的传参方法](#上传文件)类似

浏览器会收到下载文件


