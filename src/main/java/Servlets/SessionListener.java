package Servlets;

import dao.DaoObjects;
import dbConnection.DBConnection;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener extends DaoObjects implements HttpSessionListener{

    DBConnection dbConnection;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        dbConnection.getDBConnection();
        System.out.println("SessionListener : sessionCreated:Id=" + se.getSession().getId() + " created");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        psClose();
        System.out.println("SessionListener :sessionDestroyed:Id=" + se.getSession().getId() + " destroyed");
        dbConnection.closeConnection();
    }
}
