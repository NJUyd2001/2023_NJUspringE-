// 此文件专门负责项目的路由

import VueRouter from "vue-router"

// 引入组件
import Home from './views/home/Home'
import Login from './views/login/Login'
import Register from './views/register/Register'
import Client from './views/client/Client'
<<<<<<< HEAD
import Market from './views/market/Market'
import Admin  from './views/admin/Admin'

=======
import Admin  from './views/admin/Admin'
>>>>>>> 1d08763648340095c7498c2958ea635c141a594d
// 创建并暴露一个路由器
export default new VueRouter({
    mode: 'history',    // 路由模式，该模式不会在地址中显示井号#
    routes: [
        {
            path: '/',          // 路径
            redirect: '/home'  // 重定向
        },
        {
            path: '/login',     // 路径
            component: Login    // 跳转到的组件
        },
        {
            path: '/register',     // 路径
            component: Register    // 跳转到的组件
        },
        {
            path: '/home',     // 路径
            component: Home    // 跳转到的组件
        },
        {
            path: '/client',     // 路径
            component: Client    // 跳转到的组件
        },
        {
<<<<<<< HEAD
            path: '/market',     // 路径
            component: Market    // 跳转到的组件
        },
        {
=======
>>>>>>> 1d08763648340095c7498c2958ea635c141a594d
            path:'/admin',   // 路径 hdw添加
            component:Admin // 跳转到的组件
        }
    ]
})