package com.zaynukov.dev.config.bpp;

import com.zaynukov.dev.annotation.Profiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
class ProfilingBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class<?>> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, clazz);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    (o, method, args) -> {
                        long start = System.nanoTime();
                        Object result = method.invoke(bean, args);
                        long finish = System.nanoTime();
                        System.out.println("--\nВремя выполнения метода = " + (finish - start));
                        return result;
                    });
        }

        return bean;
    }
}
