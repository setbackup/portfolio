<template>
    <Menu />

    <table class="table is-fullwidth">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Date debut</th>
                <th>Date fin</th>
                <th>Prix</th>
                <th>Quantite</th>
                <th>Consulter</th>
                <th>Supprimer</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="campagneGoodies in campagnesGoodies" :key="campagnesGoodies.name">
                <td>{{ campagneGoodies.nom }}</td>
                <td>{{ campagneGoodies.date_debut }}</td>
                <td>{{ campagneGoodies.date_fin }}</td>
                <td>{{ campagneGoodies.prix }}</td>
                <td>{{ campagneGoodies.quantite }}</td>
                <td><RouterLink>
                        <img width="25" height="25" src="../../assets/loupe.png" />
                    </RouterLink></td>
                <td><RouterLink>
                        <img width="25" height="25" src="../../assets/corbeille.png" />
                    </RouterLink></td>
            </tr>
        </tbody>
    </table>
</template>

<script>

import Menu from '@/admin/components/Menu.vue'
import axios from 'axios';

export default{
    name: 'CampagneDonsConsulter',
    data(){
        return {
            campagnesGoodies : []
        }
    },
    methods:{

    },
    mounted(){
        axios.get('http://localhost:8080/campagne_goodies/consulter', {
                   headers:{
                       "Content-Type" : "application/json",
                       "Authorization" : "bearer "+localStorage.getItem('jeton')
                   } 
           }).then(response => {

                   if(response.status == 200){
                       console.log(response.data);
                       //this.$router.replace('/dashboard')*
                       this.campagnesGoodies = response.data;
                   }
           })
    },
    components:{
        Menu
    }
}
</script>