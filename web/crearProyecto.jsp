
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Proyecto</title>
        <link href="resources/jquery-ui/jquery-ui.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form method="post" action="CrearProyecto">
            <div>
                Fichas <input type="text" name="fichas" id="inputfichas"> 
                <input type="submit" value="buscar" id="botonFicha"/><br>
            </div>

            <p>
                Nombre Proyecto<input type="text" name="nombre" id="nombre"><br>
                Descripcion <input type="text" name="descripcion" id="descripcion"><br>
                fecha incio: <input type="text" id="fechainicio"><br>
                fecha fin: <input type="text" id="fechafin"><br>
            </p>

            <div>
                aprendices <input type="text" id="">
                <input type="submit" value="Buscar"/><br>
            </div>

            <table>
                <thead>
                <th>Id</th>
                <th>Nombre</th>
                <th>Proyecto</th>
                <th>Ficha</th>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Vissor</td>
                        <td>Proyecto Sena</td>
                        <td>1093506</td>
                    </tr>
                </tbody>
            </table>

            <div>
                <input type="submit" value="Buscar"/><br>
            </div>
        </form>
    </body>
    <script src="resources/jquery-ui/external/jquery/jquery.js" type="text/javascript"></script>
    <script src="resources/jquery-ui/jquery-ui.js" type="text/javascript"></script>
    <script src="resources/js/fechainicio.js" type="text/javascript"></script>
    <script src="resources/js/fechafin.js" type="text/javascript"></script>
    <script src="resources/js/jquery.dataTables.min.js" type="text/javascript"></script>
</html>
