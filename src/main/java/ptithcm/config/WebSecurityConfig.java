package ptithcm.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.service.UserDetailsServiceImpl;
@Configuration
@EnableWebSecurity
@Transactional
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class);

        // nhá»¯ng link cÃ³ báº¯t Ä‘áº§u báº±ng /nguoidung báº¯t Ä‘Äƒng nháº­p quyá»�n USER hay ADMIN Ä‘á»�u dc
        http.authorizeRequests().antMatchers("/nguoidung/**").hasAnyAuthority("USER","ADMIN");
        // Nhá»¯ng link cÃ³ /baiviet khÃ´ng cáº§n Ä‘Äƒng nháº­p
        http.authorizeRequests().antMatchers("/baiviet/**","/resources/**","/Storage/**","/mail/**").permitAll();
        //Nhá»¯ng link cÃ³ /admin báº¯t buá»™c pháº£i cÃ³ quyá»�n admin
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
        //Những người quyền User mà vào trang Admin sẽ đẩy qua page 403
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http.formLogin().loginPage("/login")
                    .defaultSuccessUrl("/baiviet/index")
                    .permitAll() 
                    .and()
                .logout() 
                    .permitAll();
        // Cái dưới này liên quan đến chống tấn công csrf
        http.csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
    }
}