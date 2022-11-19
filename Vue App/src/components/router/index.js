import VueRouter from 'vue-router';
import Vue from 'vue';

import RegisterUser from '../RegisterUser';
import Login from '../Login';
import Home from '../Home';
import Electronics from '../Electronics';
import Automobiles from '../Automobiles';
import Clothing from '../Clothing';
import AddProduct from '../AddProduct';
import HouseHold from '../HouseHold';
import Forgetpassword from '../Forgetpassword'
Vue.use(VueRouter);

const routes = [
    {
        path: "/register",
        component: RegisterUser,
    },
    {
        path: "/forget",
        component: Forgetpassword ,
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
        path: "/AddProduct",
        component: AddProduct,
    },
    {
        path: "/Clothing",
        component: Clothing,
    },
    
]


const router = new VueRouter({
    routes,
});


export default router;