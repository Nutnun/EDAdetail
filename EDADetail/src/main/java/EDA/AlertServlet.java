/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA.Servlet;

import EDA.Model.Alert;
import EDA.Model.Disaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "AlertServlet", urlPatterns = {"/AlertServlet"})
public class AlertServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String ampur = "thrung-kru";
        String province = "bangkok";

        Alert alert = new Alert();
        System.out.println("55555555555555555555");
        ArrayList<Disaster> disaster = alert.getDisaster(ampur, province);
        String sriptNoti = "";

        for (int i = 0; i < disaster.size(); i++) {
            sriptNoti +=     "Push.create('Alert notification', {\n"
                    + "        body: '" + disaster.get(i).getDisasterName() +  "',\n"
                    + "        icon: '/images/icons/icon-96x96.png',\n"
                    + "        link: '/detail.jsp?id="+disaster.get(i).getDisasterNo() +"',\n"
                    + "        timeout: 6000,\n"
                    + "        onClick: function () {\n"
                    + "            window.location='/EDA/detail.jsp?disasterid="+disaster.get(i).getDisasterNo()+"';"
                    + "            this.close();\n"
                    + "        }\n"
                    + "    });\n"
                    + "}\n"
                    + "		</script>";
        }

        request.setAttribute("scriptNoti", sriptNoti);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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
