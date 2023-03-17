<template>
  <div class="header " style="overflow-x: hidden">
    <b-navbar toggleable="lg" class="navbarHeader" >
      <h1 class="bs">MARKETPLACE</h1>

      <div v-if=this.isAuthenticated id="asd" v-bind:class="{ds:isAuthenticated==true}">
        <div class="nav-item">
          <span class="user-info">
            <img :src="this.picture" alt="User's profile picture"
              class="nav-user-profile d-inline-block rounded-circle mr-3" width="50" />
            <h6 class="d-inline-block">{{ this.user }}</h6>
          </span>
        </div>

        <font-awesome-icon icon="user" class="mr-3" />
        <!-- <router-link to="/profile">this.user</router-link> -->

        <font-awesome-icon icon="power-off" class="mr-3" />
        <a id="qsLogoutBtn" href="#" class @click.prevent="logout">Log out</a>
      </div>

    </b-navbar>
  </div>

</template>
<script>
import Vue from 'vue';
import RegisterUser from "./RegisterUser.vue";
import Login from "./Login.vue";
export default ({
  name: "APPHeader",
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
  mounted() {
    this.sample();
  },
  methods: {
    logout() {
      sessionStorage.removeItem('user')
      console.log("logout done")
      alert("logout success")
      this.isAuthenticated = false
      window.location.href = "/#/";
    },
    sample() {
      this.user = sessionStorage.getItem('user');
      console.log("user aph", this.user)
      if (this.user != "" && this.user != null) {
        this.isAuthenticated = true
        console.log("user aph1", this.user)
       // window.location.href = "/#/Home";

      }
      // if(this.user == null){
      //   window.location.href = "/";
      // }
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
  height: 60px;

}

.header {
  top: 0px;
  margin: 0px 0px 0px;
  padding: 0px;
}

.bs {
  margin-left: 350px;
}


.ds {
  margin-left: 250px;
}

.as {
  text-align: right;
  margin-left: 210px;
}

.head {
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;

}
</style>