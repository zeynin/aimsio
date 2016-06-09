package com.vaadin.demo.dashboard;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet (value = "/*", asyncSupported = true)
@VaadinServletConfiguration (productionMode = false, ui = DashboardUI.class, widgetset = "com.vaadin.demo.dashboard.DashboardWidgetSet")
@SuppressWarnings("serial")
public class DashboardServlet extends VaadinServlet
{
    @Override
    protected final void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new DashboardSessionInitListener());
    }

}