<template>
    <div>
        <br>
        <form class="col-md-12">
            <span class="text-center mb-4 other-account" style="color:red">All the fields with * are mandatory </span>
            <div class="form-group row p-10">
                <label for="Category" class="col-sm-4">Sub-Category*</label>
                <div class="col-sm-6">
                    <select class="independent form-select"  v-model="HouseHold.subcategory">
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
            <div class="form-group row p-10">
                <label for="productName" class="col-sm-4 col-form-label">Product Name*</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="HouseHold.productName" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="noOFDaysUsed" class="col-sm-4 col-form-label ">No Of Days Used</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="HouseHold.daysUsed" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="qtnAvailable" class="col-sm-4 col-form-label">Qty Available*</label>
                <div class="col-sm-6">
                    <input type="number" min="1" class="form-control" v-model="HouseHold.qtyAvailable">
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="price" class="col-sm-4 col-form-label ">Price*</label>
                <div class="col-sm-6">
                    <input type="number" min="0" class="form-control" v-model="HouseHold.price" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="description" class="col-sm-4 col-form-label">Product Description</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="HouseHold.description" />
                </div>
            </div>
            <br>
            <div class="form-group row p-10">
                <label for="formFileMultiple" class="col-sm-4 form-label">Multiple files input*</label>
                <div class="col-sm-6">
                    <input type="file" class="form-control" id="myFile" name="filename" multiple @change="onFileSelected">
                </div>
            </div>
        </form>
        <div style="text-align:center">
            <button type="submit" v-on:click="RegisterProduct" :disabled="isDisabled" class="btn btn-primary b1">SUBMIT</button>
        </div>
    </div>

</template>
<script>
import axios from "axios";
import Vue from 'vue';
import formData from 'form-data';


export default ({
    name: "HouseHold",

    data() {

        return Vue.observable({
            formdata: new formData(),
            HouseHold: {
                subcategory: "",
                productName: "",
                daysUsed: "",
                price:"",
                qtyAvailable: "",
                description: "",
                images: "",
                studentId:"",
                status:"",
                phoneNumber:""
            },
            imgArry: [],
            file:'false'
        });
    },

    computed:
    {
       isDisabled()
       {
        return this.HouseHold.subcategory ===''|| this.HouseHold.productName ==='' || this.HouseHold.price==='' || this.HouseHold.qtyAvailable==='' || this.file==='false';
       }
    },
    methods: {

        onFileSelected(event) {
            this.file='true'
            this.image = event.target.files;
            console.log(this.image, 'img')
            // this.formdata.append('images',this.image)
            console.log(event.target.files.length, "size")
            let size = event.target.files.length
            if (size == 1) {
                this.formdata.append('images', this.image[0])
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
        },

        RegisterProduct(HouseHold) {
            this.HouseHold.studentId= sessionStorage.getItem('user');
            this.HouseHold.status= 'Available'
            this.formdata.append('household', JSON.stringify(this.HouseHold));
            this.$axios
                .post("http://localhost:8082/household/addProduct", this.formdata)
                .then((res) => {
                    if (res.status == 200) {
                        console.log("success")
                        alert("Successfully uploaded the product");
                        window.location.reload();
                    }
                    else {
                        this.data = res;
                        console.log(this.data);
                        //document.getElementById("paragraph").innerHTML = this.data.data;
                    }

                });
        }

    },
});
</script>
<style>

.p-10 {
	  padding-bottom: 10px;
	}
</style>