$(document).ready(function () {
    var proyecto = {option: 1};
    var proyect = 0;
    console.log(proyecto);
    $.ajax({
        url: "../../Vistas",
        type: 'POST',
        data: proyecto,
        dataType: 'json',
        cache: false,
        success: function (i) {
            for (var x = 0; x < i.datos.length; x++) {
                var pf = i.datos[x].pf;
                var fv = i.datos[x].fv;
                var pv = i.datos[x].pv;
                var data = pv.idProyecto + "$$" + pv.nombreProyecto + "$$" + pv.descripcion + "$$" + pv.fechaInicio + "$$" + pv.fechaFin + "$$" + pv.porcentaje;
                table = $("#tablapro").dataTable().fnAddData([
                    pf.programa,
                    fv.numero,
                    pv.nombreProyecto,
                    pv.descripcion,
                    pv.fechaInicio,
                    pv.fechaFin,
                    pv.porcentaje,
                    "<button type='button' name='select'  class='btnfichaV' id='" + data + "' >Ver</button>",
                    "<button type='button' name='select' id='" + pv.idProyecto + "'  class='btnfichaE'>Eliminar</button>"
                ]);
            }
        },
        error: function () {
            alert("Error al consultar Proyectos");
        }
    });

    $(document).on('click', '.btnfichaE', function (e) {
        var json = {
            idProyecto: this.id,
            option: 5
        };
        $.ajax({
            url: "../../Vistas",
            type: 'POST',
            data: json,
            dataType: 'json',
            cache: false,
            success: function (resultSet) {
                alert(resultSet);
            },
            error: function () {
                alert("Error al consultar Proyectos");
            }
        });
    });

    $(document).on('click', '.btnfichaV', function (e) {
        var array = this.id.split("$$");
        $("#nombreProyecto").val(array[1]);
        $("#descripcionProyecto").val(array[2]);
        $("#fechaInicioProyecto").val(array[3]);
        $("#fechaFinProyecto").val(array[4]);
        $("#porcentajeProyecto").val(array[5]);
        proyect = array[0];
        resAjax(2, array[0]);
        $("#modificar").show();
    });


    $("#btnModificarP").click(function () {
        var json = {
            option: 2,
            idProyecto: proyect,
            nombre: $("#nombreProyecto").val(),
            descripcion: $("#descripcionProyecto").val(),
            fechaInicio: $("#fechaInicioProyecto").val(),
            fechaFin: $("#fechaFinProyecto").val(),
            porcentaje: $("#porcentajeProyecto").val()
        };
        $.ajax({
            url: "../../Proyecto",
            type: 'POST',
            data: json,
            dataType: 'json',
            cache: false,
            success: function (resultSet) {
                alert(resultSet.mensaje);
            },
            error: function () {
                alert("Error al consultar Proyectos");
            }
        });
    });
    $(document).on('click', '.btnAprendizE', function (e) {
        var id = this.id;
        var json = {
            option: 4,
            idUsuario: id,
            idProyecto: proyect
        };
        $.ajax({
            url: "../../Proyecto",
            type: 'POST',
            data: json,
            dataType: 'json',
            cache: false,
            success: function (resultSet) {
                alert(resultSet.mensaje);
                resAjax(2, id);
            },
            error: function () {
                alert("Error al consultar Proyectos");
            }
        });
    });

    $("#btnModificarProyectoA").click(function () {
        $("#elemento").hide();
        $("#agregarAprendiz").show();
        var aprendices = {option: 2};
        $.ajax({
            url: "../../Proyecto",
            type: 'POST',
            data: aprendices,
            dataType: 'json',
            cache: false,
            success: function (u) {
                for (var y = 0; y < u.datos.length; y++) {
                    var up = u.datos[y];
                    var datos = up.idUsuario + "$$" + up.numeroIdentificacion + "$$" + up.nombres + "$$" + up.primerApellido + "$$" + up.segundoApellido;
                    table = $("#tablaApre").dataTable().fnAddData([
                        up.numeroIdentificacion,
                        up.nombres,
                        up.primerApellido,
                        up.segundoApellido,
                        "<button type='button' name='eliminar' id='" + datos + "' class='filapren''>Agregar</button>"
                    ]);
                }
            },
            error: function () {
                alert("Error al consultar aprendices");
            }
        });
    });

    var con = 0;
    $(document).on('click', '.filapren', function (e) {
        var arra = this.id.split("$$");
        var json = {
            option: 5,
            idUsuario: arra[0],
            idProyecto: proyect,
            fechaInicio:$("#fechaInicioProyecto").val(),
            fechaFin:$("#fechaFinProyecto").val()
        };
        $.ajax({
            url: "../../Proyecto",
            type: 'POST',
            data: json,
            dataType: 'json',
            cache: false,
            success: function (resultSet) {
                alert(resultSet.mensaje);
                $("#agregarAprendiz").hide();
                $("#elemento").show();
            },
            error: function () {
                alert("Error al consultar Proyectos");
            }
        });

    });


    function resAjax(i, data) {
        if (i == 1) {
            var json = data.datos;
            $("#tabapren").dataTable().fnClearTable();
            for (var x = 0; x < json.length; x++) {
                var uv = json[x].uv;
                table = $("#tabapren").dataTable().fnAddData([
                    uv.numeroIdentificacion,
                    uv.nombres,
                    uv.primerApellido,
                    uv.segundoApellido,
                    "<button type='button' name='select' id='" + uv.idUsuario + "'  class='btnAprendizE'>Eliminar</button>"
                ]);
            }
        } else if (i == 2) {
            var json = {
                option: 3,
                idProyecto: data
            };
            $.ajax({
                url: "../../Vistas",
                type: 'POST',
                data: json,
                dataType: 'json',
                cache: false,
                success: function (resultSet) {
                    resAjax(1, resultSet);
                },
                error: function () {
                    alert("Error al consultar Proyectos");
                }
            });
        }
    }





});

function tablaIdioma(datos, cons) {
    datos.DataTable({
        language: {
            paginate: {
                first: "Primera",
                previous: "Anterior",
                next: "Siguiente",
                last: "Anterior"
            },
            processing: "Cargando datos...",
            lengthMenu: "Mostrar _MENU_ " + cons,
            info: "Se encontaron _TOTAL_ " + cons,
            infoEmpty: "Mostradas 0 de _MAX_ entradas",
            "infoFiltered": "(filtrada a partir de  _MAX_ registro)",
            infoPostFix: "",
            loadingRecords: "Cargando...",
            "zeroRecords": "Ningun " + cons + " encontrada",
            emptyTable: "No hay ningun " + cons,
            search: "Buscar:"
        }
    });
}


