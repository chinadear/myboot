package com.bootplus.core.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.google.code.kaptcha.Constants;
/**
 * 验证码校验拦截器，在登陆校验前先校验验证码，如果验证码通过再进行登陆验证，此配置再loginSecurityConfig此类中配置
 * @author angle
 *
 */
public class KaptchaAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private String servletPath;
    public KaptchaAuthenticationFilter(String servletPath, String failureUrl) {
        super(servletPath);
        this.servletPath = servletPath;
        setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(failureUrl));
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if ("POST".equalsIgnoreCase(req.getMethod()) && servletPath.equals(req.getServletPath())) {
            String expect = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (expect != null && !expect.equalsIgnoreCase(req.getParameter("kaptcha"))) {
                unsuccessfulAuthentication(req, res, new InsufficientAuthenticationException("输入的验证码不正确"));
                return;
            }
        }
        chain.doFilter(request, response);
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        return null;
    }

}
