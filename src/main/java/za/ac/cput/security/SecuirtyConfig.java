package za.ac.cput.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecuirtyConfig
{

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //-- Roles for Chef --
        manager.createUser(User.withUsername("chef-client")
                .password(bCryptPasswordEncoder.encode("54321"))
                .roles("CLIENT")
                .build()
        );

        manager.createUser(User.withUsername("chef-admin")
                .password(bCryptPasswordEncoder.encode("12345"))
                .roles("CLIENT", "ADMIN")
                .build()
        );

        //-- Roles for WaitingStaff --
        manager.createUser(User.withUsername("waitingStaff-client")
                .password(bCryptPasswordEncoder.encode("54321"))
                .roles("CLIENT")
                .build()
        );

        manager.createUser(User.withUsername("waitingStaff-admin")
                .password(bCryptPasswordEncoder.encode("12345"))
                .roles("CLIENT", "ADMIN")
                .build()
        );

        //-- Roles for Entertainment --
        manager.createUser(User.withUsername("entertainment-client")
                .password(bCryptPasswordEncoder.encode("54321"))
                .roles("CLIENT")
                .build()
        );

        manager.createUser(User.withUsername("entertainment-admin")
                .password(bCryptPasswordEncoder.encode("12345"))
                .roles("CLIENT", "ADMIN")
                .build()
        );

        //-- Roles for Date --
        manager.createUser(User.withUsername("date-client")
                .password(bCryptPasswordEncoder.encode("54321"))
                .roles("CLIENT")
                .build()
        );

        manager.createUser(User.withUsername("date-admin")
                .password(bCryptPasswordEncoder.encode("12345"))
                .roles("CLIENT", "ADMIN")
                .build()
        );

        //-- Roles for Payment --
        manager.createUser(User.withUsername("payment-client")
                .password(bCryptPasswordEncoder.encode("54321"))
                .roles("CLIENT")
                .build()
        );

        manager.createUser(User.withUsername("payment-admin")
                .password(bCryptPasswordEncoder.encode("12345"))
                .roles("CLIENT", "ADMIN")
                .build()
        );

        //-- The Roles for Booking -- //
        manager.createUser(User.withUsername("booking-client")
                .password(bCryptPasswordEncoder.encode("54321"))
                .roles("CLIENT")
                .build()
        );

        manager.createUser(User.withUsername("booking-admin")
                .password(bCryptPasswordEncoder.encode("12345"))
                .roles("CLIENT", "ADMIN")
                .build()
        );
        //-- The Roles for Client -- //
        manager.createUser(User.withUsername("client-client")
                .password(bCryptPasswordEncoder.encode("54321"))
                .roles("CLIENT")
                .build()
        );

        manager.createUser(User.withUsername("client-admin")
                .password(bCryptPasswordEncoder.encode("12345"))
                .roles("CLIENT", "ADMIN")
                .build()
        );


        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.httpBasic()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .authorizeRequests()

                // -- The Endpoints for Booking -- //
                .antMatchers(HttpMethod.GET, "/**/booking/read").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/**/booking/all").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.POST, "/**/booking/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/booking/delete").hasRole("ADMIN")

                // -- The Endpoints for Client -- //
                .antMatchers(HttpMethod.GET, "/**/client/read").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/**/client/all").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.POST, "/**/client/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/client/delete").hasRole("ADMIN")

                // -- Endpoints for Chef
                .antMatchers(HttpMethod.GET, "/**/chef/read").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/**/chef/all").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.POST, "/**/chef/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/chef/delete").hasRole("ADMIN")
                // -- Endpoints for WaitingStaff
                .antMatchers(HttpMethod.GET, "/**/waitingStaff/read").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/**/waitingStaff/all").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.POST, "/**/waitingStaff/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/waitingStaff/delete").hasRole("ADMIN")
                // -- Endpoints for Entertainment
                .antMatchers(HttpMethod.GET, "/**/entertainment/read").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/**/entertainment/all").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.POST, "/**/entertainment/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/entertainment/delete").hasRole("ADMIN")
                // -- Endpoints for Date
                .antMatchers(HttpMethod.GET, "/**/date/read").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/**/date/all").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.POST, "/**/date/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/date/delete").hasRole("ADMIN")
                // -- Endpoints for Payment
                .antMatchers(HttpMethod.GET, "/**/payment/read").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/**/payment/all").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.POST, "/**/payment/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/payment/delete").hasRole("ADMIN")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();

    }

}
