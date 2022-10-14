<template>
  <b-container fluid class="container">
    <b-col md="10" class="top-30 col-md-12"> </b-col>
    <b-col md="4" offset-md="4">
      <div class="login">
        <h4 class="mt-3">Log In</h4>
        <hr class="mb-0" />
        <b-form class="p-4" @submit="login">
          <b-form-group id="username" label="Username" label-for="username">
            <b-form-input
              id="username"
              class="input-field"
              type="text"
              placeholder="Enter username"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group id="username" label="Password" label-for="password">
            <b-form-input
              id="password"
              type="password"
              required
              placeholder="Enter password"
              autocomplete="on"
            ></b-form-input>
          </b-form-group>
          <br />
          <div class="btn-center">
            <b-button variant="primary" type="submit"> Login </b-button>
          </div>
        </b-form>
      </div>
    </b-col>
  </b-container>
</template>
<script>
export default {
  name: "Login",
  methods: {
    login() {},
  },
};
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