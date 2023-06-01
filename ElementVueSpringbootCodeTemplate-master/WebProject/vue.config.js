// vue.config.js
module.exports = {
  // ...
  devServer: {
    open: true, //process.platform === 'darwin',
    host: '0.0.0.0',
    port: 9090, // CHANGE YOUR PORT HERE!
    https: false,
    hotOnly: false,
    // proxy:{
    //   '/api':{
    //     target:'http://localhost:1234',
    //     changeorigin:true,
    //     pathRewrite:{
    //       '/api/':''
    //     }
    //   }
    // }
  },
  // ...
}