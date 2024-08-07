<template>
    <Menu />

    <div class="container">
        <div class="columns">
            <div class="box">
                <h3 class="title is-3">Camapgne</h3>
                <p>Nom : {{ this.campagne.nom }}</p>
                <p>Période {{ this.campagne.date_debut }} au {{ this.campagne.date_fin }}</p>
                <p>Prix : {{ this.campagne.prix }}</p>
                <div>

                </div>
            </div>
        </div>
    </div>
</template>



<script>
import axios from 'axios';
import Menu from '@/adherent/components/Menu.vue';

export default{
    name:"campange",
    data(){
        return {
            campagne :{
                associations :{
                    id : '',
                    nom : '',
                    adresse : '',
                    code_postal : '',
                    ville : ''
                },
                nom : '',
                id : '',
                prix : '',
                date_debut : '',
                date_fin : '',
                quantite : ''
            }
        }
    
    },
    mounted(){
        let id_campagne = this.$route.params.id;

        axios.get('http://localhost:8080/adherent/campagnes/'+id_campagne, {
            headers:{
                "Content-Type" : "application/json",
                "Authorization": "bearer " + localStorage.getItem('jeton')
            } 
        }).then(response => {
            if(response.status == 200){
                this.campagne = response.data;
            }
        })
    },
    components: {
        Menu
    }
}
</script>