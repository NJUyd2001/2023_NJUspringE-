// 此文件专门负责项目的路由

import VueRouter from "vue-router"

// 引入组件
import Home from './views/home/Home'
import Login from './views/login/Login'
import ClientLogin from './views/login/ClientLogin'
import Register from './views/register/Register'
import ClientRegister from './views/register/ClientRegister'
import Client from './views/client/Client'
import Market from './views/market/Market'
import Quality from './views/merge/Quality'
import Signatory from './views/merge/Signatory'
import TestDirector from './views/merge/TestDirector'
import Admin  from './views/admin/Admin'
import Test from './views/test/Test'
import Application from './views/apply/Application'
import ApplicationAmend from './views/apply/ApplicationAmend'
import FunctionList from './views/apply/FunctionList'
import FunctionListAmend from './views/apply/FunctionListAmend'
import CheckAuditInfor from './views/apply/CheckAuditInfor'
import CheckAuditInforFailed from './views/apply/CheckAuditInforFailed'
import Report from './views/report/Report'
import Personal from "./views/client/Personal";
import Info from "./views/client/Info";
import MarketAuditUser from './views/market/MarketAuditUser'
import MarketAuditApplication from './views/market/MarketAuditApplication'
import MarketAuditInfor from './views/market/MarketAuditInfor'
import MarketAuditFunctionList from './views/market/MarketAuditFunctionList'
import TestAuditUser from './views/test/TestAuditUser'
import TestAuditApplication from './views/test/TestAuditApplication'
import TestAuditInfor from './views/test/TestAuditInfor'
import TestAuditFunctionList from './views/test/TestAuditFunctionList'
import TestCheckMarketInfor from './views/test/TestCheckMarketInfor'
import MyInformation from './views/apply/MyInformation'
import TestContent from './views/report/TestContent'
import TestScheme from './views/test/TestScheme'
import TestDocument1 from './views/report/TestDocument1'
import TestDocument2 from './views/report/TestDocument2'
import TestReviewDelegation from './views/test/TestReviewDelegation'
import MarketContract from './views/market/Contract'
import GenQuote from './views/Quote/GenQuote'
import AuditQuote from './views/Quote/AuditQuote'

// 创建并暴露一个路由器
export default new VueRouter({
    //mode: 'history',    // 路由模式，该模式不会在地址中显示井号#
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
            path: '/clientregister',     // 路径
            component: ClientRegister    // 跳转到的组件
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
            path: '/quality',     // 路径
            component: Quality    // 跳转到的组件
        },
        {
            path: '/TestDirector',     // 路径
            component: TestDirector    // 跳转到的组件
        },
        {
            path: '/signatory',     // 路径
            component: Signatory    // 跳转到的组件
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
            path: '/applicationamend',       // 路径
            component: ApplicationAmend      // 跳转到的组件 
        },
        {
            path: '/functionlist',       // 路径
            component: FunctionList      // 跳转到的组件 
        },
        {
            path: '/functionlistAmend',       // 路径
            component: FunctionListAmend      // 跳转到的组件 
        },
        {
            path: '/checkauditinfor',     // 路径
            component: CheckAuditInfor    // 跳转到的组件
        },
        {
            path: '/checkauditinforfailed',     // 路径
            component: CheckAuditInforFailed    // 跳转到的组件
        },
        {
            path: '/myinf',       // 路径
            component: MyInformation      // 跳转到的组件 
        },
        {
            path: '/report',     // 路径
            component: Report    // 跳转到的组件
        },
        {
            path: '/marketaudituser',     // 路径
            component: MarketAuditUser    // 跳转到的组件
        },
        {
            path: '/marketauditapplication',     // 路径
            component: MarketAuditApplication    // 跳转到的组件
        },
        {
            path: '/marketauditfunctionlist',   // 路径
            component: MarketAuditFunctionList  // 跳转到的组件
        },
        {
            path: '/marketauditinfor',     // 路径
            component: MarketAuditInfor    // 跳转到的组件
        },
        {
            path: '/testaudituser',     // 路径
            component: TestAuditUser    // 跳转到的组件
        },
        {
            path: '/testauditapplication',     // 路径
            component: TestAuditApplication    // 跳转到的组件
        },
        {
            path: '/testauditfunctionlist',   // 路径
            component: TestAuditFunctionList  // 跳转到的组件
        },
        {
            path: '/testauditinfor',     // 路径
            component: TestAuditInfor    // 跳转到的组件
        },
        {
            path: '/testcheckmarketinfor',     // 路径
            component: TestCheckMarketInfor    // 跳转到的组件
        },
        {
            path: '/testcontent',   // 路径
            component: TestContent  // 跳转到的组件
        },
        {
            path: '/testscheme',   // 路径
            component: TestScheme  // 跳转到的组件
        },
        {
            path: '/testdocument1',   // 路径
            component: TestDocument1  // 跳转到的组件
        },
        {
            path: '/testdocument2',   // 路径
            component: TestDocument2  // 跳转到的组件
        },
        {
            path: '/testreviewdelegation',  // 路径
            component: TestReviewDelegation // 跳转到的组件
        },
        {
            path: '/client/Personal',     // 路径
            component: Personal    // 跳转到的组件
        },
        {
            path: '/client/Info',     // 路径
            component: Info    // 跳转到的组件
        },
        {
            path: '/MarketContract',     // 路径
            component: MarketContract    // 跳转到的组件
        },
        {
            path: '/Quote/GenQuote',     // 路径
            component: GenQuote    // 跳转到的组件
        },
        {
            path: '/Quote/AuditQuote',     // 路径
            component: AuditQuote    // 跳转到的组件
        },
    ]
})
