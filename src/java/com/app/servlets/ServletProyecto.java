package com.app.servlets;

import com.app.controlador.ControladorProyecto;
import com.app.modelo.conexion.ConexionBD;
import com.app.modelo.dto.ProyectoUsuarioDTO;
import com.app.modelo.vo.ProyectoVO;
import com.app.modelo.vo.UsuarioVO;
import com.app.utils.exceptions.ProyectoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletProyecto", urlPatterns = {"/Proyecto"})
public class ServletProyecto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int idFicha = Integer.parseInt(request.getParameter("idFicha"));
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String nombreProyecto = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String fechaInicio = request.getParameter("fechainicio");
            SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
            Date fecha = new Date(formato.parse(fechaInicio).getTime());
            String fechaFin = request.getParameter("fechafin");
            SimpleDateFormat formato1 = new SimpleDateFormat("dd/mm/yyyy");
            Date fecha1 = new Date(formato1.parse(fechaFin).getTime());

            ProyectoVO vo = new ProyectoVO();
            ProyectoUsuarioDTO vt = new ProyectoUsuarioDTO();
            vo.setIdFichas(idFicha);
            vt.setUv(new UsuarioVO());
            vt.getUv().setIdUsuario(idUsuario);
            vo.setNombreProyecto(nombreProyecto);
            vo.setDescripcion(descripcion);
            vo.setFechaInicio(fecha);
            vo.setFechaFin(fecha1);

            try {
                Connection cnn = ConexionBD.getConexionBD();
                ControladorProyecto control = new ControladorProyecto(cnn);
                ProyectoVO idProyecto = control.crearProyecto(vo);
                vt.setPv(idProyecto);
                control.usuarioProyecto(vt);
                ConexionBD.desconectarBD(cnn);
            } catch (ProyectoException prex) {
                System.out.println(prex.getErrorAplicacion().getCodigo() + "> -- <" + prex.getErrorAplicacion().getMensaje());
            } catch (NamingException | SQLException ex) {
                System.out.println("Error BD" + ex.getMessage());

            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletProyecto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletProyecto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
