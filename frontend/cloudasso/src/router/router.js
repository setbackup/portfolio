import { createRouter, createWebHistory } from 'vue-router'

import Login from '@/Login.vue'
import HomeView from '@/common/views/HomeView.vue'
import Dashboard from '@/admin/Dashboard.vue'


import AdherentCreation from '@/admin/adherent/AdherentCreation.vue'
import AdherentConsulter from '@/admin/adherent/AdherentConsulter.vue'

import DetailCampagneDons from '@/admin/campagne_dons/DetailCampagneDons.vue'
import CampagneDonsCreation from '@/admin/campagne_dons/CampagneDonsCreation.vue'
import CampagneDonsConsulter from '@/admin/campagne_dons/CampagneDonsConsulter.vue'

import DetailCampagneGoodies from '@/admin/campagne_goodies/DetailCampagneGoodies.vue'
import CampagneGoodiesCreation from '@/admin/campagne_goodies/CampagneGoodiesCreation.vue'
import CampagneGoodiesConsulter from '@/admin/campagne_goodies/CampagneGoodiesConsulter.vue'

import Inscription from '@/inscription/Inscription.vue'
import Adhesion from '@/Adhesion.vue'

import Accueil from '@/adherent/acueil/Accueil.vue'
import DetailCampagne from '@/adherent/campagne/Campagne.vue'
import Donnation from '@/adherent/campagne/Dons.vue'
import Goodie from '@/adherent/campagne/Goodie.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: HomeView
    },
    {
      path: '/login',
      component : Login
    },
    {
      path: '/inscription',
      component : Inscription
    },
    {
      path: '/dashboard',
      component: Dashboard

    },
    {
      path:'/admin/adherent/creer',
      component : AdherentCreation
    },
    {
      path:'/admin/adherent/consulter',
      component : AdherentConsulter
    },
    {
      path: '/admin/campagne_dons/creation',
      component: CampagneDonsCreation

    },
    {
      path: '/admin/campagne_dons/consulter',
      component: CampagneDonsConsulter
    },
    {
      path: '/admin/campagne_dons/details/:id',
      component: DetailCampagneDons
    },
    {
      path: '/admin/campagne_goodies/creation',
      component: CampagneGoodiesCreation
    },
    {
      path: '/admin/campagne_goodies/consulter',
      component: CampagneGoodiesConsulter
    },
    {
      path: '/admin/campagne_goodies/details/:id',
      component:  DetailCampagneGoodies
    },
    {
      path: '/adhesion',
      component: Adhesion
    },
    {
      path: '/accueil',
      component: Accueil

    },
    {
      path: '/adherent/campagne/:id',
      component: DetailCampagne
    },
    {
      path: '/adherent/donnation/:id',
      component: Donnation
    },
    {
      path: '/adherent/goodie/:id',
      component: Goodie
    }
  ]
})

export default router
