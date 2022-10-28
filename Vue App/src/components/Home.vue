<template>
    <div>
        <Menu></Menu>
        <div class="row" >
            <div class="card" style="width: 300px">
                <div class="card-body">
                    <h5 class="card-title">Clothing</h5>
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjCvu31zrBSJgWHVKm-I5f46npWKMxKd_LHg&usqp=CAU"
                        class="card-img-top" alt="Merlin">
                </div>
            </div>
            <div class="card" style="width: 300px">
                <div class="card-body">
                    <h5 class="card-title">Electronics</h5>
                    <img src="https://media.istockphoto.com/photos/mobile-devices-picture-id178716575?k=20&m=178716575&s=612x612&w=0&h=Cpbs-ivT4RGz--xBlXFrHhTTPX5kaEcRd4FK4koduWM="
                        class="card-img-top" alt="Merlin">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="card" style="width: 300px">
                <img class="card-img-top" src="" alt="" />
                <div class="card-body">
                    <h5 class="card-title">Utilities</h5>
                    <img src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/amazon-rivet-furniture-1533048038.jpg?crop=1.00xw:0.502xh;0,0.423xh&resize=1200:*"
                        class="card-img-top" alt="Merlin">
                </div>
            </div>
            <div class="card" style="width: 300px">
                <img class="card-img-top" src="" alt="" />
                <div class="card-body">
                    <h5 class="card-title">Vehicles</h5>
                    <img src="https://automobiles.honda.com/-/media/Honda-Automobiles/Vehicles/2022/Passport/non-VLP/Global-Nav/MY22-Passport-non-VLP-nav-2x-A.png"
                        class="card-img-top" alt="Merlin">
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Menu from "./Menu.vue";
export default {
    name: 'Home',
    components: {
        Menu
    }
}
</script>
    
<style>

</style>
    