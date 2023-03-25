<template>
  <div class="header " >
    <b-navbar toggleable="lg" class="navbarHeader" v-if="isAuthenticated">
      <div class="headerFlex">
        <div class="market">
          <h1 class="bs">MARKETPLACE</h1>
        </div>

        <div id="as" class="logoutC" >
          <div class="nav-item">
            <span class="user-info">
              <img :src="this.picture" alt="User's profile picture"
                class="nav-user-profile d-inline-block rounded-circle mr-3" width="50" />
              <h6 class="d-inline-block">{{ this.user }}</h6>
            </span>
          </div>

          <font-awesome-icon icon="faUser" class="mr-3" />
          <!-- <router-link to="/profile">this.user</router-link> -->

          <font-awesome-icon icon="fa-powerOff" class="mr-3" />
          <button id="qsLogoutBtn" v-on:click="logout">Log out</button>
        </div>
      </div>

    </b-navbar>
    <b-navbar v-else toggleable="lg" class="navbarHeader2">
        <div class="market">
          <h1>MARKETPLACE</h1>
        </div>
    </b-navbar>
  </div>
   
</template>
<script>
import Vue from 'vue';
import RegisterUser from "./RegisterUser.vue";
import Login from "./Login.vue";
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
export default ({
  name: "APPHeader",
  components: {
    FontAwesomeIcon
  },
  data() {

    return Vue.observable({
      isAuthenticated: false,
      picture: "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png",
      user: ""
    })

  },
  components: {
    RegisterUser,
    Login,
  },

  mounted(){
    // if (localStorage.getItem('loggedIn')==="true") {
    //    this.isAuthenticated = true
    //     return true
    //   } else {
    //     this.isAuthenticated = false
    //     return false
    //   }
  },
  computed: {

    // ...mapState({
    //   user1: state => state.user1
    // })
    showComponent() {
      // console.log("jeevan")
      // Check if localStorage item is true

      
    }
  },

  mounted() {
    // this.sample();
    // this.showComponent();
    if (localStorage.getItem('loggedIn')==="true") {
       this.isAuthenticated = true
        return true
      } else {
        this.isAuthenticated = false
        return false
      }
  },
  updated(){
    if (localStorage.getItem('loggedIn')==="true") {
       this.isAuthenticated = true
        return true
      } else {
        this.isAuthenticated = false
        return false
      }
  },
  methods: {
    logout() {
      // console.log("User clicked Logout")
      sessionStorage.removeItem('user')
      // console.log("logout done")
      alert("logout success")
      this.isAuthenticated = false
      // localStorage.setItem("loggedIn", "false");
      localStorage.removeItem('loggedIn')
      sessionStorage.removeItem("user");
      //  this.$router.push('/login')
      window.location.href = "/login";
    }

  },
}
);
</script>
  
<style scoped>
.navbarHeader {
  background-color: #1f5a7c;
  font-weight: bold;
  color: whitesmoke;
  height: auto;
  float: none;
  margin: 0px;
  justify-content: center;
}
.navbarHeader2 {
  background-color: #1f5a7c;
  font-weight: bold;
  color: whitesmoke;
  height: auto;
  text-align: center;
  float: none;
  margin: 0px;
  justify-content: center;
}

.header {
  top: 0px;
  margin: 0px 0px 0px;
  padding: 0px;
}

/* .bs {
  /* margin-left: 350px; */
  /* text-align: justify; */
/* } */ 

.navbarHeaderNoLogin{
  text-align: center;
}
.headerFlex{
  display: flex;
  justify-content: space-around;
  width: 100%;
  flex-direction: row;
  flex-wrap: nowrap;
  align-items: center ;
}

/* .ds {
 align-items: center;
} */

/* .as {
  text-align: right;
  margin-left: 210px;
} */
.logoutC {
  margin-right: 0px;
  position: relative;
  float: right;
}
h1{
  text-align: center;
}
.market{
  text-align: center;
}

.head {
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;

}
</style>