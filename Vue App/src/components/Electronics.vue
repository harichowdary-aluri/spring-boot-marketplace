<template>
    <div>
        <br>
        <form class="offset-lg-3 col-md-6">
            <div class="form-group row ">
                <label for="Category" class="col-sm-5">Sub-Category</label>
                <div class="col-sm-6">
                    <select v-model="Electronics.subcategory">
                        <option class="form-control">SmartPhone</option>
                        <option class="form-control">Laptop</option>
                        <option class="form-control">TV</option>
                        <option class="form-control">Others</option>
                    </select>
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
                    <input type="number" value="1" v-model="Electronics.qtyAvailable">
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
    name: "Electronics",

    data() {
        return {
            Electronics: {
                electronicsId: "",
                subcategory: "",
                productName: "",
                modelName: "",
                price:"",
                dimensions: "",
                daysUsed: "",
                qtyAvailable: "",
                description: "",
                image: ""
            }
        };
    },
    methods: {

        onFilesSelected(event) {
            this.Electronics.image = event.target.files[0];
        },

        RegisterProduct() {
            axios.post
        }

    },
});
</script>
<style>

</style>