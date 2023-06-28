import ConfigAdd from './ConfigAdd.vue';
import ConfigTable from './table/ConfigTable';
import ConfigTable2 from './table/ConfigTable2';
import ConfigTableQ from './table/ConfigTableQ';

import CTMENT from './table/CTM-ENT';
import ProgressQuery from './table/ProgressQuery';


import LoginDialog from './LoginDialog';
import ConfigTableSimple from './table/ConfigTableSimple';
import ConfigTableSimpleFilter from './table/ConfigTableSimpleFilter';
import DelegateRecordsTable from './table/DelegateRecordsTable';//黄大伟添加
import TestDocAuditTable from './table/TestDocAuditTable';//黄大伟添加
import TestCenterAccount  from './table/TestCenterAccount';//黄大伟添加
import TestResultTable from './table/TestResultTable';//文炫添加
import TestReportTable from './table/TestReportTable';//文炫添加
import ImmediateProcessing from './table/ImmediateProcessing'
//tree
import SimpleTree from './tree/SimpleTree';
import SimpleTreeWithIcon from './tree/SimpleTreeWithIcon';

// uploadfile
import UploadFile from './uploadfile/UploadFile';
import UploadHistory from './uploadfile/UploadHistory';

// 
import UserTable from './table/UserTable';

import Vue from 'vue';

function registerComponents(){
    
    Vue.component('ConfigAdd', ConfigAdd);
    
    Vue.component('ConfigTable', ConfigTable);
    Vue.component('ConfigTable2', ConfigTable2);
    Vue.component('ConfigTableQ', ConfigTableQ);
    Vue.component('CTMENT', CTMENT);
    Vue.component('ProgressQuery', ProgressQuery); 

    Vue.component('LoginDialog', LoginDialog);
    Vue.component('ConfigTableSimple', ConfigTableSimple);
    Vue.component('ConfigTableSimpleFilter', ConfigTableSimpleFilter);
    Vue.component('DelegateRecordsTable', DelegateRecordsTable);//黄大伟添加
    Vue.component('TestDocAuditTable', TestDocAuditTable);//黄大伟添加
    Vue.component('TestCenterAccount', TestCenterAccount);//黄大伟添加
    Vue.component('TestResultTable', TestResultTable); //文炫添加
    Vue.component('TestReportTable', TestReportTable); //文炫添加
    Vue.component('ImmediateProcessing', ImmediateProcessing); //文炫添加
    //tree
    Vue.component('SimpleTree', SimpleTree);
    Vue.component('SimpleTreeWithIcon', SimpleTreeWithIcon);

    // upload file
    Vue.component('UploadFile', UploadFile);
    Vue.component('UploadHistory', UploadHistory);

    // User
    Vue.component('UserTable', UserTable);
    
}

export {
    registerComponents
}