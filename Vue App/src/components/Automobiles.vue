<template>
    <div>
        <br>
        <form class="col-md-12">
            <span class="text-center mb-4 other-account" style="color:red">All the fields with * are mandatory </span>
            <div class="form-group row p-10">
                <label for="Category" class="col-sm-4">Sub-Category*</label>
                <div class="col-sm-6">
                    <select v-model="Automobiles.subcategory" required class="form-select">
                        <option class="form-control">Cars</option>
                        <option class="form-control">Trucks</option>
                        <option class="form-control">2-Wheelers</option>
                        <option class="form-control">Others</option>
                    </select>
                </div>
            </div>
            <br>
            <div class="form-group row p-10">
                <label for="productName" class="col-sm-4 col-form-label">Product Name*</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Automobiles.productName" required />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="productName" class="col-sm-4 col-form-label">Company Name</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Automobiles.companyName" required />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="modelName" class="col-sm-4 col-form-label">Model Name</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Automobiles.modelName" required/>
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="capacity" class="col-sm-4 col-form-label">Capacity</label>
                <div class="col-sm-6">
                    <input type="number" min="0" class="form-control" placeholder="No of seats"
                        v-model="Automobiles.capacity" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="noOFDaysUsed" class="col-sm-4 col-form-label ">No Of Days Used</label>
                <div class="col-sm-6">
                    <input type="number" class="form-control" min="0" v-model="Automobiles.daysUsed" required />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="qtnAvailable" class="col-sm-4 col-form-label">Qty Available*</label>
                <div class="col-sm-6">
                    <input type="number" min="1" class="form-control" v-model="Automobiles.qtyAvailable" required>
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="price" class="col-sm-4 form-label ">Price*</label>
                <div class="col-sm-6">
                    <input type="number" min="0" class="form-control" v-model="Automobiles.price" required/>
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="description" class="col-sm-4 form-label ">Product Description</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Automobiles.description" required />
                </div>
            </div>
            <br>
            <div class="form-group row p-10">
                <label for="formFileMultiple" class="col-sm-4 form-label">Multiple files input*</label>
                <div class="col-sm-6">
                    <input type="file" id="myFile" class="form-control" name="filename" multiple @change="onFileSelected" required>
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
    name: "Automobiles",

    data() {
        return Vue.observable({
            formdata: new formData(),
            Automobiles: {
                subcategory: "",
                productName: "",
                modelName: "",
                price: "",
                capacity: "",
                daysUsed: "",   
                qtyAvailable: "",
                description: "",
                images: "",
                studentId:"",
                status:"",
                phoneNumber: ""

            },
            imgArry: [],
            file:'false'

        });
    },

    computed:
    {
       isDisabled()
       {
        return this.Automobiles.subcategory ===''|| this.Automobiles.productName ==='' || this.Automobiles.price==='' || this.Automobiles.qtyAvailable==='' || this.file==='false';
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

        RegisterProduct(Automobiles) {
            this.Automobiles.studentId = (sessionStorage.getItem('user'));
            this.Automobiles.status='Available'
            this.formdata.append('automobiles', JSON.stringify(this.Automobiles));
            this.$axios
                .post("http://localhost:8082/automobiles/addProduct", this.formdata)
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