import Vue from "vue";
import Router from "vue-router";

import SearchCustomers from "./components/SearchCustomers.vue";
import SearchCustomersById from "./components/SearchCustomersById.vue";
import ChartCustomer from "./components/ChartCustomer.vue";
import AddCustomer from "./components/AddCustomer.vue";
import DetailCustomer from "./components/DetailCustomer.vue";
import UpdateCustomer from "./components/UpdateCustomer.vue";
import FoodInfo from "./components/FoodInfo.vue";
import MainList from "./components/MainList.vue";
import NoticeList from "./components/NoticeList.vue";
import Noticereg from "./components/Noticereg";
import NoticeView from "./components/NoticeView.vue";
import Chart from "./components/FoodChart.vue";
import QnA from "./components/QnA.vue";
import QnAView from "./components/QnAView.vue";
import QnAWirte from "./components/QnAwrite.vue";


//import Login from "./components/Login.vue";
//import CustomerRegistry from "./components/CustomerRegistry.vue";
//import ChartPieCustomer from "./components/ChartPieCustomer.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/foodinfo",
      name: "foodinfo",
      alias: "/foodinfo",
      component: FoodInfo
    },
    {
      path: "/",
      name: "mainlist",
      alias: "/mainlist",
      component: MainList

    },
    
    {
      path: "/foodchart/:code",
      name: "foodchart",
      alias: "/chart",
      component: Chart,
      props: true
    },
    {
      path: "/noticereg",
      name: "noticereg",
      alias: "/noticereg",      
      component: Noticereg
    },
    {
      path: "/noticelist",
      name: "noticelist",
      alias: "/noticelist",      
      component: NoticeList
    },
    {
      path: "/noticeview/:no",
      name: "noticeview",
      alias: "/noticeview",
      props: true,
      component: NoticeView
    },
    {
      path: "/QnA",
      name: "QnA",
      alias: "/QnA",      
      component: QnA
    },
    {
      path: "/QnAWrite",
      name: "QnAwrite",
      alias: "/QnAwrite",      
      component: QnAWirte
    },
    {
      path: "/QnAView/:no",
      name: "QnAView",
      alias: "/QnAView",      
      props: true,
      component: QnAView
    },
    /*{
      path: "/",
      name: "customers",
      alias: "/customer",
      component: CustomersList
    },*/
    {
      path: "/search",
      name: "search",
      component: SearchCustomers
    },
    {
      path: "/searchbyid",
      name: "searchbyid",
      component: SearchCustomersById
    }
    ,
    {
      path: "/chartcustomer",
      name: "chartcustomer",
      component: ChartCustomer
    } ,
    {
      path: "/add",
      name: "add",
      component: AddCustomer
    }
    ,
    {
      path: '/detailcustomer/:id',
      name: 'detailcustomer',
      component: DetailCustomer,
      props: true,
    }
    ,
    {
      path: '/updatecustomer/:id',
      name: 'updatecustomer',
      component: UpdateCustomer,
      props: true,
    }
    
    
  ]
});