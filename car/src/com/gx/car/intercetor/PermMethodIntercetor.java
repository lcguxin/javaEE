package com.gx.car.intercetor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class PermMethodIntercetor implements MethodInterceptor{
	
	/**
	 * invoke 方法是aop生成代理对象后，反射执行的逻辑
	 */
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	



}
