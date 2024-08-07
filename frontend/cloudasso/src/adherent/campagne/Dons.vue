<template>
    <Menu />

    <div class="container">
        <div class="columns">
            <div class="box">
                Donnation
                <form @submit.prevent="donnation">
                    <div class="control">
                        <input type="number" min="0" v-model="don.montant" />
                    </div>
                    <button type="submit" class="button is-info">Donner</button>
                </form>
            </div>
        </div>
    </div>
</template>


<script>
import axios from 'axios';
import Menu from '@/adherent/components/Menu.vue'

export default{
    name : 'donnation',
    data() {
        return {
            don :{
                id_campagne : this.$route.params.id ,
                montant : ''
            }
        }
    },
    mounted(){

    },
    methods:{
        donnation(){

            const body = JSON.stringify({
                montant : this.don.montant,
                id_campagne : this.don.id_campagne
            });

            axios.post('http://localhost:8080/donnations', body, {
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
    components :{
        Menu
    }
}

</script>