SPRING SECURITY PROJECT
-------------------------------------------------------------------------------------

Proyecto Spring Boot que utiliza Spring Security para autenticar y autorizar el 
acceso a URLs dependiendo del "rol" o si el usuario ha sido autenticado.

La clase SecurityConfiguration define las URLs de acceso público y privado:


```

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/init").permitAll()
                .antMatchers("/private").authenticated()
                .antMatchers("/admin").hasRole("ADMIN")
                .and().formLogin().and().logout();
    }

```

