<template>
	<nav class="navbar" role="navigation" aria-label="main navigation">
	<div class="container">
		<div class="navbar-brand">
			<RouterLink class="navbar-item" to="/">
				<img src="../../assets/logo.svg" />
			</RouterLink>

			<a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false"
				data-target="navbarBasicExample">
				<span aria-hidden="true"></span>
				<span aria-hidden="true"></span>
				<span aria-hidden="true"></span>
				<span aria-hidden="true"></span>
			</a>
		</div>
		<div  class="navbar-menu">
			<div class="navbar-end">
				<div class="navbar-item">
					<div class="buttons">
						<RouterLink class="button is-primary is-outlined" to="/adhesion">
							<strong>J'adhére</strong>
						</RouterLink>
						<RouterLink class="button is-primary is-outlined" to="/inscription">
							<strong>Asso Party</strong>
						</RouterLink>
						<RouterLink class="button is-primary is-outlined" to="/login">
							<strong>Login</strong>
						</RouterLink>
					</div>
				</div>
			</div>
		</div>
	</div>
	</nav>
</template>


<script>

export default{
	name : "Menu",
	methods:{
		logout(){
			localStorage.removeItem("jeton");
			this.$router.push("/")
		}	
	}
}

</script>