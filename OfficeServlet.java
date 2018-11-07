/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OfficeDaoLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Office;

/**
 *
 * @author Keiji
 */
@WebServlet(name = "OfficeServlet", urlPatterns = {"/OfficeServlet"})
public class OfficeServlet extends HttpServlet {
    @EJB
    private OfficeDaoLocal officeDao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String officeIdStr = request.getParameter("studentId");
        int officeId=0;
        if(officeIdStr!=null && !officeIdStr.equals("")){
            officeId=Integer.parseInt(officeIdStr);    
        }
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String centre = request.getParameter("centre");
        
        Office office = new Office(officeId, firstname, lastname, centre);
        
        if("Add".equalsIgnoreCase(action)){
            officeDao.addOffice(office);
        }else if("Edit".equalsIgnoreCase(action)){
            officeDao.editOffice(office);
        }else if("Delete".equalsIgnoreCase(action)){
            officeDao.deleteOffice(officeId);
        }else if("Search".equalsIgnoreCase(action)){
            office = officeDao.getOffice(officeId);
        }
        request.setAttribute("office", office);
        request.setAttribute("allOffices", officeDao.getAllOffices());
        request.getRequestDispatcher("officeinfo.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
