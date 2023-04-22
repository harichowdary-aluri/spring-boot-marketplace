<template>
    <div>
        <br>
        <form class="col-md-12">
            <span class="text-center mb-4 other-account" style="color:red">All the fields with * are mandatory </span>
            <div class="form-group row p-10">
                <label for="SubCategory" class="col-sm-4">Sub-Category*</label>
                <div class="col-sm-6">
                    <select v-model="Clothing.subcategory" class="form-select">
                        <option class="form-control">Women</option>
                        <option class="form-control">Men</option>
                        <option class="form-control">Kids</option>
                    </select>
                </div>
            </div>
            <br>
            <div class="form-group row p-10">
                <label for="productName" class="col-sm-4 col-form-label">Product Name*</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Clothing.productName" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="size" class="col-sm-4 col-form-label">Size</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Clothing.size" />
                </div>
            </div>
       <!--     <div class="form-group row">
                <label for="size" class="col-sm-5">Size</label>
                <div class="col-sm-5">
                    <input type="Checkbox" id = "XXS" v-model="Clothing.size" value ="XXS">XXS
                    <input type="Checkbox" id = "XS" v-model="Clothing.size" value ="XS">XS
                    <input type="Checkbox" id = "S" v-model="Clothing.size" value ="S">S
                    <input type="Checkbox" id = "M" v-model="Clothing.size" value ="M">M
                    <input type="Checkbox" id = "L" v-model="Clothing.size" value ="L">L
                    <input type="Checkbox" id = "XL" v-model="Clothing.size" value ="XL">XL
                    <input type="Checkbox" id = "XXL" v-model="Clothing.size" value ="XXL">XXL
                </div>
            </div> -->
            <div class="form-group row p-10">
                <label for="colour" class="col-sm-4 col-form-label">Colour</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control"
                        v-model="Clothing.colour" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="noOFDaysUsed" class="col-sm-4 col-form-label">No Of Days Used</label>
                <div class="col-sm-6">
                    <input type="number" min=0 class="form-control" v-model="Clothing.daysUsed" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="qtnAvailable" class="col-sm-4 col-form-label">Qty Available*</label>
                <div class="col-sm-6">
                    <input type="number" min="1" class="form-control" v-model="Clothing.qtyAvailable">
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="price" class="col-sm-4 col-form-label">Price*</label>
                <div class="col-sm-6">
                    <input type="text" min="0" class="form-control" v-model="Clothing.price" />
                </div>
            </div>
            <div class="form-group row p-10">
                <label for="description" class="col-sm-4 col-form-label">Product Description</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" v-model="Clothing.description" />
                </div>
            </div>
            <br>
            <div class="form-group row p-10">
                <label for="formFileMultiple" class="col-sm-4 form-label">Multiple files input*</label>
                <div class="col-sm-6">
                    <input class="form-control" type="file" id="myFile" name="filename" multiple @change="onFileSelected">
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
    name: "Clothing",

    data() {
        return Vue.observable({
            formdata: new formData(),
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
        return this.Clothing.subcategory ===''|| this.Clothing.productName ==='' || this.Clothing.price==='' || this.Clothing.qtyAvailable==='' || this.file==='false';
       }
    },
    methods: {

        onFileSelected(event) {
            this.file='true';
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

        RegisterProduct(Clothing) {
            this.Clothing.studentId = (sessionStorage.getItem('user'));
            this.Clothing.status='Available'
            console.log(this.Clothing, 'Clothing object');
            this.formdata.append('clothing', JSON.stringify(this.Clothing));
            this.$axios
                .post("http://localhost:8082/clothing/addProduct", this.formdata)
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