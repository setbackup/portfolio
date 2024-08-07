<template>
    <Menu />
    <div class="container">
        <div class="columns">
            <div class="column is-three-fifths is-offset-one-fifth">
                <form class="box" @submit.prevent="sendInscription">
                    <h3> Inscription Association</h3>
                    <Utilisateur v-model:nom-utilisateur="nom_utilisateur"
                        v-model:prenom-utilisateur="prenom_utilisateur" v-model:email-utilisateur="email_utilisateur"
                        v-model:password-utilisateur="password_utilisateur" />

                    <Association v-model:nom-association="nom_association"
                        v-model:adress-association="adress_association"
                        v-model:codepostal-association="codepostal_association"
                        v-model:ville-association="ville_association" />

                    <button class="button is-primary" type="submit">inscription</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script setup>

import Menu from '@/common/components/Menu.vue';
import Utilisateur from './components/Utilisateur.vue';
import Association from './components/Association.vue';


import axios from 'axios';
import { ref }  from 'vue' ;


const nom_utilisateur = ref('');
const prenom_utilisateur = ref('');
const email_utilisateur = ref('');
const password_utilisateur = ref('')

const nom_association = ref('')
const adress_association = ref('')
const codepostal_association = ref('')
const ville_association = ref('')

const sendInscription = function defineSendInscription(){

    const bodyInscription = JSON.stringify({
        nom : nom_utilisateur.value,
        prenom : prenom_utilisateur.value,
        email : email_utilisateur.value,
        password : password_utilisateur.value,
        association: {
            nom : nom_association.value,
            adresse : adress_association.value,
            codePostal : codepostal_association.value,
            ville : ville_association.value
        }
    });

    axios.post('http://localhost:8080/inscription',bodyInscription, {
        headers:{
            "Content-Type" : "application/json"
        } 
    }).then((response) => console.log(response))
}

</script>

