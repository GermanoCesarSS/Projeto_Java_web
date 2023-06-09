package controller;

import dao.BrinquedoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Brinquedo;
import model.Marca;

@WebServlet(name = "GravarBrinquedo", urlPatterns = {"/GravarBrinquedo"})
public class GravarBrinquedo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            int codigoBrinquedo = request.getParameter("codigoBrinquedo").isEmpty() 
                    ? 0 : Integer.parseInt(request.getParameter("codigoBrinquedo"));
            
            String nomeBrinquedo = request.getParameter("nomeBrinquedo");
            
            int codigoMarca = Integer.parseInt(request.getParameter("codigoMarca"));
            Marca marca = new Marca();
            marca.setCodigoMarca(codigoMarca);
            
            Brinquedo Brinquedo = new Brinquedo(codigoBrinquedo, nomeBrinquedo, marca);
            
            BrinquedoDAO BrinquedoDAO = new BrinquedoDAO();
            BrinquedoDAO.gravar(Brinquedo);
            
            request.setAttribute("mensagem", "Brinquedo gravado com sucesso");    
        }
        catch(SQLException | ClassNotFoundException ex){
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("ListarBrinquedo")
                .forward(request, response);
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
