/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.RequestFriendDAO;
import db.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author Hoang Hiep
 */
public class ShowFriendController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            /* TODO output your page here. You may use following sample code. */
            
            out.print("Request sent:<br>");
            ArrayList<User> users = UserDAO.showAllUser();
            for (User user : users) {
                String fromUserID = (String) session.getAttribute("sessionmemberid");
                String toUserID = user.getId();
                if(RequestFriendDAO.checkRequestSent(fromUserID, toUserID))
                out.print("<p>"+user.getUserName()+" &emsp; <a href='CancelRequestFriendController?toUserID="+user.getId()+"'>Cancel Request</a>");
            }
            
            out.print("<br><p>User you may know:</p>");
            for (User user : users) {
                String fromUserID = (String) session.getAttribute("sessionmemberid");
                String toUserID = user.getId();
                if(RequestFriendDAO.checkRequestSent(fromUserID, toUserID)==false&&!fromUserID.equals(toUserID))
                out.print("<p>"+user.getUserName()+" &emsp; <a href='AddFriendController?toUserID="+user.getId()+"'>Add Friend</a> <a href=''>Is Colleague</a></p>");
            }
        }
    }
}
