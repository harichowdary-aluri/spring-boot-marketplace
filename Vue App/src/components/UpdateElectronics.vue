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
                    <input type="text" class="form-control" v-model="Electronics.subcategory" readonly />
                </div>
            </div>
            <br>
            <div class="form-group row">
                <label for="productName" class="col-sm-5 col-form-label">Product Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Electronics.productName" />
                </div>
            </div>
            <div class="form-group row">
                <label for="modelName" class="col-sm-5">Model Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Electronics.modelName" />
                </div>
            </div>
            <div class="form-group row">
                <label for="dimensions" class="col-sm-5">Dimensions</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" placeholder="dimensions in inches"
                        v-model="Electronics.dimensions" />
                </div>
            </div>
            <div class="form-group row">
                <label for="noOFDaysUsed" class="col-sm-5 ">No Of Days Used</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Electronics.daysUsed" />
                </div>
            </div>
            <div class="form-group row">
                <label for="qtnAvailable" class="col-sm-5">Qty Available</label>
                <div class="col-sm-5">
                    <input type="number" style="width: 190px" value="1" v-model="Electronics.qtyAvailable">
                </div>
            </div>
            <div class="form-group row">
                <label for="price" class="col-sm-5 ">Price</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Electronics.price" />
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-sm-5 ">Product Description</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Electronics.description" />
                </div>
            </div>

            <div class="form-group row ">
                <label for="Category" class="col-sm-5">Status</label>
                <div class="col-sm-5" >
                    <select style="width: 190px" v-model="Electronics.status">
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
    name: "UpdateElectronics",
    mounted() {
        this.productId=  sessionStorage.getItem("electronicId");
        this.getData(this.productId);
    },

    data() {
        return Vue.observable({
            formdata: new formData(),
            productId: "",
            category: "Electronics",
            Electronics: {
                id: "",
                subcategory: "",
                productName: "",
                modelName: "",
                price: "",
                dimensions: "",
                daysUsed: "",
                qtyAvailable: "",
                description: "",
                images: "",
                status:""

            },

        });
    },
    methods: {

        UpdateProduct(Electronics) {
            this.Electronics.id= this.productId;
            this.$axios
            .put("http://localhost:8082/electronics/updateElec",this.Electronics)
                .then((res) => {
                    if (res.status == 200) {
                        this.data = res;

                        console.log(this.data)
                        this.Electronics = this.data.data
                        this.Electronics.category= 'Electronics'
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
                    "http://localhost:8082/electronics/product/" + id
                )
                .then((res) => {
                    if (res.status == 200) {
                        this.data = res;

                        console.log(this.data)
                        this.Electronics = this.data.data
                        this.category= 'Electronics'

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