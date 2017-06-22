$(document).ready(function () {
    var proyecto = {option: 1};
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
        var json={
            idProyecto :this.id,
            option :5
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
        var json = {
            option: 3,
            idProyecto: array[0],            
            nombreProyecto:$("#nombreProyecto").val(),
            descripcionProyecto:$("#descripcionProyecto").val(),
            fechaInicio:$("#fechaInicioProyecto").val(),
            fechaFin:$("#fechaFinProyecto").val(),
            porcentaje:$("#porcentajeProyecto").val()
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
    });

    function resAjax(i, data) {
        if (i == 1) {
//            for (var x = 0; x < i.datos.length; x++) {
//                var pf = i.datos[x].pf;
//                var fv = i.datos[x].fv;
//                var pv = i.datos[x].pv;
//                var data = pv.idProyecto + "$$" + pv.nombreProyecto + "$$" + pv.descripcion + "$$" + pv.fechaInicio + "$$" + pv.fechaFin + "$$" + pv.porcentaje;
//                table = $("#tabapren").dataTable().fnAddData([
//                    pf.programa,
//                    fv.numero,
//                    pv.nombreProyecto,
//                    pv.descripcion,
//                    pv.fechaInicio,
//                    pv.fechaFin,
//                    pv.porcentaje,
//                    "<button type='button' name='select'  class='btnfichaV' id='" + data + "' >Ver</button>",
//                    "<button type='button' name='select' id='" + pv.idProyecto + "'  class='btnfichaE'>Eliminar</button>"
//                ]);
     //       }
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


