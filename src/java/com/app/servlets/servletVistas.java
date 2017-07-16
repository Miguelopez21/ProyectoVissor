package com.app.servlets;

import com.app.controlador.ControladorProyecto;
import com.app.controlador.ControladorUsuarios;
import com.app.modelo.conexion.ConexionBD;
import com.app.modelo.dto.ProyectoUsuarioDTO;
import com.app.modelo.dto.RespuestaDTO;
import com.app.modelo.vo.ProyectoVO;
import com.app.modelo.vo.UsuarioVO;
import com.app.utils.enums.EErroresAplicacion;
import com.app.utils.exceptions.ProyectoException;
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

/**
 *
 * @author PODER
 */
@WebServlet(name = "servletVistas", urlPatterns = {"/Vistas"})
public class servletVistas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws com.app.utils.exceptions.ProyectoException
     * @throws java.sql.SQLException
     * @throws javax.naming.NamingException
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ProyectoException, SQLException, NamingException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String casos = "";
            int idProyecto = 0;
            String nombreProyecto = "";
            String descripcion = "";
            String fechaInicio = "";
            String fechafin = " ";
            int porcentaje = 0;
            Properties caso = null;
            int opcion = 0;
            if (request.getParameter("datos") != null) {
                casos = request.getParameter("datos");
                caso = new Gson().fromJson(casos, Properties.class);
                opcion = Integer.parseInt(caso.getProperty("option"));
                idProyecto = Integer.parseInt(caso.getProperty("idProyecto"));
                nombreProyecto = caso.getProperty("nombre");
                descripcion = caso.getProperty("descripcion");
                fechaInicio = caso.getProperty("fechaInicio");
                fechafin = caso.getProperty("fechaFin");
                porcentaje = Integer.parseInt(caso.getProperty("porcentaje"));

            } else {
                opcion = Integer.parseInt(request.getParameter("option"));
            }

            switch (opcion) {

                //listar Proyecto
                case 1:
                    String respuestaServlet = "";
                    RespuestaDTO respuesta = new RespuestaDTO();
                    try {
                        ProyectoUsuarioDTO pu = new ProyectoUsuarioDTO();
                        Connection cnn = ConexionBD.getConexionBD();
                        ControladorProyecto control = new ControladorProyecto(cnn);
                        List<ProyectoUsuarioDTO> lista = control.ListarProyecto(pu);
                        ConexionBD.desconectarBD(cnn);

                        if (lista == null) {
                            respuesta.setCodigo(EErroresAplicacion.ERROR_CONSULTAR.getCodigo());
                            respuesta.setMensaje(EErroresAplicacion.ERROR_CONSULTAR.getMensajes());
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
                    
                    //Modificar Proyecto

                    RespuestaDTO resinset = new RespuestaDTO();

                    idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
                    nombreProyecto = request.getParameter("nombre");
                    descripcion = request.getParameter("descripcion");
                    fechaInicio = request.getParameter("fechaInicio");
                    SimpleDateFormat formato = new SimpleDateFormat("mm/dd/yyyy");
                    Date fecha = new Date(formato.parse(fechaInicio).getTime());
                    fechafin = request.getParameter("fechaFin");
                    SimpleDateFormat formatos = new SimpleDateFormat("mm/dd/yyyy");
                    Date fecha1 = new Date(formatos.parse(fechafin).getTime());
                    porcentaje = Integer.parseInt(request.getParameter("porcentaje"));

                    if (idProyecto == 0 || nombreProyecto == null || descripcion == null || fechaInicio == null || fechafin == null
                            || nombreProyecto.isEmpty() || descripcion.isEmpty() || fechaInicio.isEmpty() || fechafin.isEmpty()) {
                        resinset.setCodigo(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getCodigo());
                        resinset.setMensaje(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getMensajes());
                        respuestaServlet = new Gson().toJson(resinset);
                    } else {
                        RespuestaDTO reinset = new RespuestaDTO();
                        try {
                            Connection cnn = ConexionBD.getConexionBD();
                            ControladorProyecto controProyecto = new ControladorProyecto(cnn);
                            ProyectoVO vo = new ProyectoVO();
                            vo.setNombreProyecto(nombreProyecto);
                            vo.setDescripcion(descripcion);
                            vo.setFechaInicio(fecha);
                            vo.setFechaFin(fecha1);
                            vo.setDescripcion(descripcion);
                            vo.setIdProyecto(idProyecto);
                            vo.setPorcentaje(porcentaje);
                            ProyectoVO result = controProyecto.ModificarProyecto(vo);
                            ConexionBD.desconectarBD(cnn);

                            if (vo == null) {
                                reinset.setCodigo(EErroresAplicacion.EXITO.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.EXITO.getMensajes());
                                respuestaServlet = new Gson().toJson(reinset);
                            } else {
                                reinset.setCodigo(EErroresAplicacion.EXITO.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.EXITO.getMensajes());
                                reinset.setDatos(vo);
                                respuestaServlet = new Gson().toJson(reinset);
                            }

                        } catch (SQLException | NamingException e) {
                            reinset.setCodigo(EErroresAplicacion.ERROR_CONEXION_BD.getCodigo());
                            reinset.setMensaje(EErroresAplicacion.ERROR_CONEXION_BD.getMensajes());
                            respuestaServlet = new Gson().toJson(reinset);
                        }

                    }
                    out.println(respuestaServlet);

                    break;

                case 3:

                    //listar Aprendices Proyecto
                    
                    RespuestaDTO resAprend = new RespuestaDTO();
                    try {

                        ProyectoVO pVo = new ProyectoVO();
                        int id = Integer.parseInt(request.getParameter("idProyecto"));
                        pVo.setIdProyecto(id);
                        ProyectoUsuarioDTO pu = new ProyectoUsuarioDTO();
                        pu.setPv(pVo);
                        Connection cnn = ConexionBD.getConexionBD();
                        ControladorProyecto controProyecto = new ControladorProyecto(cnn);
                        List<ProyectoUsuarioDTO> lista = controProyecto.listarProyectoCreado(pu);
                        ConexionBD.desconectarBD(cnn);

                        if (lista == null) {
                            resAprend.setCodigo(EErroresAplicacion.ERROR_CONSULTAR.getCodigo());
                            resAprend.setMensaje(EErroresAplicacion.ERROR_CONSULTAR.getMensajes());
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

                    out.println(respuestaServlet);

                    break;

                case 4:

                    //Listar Aprendices
                    
                    RespuestaDTO resAprendo = new RespuestaDTO();
                    try {
                        UsuarioVO vo = new UsuarioVO();
                        Connection cnn = ConexionBD.getConexionBD();
                        ControladorUsuarios aprendiz = new ControladorUsuarios(cnn);
                        List<UsuarioVO> lista = aprendiz.listarAprendices(vo);
                        ConexionBD.desconectarBD(cnn);

                        if (lista == null) {
                            resAprendo.setCodigo(EErroresAplicacion.ERROR_CONSULTAR.getCodigo());
                            resAprendo.setMensaje(EErroresAplicacion.ERROR_CONSULTAR.getMensajes());
                            respuestaServlet = new Gson().toJson(resAprendo);
                        } else {
                            resAprendo.setCodigo(EErroresAplicacion.EXITO.getCodigo());
                            resAprendo.setMensaje(EErroresAplicacion.EXITO.getMensajes());
                            resAprendo.setDatos(lista);
                            respuestaServlet = new Gson().toJson(resAprendo);
                        }

                    } catch (SQLException | ProyectoException ex) {
                        resAprendo.setCodigo(EErroresAplicacion.ERROR_CONEXION_BD.getCodigo());
                        resAprendo.setMensaje(EErroresAplicacion.ERROR_CONEXION_BD.getMensajes());
                        respuestaServlet = new Gson().toJson(resAprendo);
                    }

                    out.println(respuestaServlet);

                    break;

                case 5:

                    //Eliminar Proyecto
                    
                    RespuestaDTO resAprendos = new RespuestaDTO();
                    
                    int id = Integer.parseInt(request.getParameter("idProyecto"));

                    if (id == 0) {
                        resAprendos.setCodigo(EErroresAplicacion.ERROR_CONSULTAR.getCodigo());
                        resAprendos.setMensaje(EErroresAplicacion.ERROR_CONSULTAR.getMensajes());
                        respuestaServlet = new Gson().toJson(resAprendos);
                    } else {
                        RespuestaDTO reinset = new RespuestaDTO();
                        try {
                            Connection cnn = ConexionBD.getConexionBD();
                            ControladorProyecto controProyecto = new ControladorProyecto(cnn);
                            ProyectoVO pVo = new ProyectoVO();
                            pVo.setIdProyecto(id);
                            ProyectoVO resul = controProyecto.EliminarProyecto(pVo);

                            if (pVo == null) {
                                reinset.setCodigo(EErroresAplicacion.ERROR_CONSULTAR.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.ERROR_CONSULTAR.getMensajes());
                                respuestaServlet = new Gson().toJson(reinset);
                            } else {
                                reinset.setCodigo(EErroresAplicacion.EXITO.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.EXITO.getMensajes());
                                reinset.setDatos(pVo);
                                respuestaServlet = new Gson().toJson(reinset);
                            }

                        } catch (ProyectoException | SQLException | NamingException e) {
                            reinset.setCodigo(EErroresAplicacion.ERROR_CONEXION_BD.getCodigo());
                            reinset.setMensaje(EErroresAplicacion.ERROR_CONEXION_BD.getMensajes());
                            respuestaServlet = new Gson().toJson(reinset);
                        }
                    }
                    out.println(respuestaServlet);
                    
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
        } catch (ProyectoException | SQLException | NamingException | ParseException ex) {
            Logger.getLogger(servletVistas.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ProyectoException | SQLException | NamingException | ParseException ex) {
            Logger.getLogger(servletVistas.class.getName()).log(Level.SEVERE, null, ex);
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
