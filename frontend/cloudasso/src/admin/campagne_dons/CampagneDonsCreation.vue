<template>
    <Menu />
    <div class="container">
        <div class="columns">
            <div class="column is-three-fifths is-offset-one-fifth">
                <p class="title">
                    Creation d'une campagne de dons
                </p>
                <form class="box" @submit.prevent="addCampagneDons">
                    <div class="field">
                        <label class="label">Nom de la campagne</label>
                        <div class="control">
                            <input class="input" type="text" v-model="campagne_dons.nom" placeholder="Text input">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Date début</label>
                        <input type="date" id="start" name="trip-start" v-model="campagne_dons.date_debut"
                            value="2024-07-22" min="2020-01-01" max="2035-12-31" />
                    </div>
                    <div class="field">
                        <label class="label">Date fin</label>
                        <input type="date" id="start" name="trip-start" v-model="campagne_dons.date_fin"
                            value="2024-07-22" min="2020-01-01" max="2035-12-31" />
                    </div>
                    <div class="field">
                        <label class="label">Objectif</label>
                        <input type="number" id="tentacles" v-model="campagne_dons.objectif" name="tentacles" min="1"
                            max="10000" />
                    </div>
                    <button type="submit" class="button is-info">Valider</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>

import Menu from '@/admin/components/Menu.vue'
import axios from 'axios';

export default{
    name: 'CampagneDonsCreation',
    data(){
        return {
            campagne_dons: {
                nom:'',
                date_debut:'',
                date_fin:'',
                objectif:''
            }
        }
    },
    methods:{
        addCampagneDons(){
            const body = JSON.stringify({ 
                nom :  this.campagne_dons.nom,
                date_debut : this.campagne_dons.date_debut,
                date_fin : this.campagne_dons.date_fin,
                objectif : this.campagne_dons.objectif
            });

            console.log(body)

            axios.post('http://localhost:8080/campagnes_dons/creation', body, {
                    headers:{
                        "Content-Type" : "application/json",
                        "Authorization" : "bearer "+localStorage.getItem('jeton')
                    } 
            }).then(response => {
                    if(response.status == 202){
                        console.log("enregistrer");
                        //this.$router.replace('/dashboard')
                    }
            })

        }   
    },
    components:{
        Menu
    }
}
</script>
