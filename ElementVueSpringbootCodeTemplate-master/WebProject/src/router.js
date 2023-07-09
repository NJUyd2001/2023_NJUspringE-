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
import ApplicationAmendMarket from './views/apply/ApplicationAmendMarket'
import ApplicationAmendTest from './views/apply/ApplicationAmendTest'
import FunctionList from './views/apply/FunctionList'
import FunctionListAmendMarket from './views/apply/FunctionListAmendMarket'
import FunctionListAmendTest from './views/apply/FunctionListAmendTest'
import CheckAuditInforMarket from './views/apply/CheckAuditInforMarket'
import CheckAuditInforFailedMarket from './views/apply/CheckAuditInforFailedMarket'
import CheckAuditInforTest from './views/apply/CheckAuditInforTest'
import CheckAuditInforFailedTest from './views/apply/CheckAuditInforFailedTest'
import Report from './views/report/Report'
import Personal from "./views/client/Personal";
import ProQurey from "./views/client/ProQurey";
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
import ChangeQuote from './views/Quote/ChangeQuote'
import AuditQuote from './views/Quote/AuditQuote'
import ReportChecklist from './views/report/ReportChecklist'
import Defectlist from './views/test/Defectlist'
import SoftwareDocumentReviewForm1 from './views/report/SoftwareDocumentReviewForm1'
import SoftwareDocumentReviewForm2 from './views/report/SoftwareDocumentReviewForm2'
import TestReportCover from './views/report/TestReportCover'
import TestEnvironment from './views/report/TestEnvironment'
import SoftwareProjectTestChecklist from './views/test/SoftwareProjectTestChecklist'
import DataSubmit from './views/client/DataSubmit'
import ConfidentialityAgreement from './views/client/ConfidentialityAgreement'
import DocumentandSign from './views/apply/DocumentAndSign'

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
            path: '/applicationamendmarket',       // 路径
            component: ApplicationAmendMarket      // 跳转到的组件 
        },
        {
            path: '/applicationamendtest',       // 路径
            component: ApplicationAmendTest      // 跳转到的组件 
        },
        {
            path: '/functionlist',       // 路径
            component: FunctionList      // 跳转到的组件 
        },
        {
            path: '/documentandsign',       // 路径
            component: DocumentandSign      // 跳转到的组件 
        },
        {
            path: '/functionlistamendmarket',       // 路径
            component: FunctionListAmendMarket      // 跳转到的组件 
        },
        {
            path: '/functionlistamendtest',       // 路径
            component: FunctionListAmendTest      // 跳转到的组件 
        },
        {
            path: '/checkauditinformarket',     // 路径
            component: CheckAuditInforMarket    // 跳转到的组件
        },
        {
            path: '/checkauditinfortest',     // 路径
            component: CheckAuditInforTest    // 跳转到的组件
        },
        {
            path: '/checkauditinforfailedmarket',     // 路径
            component: CheckAuditInforFailedMarket    // 跳转到的组件
        },
        {
            path: '/checkauditinforfailedtest',     // 路径
            component: CheckAuditInforFailedTest    // 跳转到的组件
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
            path: '/Personal',     // 路径
            component: Personal    // 跳转到的组件
        },
        {
            path: '/ProQurey',     // 路径
            component: ProQurey    // 跳转到的组件
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
            path: '/GenQuote',     // 路径
            component: GenQuote    // 跳转到的组件
        },
        {
            path: '/changeQuote',     // 路径
            component: ChangeQuote    // 跳转到的组件
        },
        {
            path: '/AuditQuote',     // 路径
            component: AuditQuote    // 跳转到的组件
        },
        {
            path: '/ReportChecklist',    // 路径
            component: ReportChecklist   // 跳转到的组件
        },
        {
            path: '/test/Defectlist',  // 路径
            component: Defectlist      // 跳转到的组件
        },
        {
            path: '/report/SoftwareDocumentReviewForm1',  // 路径
            component: SoftwareDocumentReviewForm1        // 跳转到的组件
        },
        {
            path: '/report/SoftwareDocumentReviewForm2',  // 路径
            component: SoftwareDocumentReviewForm2        // 跳转到的组件
        },
        {
            path: '/TestReportCover',      // 路径
            component: TestReportCover     // 跳转到的组件
        },
        {
            path: '/TestEnvironment',      // 路径
            component: TestEnvironment     // 跳转到的组件
        },
        {
            path: '/SoftwareProjectTestChecklist',   // 路径
            component: SoftwareProjectTestChecklist       // 跳转到的组件
        },
        {
            path: '/client/DataSubmit',   // 路径
            component: DataSubmit         // 跳转到的组件
        },
        {
            path: '/client/ConfidentialityAgreement',   // 路径
            component: ConfidentialityAgreement         // 跳转到的组件
        },
    ]
})
