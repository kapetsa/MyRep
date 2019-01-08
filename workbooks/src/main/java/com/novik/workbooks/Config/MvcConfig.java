package com.novik.workbooks.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.integration.spring.BeanInjectingCheckInitializationListener;
import net.sf.oval.integration.spring.SpringValidator;
import org.springframework.validation.Validator;


@Configuration
@ComponentScan("net.sf.oval.integration.spring")
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public Validator getValidator() {
        AnnotationsConfigurer myConfigurer = new AnnotationsConfigurer();
        myConfigurer.addCheckInitializationListener(BeanInjectingCheckInitializationListener.INSTANCE);
        return new SpringValidator(new net.sf.oval.Validator(myConfigurer));
    }


}