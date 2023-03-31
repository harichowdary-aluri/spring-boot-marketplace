<template>
    <div>

        <div class="row">
            <div class="card" style="width: 300px" v-on:click="cloth">
                <div class="card-body">
                    <h5 class="card-title">Clothing</h5>
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjCvu31zrBSJgWHVKm-I5f46npWKMxKd_LHg&usqp=CAU"
                        class="card-img-top" alt="Merlin">
                </div>
            </div>
            <div class="card" style="width: 300px" v-on:click="electronic">
                <div class="card-body">
                    <h5 class="card-title">Electronics</h5>
                    <img src="https://media.istockphoto.com/photos/mobile-devices-picture-id178716575?k=20&m=178716575&s=612x612&w=0&h=Cpbs-ivT4RGz--xBlXFrHhTTPX5kaEcRd4FK4koduWM="
                        class="card-img-top" alt="Merlin">
                </div>
            </div>
            <div class="card" style="width: 300px" v-on:click="misc">
                <img class="card-img-top" src="" alt="" />
                <div class="card-body">
                    <h5 class="card-title">Miscellenous</h5>
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQx3Q_6YEaOJuqSV-Yjkglp4rTJFPHovZuMow&usqp=CAU"
                        class="card-img-top" alt="Merlin">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="card" style="width: 300px" v-on:click="utility">
                <img class="card-img-top" src="" alt="" />
                <div class="card-body">
                    <h5 class="card-title">Utilities</h5>
                    <img src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/amazon-rivet-furniture-1533048038.jpg?crop=1.00xw:0.502xh;0,0.423xh&resize=1200:*"
                        class="card-img-top" alt="Merlin">
                </div>
            </div>
            <div class="card" style="width: 300px" v-on:click="auto">
                <img class="card-img-top" src="" alt="" />
                <div class="card-body">
                    <h5 class="card-title">Automobiles</h5>
                    <img src="https://automobiles.honda.com/-/media/Honda-Automobiles/Vehicles/2022/Passport/non-VLP/Global-Nav/MY22-Passport-non-VLP-nav-2x-A.png"
                        class="card-img-top" alt="Merlin">
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Menu from "./Menu.vue";
import * as THREE from 'three';
export default {
    name: 'Home',
    components: {
        Menu
    },
    mounted() {
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
    },
    methods: {
        electronic() {
            //window.location.href = "/#/BuyElectronics";
            this.$router.push('/BuyElectronics')
        },
        cloth() {
            // window.location.href = "/#/BuyClothing";
            this.$router.push("/BuyClothing")
        },
        auto() {
            // window.location.href = "/#/BuyAutomobiles";
            this.$router.push("/BuyAutomobiles")
        },
        utility() {
            // window.location.href = "/#/BuyHousehold";
            this.$router.push("/BuyHousehold")

        },
        misc() {
            this.$router.push("/BuyMiscellenous")
        }
    }
}
</script>

<style scoped>
.card {
  width: calc(33.3% - 10px); /* Set the width of each card to half the screen width minus the margin */
  height: 250px;
  background-color: white;
  border: none;
  box-shadow: 0px 2px 6px rgba(0, 0, 0, 0.2);
  position: relative;
  margin-right: 20px; /* Add a margin between each card */
  margin-bottom: 20px; /* Add a margin between each row */
}
.card:nth-child(1),
.card:nth-child(2),
.card:nth-child(3) {
  top: 0;
  /* Position the first three cards at the top */
  left: 0;
  /* Position the first three cards at the left */
}

.card:nth-child(4),
.card:nth-child(5) {
  top: 0;
  /* Position the last two cards at the top */
  left: calc(66.66% + 20px);
}
</style>
