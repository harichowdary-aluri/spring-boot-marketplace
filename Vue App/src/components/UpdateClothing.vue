<template>
    <div>
        <br>
        <form class="offset-lg-3 col-md-6">
            <div class="form-group row ">
                <label for="category" class="col-sm-5 col-form-label">Category</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="this.category" readonly />
                </div>
            </div>
            <div class="form-group row ">
                <label for="sub category" class="col-sm-5 col-form-label">Sub Category</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Clothing.subcategory" readonly />
                </div>
            </div>
            <br>
            <div class="form-group row">
                <label for="productName" class="col-sm-5 col-form-label">Product Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Clothing.productName" />
                </div>
            </div>
            <div class="form-group row">
                <label for="size" class="col-sm-5 col-form-label">Size</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Clothing.size" />
                </div>
            </div>
            <div class="form-group row">
                <label for="colour" class="col-sm-5">Colour</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control"
                        v-model="Clothing.colour" />
                </div>
            </div>
            <div class="form-group row">
                <label for="noOFDaysUsed" class="col-sm-5 ">No Of Days Used</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Clothing.daysUsed" />
                </div>
            </div>
            <div class="form-group row">
                <label for="qtnAvailable" class="col-sm-5">Qty Available</label>
                <div class="col-sm-5">
                    <input type="number" style="width: 190px" value="1" v-model="Clothing.qtyAvailable">
                </div>
            </div>
            <div class="form-group row">
                <label for="price" class="col-sm-5 ">Price</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Clothing.price" />
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-sm-5 ">Product Description</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Clothing.description" />
                </div>
            </div>

            <div class="form-group row ">
                <label for="Category" class="col-sm-5">Status</label>
                <div class="col-sm-5" >
                    <select style="width: 190px" v-model="Clothing.status">
                        <option class="">Available</option>
                        <option class="">Sold</option>
                    </select>
                </div>
            </div>
        </form>
        <br>
        <div style="text-align:center">
            <button type="submit" v-on:click="UpdateProduct" class="btn btn-primary b1">SUBMIT</button>
        </div>
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

        });
    },
    methods: {

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