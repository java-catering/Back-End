package app.config;


import javax.sql.DataSource;

//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter
//{
//    @Autowired
//    DataSource dataSource;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        System.out.println("Entering the security config");
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "SELECT email, password, true FROM user WHERE email = ?"
//                )
//                .authoritiesByUsernameQuery(
//                        "SELECT name, email FROM user JOIN role ON role.id = user.role_id WHERE email = ?"
//                )
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
//}
