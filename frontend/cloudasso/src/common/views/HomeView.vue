<template>

  <Menu />

  <div class="container">
    <div class="section">
      <div class="row columns is-multiline">

        <div class="column is-4" v-for="campagne in campagnes" >
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
              <a href="#" class="card-footer-item">Consulter</a>
              <a href="#" class="card-footer-item">Dons</a>
              <a href="#" class="card-footer-item">Adhérer</a>
            </footer>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>

import Inscription from '@/inscription/Inscription.vue';
import Adhesion from '@/Adhesion.vue';
import Menu from '@/common/components/Menu.vue';
import axios from 'axios';

export default {
  name: "HomeView",
  data() {
    return {
      campagnes: {
        id: '',
        id_association: '',
        nom: '',
        date_debut: '',
        date_fin: ''
      }
    }
  },
  mounted() {
    axios.get('http://localhost:8080/campagnes', {
      headers: {
        "Content-Type": "application/json",
      }
    }).then(response => {
      if (response.status == 200) {
        this.campagnes = response.data;
      }
    })
  },
  components: {
    Inscription,
    Adhesion,
    Menu
  }

}
</script>