<template>
    <div class="background" style="background-color: azure; height: 850px;">
        <b-container id="mainContainer" align-v="center">

            <b-row align-v="center" align-h="center">
                <b-col md="6">
                    <div>
                        <b-card id="cardLogin" style="background-color: aliceblue;">
                            <b-form v-if="show" id="formRegister">
                                <h2 class="text-center mb-3" style="color: #1f5a7c">Update product information</h2>
                                <b-form-group id="input-group-1" label="Category" label-for="Category" style="color: gray">
                                    <b-form-input id="category" class="input" v-model="this.category" type="text"
                                        placeholder="Category" readonly></b-form-input>
                                </b-form-group>
                                <b-form-group id="input-group-1" label="Sub Category" label-for="Sub Category"
                                    style="color: gray">
                                    <b-form-input id="subcategory" class="input" v-model="Clothing.subcategory"
                                        type="text" placeholder="Subcategory" required></b-form-input>
                                </b-form-group>
                                <b-form-group id="input-group-1" label="Product Name" label-for="productName"
                                    style="color: gray">
                                    <b-form-input id="productName" class="input" v-model="Clothing.productName"
                                        type="text" placeholder="ProductName" required></b-form-input>
                                </b-form-group>

                                <b-form-group id="input-group-1" label="Size" label-for="size"
                                    style="color: gray">
                                    <b-form-input id="size" class="input" v-model="Clothing.size"
                                        placeholder="Size" type="text"></b-form-input>
                                </b-form-group>
                                <b-form-group id="input-group-1" label="Color" label-for="color"
                                    style="color: gray">
                                    <b-form-input id="color" class="input" v-model="Clothing.colour"
                                        placeholder="Colour" type="text"></b-form-input>
                                </b-form-group>
                                <b-form-group id="input-group-1" label-for="noOFDaysUsed" label="No of Days Used"
                                    style="color: gray">
                                    <b-form-input id="noOFDaysUsed" class="input" v-model="Clothing.daysUsed" type="text"
                                        placeholder="Days Used"></b-form-input>
                                </b-form-group>
                                <b-form-group id="input-group-1" label-for="qtnAvailable" label="Quantity Available"
                                    style="color: gray">
                                    <b-form-input id="qtnAvailable" class="input" v-model="Clothing.qtyAvailable"
                                        type="number" placeholder="Qty Available" min="1" required></b-form-input>
                                </b-form-group>
                                <b-form-group id="input-group-1" label-for="price" label="Price" style="color: gray">
                                    <b-form-input id="price" class="input" v-model="Clothing.price" type="text"
                                        placeholder="Price" required></b-form-input>
                                </b-form-group>
                                <b-form-group id="input-group-1" label="Product Description" label-for="description"
                                    style="color: gray">
                                    <b-form-input id="description" class="input" v-model="Clothing.description"
                                        type="text" placeholder="Product Description" ></b-form-input>
                                </b-form-group>
                                <!-- <div class="d-flex justify-content-center mt-3">
          <b-button type="submit" variant="primary" class="btn-login"
            >Entrar <font-awesome-icon icon="arrow-right" class="arrow"
          /></b-button>
        </div> -->
                                <br>



                            </b-form>
                        </b-card>
                        <br>
                        
                    </div>
                </b-col>

                <b-col>
                    <div>
                        <b-card id="cardLogin" style="background-color: aliceblue;">
                            <h6 class="text-center mb-3" style="color: #1f5a7c">Status and Attachments</h6>
                            <div class="form-group row ">
                                <label for="Category" class="col-sm-5" style="color: gray">Status</label>
                                <div class="col-sm-5">
                                    <select style="width: 190px" v-model="Clothing.status" class="form-control">
                                        <option class="">Available</option>
                                        <option class="">Sold</option>
                                    </select>
                                </div>
                            </div>
                            <br>
                            <br>
                            <div class="form-group row">

                                <div class="col-sm-5">
                                    <input type="file" id="myFile" name="filename" multiple @change="onFileSelected">
                                </div>
                            </div>
                        </b-card>
                    </div>
                </b-col>
            </b-row>
        </b-container>
        <b-button variant="primary" type="submit" @click="UpdateProduct"> Update </b-button>

    </div>
</template>

<script>

import Vue from 'vue';
import formData from 'form-data';

export default ({
    name: "UpdateClothing",
    mounted() {
        this.productId=  sessionStorage.getItem("clothingId");
        this.getData(this.productId);
    },

    data() {
        return Vue.observable({
            formdata: new formData(),
            productId: "",
            category: "Clothing",
            Clothing: {
                subcategory: "",
                productName: "",
                size: "",
                colour: "",
                daysUsed: "",
                qtyAvailable: "",
                price: "",
                description:"",
                images: "",
                status:""
            },

            imgArry: [],
            show: true

        });
    },
    methods: {
        onFileSelected(event) {
            this.image = event.target.files;
            console.log(this.image, 'img')
            // this.formdata.append('images',this.image)
            console.log(event.target.files.length, "size")
            let size = event.target.files.length
            if (size == 1) {
                this.formdata.append('images', this.image[0])
                console.log("image1" ,this.formdata.append.length)
            }
            else {
                console.log("Inside", size)
                for (let i = 0; i < size; i++) {

                    this.imgArry[i] = this.image[i];

                    console.log(this.imgArry[i], "insides for")
                     this.formdata.append('images', this.imgArry[i]);
                }

               // this.formdata.append('images[]', this.imgArry);
                /* this.imgArry.forEach(function (element) {
                     console.log("index ", element);
                 });*/

            }
            this.formdata.forEach(function (value, key) {
                console.log(key + ": image" + JSON.stringify(value));
            });

            this.Clothing.id= this.productId;
            this.$axios
            .post("http://localhost:8082/clothing/updateProductImages/"+this.Clothing.id, this.formdata)
                .then((res) => {
                    if (res.status == 200) {
                        this.data = res;

                        console.log(this.data)
                        //this.Electronics = this.data.data
                        //this.Electronics.category= 'Electronics'
                        //alert("Successfully updated the images");
                        //window.location.href="/#/Ads"
                        //this.$router.push("/Ads")

                    }
                    else {
                        this.data = res;
                        console.log(this.data);

                    }

                });

        },

        UpdateProduct(Electronics) {
            this.Clothing.id= this.productId;
            this.$axios
            .put("http://localhost:8082/clothing/updateCloth",this.Clothing)
                .then((res) => {
                    if (res.status == 200) {
                        this.data = res;

                        console.log(this.data)
                        this.Clothing = this.data.data
                        this.category= 'Clothing'
                        alert("Successfully updated the product");
                        //window.location.href="/#/Ads"
                        this.$router.push("/Ads")

                    }
                    else {
                        this.data = res;
                        console.log(this.data);

                    }

                });
        },
        async getData(id) {
            
            this.$axios
                .get(
                    "http://localhost:8082/clothing/product/" + id
                )
                .then((res) => {
                    if (res.status == 200) {
                        this.data = res;

                        console.log(this.data)
                        this.Clothing = this.data.data
                        this.category= 'Clothing'

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

<style lang="scss">
@import "../assets/scss/animations.scss";
@import "../assets/scss/variables.scss";
@import "../assets/scss/fonts.scss";
@import "node_modules/bootstrap/scss/bootstrap.scss";

.background {
    
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
    border-radius: 25px;
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


}</style>