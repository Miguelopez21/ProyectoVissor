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
                table = $("#tablapro").dataTable().fnAddData([

                ]);
            }
        },
        error: function () {
            alert("Error al consultar Proyectos");
        }
    });
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


