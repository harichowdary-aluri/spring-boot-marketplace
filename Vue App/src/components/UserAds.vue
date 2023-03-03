<template>
    <div class="page-content page-container" id="page-content">
        <h1>ADS Items</h1>
        <div class="row card-container">
            <div class="col mb-4" v-for="c in this.data.data.adsPageItems" :key="c.electronicid">
                <div class="row">
                    <div class="a1">
                        <!-- <img src="..." class="card-img-top" alt="..."> -->
                        <div>
                            <img :src="getimgURL(c)" class="img-radius" alt="User-Profile-Image" height="190"
                                        width="190" id="image1" />
                            <h5 class="card-title">{{ c.productName }}</h5>
                            <p class="card-text">${{ c.price }}</p>
                            <p class="card-text">{{ c.description }}</p>
                            <p class="card-text">{{ c.qtyAvailable }} Available</p>
                            <br />
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <a href="#/home">Home</a>
    </div>
</template>
<script>

import Vue from 'vue';
//import formData from 'form-data';
export default {
    name: "UserAds",
    mounted() {
        this.electronics();
    },
    data() {
        return Vue.observable({

            data: null,
            Electronics: {
                subcategory: "",
                productName: "",
                modelName: "",
                price: "",
                dimensions: "",
                daysUsed: "",
                qtyAvailable: "",
                description: "",
                images: [],
                studentId:"",
            }

        });
    },
    methods: {

        async electronics() {

           this.Electronics.studentId = sessionStorage.getItem('user');
           console.log('id is', this.Electronics.studentId);
            await this.$axios
                .get(
                    "http://localhost:8082/ads/" + this.Electronics.studentId
                )

                .then((res) => {
                    if (res.status == 200) {
                        this.data = res;
                        console.log(JSON.stringify(this.data.data.adsPageItems), "data")
                    }
                });

        },

        getimgURL(c) {

            let img = c.images.split(" ")[0]
            console.log("cccc " + img)
            return img
        },

    },
};
</script>
<style scoped>
.mycarousel {
    width: 90%;
    margin-left: 10px
}

.a1{

height: 600px;
width: 400px;
}
.card {
    flex: 1;
    /* make the cards take up equal space */
}
</style>