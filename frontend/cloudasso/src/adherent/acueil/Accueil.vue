<template>

    <Menu />
    
    <div class="container">
        <div class="section">
            <div class="row columns is-multiline">

                <div class="column is-4" v-for="campagne in campagnes">
                    <div class="card large" :id=campagne.id_association>
                        <header class="card-header">
                            <p class="card-header-title">{{ campagne.nom }}</p>
                            <button class="card-header-icon" aria-label="more options">
                                <span class="icon">
                                    <i class="fas fa-angle-down" aria-hidden="true"></i>
                                </span>
                            </button>
                        </header>
                        <div class="card-content">
                            <div class="content">
                                Association : <br />
                                Du {{ campagne.date_debut }} au {{ campagne.date_fin }} <br />
                                <time datetime="2016-1-1">11:09 PM - 1 Jan 2016</time>
                            </div>
                        </div>
                        <footer class="card-footer">
                            <RouterLink :to="'/adherent/campagne/'+campagne.id" class="card-footer-item" >Consulter</RouterLink>
                            <RouterLink :to="'/adherent/donnation/'+campagne.id" class="card-footer-item" v-if="campagne.type == 'don'" >Dons</RouterLink>
                            <RouterLink :to="'/adherent/goodie/'+campagne.id" class="card-footer-item" v-if="campagne.type == 'goodies'">Acheter</RouterLink>
                        </footer>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>


<script>

import axios from 'axios';
import Menu from '@/adherent/components/Menu.vue';

export default {
    name: "accueil",
    data(){
      return {
        campagnes: {
          type : '',
          id: '',
          id_association:'',
          nom: '',
          date_debut: '',
          date_fin: ''
        }
      } 
    },
    mounted() {
        axios.get('http://localhost:8080/adherent/campagnes', {
            headers: {
                "Content-Type": "application/json",
                "Authorization": "bearer " + localStorage.getItem('jeton')
            }
        }).then(response => {

            if (response.status == 200) {
                this.campagnes = response.data;
            }
        })
    },
    methods: {
        logout() {
            localStorage.removeItem("jeton");
            this.$router.push("/")
        }
    },
    components: {
        Menu
    }
}

</script>