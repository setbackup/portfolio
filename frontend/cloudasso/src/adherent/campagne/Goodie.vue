<template>
    <Menu />

    <div class="container">
        <div class="columns">
            <div class="box">
                <form @submit.prevent="goodies">
                    <div class="control">
                        <input type="number" min="0" v-model="goodie.quantite"/>
                    </div>
                    <button type="submit" class="button is-info">Participer</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import Menu from '../components/Menu.vue';

export default{
    name :'goodies',
    components :{
        Menu
    },
    data() {
        return {
            goodie :{
                id_campagne : this.$route.params.id ,
                quantite : ''
            }
        }
    },
    methods:{
        goodies(){

            const body = JSON.stringify({
                quantite : this.goodie.quantite,
                id_campagne : this.goodie.id_campagne
            });

            console.log(body);

            axios.post('http://localhost:8080/goodies', body, {
                headers:{
                    "Content-Type": "application/json",
                    "Authorization": "bearer " + localStorage.getItem('jeton')
                }
            }).then(reponse => {
                if (response.status == 200) {
                    console.log("SUPER");
                }
            })
        }
    },

}
</script>