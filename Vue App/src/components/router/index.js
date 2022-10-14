import VueRouter from 'vue-router';
import Vue from 'vue';

import RegisterUser from '../RegisterUser';
import Login from '../Login';
import Home from '../Home';
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
]


const router = new VueRouter({
    routes,
});


export default router;