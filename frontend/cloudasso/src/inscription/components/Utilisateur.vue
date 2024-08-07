
<template>
    <div class="field">
        <div>
            <input v-model="nomUtilisateur" id="nom" class="input" type="text" placeholder="nom"  />
        </div>
    </div>
    <div class="field">
        <div>
            <input v-model="prenomUtilisateur" id="prenom" class="input" type="text" placeholder="prenom" />
        </div>
    </div>
    <div class="field">
        <div>
            <input v-model="emailUtilisateur" class="input" type="email" placeholder="email" />
        </div>
    </div>    
    <div>
        <div>
            <input v-model="passwordUtilisateur" class="input" type="password" placeholder="password" />
        </div>
    </div>
</template>

<script setup>

import { reactive, ref } from "vue"

const nomUtilisateur = defineModel('nomUtilisateur')
const prenomUtilisateur = defineModel('prenomUtilisateur')
const emailUtilisateur = defineModel('emailUtilisateur')
const passwordUtilisateur = defineModel('passwordUtilisateur')

const NomhasGood = ref('false')
const NomhasError = ref('false')
</script>

