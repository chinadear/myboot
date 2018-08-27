package com.bootplus.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import com.bootplus.core.component.AuthenticationSuccess;
import com.bootplus.core.filter.KaptchaAuthenticationFilter;
import com.bootplus.core.component.AuthUserDetailsServiceImpl;
import com.bootplus.core.component.AuthenticationFailure;

@Configuration
@EnableWebSecurity
public class loginSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationSuccess authenticationSuccess;
	@Autowired
	private AuthenticationFailure authenticationFailure;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    return new BCryptPasswordEncoder();
	}

	@Bean
    UserDetailsService detailsService() {
        return new AuthUserDetailsServiceImpl();
    }
	/**
	 * 配置不拦截的静态资源请求
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/webjars/**", "/css/**", "/lib/**", "/img/**", "/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 //在认证用户名之前认证验证码，如果验证码错误，将不执行用户名和密码的认证
		 http.addFilterBefore(new KaptchaAuthenticationFilter("/login","/auth/login?meg='验证码错误'"), UsernamePasswordAuthenticationFilter.class)
//		http.headers()
        .authorizeRequests()//and()是链接符，and之间的内容有相同的作用域，比如A().B().permitAll();表示A,B都面对全部用户
        .antMatchers("/registerAdmin").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/**/noSecurity/**").permitAll()
        .antMatchers("/liulu/**").permitAll()//antMatchers无需权限 即可访问，permitAll全部用户
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/auth/login")//formlogin登录配置
        .successHandler(authenticationSuccess)//登陆成功处理
        .failureHandler(authenticationFailure)//登录失败的处理
        .loginProcessingUrl("/login")//登录验证处理请求，请求逻辑是security内置的，此处只设置自己喜欢的请求就可以了，然后在表单中提交的请求要与此处设置的一致即可
        .usernameParameter("username").passwordParameter("password").permitAll()//设置security内置的请求表单元素的name名称，此处设置的要与登录表单的用户名密码的name一致
//        .loginProcessingUrl("/login").defaultSuccessUrl("/",true)
//        .failureUrl("/auth/login").permitAll()
//        .and().sessionManagement().invalidSessionUrl("/login")
//        .and().rememberMe().tokenValiditySeconds(1209600)
        .and().headers().frameOptions().disable()
        .and().logout().logoutSuccessUrl("/auth/login").permitAll()//设置登出后跳转的链接，一般设置登录页面，登录请求也是security内置的默认为logout,自定义登录链接用.logoutUrl(logoutUrl)
        .and().csrf().disable();// 关闭csrf防护
	}
	/**
	 * 设置用户信息获取方法，获取方法是自定义的实现security提供的接口即可
	 * 就是通过自定义接口实现获取业务用户的信息包括用户名，密码，权限角色，交给security处理
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(detailsService()).passwordEncoder(passwordEncoder());
		//内存中创建一个系统账号，作为系统默认账号
//		auth.inMemoryAuthentication().withUser("system").password("12345678").roles("SYSTEM");
	}
	@Bean
	public SecurityContextRepository securityContextRepository() {
      //设置对spring security的UserDetails进行session保存,这个必须要有，不然不会保存至session对应的缓存redis中
        HttpSessionSecurityContextRepository httpSessionSecurityContextRepository = 
            new HttpSessionSecurityContextRepository();
        return httpSessionSecurityContextRepository;
    }
}
