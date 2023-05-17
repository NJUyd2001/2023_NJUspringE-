// 此文件专门负责项目的路由

import VueRouter from "vue-router"

// 引入组件
import Home from './views/home/Home'
import Login from './views/login/Login'
import ClientLogin from './views/login/ClientLogin'
import Register from './views/register/Register'
import Client from './views/client/Client'
import Market from './views/market/Market'
import Admin  from './views/admin/Admin'
import Test from './views/test/Test'
import Application from './views/apply/Application'
import FunctionList from './views/apply/FunctionList'
import Report from './views/report/Report'

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
            path: '/clientlogin',     // 路径
            component: ClientLogin    // 跳转到的组件
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
            path: '/market',     // 路径
            component: Market    // 跳转到的组件
        },
        {
            path:'/admin',   // 路径 黄大伟添加
            component:Admin // 跳转到的组件
        },
        {
            path: '/test',       // 路径
            component: Test      // 跳转到的组件 
        },
        {
            path: '/application',       // 路径
            component: Application      // 跳转到的组件 
        },
        {
            path: '/functionlist',       // 路径
            component: FunctionList      // 跳转到的组件 
        },
        {
            path: '/report',     // 路径
            component: Report    // 跳转到的组件
        },
    ]
})
