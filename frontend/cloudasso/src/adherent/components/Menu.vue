<template>
	<nav class="navbar" role="navigation" aria-label="main navigation">
		<div class="navbar-brand">
			<a class="navbar-item" href="https://bulma.io">
				<img src="../../assets/logo.svg" />
			</a>

			<a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false"
				data-target="navbarBasicExample">
				<span aria-hidden="true"></span>
				<span aria-hidden="true"></span>
				<span aria-hidden="true"></span>
				<span aria-hidden="true"></span>
			</a>
		</div>

		<div id="navbarBasicExample" class="navbar-menu">
			<div class="navbar-start">
				<RouterLink class="navbar-item" to="/">
					Home
				</RouterLink>
			</div>


			<div class="navbar-end">
				<div class="navbar-item">
					<div class="buttons">
						<RouterLink class="button is-danger is-outlined" to="/" @click="logout()">
							Logout
						</RouterLink>
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