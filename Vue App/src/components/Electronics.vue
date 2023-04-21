<template>
    <div>
        <br>
        <form class="col-md-12">
            <span class="text-center mb-4 other-account" style="color:red">All the fields with * are mandatory </span>
            <div class="form-group row p-10">
                <label for="Category" class="col-sm-4">Sub-Category*</label>
                <div class="col-sm-6">
                    <select v-model="Electronics.subcategory" required class="form-select">
                        <option class="form-control">SmartPhone</option>
                        <option class="form-control">Laptop</option>
                        <option class="form-control">TV</option>
                        <option class="form-control">Others</option>
                    </select>
                </div>
            </div>
            <br>
            <div class="form-group row p-10">
                <label for="productName" class="col-sm-4 col-form-label">Product Name*</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Electronics.productName" required />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="modelName" class="col-sm-4">Model Name</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Electronics.modelName" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="dimensions" class="col-sm-4">Dimensions</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="dimensions in inches"
                        v-model="Electronics.dimensions" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="noOFDaysUsed" class="col-sm-4 ">No Of Days Used</label>
                <div class="col-sm-6">
                    <input type="number" min="0" class="form-control" v-model="Electronics.daysUsed" required />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="qtnAvailable" class="col-sm-4">Qty Available*</label>
                <div class="col-sm-6">
                    <input type="number" class="form-control" min="1" v-model="Electronics.qtyAvailable" required>
                </div>
            </div>  
            <div class="form-group row p-10">
                <label for="price" class="col-sm-4">Price*</label>
                <div class="col-sm-6">
                    <input type="number" min="0" class="form-control" v-model="Electronics.price" required />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="description" class="col-sm-4 ">Product Description</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Electronics.description" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="formFileMultiple" class="col-sm-4 form-label">Multiple files input*</label>
                <div class="col-sm-6">
                    <input class="form-control" type="file" multiple id="myFile" name="filename" @change="onFileSelected" />
                </div>
            </div>
        </form>
        <div style="text-align:center">
            <button type="submit" v-on:click="RegisterProduct"  :disabled="isDisabled" class="btn btn-primary b1">SUBMIT</button>
        </div>
    </div>
</template>
<script>
import axios from "axios";
import Vue from 'vue';
import formData from 'form-data';

export default ({
    name: "Electronics",

    data() {
        return Vue.observable({
            formdata: new formData(),

            Electronics: {
                subcategory: "",
                productName: "",
                modelName: "",
                price: "",
                dimensions: "",
                daysUsed: "",
                qtyAvailable: "",
                description: "",
                images: "",
                studentId: "",
                status: "",
                phoneNumber:""

            },
            imgArry: [],
            selectedFiles: [],
            file:'false'

        });
    },

    computed:
    {
       isDisabled()
       {
        return this.Electronics.subcategory ===''|| this.Electronics.productName ==='' || this.Electronics.price==='' || this.Electronics.qtyAvailable==='' || this.file==='false';
       }
    },

    methods: {

        onFileSelected(event) {
            
            this.file='true';
            this.selectedFiles = event.target.files;

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

        RegisterProduct(Electronics) {
            


            this.Electronics.studentId = (sessionStorage.getItem('user'));
            this.Electronics.status = 'Available'
            console.log(this.formdata);
            this.formdata.append('electronics', JSON.stringify(this.Electronics));
            this.$axios
                .post("http://localhost:8082/electronics/addProduct", this.formdata)
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