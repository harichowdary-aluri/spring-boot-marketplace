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
import Others from '../Others';
import Forgetpassword from '../Forgetpassword';
import BuyElectronics from '../BuyElectronics';
import BuyClothing from '../BuyClothing';
import BuyAutomobiles from '../BuyAutomobiles';
import BuyHousehold from '../BuyHousehold';
import BuyMiscellenous from '../BuyMiscellenous';
import UserAds from '../UserAds';
import MyAccount from '../MyAccount';
import UpdateElectronics from '../UpdateElectronics';
import UpdateClothing from '../UpdateClothing';
import UpdateHousehold from '../UpdateHousehold';
import UpdateAutomobiles from '../UpdateAutomobiles';
import UpdateOthers from '../UpdateOthers';
import resetPassword from '../resetPassword';
import LoginForm from '../LoginForm';

Vue.use(VueRouter);

const  routes = [
    {
        path: "/register",
        component: RegisterUser,
        meta: {
          requiresAuth: false // set the "requiresAuth" meta field to true
        }
    },
    {
        path: "/login",
        component: Login,
    },
    {
        path: "/Home",
        component: Home,
        meta: {
          requiresAuth: true // set the "requiresAuth" meta field to true
        }
    },
    {
        path: "/Electronics",
        component: Electronics,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path: "/AddProduct",
        component: AddProduct,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path: "/Clothing",
        component: Clothing,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path: "/Automobiles",
        component: Automobiles,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path: "/HouseHold",
        component: HouseHold,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path: "/Others",
        component: Others,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path: "/Forgetpassword",
        component: Forgetpassword,
        meta: {
          requiresAuth: false // set the "requiresAuth" meta field to true
        }
    },
    {
        path: "/BuyElectronics",
        component: BuyElectronics,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path: "/BuyClothing",
        component: BuyClothing,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path: "/BuyAutomobiles",
        component: BuyAutomobiles ,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          } 

    },
    {
        path: "/BuyHousehold",
        component: BuyHousehold  ,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }

    }, 
    {
        path: "/BuyMiscellenous",
        component: BuyMiscellenous,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }

    }, 
    {
        path:"/Ads",
        component: UserAds,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path:"/MyAccount",
        component: MyAccount,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path:"/UpdateElectronics",
        component: UpdateElectronics,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path:"/UpdateClothing",
        component: UpdateClothing,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path:"/UpdateAutomobiles",
        component: UpdateAutomobiles,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path:"/UpdateHousehold",
        component: UpdateHousehold,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path:"/UpdateOthers",
        component: UpdateOthers,
        meta: {
            requiresAuth: true // set the "requiresAuth" meta field to true
          }
    },
    {
        path:"/resetPassword",
        component: resetPassword
    },
    {
      path:"/",
      component: LoginForm
  },
]


const router = new VueRouter({
    routes,
    mode: "history"
});
router.beforeEach((to, from, next) => {
    const requiresAuth = to.matched.some(record => record.meta.requiresAuth); // check if the "requiresAuth" meta field is set for the route
    const isAuthenticated = localStorage.getItem('loggedIn'); // get the boolean value from local storage
    console.log(isAuthenticated)
  
    if (requiresAuth && isAuthenticated==null) { // if the route requires authentication and the user is not authenticated
      next('/'); // redirect to the access denied page
    } else {
      next(); // allow the user to access the route
    }
  });

export default router;