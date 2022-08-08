import { createApp } from 'vue'
import { createWebHistory, createRouter } from 'vue-router';
import App from './App.vue'

import HelloWorld from './views/HelloWorld.vue';
import HyundaiApartment from './views/HyundaiApartment.vue';
import Prototye from './views/Prototype.vue';

const router = createRouter({
    history: createWebHistory(),
    routes : [
        {
            path : '/',
            name : 'HelloWorld',
            component : HelloWorld,
        },
        {
            path : '/hyundaiApartment',
            name : 'HyundaiApartment',
            component : HyundaiApartment,
        },
        {
            path : '/5',
            name : 'Prototype',
            component : Prototye,
        }
    ]
})


const app = createApp(App);
app.use(router);

app.mount('#app');