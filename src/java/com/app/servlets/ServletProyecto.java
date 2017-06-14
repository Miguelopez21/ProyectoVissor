package com.app.servlets;

import com.app.controlador.ControladorFichas;
import com.app.controlador.ControladorProyecto;
import com.app.controlador.ControladorUsuarios;
import com.app.modelo.conexion.ConexionBD;
import com.app.modelo.dto.FichasProgramaDTO;
import com.app.modelo.dto.ProyectoUsuarioDTO;
import com.app.modelo.dto.RespuestaDTO;
import com.app.utils.exceptions.ProyectoException;
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
     * @throws java.sql.SQLException
     * @throws com.app.utils.exceptions.ProyectoException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, NamingException, SQLException, ProyectoException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String casos = "";
            Properties caso = null;
            int opcion = 0;
            int idFicha = 0;
            int idUsuario = 0;
            String nombreProyecto = "";
            String descripcion = "";
            String fechaInicio = "";
            String fechafin = " ";

            if (request.getParameter("datos") != null) {
                casos = request.getParameter("datos");
                caso = new Gson().fromJson(casos, Properties.class);
                opcion = Integer.parseInt(caso.getProperty("option"));
                idFicha = Integer.parseInt(caso.getProperty("fichas").split(";")[0]);
                idUsuario = Integer.parseInt(caso.getProperty("aprendices"));
                nombreProyecto = caso.getProperty("nombre");
                descripcion = caso.getProperty("descripcion");
                fechaInicio = caso.getProperty("fechaInicio");
                fechafin = caso.getProperty("fechaFin");

            } else {
;                opcion = Integer.parseInt(request.getParameter("option"));
            }

            switch (opcion) {

                case 1:
                    String respuestaServlet = "";
                    RespuestaDTO respuesta = new RespuestaDTO();
                    try {
                        FichasProgramaDTO vo = new FichasProgramaDTO();
                        Connection cnn = ConexionBD.getConexionBD();
                        ControladorFichas fichas = new ControladorFichas(cnn);
                        List<FichasProgramaDTO> lista = fichas.ListarFichas(vo);
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

                    RespuestaDTO resAprend = new RespuestaDTO();
                    try {
                        UsuarioVO vo = new UsuarioVO();
                        Connection cnn = ConexionBD.getConexionBD();
                        ControladorUsuarios aprendiz = new ControladorUsuarios(cnn);
                        List<UsuarioVO> lista = aprendiz.listarAprendices(vo);
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

                case 3:

                    RespuestaDTO resinset = new RespuestaDTO();

                    idFicha = Integer.parseInt(request.getParameter("fichas").split(";")[0]);
                    String aprendices = request.getParameter("aprendices");
                    nombreProyecto = request.getParameter("nombre");
                    descripcion = request.getParameter("descripcion");
                    fechaInicio = request.getParameter("fechaInicio");
                    SimpleDateFormat formato = new SimpleDateFormat("mm/dd/yyyy");
                    Date fecha = new Date(formato.parse(fechaInicio).getTime());
                    fechafin = request.getParameter("fechaFin");
                    SimpleDateFormat formatos = new SimpleDateFormat("mm/dd/yyyy");
                    Date fecha1 = new Date(formatos.parse(fechafin).getTime());

                    if (idFicha == 0 || aprendices == null || nombreProyecto == null || descripcion == null || fechaInicio == null || fechafin == null
                            || aprendices.isEmpty() || nombreProyecto.isEmpty() || descripcion.isEmpty() || fechaInicio.isEmpty() || fechafin.isEmpty()) {
                        resinset.setCodigo(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getCodigo());
                        resinset.setMensaje(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getMensajes());
                        respuestaServlet = new Gson().toJson(resinset);
                    } else {
                        RespuestaDTO reinset = new RespuestaDTO();
                        try {

                            Connection cnn = ConexionBD.getConexionBD();
                            ControladorProyecto controProyecto = new ControladorProyecto(cnn);
                            ProyectoVO vo = new ProyectoVO();

                            vo.setIdFichas(idFicha);
                            vo.setNombreProyecto(nombreProyecto);
                            vo.setDescripcion(descripcion);
                            vo.setFechaInicio(fecha);
                            vo.setFechaFin(fecha1);
                            ProyectoVO result = controProyecto.CrearProyecto(vo);
                            vo.setIdProyecto(result.getIdProyecto());
                            vo.setFechaInicio(result.getFechaInicio());
                            vo.setFechaFin(result.getFechaFin());
 

                            String[] arrayAprendices = aprendices.split(",");

                            for (int y = 0; y < arrayAprendices.length; y++) {
                                idUsuario = Integer.parseInt(arrayAprendices[y]);
                                ControladorProyecto proyect = new ControladorProyecto(cnn);
                                ProyectoUsuarioDTO pu = new ProyectoUsuarioDTO();
                                pu.setPv(new ProyectoVO());
                                pu.setUv(new UsuarioVO());
                                pu.getPv().setIdProyecto(vo.getIdProyecto());
                                pu.getUv().setIdUsuario(idUsuario);
                                pu.getPv().setFechaInicio(vo.getFechaInicio());
                                pu.getPv().setFechaFin(vo.getFechaFin());
                                ProyectoUsuarioDTO resul = proyect.UsuarioProyecto(pu);
                            }

                            ConexionBD.desconectarBD(cnn);

                            if (vo == null) {
                                reinset.setCodigo(EErroresAplicacion.INSERTO.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.INSERTO.getMensajes());
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
        } catch (ParseException | NamingException | SQLException | ProyectoException ex) {
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
        } catch (ParseException | NamingException | SQLException | ProyectoException ex) {
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
