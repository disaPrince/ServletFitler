package com.example.Anelya.servlets;

import com.example.Anelya.dataBase.userDataBase;
import com.example.Anelya.model.user;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.Anelya.model.user.NAME.IITU;
import static com.example.Anelya.model.user.NAME.KBTU;

public class Base implements ServletContextListener {

    private AtomicReference<userDataBase> data;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        data = new AtomicReference<>(new userDataBase());
        data.get().add(new user(1, "IITU", "1234", IITU));
        data.get().add(new user(2, "KBTU", "1234", KBTU));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("data", data);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        data = null;
    }
}
