<template>
    <div class="page-content page-container" id="page-content">

        <h1>Electronics List</h1>
        <div class="row">
            <div class="col mb-4" v-for="c in this.data.data" :key="c.electronicid">
                <div class="row">
                    <div class="a1">
                        <!-- <img src="..." class="card-img-top" alt="..."> -->
                        <div>
                            <carousel class="mycarousel" :perPage="1" :navigationEnabled="true" :paginationEnabled="true">
                                <slide v-for="(image, index) in c.images" :key="index">
                                    <img :src="image" class="img-radius" alt="User-Profile-Image" height="190" width="190"
                                        id="image1" />
                                </slide>
                            </carousel>
                            <h5 class="card-title">{{ c.productName }}</h5>
                            <p class="card-text" v-if="c.price" style="color: blue">${{ c.price }}</p>
                            <p class="card-text" v-if="c.description" style="color: rebeccapurple">{{ c.description }}</p>
                            <p class="card-text" v-if="c.modelName" style="color: gray">Model: {{ c.modelName }}</p>
                            <p class="card-text" v-if="c.daysUsed" style="color: red">{{ c.daysUsed }} Days used</p>
                            <p class="card-text" v-if="c.qtyAvailable" style="color: royalblue">{{ c.qtyAvailable }} Available</p>
                            <p class="card-text" v-if="c.dimensions" style="color: purple">{{ c.dimensions }} inches</p>
                            <font-awesome-icon icon="phone" class="rotate-icon" style="color: green;"/> 
                            <span style="margin-left:7px;">{{c.qtyAvailable}}</span>
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
import { Carousel, Slide } from 'vue-carousel';
import formData from 'form-data';
export default {
    name: "BuyElectronics",
    components: {
        Carousel,
        Slide
    },
    mounted() {
        this.electronics();
    },
    /*mounted() {
        this.electronics();
        const scene = new THREE.Scene();
        const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
        const renderer = new THREE.WebGL1Renderer({
            canvas: document.querySelector('#bg'),
        });

        renderer.setPixelRatio(window.devicePixelRatio);
        renderer.setSize(window.innerWidth, window.innerHeight);
        camera.position.setZ(30);

        // create a loader for loading 3D models
        const loader = new GLTFLoader();

        // loop over each card element and load a 3D model for it
        const cards = document.querySelectorAll('.card');
        cards.forEach((card, index) => {
            // load the 3D model for the card
            loader.load('/path/to/card-model.gltf', gltf => {
                // get the card mesh from the loaded model
                const cardMesh = gltf.scene.children[0];

                // set the position and rotation of the card mesh to match the position and rotation of the card element in the DOM
                const boundingRect = card.getBoundingClientRect();
                cardMesh.position.set((boundingRect.left + boundingRect.right) / 2 - window.innerWidth / 2, -1 * ((boundingRect.top + boundingRect.bottom) / 2 - window.innerHeight / 2), 0);
                cardMesh.rotation.y = Math.PI * 2 * index / cards.length;

                // add the card mesh to the scene
                scene.add(cardMesh);
            });
        });

        // render the scene
        function animate() {
            requestAnimationFrame(animate);
            renderer.render(scene, camera);
        }
        animate();
    },*/
    data() {
        return Vue.observable({

            formdata: new formData(),

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
                images: []
            }

        });
    },
    methods: {

        async electronics() {
            await this.$axios
                .get(
                    "http://localhost:8082/electronics/electronics"
                )

                .then((res) => {
                    if (res.status == 200) {
                        this.data = res;
                        console.log(this.data.data, "data")
                        for (let i = 0; i < this.data.data.length; i++) {
                            let imageurl = this.getimgsURL(this.data.data[i])
                            var s = imageurl.split(" ")
                            let len = s.length
                            console.log(s.length, " leng")
                            var url = []
                            if (len == 1)
                                url = s
                            else {
                                for (let j = 0; j < len - 1; j++) {
                                    console.log(s[j] + "   image in s")
                                    console.log(JSON.stringify(this.data.data[i].images) + "   image data")
                                    url[j] = s[j]
                                    console.log(JSON.stringify(url[j]) + " post  image data")
                                }
                            }
                            this.data.data[i].images = url
                        }
                    }
                });

        },

        getimgURL(c) {

            let img = c.images.split(" ")[0]
            console.log("cccc " + img)
            return img
        },

        getimgsURL(c) {
            var imgsarrz = c.images
            console.log("multiple images" + imgsarrz)
            return imgsarrz
        }
    },
};
</script>
<style scoped>
.mycarousel {
    width: 90%;
    margin-left: 10px
}

.a1 {   

    height: 600px;
    width: 400px;
}


.card {
    flex: 1;
    /* make the cards take up equal space */
}

.rotate-icon {
  transform: rotate(90deg); /* Apply rotation to the icon */
}

</style>
