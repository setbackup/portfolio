<template>

    <Menu />
    
    <div class="container">
        <div class="columns">
            <div class="column is-three-fifths is-offset-one-fifth">
                <form class="box" @submit.prevent="addAdhesion">
                    <div>
                        <label class="label">Adhesion à l'association</label>
                        <div class="select">
                            <select v-model="adhesion.id_association">
                                <option v-for="association in associations" v-bind:value="association.id">{{ association.nom }}
                                </option>
                            </select>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Nom</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Nom" v-model="adhesion.nom" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Prenom</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Prenom" v-model="adhesion.prenom" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Email</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Email" v-model="adhesion.email" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Password</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Password" v-model="adhesion.password" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Adresse</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Adresse" v-model="adhesion.adresse" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Ville</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Ville" v-model="adhesion.ville" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Code postal</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Code postal" v-model="adhesion.code_postal" />
                        </div>
                    </div>
                    <button class="button is-info is-outlined" type="submit">Adhesion</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>

import axios from 'axios';
import Menu from '@/common/components/Menu.vue';

export default{
    name: 'adhesion',
    data(){
        return {
            associations : [],
            adhesion:{
                nom : '',
                prenom : '',
                email : '',
                password : '',
                adresse : '',
                code_postal : '',
                ville : '',
                id_association : ''
            }
        }
    },
    mounted(){
        axios.get('http://localhost:8080/adhesion', {
            headers:{
                "Content-Type" : "application/json",
            } 
        }).then(response => {
            console.log(response.data);
            if(response.status == 200){
                
                this.associations = response.data;
            }
        })
    },
    methods:{
        addAdhesion(){

            const body = JSON.stringify({
                nom : this.adhesion.nom,
                prenom : this.adhesion.prenom,
                email : this.adhesion.email,
                password : this.adhesion.password,
                adresse : this.adhesion.adresse,
                code_postal : this.adhesion.code_postal,
                ville : this.adhesion.ville,
                id_association : this.adhesion.id_association
            });
            console.log(body);
            axios.post('http://localhost:8080/adhesion',body,{
                headers:{
                    "Content-Type" : "application/json"
                }
            }).then(response => {
                console.log(response);
            })
        }
    },
    components:{
        Menu
    }
}
</script>