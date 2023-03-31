<template>
  <div class="background">
    <b-container id="mainContainer" align-v="center">

      <b-row align-v="center" align-h="center">
        <b-col md="6">
          <div>
            <b-card id="cardLogin" >
              <b-form @submit.prevent="onSubmit" v-if="show" id="formRegister">


                <h1 class="text-center mb-3" style="color: #1f5a7c">Register</h1>
                <span class="text-center mb-4 other-account">Please register yourself</span>
                <b-form-group id="input-group-1" label-for="919 Number">
                  <b-form-input id="919" class="input" v-model="student.sID" type="text" placeholder="919 Number"
                    required></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-1" label-for="FirstName">
                  <b-form-input id="first" class="input" v-model="student.firstName" type="text" placeholder="First Name"
                    required></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-1" label-for="LastName">
                  <b-form-input id="last" class="input" v-model="student.lastName" type="text" placeholder="Last Name"
                    required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-1" label-for="Password">
                  <b-form-input id="password" class="input" v-model="student.password" placeholder="Password"
                    type="password" required></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-1" label-for="ConfirmPassword">
                  <b-form-input id="confirm" class="input" v-model="student.confirmPassword"
                    placeholder="Confirm Password" type="password" required></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-1" label-for="email">
                  <b-form-input id="email" class="input" v-model="student.email" type="text" placeholder="Email address"
                    required></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-1" label-for="phoneNumber">
                  <b-form-input id="phone" class="input" v-model="student.phoneNumber" type="text"
                    placeholder="Phone Number" required></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-1" label-for="address">
                  <b-form-input id="address" class="input" v-model="student.address" type="text" placeholder="Address"
                    required></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-1" label-for="city">
                  <b-form-input id="city" class="input" v-model="student.city" type="text" placeholder="City"
                    required></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-1" label-for="state">
                  <b-form-input id="state" class="input" v-model="student.state" type="text" placeholder="State"
                    required></b-form-input>
                </b-form-group>
                <b-form-group id="input-group-1" label-for="zip">
                  <b-form-input id="zip" class="input" v-model="student.zip" type="text" placeholder="ZipCode"
                    required></b-form-input>
                </b-form-group>
                <!-- <div class="d-flex justify-content-center mt-3">
        <b-button type="submit" variant="primary" class="btn-login"
          >Entrar <font-awesome-icon icon="arrow-right" class="arrow"
        /></b-button>
      </div> -->
      <br>

                <b-form-group id="input-group-1" label-for="zip">
                  <b-button variant="primary" type="submit"> Register </b-button>
                </b-form-group>
              </b-form>
            </b-card>
          </div>
        </b-col>
      </b-row>
    </b-container>

  </div>
</template>

<script>

export default {
  name: "LoginForm",
  created() {
    console.log("as")
    require('@/assets/background.jpg')
  },
  data() {
    return {
      student: {
        sID: "",
        firstName: "",
        lastName: "",
        password: "",
        confirmPassword: "",
        email: "",
        phoneNumber: "",
        address: "",
        city: "",
        state: "",
        zip: ""
      },
      show: true,
    };
  },

  methods: {
    async onSubmit(event) {
      console.log('login', JSON.stringify(this.student));
      //alert(JSON.stringify(this.login));

      await this.$axios
        .post("http://localhost:8082/register", this.student)
        .then((res) => {
          if (res.status == 200) {
            this.data = res;
            // console.log(this.data)
            alert(this.data.data);
            if(this.data.data=='Student is already registered')
            window.location.href = "/register"
            else
            window.location.href = "/"

          }
          else {
            this.data = res;
            // console.log(this.data);
            alert(this.data.data);
           
          }

        });
    },
  },
};
</script>

<style lang="scss">
@import "../assets/scss/animations.scss";
@import "../assets/scss/variables.scss";
@import "../assets/scss/fonts.scss";
@import "node_modules/bootstrap/scss/bootstrap.scss";

.background {
  background-image: url("") !important;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100vh;

}

body {
  //font-family: $OpenSans !important;
}

#cardLogin {
  margin-top: 30px;
  margin-left: 64px;
  border-radius: 15px;
  box-shadow: 0px 0px 10px $gray;

  #formRegister {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 20px;
    position: relative;

    h1 {
      color: $primary;
      font-weight: 700;
      font-family: $Poppins;
    }

    h2 {
      font-size: 1.2rem;
      color: $lightBlack;
      font-weight: 600;
      font-family: $Poppins;
    }

    .other-account {
      color: $gray;
    }

    .icons {
      width: 30px;
      cursor: pointer;
    }

    .input {
      border-radius: 10px;
    }

    .remember {
      color: $lightBlack;
    }

    .blob {
      position: absolute;
      top: -15%;
      left: -12%;
      width: 150px;
      opacity: 0.2;
    }
  }

  /* .logoLogin {
    margin: 0 auto;
    width: 100px;
  } */

  .forgotPassword {
    color: $gray;
    text-decoration: none;

    &:hover {
      color: #1f5a7c;
      transition: 0.5s ease-in-out;
    }
  }

  /* .btn-login {
    width: 200px;
    background-color: $primary;
    border: none;
    font-size: 1.3rem;
    font-weight: 600;
    border-radius: 10px;

    &:hover {
      background-color: $secondary;
      transition: 0.5s ease-in-out;
    }
  } */

  .arrow-btn {
    width: 100px;
    border-radius: 15px;
    background: $primary;
    color: #fff;
    font-size: 60px;
    padding: 5px;
    box-shadow: -4px 4px 4px rgba(0, 0, 0, 0.25);

    &:hover {
      background: $secondary;
      transition: 0.5s ease-in-out;
      box-shadow: none;
    }
  }

  .register {
    span {
      color: $lightBlack;
    }

    .createAccount {
      color: $primary;
      text-decoration: none;
    }
  }

  #mainContainer {
    width: 100%;
    height: auto;
    position: relative;
  }


}
</style>