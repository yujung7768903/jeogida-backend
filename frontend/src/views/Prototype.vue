<template>
    <div id="prototype">
        <parkingSpot
            v-for="parkingInfo in isParked" :key="parkingInfo"
            :_parkingSpotNumber = "parkingInfo.number"
            :_isParked = "parkingInfo.is_parked"
        ></parkingSpot>
    </div>
</template>

<script>
import parkingSpot from '../components/parking-spot.vue'
import axios from "axios"

export default {
    name: 'Prototype',
    components: {
        parkingSpot
    },
    data() {
        return {
            isParked: []
        }
    },
    mounted() {
        this.getParkingInfo();
    },
    methods: {
        getParkingInfo() {
            axios
            .get("http://ec2-3-37-217-255.ap-northeast-2.compute.amazonaws.com:8081/parkinglot/parkinginfo/5")
            .then(res => {
                console.log(res);
                this.setIsParked(res)
            })
            .catch(err => {
                console.log(err);
            })
        },
        setIsParked(res) {
            for (let index = 0; index < res.data.length; index++) {
                    let item = {number: res.data[index].number, is_parked: res.data[index].is_parked}
                    this.isParked.push(item)
                }
        }
    }
}
</script>

<style>
#prototype {
    width: 211px;
    height: 130px;
    border: 2px solid black;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    gap: 10px;
}
</style>
  