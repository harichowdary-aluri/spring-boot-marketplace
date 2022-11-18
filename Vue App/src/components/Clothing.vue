<template>
    <div>
        <br>
        <form class="offset-lg-3 col-md-6">
            <div class="form-group row ">
                <label for="SubCategory" class="col-sm-5">Sub-Category</label>
                <div class="col-sm-6">
                    <select v-model="Clothing.subcategory">
                        <option class="form-control">Women</option>
                        <option class="form-control">Men</option>
                        <option class="form-control">Kids</option>
                    </select>
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
                <label for="size" class="col-sm-5">Size</label>
                <div class="col-sm-5">
                    <input type="Checkbox"  v-model="Clothing.size" value ="yes">XXS
                    <input type="Checkbox"  v-model="Clothing.size" value ="yes">XS
                    <input type="Checkbox"  v-model="Clothing.size" value ="yes">S
                    <input type="Checkbox"  v-model="Clothing.size" value ="yes">M
                    <input type="Checkbox"  v-model="Clothing.size" value ="yes">L
                    <input type="Checkbox"  v-model="Clothing.size" value ="yes">XL
                    <input type="Checkbox"  v-model="Clothing.size" value ="yes">XXL
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
                    <input type="number" value="1" v-model="Clothing.qtyAvailable">
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
    name: "Clothing",

    data() {
        return {
            Clothing: {
                clothingId: "",
                subcategory: "",
                productName: "",
                size: "",
                colour: "",
                daysUsed: "",
                qtyAvailable: "",
                price: "",
                description:"",
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