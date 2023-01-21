<template>
    <div>
        <h3>Sell your Products</h3>
        <br>
        <form class="offset-lg-3 col-md-6">
            <div class="form-group row">
                <label for="Category" class="col-sm-5">Category</label>
                <div class="col-sm-5">
                    <select v-model="p" @change= 'render(p)'>
                        <option class="form-control">Electronics</option>
                        <option class="form-control">Clothing</option>
                        <option class="form-control">Automobiles</option>
                        <option class="form-control">Household Utilities</option>
                        <option class="form-control">Others</option>
                    </select>
                </div>
            </div>
        </form>
        <Electronics v-if=E></Electronics>
        <Clothing v-if=C></Clothing>
        <Automobiles v-if=A></Automobiles>
        <HouseHold v-if=H></HouseHold>
        <Others v-if=O></Others>
    </div>
</template>

<script>
 import Electronics from "./Electronics.vue"
 import Clothing from "./Clothing.vue"
 import Automobiles from "./Automobiles.vue"
 import HouseHold from "./HouseHold.vue"
 import Others from "./Others.vue"

 export default ({
    name: "AddProduct",
    components: {
          Electronics,
          Clothing,
          Automobiles,
          HouseHold,
          Others
      },
      
    data() {
        
      return {
        E:false,
        C:false,
        A:false,
        H:false,
        O:false,
        p:"false"
      };
    },
    methods: {
      render(p){
        if(p == "Electronics"){
          console.log("inside E ")
            this.C= false;
            this.A= false;
            this.H = false;
            this.E = true;
            this.O = false;
            
        }
        if(p == "Clothing"){
          console.log("inside c ")
            this.E = false;
            this.A= false;
            this.H= false;
            this.C = true;
            this.O = false;
            
        }
        if(p == "Automobiles"){
          console.log("inside Auto ")
            this.E = false;
            this.H = false;
            this.C= false;
            this.A = true;
            this.O = false;
            
        }
        if(p == "Household Utilities"){
          console.log("inside U ")
            this.E = false;
            this.C= false;
            this.A= false;
            this.H = true;
            this.O = false;
            
        }
        if(p == "Others"){
          console.log("inside O ")
            this.E = false;
            this.C= false;
            this.A= false;
            this.H = false;
            this.O = true;
            
        }


       
      }
      
    },
  });

</script>
