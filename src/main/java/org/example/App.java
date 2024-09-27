package org.example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.example.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * Hello world!
 *
 * @author mrawa_ltf
 */
public class App implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(WebConfig.class);
//
//        servletContext.addListener(new ContextLoaderListener(context));
//
//
//        var appServlet = servletContext.addServlet("dispatcher", new DispatcherServlet((context)));
//        appServlet.setLoadOnStartup(1);
//        appServlet.addMapping("/");
    }
}
