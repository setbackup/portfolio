<template>
    <Menu />
    <div class="container">
        <div class="columns">
        <div class="column is-three-fifths is-offset-one-fifth">
            <form class="box" @submit.prevent="login(email, password)">
                <div class="field">
                    <p class="control has-icons-left has-icons-right">
                        <label for="email">Email</label>
                        <input class="input is-rounded" type="email" v-model="email" placeholder="Email">
                        <span class="icon is-small is-left">
                            <i class="fas fa-envelope"></i>
                        </span>
                        <span class="icon is-small is-right">
                            <i class="fas fa-check"></i>
                        </span>
                    </p>
                </div>
                <div class="field">
                    <p class="control has-icons-left">
                        <label for="password">Password</label>
                        <input class="input is-rounded" type="password" v-model="password" placeholder="Password">
                        <span class="icon is-small is-left">
                            <i class="fas fa-lock"></i>
                        </span>
                    </p>
                </div>
                <div class="field">
                    <p class="control">
                        <button class="button is-success">
                            Login
                        </button>
                    </p>
                </div>
                <div v-show="error === true" class="notification is-danger">
                    Erreur d'identification
                </div>
            </form>
        </div>
    </div>
    </div>
</template>

<script>
import Menu from '@/common/components/Menu.vue';
import axios from 'axios';

export default{
    data(){
        return{
            email : '',
            password : '',
            error : false
        }
    },
    methods:{
        login(email, password){
            
            const bodyLogin = JSON.stringify({
                email :  email,
                password : password
            });

            axios.post('http://localhost:8080/login',bodyLogin, {
                headers:{
                    "Content-Type" : "application/json"
                } 
            }).then(response => {
                
                if(response.status == 202){
                   
                   localStorage.setItem('jeton', response.data.jeton )
                   
                   if(response.data.admin){
                    this.$router.replace('/dashboard')
                   }
                   else{
                    this.$router.replace('/accueil')
                   } 
                }
                else{
                    this.error=true;
                }
            })
        },       
    },
    components:{
        Menu
    }
}

</script>
