<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="../../resources/img/favicon.png" alt="" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Proyecto Vissor</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <!-- Bootstrap core CSS     -->
        <link href="../../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!--  Material Dashboard CSS    -->
        <link href="../../resources/css/material-dashboard.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/estilo.css" rel="stylesheet" type="text/css"/>

        <!--     Fonts and icons     -->
        <link href="../../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/material-icons.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../resources/css/roboto.min.css" rel="stylesheet" type="text/css"/>

        <!--    JqueryUI    -->
        <link href="../../resources/jquery-ui/jquery-ui.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <div class="wrapper">
            <div class="sidebar" data-color="purple" data-image="../../resources/img/fondo.jpg" alt="">
                <div class="logo">
                    <a href="index.jsp" class="simple-text">
                        <img src="../../resources/img/Logo.png" width="230" height="42" alt=""/>
                    </a>
                </div>
                <br>

                <div class="sidebar-wrapper">
                    <ul class="nav">

                        <li>
                            <a href="index.jsp">
                                <i class="material-icons">dashboard</i>
                                <p>Menu</p>
                            </a>     
                        </li>


                        <ul class="nav">
                            <li class="active">
                                <a href="gestionProyectos.jsp">
                                    <i class="material-icons">account_balance_wallet</i>
                                    <p>Gestion de Proyectos</p>
                                </a> 
                            </li>
                            <ul class="nav">
                                <li>
                                    <a href="proyectos.jsp">
                                        <i class="material-icons">assignment_late</i></i>
                                        <p>Proyectos</p>
                                    </a>
                                </li>
                            </ul>

                            <ul class="nav">
                                <li>
                                    <a href="reunion.jsp">
                                        <i class="material-icons">supervisor_account</i>
                                        <p>Reuniones</p>
                                    </a>
                                </li>
                            </ul>

                            <ul class="nav">
                                <li>
                                    <a href="sustentaciones.jsp">
                                        <i class="material-icons">content_paste</i>
                                        <p>Sustentaciones</p>
                                    </a>
                                </li>
                            </ul>
                        </ul>

                        <li>
                            <a href="#">
                                <i class="material-icons">assignmentreturned</i>
                                <p>Gestion de Fichas</p>
                            </a>
                            <ul class="nav">
                                <li>
                                    <a href="#">
                                        <i class="material-icons">recent_actors</i>
                                        <p>Administrar Fichas</p>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="#">
                                <i class="material-icons">people</i>
                                <p>Gestion de usuarios</p>
                            </a>
                            <ul class="nav">
                                <li>
                                    <a href="#">
                                        <i class="material-icons">recent_actors</i>
                                        <p>Administrar Instructores</p>
                                    </a>
                                </li>
                            </ul>

                            <ul class="nav">
                                <li>
                                    <a href="#">
                                        <i class="material-icons">group</i>
                                        <p>Administrar Aprendices</p>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="main-panel">

                <nav class="navbar navbar-transparent navbar-absolute">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#">Bienvenido al sistema</a>
                        </div>

                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">

                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <i class="material-icons">person</i>
                                        <p class="hidden-lg hidden-md">Perfil</p>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Perfil</a></li>
                                        <li><a href="#">Cerrar Sesion</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <!--Contenido pagina -->

                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header" data-background-color="purple">
                                        <h4 class="title">Menu Principal</h4>
                                    </div>
                                    <div class="card-content">

                                        <center>
                                            <form method="post" action="Proyecto">
                                                <div>
                                                    Fichas <input type="text" name="fichas" id="inputfichas"> 
                                                    <input type="submit" value="buscar" id="botonFicha"/>
                                                    <br><br>
                                                    <div class="col-md-12">
                                                        <div class="card">
                                                            <div class="card-header" data-background-color="purple">
                                                                <h4 class="title">Fichas de Formacion</h4>

                                                            </div>
                                                            <div class="card-content table-responsive">
                                                                <table class="table">
                                                                    <thead class="text-primary">
                                                                    <th>Programa de Formacion</th>
                                                                    <th>Ficha</th>
                                                                    <th>Fecha de Incio</th>
                                                                    <th>Fecha de Terminacion</th>                                                                    
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td><input type="submit" value="Eliminar"></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>


                                                <p>
                                                    Nombre Proyecto<input type="text" name="nombre" id="nombre"><br>
                                                    Descripcion <input type="text" name="descripcion" id="descripcion"><br>
                                                    fecha incio: <input type="text" id="fechainicio"><br>
                                                    fecha fin: <input type="text" id="fechafin"><br>
                                                </p>

                                                <br>

                                                <div>
                                                    aprendices <input type="text" id="">
                                                    <input type="submit" value="Buscar"/>
                                                    <br>
                                                </div>
                                                <br>

                                                <div class="col-md-12">
                                                    <div class="card">
                                                        <div class="card-header" data-background-color="purple">
                                                            <h4 class="title">Aprendices en Formacion</h4>

                                                        </div>
                                                        <div class="card-content table-responsive">
                                                            <table class="table">
                                                                <thead class="text-primary">
                                                                <th>Programa de Formacion</th>
                                                                <th>Ficha</th>
                                                                <th>Fecha de Incio</th>
                                                                <th>Fecha de Terminacion</th>                                                                    
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <td></td>
                                                                        <td></td>
                                                                        <td></td>
                                                                        <td></td>
                                                                        <td><input type="submit" value="Eliminar"></td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>

                                                    </div>
                                                </div>

                                            </form>
                                        </center>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <footer class="footer">
                    <div class="container-fluid">

                        <p class="copyright pull-right">
                            &copy; <script>document.write(new Date().getFullYear())</script> <a href="http://oferta.senasofiaplus.edu.co/sofia-oferta/">Sena Vissor</a>, Centro de gestion de mercados, Logistica y tics.
                        </p>
                    </div>
                </footer>

            </div>
        </div>


    </body>

    <!--   Core JS Files   -->
    <script src="../../resources/jquery-ui/external/jquery/jquery.js" type="text/javascript"></script>
    <script src="../../resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../../resources/js/material.min.js" type="text/javascript"></script>

    <!--  Charts Plugin -->
    <script src="../../resources/js/chartist.min.js" type="text/javascript"></script>

    <!--  Notifications Plugin    -->
    <script src="../../resources/js/bootstrap-notify.js" type="text/javascript"></script>

    <!-- Material Dashboard javascript methods -->
    <script src="../../resources/js/material-dashboard.js" type="text/javascript"></script>

    <!-- JqueryUI -->
    <script src="../../resources/jquery-ui/jquery-ui.js" type="text/javascript"></script>
    <script src="../../resources/js/fechainicio.js" type="text/javascript"></script>
    <script src="../../resources/js/fechafin.js" type="text/javascript"></script>

</html>
