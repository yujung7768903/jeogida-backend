<template>
    <div id="parking-spot" :class="[_isParked ? 'unavailable' : 'available']">
        {{_parkingSpotNumber}}
    </div>
</template>

<script>
export default {
    name: 'parking-spot',
    props: ['_parkingSpotNumber', '_isParked'],
    components: {
        
    },
    created() {
        
    }
}
</script>

<style>
#parking-spot {
    width: 35px;
    height: 62px;
    line-height: 62px;
}

#parking-spot.available {
    background-color: #C6DBA0;
}

#parking-spot.unavailable {
    background-color: #6D6D6D;
}
</style>
  