<template>
    <div>
        <br>
        <form class="offset-lg-3 col-md-6">
            <div class="form-group row ">
                <label for="Category" class="col-sm-5">Sub-Category</label>
                <div class="col-sm-6">
                    <select v-model="Automobiles.subcategory">
                        <option class="form-control">Cars</option>
                        <option class="form-control">Trucks</option>
                        <option class="form-control">2-Wheelers</option>
                        <option class="form-control">Others</option>
                    </select>
                </div>
            </div>
            <br>
            <div class="form-group row">
                <label for="productName" class="col-sm-5 col-form-label">Product Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Automobiles.productName" />
                </div>
            </div>
            <div class="form-group row">
                <label for="productName" class="col-sm-5 col-form-label">Company Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Automobiles.companyName" />
                </div>
            </div>
            <div class="form-group row">
                <label for="modelName" class="col-sm-5">Model Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Automobiles.modelName" />
                </div>
            </div>
            <div class="form-group row">
                <label for="dimensions" class="col-sm-5">Capacity</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" placeholder="No of seats"
                        v-model="Automobiles.capacity" />
                </div>
            </div>
            <div class="form-group row">
                <label for="noOFDaysUsed" class="col-sm-5 ">No Of Days Used</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Automobiles.daysUsed" />
                </div>
            </div>
            <div class="form-group row">
                <label for="qtnAvailable" class="col-sm-5">Qty Available</label>
                <div class="col-sm-5">
                    <input type="number" value="1" v-model="Automobiles.qtyAvailable">
                </div>
            </div>
            <div class="form-group row">
                <label for="price" class="col-sm-5 ">Price</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Automobiles.price" />
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-sm-5 ">Product Description</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="Automobiles.description" />
                </div>
            </div>
            <br>
            <div class="form-group row">
                <div class="col-sm-5">
                    <input type="file" id="myFile" name="filename" multiple @change="onFileSelected">
                </div>
            </div>
        </form>
        <div style="text-align:center">
            <button type="submit" v-on:click="RegisterProduct" class="btn btn-primary b1">SUBMIT</button>
        </div>
    </div>

</template>
<script>
import axios from "axios";


export default ({
    name: "Automobiles",

    data() {
        return {
            Automobiles: {
                automobilesId: "",
                subcategory: "",
                productName: "",
                companyName:"",
                price:"",
                modelName: "",
                capacity: "",
                daysUsed: "",
                qtyAvailable: "",
                description: "",
                image: ""
            }
        };
    },
    methods: {

        onFileSelected(event) {
            this.Automobiles.image = event.target.files[0];
        },

        RegisterProduct() {
            axios.post
        }

    },
});
</script>
<style>

</style>