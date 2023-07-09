// vue.config.js
module.exports = {
  // ...
  baseUrl: './',
  devServer: {
    host: 'localhost',
    //host: '0.0.0.0',
    port: '9090',
    proxy: {
      '/api': { // 请求的代称，写在Axios里的BaseUrl
        target: 'http://localhost:1234', // 真实请求URl
        //target: 'http://210.28.133.13:21603',
        ws: true,
        changeOrigin: true, // 允许跨域
        pathRewrite: { //替换，通配/api的替换成对应字符
        //     /* 重写路径，当我们在浏览器中看到请求的地址为：http://localhost:8080/api/core/getData/userInfo 时
        //       实际上访问的地址是：http://localhost:8088/spring/core/getData/userInfo,因为重写了 /api
        //      */
            '^/api': '' //当你的接口中没有/api字眼时，采用这种，直接替换成空即可
        //     '^/api': '/api'   //当你的接口中刚好有/api 时，采用这种方式
        }
    }
}
  // ...
}
}