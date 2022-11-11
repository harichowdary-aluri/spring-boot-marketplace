<template>
    <b-container fluid  class="container mt-5">
      <b-col md="10" class="top-30 col-md-12"> </b-col>
      <b-col md="4" offset-md="4">
        <div class="forget">
          <h4 class="mt-3">Forget Password</h4>
          <hr class="mb-0" />
          <b-form class="p-4" @submit="forget">
            <b-form-group id="username" label="Enter your email and we will send you a link to reset your password" label-for="username">
              <b-form-input
                id="username"
                class="input-field"
                type="text"
                placeholder="Enter mail ID"
                required
              ></b-form-input>
            </b-form-group>     
            <br />
            <div class="btn-center">
              <b-button variant="primary" type="submit"> Submit </b-button>
            </div>
          </b-form>
        </div>
      </b-col>
    </b-container>
</template>
<script>
  export default {
    name: "forget",
    methods: {
      forget() {},
    },
  };
  </script>
  
  <style scoped>
  .forget {
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