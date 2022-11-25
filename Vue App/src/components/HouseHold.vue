<template>
    <div>
        <br>
        <form class="offset-lg-3 col-md-6">
            <div class="form-group row ">
                <label for="Category" class="col-sm-5">Sub-Category</label>
                <div class="col-sm-6">
                    <select class="independent" v-model="HouseHold.subcategory">
                        <optgroup class="form-control" label="KitchenEquipment"> 
                          <option class="form-control">Drying Rack</option>
                          <option class="form-control">Pot Holder</option>
                          <option class="form-control">Cutlery</option>
                          <option class="form-control">Cutting Board</option>
                          <option class="form-control">Baking Pan</option>
                          <option class="form-control">Non Stick Pan</option>
                          <option class="form-control">Drinking Glasses</option>
                          <option class="form-control">Plates</option>
                          <option class="form-control">Others</option>
                        </optgroup>
                        <optgroup class="form-control" label="Furniture"> 
                          <option class="form-control">Coffe/Side table</option>
                          <option class="form-control">Bed Frame</option>
                          <option class="form-control">Pillow</option>
                          <option class="form-control">Garment Rack</option>
                          <option class="form-control">Others</option>
                        </optgroup>
                        <optgroup class="form-control" label="Decor"> 
                          <option class="form-control">Bath Towels</option>
                          <option class="form-control">Comforter</option>
                          <option class="form-control">Clock</option>
                          <option class="form-control">Lamp</option>
                          <option class="form-control">Flower vase</option>
                          <option class="form-control">Mirror</option>
                          <option class="form-control">Others</option>
                        </optgroup>
                    </select>
                </div>
            </div>
            <br>
            <div class="form-group row">
                <label for="productName" class="col-sm-5 col-form-label">Product Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="HouseHold.productName" />
                </div>
            </div>
            <div class="form-group row">
                <label for="noOFDaysUsed" class="col-sm-5 ">No Of Days Used</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="HouseHold.daysUsed" />
                </div>
            </div>
            <div class="form-group row">
                <label for="qtnAvailable" class="col-sm-5">Qty Available</label>
                <div class="col-sm-5">
                    <input type="number" value="1" v-model="HouseHold.qtyAvailable">
                </div>
            </div>
            <div class="form-group row">
                <label for="price" class="col-sm-5 ">Price</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="HouseHold.price" />
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-sm-5 ">Product Description</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" v-model="HouseHold.description" />
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
    name: "HouseHold",

    data() {
        return {
            HouseHold: {
                houseHoldId: "",
                subcategory: "",
                productName: "",
                daysUsed: "",
                price:"",
                qtyAvailable: "",
                description: "",
                image: ""
            }
        };
    },
    methods: {

        onFileSelected(event) {
            this.HouseHold.image = event.target.files[0];
        },

        RegisterProduct() {
            axios.post
        }

    },
});
</script>
<style>

</style>