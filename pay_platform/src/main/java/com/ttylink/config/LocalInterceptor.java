package com.ttylink.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.JSONObject;
@Configuration // 申明这是一个配置
public class LocalInterceptor extends WebMvcConfigurerAdapter {

	protected static Logger logger = LoggerFactory.getLogger(LocalInterceptor.class);

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor handler = new HandlerInterceptor() {

			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				PrintWriter out = null;
				String requestURI = request.getRequestURI();
				String contextPath = request.getContextPath();
				String url = requestURI.substring(contextPath.length());
				logger.info("url:" + url);
				System.out.println("----------------------" + url);
				if ("/error".equals(url)) {
					JSONObject res = new JSONObject();
					res.put("state", "-1");
					res.put("message", "用户超时，请重新登陆");
					out = response.getWriter();
					out.append(res.toString());
					response.sendError(999);
					return false;
				}

				return HandlerInterceptor.super.preHandle(request, response, handler);
			}

			/**
			 * 该方法将在Controller执行之后，返回视图之前执行，
			 * modelAndView表示请求Controller处理之后返回的Model和View对象，所以可以在
			 * 这个方法中修改modelAndView的属性，从而达到改变返回的模型和视图的效果。
			 */
			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				System.out.println("我进入了拦截器方法————————————————————postHandle");
				HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
			}

			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
					Exception ex) throws Exception {
				System.out.println("我进入了拦截器方法————————————————————afterCompletion");
				HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
			}

		};
		registry.addInterceptor(handler).addPathPatterns("/**");
	}

}
