<template>
  <b-container fluid class="container">
    <b-col md="10" class="top-30 col-md-12"> </b-col>
    <b-col md="4" offset-md="4">
      <div class="login">
        <h4 class="mt-3">Log In</h4>
        <hr class="mb-0" />
        <b-form class="p-4" @submit.prevent="loginUser">
          <b-form-group id="username" label="Username" label-for="username">
            <b-form-input id="username" class="input-field" type="text" v-model="login.username"
              placeholder="Enter username" required></b-form-input>
          </b-form-group>

          <b-form-group id="username" label="Password" label-for="password">
            <b-form-input id="password" type="password" required placeholder="Enter password" v-model="login.password"
              autocomplete="on"></b-form-input>
          </b-form-group>
          <br />

          <div class="col-md-8">
            <router-link to="/Forgetpassword">Forgot Password</router-link>
            &nbsp;&nbsp;&nbsp;<router-link to="/register">Signup</router-link>
          </div>
          <div class="col-md-11"> <b-button variant="primary" type="submit"> Login </b-button></div>



        </b-form>
      </div>
    </b-col>
  </b-container>
</template>
<script>

export default (
  {
    name: "Login",

    data() {
      return {
        login: {
          username: "",
          password: ""
        }
      };
    },

    methods: {
      async loginUser() {
        console.log("inside method")
        console.log(this.login);

        await this.$axios
          .post("http://localhost:8082/login", this.login)
          .then((res) => {
            if (res.status == 200) {
              this.data = res;

              // console.log(this.data , "res")
             alert(this.data.data);

              if (this.data.data == "Login successful") {
                //console.log("Inside successfull login");
                 sessionStorage.setItem('user', this.login.username);
                 localStorage.setItem("loggedIn","true")
                //  console.log("Inside successfull login 2");
                //window.location.href = "/#/Home";
                window.location.href = "/Home";
                  // this.$router.push('/Home')

              }
              else if (this.data.data === "User is not registered, Please sign in") 
              {
                this.$router.push('/register')
              }

              else
              {
                this.$router.push('/')
              }

              
             
            }
            else {
              this.data = res;
              // console.log(this.data);
              alert(this.data.data);
            }

          });
      },
    
      Forgot() {
    //    this.$router.push('/Forgetpassword')
      }
    },
  }
);
</script>

<style scoped>
.login {
  border: 1px solid #ccc;
  border-radius: 10px;
  margin-bottom: 69px;
}

.m-t-4 {
  margin-top: 2px;
}

.top-30 {
  margin-top: 5%;
  margin-bottom: 25px;
}

@media (min-width: 1025px) and (max-width: 1200px) {
  .top-30 {
    margin-bottom: 90px;
  }
}
</style>