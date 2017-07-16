package com.app.servlets;

import com.app.controlador.ControladorReunion;
import com.app.modelo.conexion.ConexionBD;
import com.app.modelo.dto.RespuestaDTO;
import com.app.modelo.dto.ReunionDTO;
import com.app.modelo.vo.AsistenciaVO;
import com.app.modelo.vo.ProyectoVO;
import com.app.modelo.vo.ReunionVO;
import com.app.modelo.vo.TrimestreVO;
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

@WebServlet(name = "ServletReunion", urlPatterns = {"/ServletReunion"})
public class ServletReunion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     * @throws com.app.utils.exceptions.ProyectoException
     * @throws javax.naming.NamingException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, ProyectoException, NamingException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String casos = "";
            Properties caso = null;
            int opcion = 0;
            int idProyecto = 0;
            int idTipoReunion = 0;
            int idTrimestre = 0;
            int idReunion = 0;
            int idAsistentes = 0;
            String usuario = "";
            String nombre = "";
            String lugar = "";
            String ambiente = "";
            String fechaInicio = "";
            String fechafin = " ";

            if (request.getParameter("datos") != null) {
                casos = request.getParameter("datos");
                caso = new Gson().fromJson(casos, Properties.class);
                opcion = Integer.parseInt(caso.getProperty("option"));
                idProyecto = Integer.parseInt(caso.getProperty("idProyecto"));
                idReunion = Integer.parseInt(caso.getProperty("idReunion"));
                idTipoReunion = Integer.parseInt(caso.getProperty("idTipoReunion"));
                idTrimestre = Integer.parseInt(caso.getProperty("idTrimestre"));
                idAsistentes = Integer.parseInt(caso.getProperty("idAsistentes"));
                usuario = caso.getProperty("nombre").split(",")[0];
                nombre = caso.getProperty("nombre");
                lugar = caso.getProperty("lugar");
                ambiente = caso.getProperty("ambiente");
                fechaInicio = caso.getProperty("fechaInicio");
                fechafin = caso.getProperty("fechaFin");
            } else {
                opcion = Integer.parseInt(request.getParameter("option"));
            }

            switch (opcion) {

                case 1:

                    //Insertar seguimiento
                    RespuestaDTO resinset = new RespuestaDTO();
                    String respuestaServlet = "";

                    idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
                    idTipoReunion = Integer.parseInt(request.getParameter("idTipoReunion"));
                    idTrimestre = Integer.parseInt(request.getParameter("idTrimestre"));
                    usuario = request.getParameter("aprendices");
                    nombre = request.getParameter("nombre");
                    lugar = request.getParameter("lugar");
                    ambiente = request.getParameter("ambiente");
                    fechaInicio = request.getParameter("fechaInicio");
                    SimpleDateFormat formato = new SimpleDateFormat("mm/dd/yyyy");
                    Date fecha = new Date(formato.parse(fechaInicio).getTime());
                    fechafin = request.getParameter("fechaFin");
                    SimpleDateFormat formatos = new SimpleDateFormat("mm/dd/yyyy");
                    Date fecha1 = new Date(formatos.parse(fechafin).getTime());

                    if (idProyecto == 0 || nombre == null || lugar == null || ambiente == null || fechaInicio == null || fechafin == null
                            || nombre.isEmpty() || lugar.isEmpty() || ambiente.isEmpty() || fechaInicio.isEmpty() || fechafin.isEmpty()) {
                        resinset.setCodigo(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getCodigo());
                        resinset.setMensaje(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getMensajes());
                        respuestaServlet = new Gson().toJson(resinset);
                    } else {
                        RespuestaDTO reinset = new RespuestaDTO();
                        try {

                            ReunionVO vo = new ReunionVO();
                            ProyectoVO py = new ProyectoVO();
                            TrimestreVO tv = new TrimestreVO();
                            py.setIdProyecto(idProyecto);
                            vo.setIdTipoReunion(idTipoReunion);
                            tv.setIdTrimestre(idTrimestre);
                            vo.setNombre(nombre);
                            vo.setLugar(lugar);
                            vo.setAmbiente(ambiente);
                            vo.setFechaIncio(fecha);
                            vo.setFechaFin(fecha1);
                            ReunionDTO rt = new ReunionDTO();
                            rt.setRv(vo);
                            rt.setTv(tv);
                            rt.setPv(py);
                            Connection cnn = ConexionBD.getConexionBD();
                            ControladorReunion controladorReunion = new ControladorReunion(cnn);
                            ReunionDTO control = controladorReunion.CrearReunion(rt);
                            rt.getRv().setIdReunion(control.getRv().getIdReunion());
                            ConexionBD.desconectarBD(cnn);

                            if (idTipoReunion == 1) {

                                String[] arrayUsuario = usuario.split(",");
                                for (int i = 0; i < arrayUsuario.length; i++) {
                                    usuario = arrayUsuario[i];
                                    ControladorReunion reuno = new ControladorReunion(cnn);
                                    ReunionDTO re = new ReunionDTO();
                                    re.getRv().setIdReunion(rt.getRv().getIdReunion());
                                    re.getAv().setAsistentes(usuario);
                                    re.getAv().setEstado(true);
                                    ReunionDTO resultado = reuno.CrearAsistentes(re);
                                }
                                ConexionBD.desconectarBD(cnn);
                            }

                            if (rt == null) {
                                reinset.setCodigo(EErroresAplicacion.ERROR_INSERTAR.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.ERROR_INSERTAR.getMensajes());
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

                case 2:

                    //Eliminar Reunion
                    RespuestaDTO resAprendos = new RespuestaDTO();

                    idReunion = Integer.parseInt(request.getParameter("idReunion"));

                    if (idReunion == 0) {
                        resAprendos.setCodigo(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getCodigo());
                        resAprendos.setMensaje(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getMensajes());
                        respuestaServlet = new Gson().toJson(resAprendos);
                    } else {
                        RespuestaDTO reinset = new RespuestaDTO();
                        try {
                            ReunionVO vo = new ReunionVO();
                            vo.setIdReunion(idReunion);
                            ReunionDTO reu = new ReunionDTO();
                            reu.setRv(vo);
                            Connection cnn = ConexionBD.getConexionBD();
                            ControladorReunion controReu = new ControladorReunion(cnn);
                            ReunionDTO result = controReu.EliminarReunion(reu);
                            ConexionBD.desconectarBD(cnn);

                            if (reu == null) {

                                reinset.setCodigo(EErroresAplicacion.ERROR_ELIMINAR.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.ERROR_ELIMINAR.getMensajes());
                                respuestaServlet = new Gson().toJson(reinset);

                            } else {

                                reinset.setCodigo(EErroresAplicacion.EXITO.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.EXITO.getMensajes());
                                reinset.setDatos(vo);
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

                case 3:

                    //Eliminar Asistentes
                    RespuestaDTO resAprendo = new RespuestaDTO();

                    idAsistentes = Integer.parseInt(request.getParameter("idAsistentes"));

                    if (idAsistentes == 0) {
                        resAprendo.setCodigo(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getCodigo());
                        resAprendo.setMensaje(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getMensajes());
                        respuestaServlet = new Gson().toJson(resAprendo);
                    } else {
                        RespuestaDTO reinset = new RespuestaDTO();
                        try {
                            AsistenciaVO vo = new AsistenciaVO();
                            vo.setIdAsistencia(idAsistentes);
                            ReunionDTO reu = new ReunionDTO();
                            reu.setAv(vo);
                            Connection cnn = ConexionBD.getConexionBD();
                            ControladorReunion controReu = new ControladorReunion(cnn);
                            ReunionDTO result = controReu.EliminarAsistencia(reu);
                            ConexionBD.desconectarBD(cnn);

                            if (reu == null) {

                                reinset.setCodigo(EErroresAplicacion.ERROR_ELIMINAR.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.ERROR_ELIMINAR.getMensajes());
                                respuestaServlet = new Gson().toJson(reinset);

                            } else {

                                reinset.setCodigo(EErroresAplicacion.EXITO.getCodigo());
                                reinset.setMensaje(EErroresAplicacion.EXITO.getMensajes());
                                reinset.setDatos(vo);
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

                case 4:

                    //Modificar reunion
                    RespuestaDTO resinsetoi = new RespuestaDTO();

                    nombre = request.getParameter("nombre");
                    lugar = request.getParameter("lugar");
                    ambiente = request.getParameter("ambiente");
                    fechaInicio = request.getParameter("fechaInicio");
                    SimpleDateFormat formatos1 = new SimpleDateFormat("mm/dd/yyyy");
                    Date fechas = new Date(formatos1.parse(fechaInicio).getTime());
                    fechafin = request.getParameter("fechaFin");
                    SimpleDateFormat formato1 = new SimpleDateFormat("mm/dd/yyyy");
                    Date fechas1 = new Date(formato1.parse(fechafin).getTime());
                    idReunion = Integer.parseInt(request.getParameter("idProyecto"));

                    if (idReunion == 0 || nombre == null || lugar == null || ambiente == null || fechaInicio == null || fechafin == null
                            || nombre.isEmpty() || lugar.isEmpty() || ambiente.isEmpty() || fechaInicio.isEmpty() || fechafin.isEmpty()) {
                        resinsetoi.setCodigo(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getCodigo());
                        resinsetoi.setMensaje(EErroresAplicacion.ERROR_DATOS_INCOMPLETOS.getMensajes());
                        respuestaServlet = new Gson().toJson(resinsetoi);
                    } else {
                        RespuestaDTO reinset = new RespuestaDTO();
                        try {
                            Connection cnn = ConexionBD.getConexionBD();
                            ControladorReunion controreu = new ControladorReunion(cnn);
                            ReunionVO vo = new ReunionVO();
                            vo.setNombre(nombre);
                            vo.setLugar(lugar);
                            vo.setAmbiente(ambiente);
                            vo.setFechaIncio(fechas);
                            vo.setFechaFin(fechas1);
                            vo.setIdReunion(idReunion);
                            ReunionDTO rt = new ReunionDTO();
                            rt.setRv(vo);
                            ReunionDTO result = controreu.ModificarReunion(rt);
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

                case 5:

                    //listarReunion
                    RespuestaDTO resAprend = new RespuestaDTO();
                    try {
                        ReunionDTO vo = new ReunionDTO();
                        Connection cnn = ConexionBD.getConexionBD();
                        ControladorReunion reu = new ControladorReunion(cnn);
                        List<ReunionDTO> lista = reu.listarReunionCreada(vo);
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

                case 6:

                    //listar Asistentes
                    RespuestaDTO resAprendosa = new RespuestaDTO();
                    try {

                        AsistenciaVO pVo = new AsistenciaVO();
                        int id = Integer.parseInt(request.getParameter("idReunion"));
                        pVo.setIdReunion(id);
                        ReunionDTO pu = new ReunionDTO();
                        pu.setAv(pVo);
                        Connection cnn = ConexionBD.getConexionBD();
                        ControladorReunion controreu = new ControladorReunion(cnn);
                        List<ReunionDTO> lista = controreu.listarAsistentes(pu);
                        ConexionBD.desconectarBD(cnn);

                        if (lista == null) {
                            resAprendosa.setCodigo(EErroresAplicacion.ERROR_CONSULTAR.getCodigo());
                            resAprendosa.setMensaje(EErroresAplicacion.ERROR_CONSULTAR.getMensajes());
                            respuestaServlet = new Gson().toJson(resAprendosa);
                        } else {
                            resAprendosa.setCodigo(EErroresAplicacion.EXITO.getCodigo());
                            resAprendosa.setMensaje(EErroresAplicacion.EXITO.getMensajes());
                            resAprendosa.setDatos(lista);
                            respuestaServlet = new Gson().toJson(resAprendosa);
                        }

                    } catch (SQLException | ProyectoException ex) {
                        resAprendosa.setCodigo(EErroresAplicacion.ERROR_CONEXION_BD.getCodigo());
                        resAprendosa.setMensaje(EErroresAplicacion.ERROR_CONEXION_BD.getMensajes());
                        respuestaServlet = new Gson().toJson(resAprendosa);
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
        } catch (ParseException | ProyectoException | NamingException ex) {
            Logger.getLogger(ServletReunion.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException | ProyectoException | NamingException ex) {
            Logger.getLogger(ServletReunion.class.getName()).log(Level.SEVERE, null, ex);
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
