<template>
  <div>
    <h4>Profile</h4>
    <form class="col-lg-6 offset-lg-3">
      <div class="">
        <div class="form-group row">
          <label for="919 Number" class="col-sm-4 col-form-label">919 Number</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" v-model="student.sID" readonly />
          </div>
        </div>
        <div class="form-group row">
          <label for="fname" class="col-sm-4 col-form-label">First Name</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" v-model="student.firstName" required :readonly="this.read" />
          </div>
        </div>
        <div class="form-group row">
          <label for="lname" class="col-sm-4 col-form-label">Last Name</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" v-model="student.lastName" required :readonly="this.read" />
          </div>
        </div>
        <div class="form-group row">
          <label for="Email" class="col-sm-4 col-form-label">Email</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" v-model="student.email" required readonly />
          </div>
        </div>
        <div class="form-group row">
          <label for="phone" class="col-sm-4 col-form-label">Contact number</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" v-model="student.phoneNumber" required :readonly="this.read" />
          </div>
        </div>
        <div class="form-group row">
          <label for="address" class="col-sm-4 col-form-label">Address</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" v-model="student.address" required :readonly="this.read" />
          </div>
        </div>
        <div class="form-group row">
          <label for="city" class="col-sm-4 col-form-label">City</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" v-model="student.city" required :readonly="this.read" />
          </div>
        </div>
        <div class="form-group row">
          <label for="state" class="col-sm-4 col-form-label">State</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" v-model="student.state" required :readonly="this.read" />
          </div>
        </div>
        <div class="form-group row">
          <label for="Zip" class="col-sm-4 col-form-label">Zip code</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" v-model="student.zip" required :readonly="this.read" />
          </div>
        </div>
        <br>
        <br>
        <button type="submit" v-on:click="update" class="btn btn-primary a1">Update</button>
        &nbsp;&nbsp;
        
        <button type="submit" v-on:click="submitProfile" class="btn btn-primary">Submit</button>
        <br>
      </div>
    </form>
  </div>
</template>

<script>
import Menu from "./Menu.vue"

export default (
  {
    name: "MyAccount",
    components: {
      Menu,
      
    },
    mounted() {
      this.getUser();
      
    },
    data() {
      return {
        student: {
          sID: "",
          firstName: "",
          lastName: "",
          email: "",
          phoneNumber: "",
          address: "",
          city: "",
          state: "",
          zip: ""
        },
        read: true
      };
    },
    methods: {
      async getUser() {
        let id = sessionStorage.getItem("user")
        console.log("user in myacount", id)

        this.$axios
          .get(
            "http://localhost:8082/student/" + id
          )
          .then((res) => {
            if (res.status == 200) {
              this.data = res;

              console.log(this.data)
              this.student = this.data.data
              
            }
            else {
              this.data = res;
              console.log(this.data);
              
            }

          });
      },

      async update(){
        this.read = false
      },

      async submitProfile() {
        console.log("submit profile")
        
        let id = sessionStorage.getItem("user")
        this.$axios
          .put("http://localhost:8082/updateProfile/" + id, this.student)

          .then((res) => {
            if (res.status == 200) {
              this.data=res;
            
            console.log(this.data)
            alert('Profile Updated')
            this.student= this.data.data
            this.read= true

            }
            else {
              this.data = res;
              console.log(this.data);
            }

          });

      }

    },
  });
</script>
<style>

</style>