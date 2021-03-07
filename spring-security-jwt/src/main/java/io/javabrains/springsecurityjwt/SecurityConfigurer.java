package io.javabrains.springsecurityjwt;

import io.javabrains.springsecurityjwt.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//security configure also needs and annotation which is web security
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //this will call the authUserdetails service and

    auth.userDetailsService(myUserDetailsService);

    }

    @Override
    @Bean
    //this was added becuase otherwise In the helloResource file it doesnt identify that there is a bean called AUthetication Manger when it is autowired.
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }



   @Bean
   public PasswordEncoder passwordEncoder(){

    return NoOpPasswordEncoder.getInstance();

   }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //this disable cross site refference forgery and for /authenticate it permits any ot this. any other requests should be authenticated.
        http.csrf().disable()
                    .authorizeRequests().antMatchers("/authenticate").permitAll().
                    anyRequest().authenticated();

    }
}
