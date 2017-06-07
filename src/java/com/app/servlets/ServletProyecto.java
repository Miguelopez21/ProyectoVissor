package com.app.servlets;

import com.app.controlador.ControladorFichas;
import com.app.controlador.ControladorProyecto;
import com.app.controlador.ControladorUsuarios;
import com.app.modelo.conexion.ConexionBD;
import com.app.modelo.dto.FichasProgramaDTO;
import com.app.modelo.dto.ProyectoUsuarioDTO;
import com.app.modelo.dto.RespuestaDTO;
import com.app.utils.exceptions.ProyectoException;
import com.app.modelo.vo.FichasVO;
import com.app.modelo.vo.ProyectoVO;
import com.app.modelo.vo.UsuarioVO;
import com.app.utils.enums.EErroresAplicacion;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
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
     * @throws javax.naming.NamingException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, NamingException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String casos = "";
            Properties caso = null;
            int opcion = 0;
            if (request.getParameter("datos") != null) {
                casos = request.getParameter("datos");
                caso = new Gson().fromJson(casos, Properties.class);
                opcion = Integer.parseInt(caso.getProperty("option"));
            } else {
                opcion = Integer.parseInt(request.getParameter("option"));
            }

            switch (opcion) {

                case 1:
                    String respuestaServlet = "";
                    RespuestaDTO respuesta = new RespuestaDTO();
                    try {
                        FichasProgramaDTO vo = new FichasProgramaDTO();
                        ControladorFichas fichas = new ControladorFichas(ConexionBD.getConexionBD());
                        List<FichasProgramaDTO> lista = fichas.ListarFichas(vo);

                        if (lista == null) {
                            respuesta.setCodigo(EErroresAplicacion.CONSULTO.getCodigo());
                            respuesta.setMensaje(EErroresAplicacion.CONSULTO.getMensajes());
                            respuestaServlet = new Gson().toJson(respuesta);
                        } else {
                            respuesta.setCodigo(EErroresAplicacion.EXITO.getCodigo());
                            respuesta.setMensaje(EErroresAplicacion.EXITO.getMensajes());
                            respuesta.setDatos(lista);
                            respuestaServlet = new Gson().toJson(respuesta);
                        }

                    } catch (SQLException | ProyectoException ex) {
                        respuesta.setCodigo(EErroresAplicacion.ERROR_CONEXION_BD.getCodigo());
                        respuesta.setMensaje(EErroresAplicacion.ERROR_CONEXION_BD.getMensajes());
                        respuestaServlet = new Gson().toJson(respuesta);
                    }
                    out.println(respuestaServlet);

                    break;

                case 2:
                    
                    String respuestaAprendiz = "";
                    RespuestaDTO resAprend = new RespuestaDTO();
                    try {
                        UsuarioVO vo = new UsuarioVO();
                        ControladorUsuarios aprendiz = new ControladorUsuarios(ConexionBD.getConexionBD());
                        List<UsuarioVO> lista = aprendiz.listarAprendices(vo);

                        if (lista == null) {
                            resAprend.setCodigo(EErroresAplicacion.CONSULTO.getCodigo());
                            resAprend.setMensaje(EErroresAplicacion.CONSULTO.getMensajes());
                            respuestaServlet = new Gson().toJson(resAprend);
                        } else {
                            resAprend.setCodigo(EErroresAplicacion.EXITO.getCodigo());
                            resAprend.setMensaje(EErroresAplicacion.EXITO.getMensajes());
                            resAprend.setDatos(lista);
                            respuestaServlet = new Gson().toJson(resAprend);
                        }

                    } catch (SQLException | ProyectoException ex) {
                        resAprend.setCodigo(EErroresAplicacion.ERROR_CONEXION_BD.getCodigo());
                        resAprend.setMensaje(EErroresAplicacion.ERROR_CONEXION_BD.getMensajes());
                        respuestaServlet = new Gson().toJson(resAprend);
                    }
                    out.println(respuestaAprendiz);

                    
                    break;
                    
                    
                case 3:

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
                    vt.setUv(new UsuarioVO());
                    vt.setFv(new FichasVO());
                    vt.getFv().setIdFichas(idFicha);
                    vt.getUv().setIdUsuario(idUsuario);
                    vo.setNombreProyecto(nombreProyecto);
                    vo.setDescripcion(descripcion);
                    vo.setFechaInicio(fecha);
                    vo.setFechaFin(fecha1);

                    try {
                        Connection cnn = ConexionBD.getConexionBD();
                        ControladorProyecto control = new ControladorProyecto(cnn);
                        ProyectoVO idProyecto = control.CrearProyecto(vo);
                        vt.setPv(idProyecto);
                        control.UsuarioProyecto(vt);
                        ConexionBD.desconectarBD(cnn);

                    } catch (ProyectoException prex) {
                    } catch (NamingException | SQLException ex) {
                        System.out.println("Error BD" + ex.getMessage());
                    }
                    break;

            }
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
        } catch (ParseException | NamingException ex) {
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
        } catch (ParseException | NamingException ex) {
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
