<template>
    <div class="field">
        <div>
            <input v-model="nomAssociation" id="name_association" class="input" type="text" placeholder="Nom de l'association" />
        </div>
    </div>
    <div class="field">
        <div>
            <input v-model="adressAssociation" class="input" type="text" placeholder="Adresse de l'association" />
        </div>
    </div>
    <div class="field">
        <div>
            <input v-model="codepostalAssociation" class="input" type="text" placeholder="Code Postal" />
        </div>
        <div>
            <input v-model="villeAssociation" class="input" type="text" placeholder="Ville" />
        </div>
    </div>
</template> 

<script setup>

const nomAssociation = defineModel('nomAssociation')
const adressAssociation = defineModel('adressAssociation')
const codepostalAssociation = defineModel('codepostalAssociation')
const villeAssociation = defineModel('villeAssociation')

</script>