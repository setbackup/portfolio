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
				<RouterLink class="navbar-item" to="/dashboard">
					Home
				</RouterLink>

				<div class="navbar-item has-dropdown is-hoverable">
					<a class="navbar-link">
						Adhésion
					</a>

					<div class="navbar-dropdown">
						<RouterLink to="/admin/adherent/creer" class="navbar-item">
							Création des adhérants
						</RouterLink>
						<RouterLink to="/admin/adherent/consulter" class="navbar-item">
							Consultation des adhérants
						</RouterLink>
					</div>
				</div>

				<div class="navbar-item has-dropdown is-hoverable">
					<a class="navbar-link">
						Campagne de dons
					</a>

					<div class="navbar-dropdown">
						<RouterLink class="navbar-item" to="/admin/campagne_dons/creation">
							Création d'un campagne de dons
						</RouterLink>
						<RouterLink class="navbar-item" to="/admin/campagne_dons/consulter">
							Consultation d'une campagne de dons
						</RouterLink>
					</div>
				</div>

				<div class="navbar-item has-dropdown is-hoverable">
					<a class="navbar-link">
						Campagne de goodies
					</a>

					<div class="navbar-dropdown">
						<RouterLink class="navbar-item" to="/admin/campagne_goodies/creation">
							Création d'un campagne de dons
						</RouterLink>
						<RouterLink class="navbar-item" to="/admin/campagne_goodies/consulter">
							Consultation d'une campagne de dons
						</RouterLink>
					</div>
				</div>
			</div>

			<div class="navbar-end">
				<div class="navbar-item">
					<div class="buttons">
						<a class="button is-primary">
							<strong>Sign up</strong>
						</a>
						<a class="button is-light" @click="logout()">
							Logout
						</a>
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