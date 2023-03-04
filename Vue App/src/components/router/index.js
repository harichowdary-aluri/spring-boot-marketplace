/**
 * @Author: Your name
 * @Date:   2022-10-14 20:23:15
 * @Last Modified by:   Your name
 * @Last Modified time: 2022-11-22 19:37:54
 */
import VueRouter from 'vue-router';
import Vue from 'vue';

import RegisterUser from '../RegisterUser';
import Login from '../Login';
import Home from '../Home';
import Electronics from '../Electronics';
// import Automobiles from '../Automobiles';
import Clothing from '../Clothing';
import AddProduct from '../AddProduct';
import HouseHold from '../HouseHold';
import Others from '../Others';
import Dialler from '../Dialler';
Vue.use(VueRouter);

const routes = [
    {
        path: "/register",
        component: RegisterUser,
    },
    {
        path: "/login",
        component: Login,
    },
    {
        path: "/Home",
        component: Home,
    },
    {
        path: "/Electronics",
        component: Electronics,
    },
    {
         path: "/Dialler",
        component: Dialler,
    },
    {
        path: "/Clothing",
        component: Clothing,
    },
    {
        path: "/Automobiles",
        component: Automobiles,
    },
    {
        path: "/HouseHold",
        component: HouseHold,
    },
    {
        path: "/Others",
        component: Others
    }
    
    
]

const router = new VueRouter({
    routes,
});


export default router;