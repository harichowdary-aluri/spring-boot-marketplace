<template>
    <div class="header " style="overflow-x: hidden">
      <b-navbar toggleable="lg" class="navbarHeader" fixed>
        <h1 class="bs">MARKETPLACE</h1>
  
        
  
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
        window.location.href = "/#/login";
      },
      sample() {
        this.user = sessionStorage.getItem('user');
        console.log("user ih", this.user)
        if (this.user != "" && this.user != null) {
          this.isAuthenticated = true
          console.log("user in", this.user)
        }
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
    margin-left: 500px;
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