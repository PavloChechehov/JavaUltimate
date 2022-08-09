package com.pch.homework.config;

import com.pch.homework.annotation.Trimmed;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization TrimmedAnnotationBeanPostProcessor");
        Class<?> beanType = bean.getClass();
        boolean annotationPresent = beanType.isAnnotationPresent(Trimmed.class);

        if (annotationPresent) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanType);

            MethodInterceptor methodInterceptor = (obj, method, args, methodProxy) -> {

                System.out.println("Method " + method.getName());
                Object[] newObjectArgs = new Object[args.length];
                for (int i = 0; i < args.length; i++) {
                    Object arg = args[i];
                    if (arg instanceof String s) {
                        newObjectArgs[i] = s.trim();
                    } else {
                        newObjectArgs[i] = arg;
                    }
                }

                Object o = methodProxy.invokeSuper(obj, newObjectArgs);
                if (o instanceof String s) {
                    return s.trim();
                }
                return o;
            };


            enhancer.setCallback(methodInterceptor);
            return enhancer.create();
        }
        return bean;
    }
}
