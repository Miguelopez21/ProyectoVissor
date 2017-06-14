$(document).ready(function () {
    var arrAprendiz = [];
    tablaIdioma($("#tabla"), "Fichas");
    tablaIdioma($("#tablaApre"), "Aprendices");
    var ficha = {option: 1};
    console.log(ficha);
    $.ajax({
        url: "../../Proyecto",
        type: 'POST',
        data: ficha,
        dataType: 'json',
        cache: false,
        success: function (i) {
            for (var x = 0; x < i.datos.length; x++) {
                var fv = i.datos[x].fv;
                var pf = i.datos[x].pf;
                var data = fv.idFichas + "$$" + pf.programa + "$$" + fv.numero + "$$" + fv.fechaInicio + "$$" + fv.fechaFin;
                table = $("#tabla").dataTable().fnAddData([
                    pf.programa,
                    fv.numero,
                    fv.fechaInicio,
                    fv.fechaFin,
                    "<button type='button' name='select'  class='btnficha' id='" + data + "'>Agregar</button>"
                ]);
            }
        },
        error: function () {
            alert("Error al consultar Fichas");
        }
    });
    var fichaSelec = 0;
    $(document).on('click', '.btnficha', function (e) {
        var arr = this.id.split("$$");
        fichaSelec = arr[0];
        $("#mostrar").show();
        $("#programa").text(arr[1]);
        $("#Ficha").text(arr[2]);
        $("#Fechainicio").text(arr[3]);
        $("#Fechafin").text("Fecha final: " + arr[4]);
    });

    $("#eliminar").click(function () {
        alert("Se elimino una ficha");
        $("#mostrar").hide();
        $("#programa").text();
        $("#Ficha").text();
        $("#Fechainicio").text();
        $("#Fechafin").text();
    });

    var aprendices = {option: 2};
    console.log(aprendices);
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
    var con = 0;
    $(document).on('click', '.filapren', function (e) {
        var arra = this.id.split("$$");
        arrAprendiz.push(arra[0]);
        var clon = $("#mostrarapre").clone();
        clon.find(".elemento").attr("id", "element" + con);
        clon.find("#aprendiz").attr("value", arra[0]);
        clon.find("#numero").text(arra[1]);
        clon.find("#nombres").text(arra[2]);
        clon.find("#primer").text(arra[3]);
        clon.find("#segundo").text(arra[4]);
        clon.find("#eliminarap").val(arra[0] + "@element" + con);
        clon.children().appendTo("#agregar");
        con++;
    });

    $(document).on('click', '.elementobtn', function (e) {
        var value = $(this).val().split("@");
        var busqueda = $.inArray(value[0], arrAprendiz);
        arrAprendiz.splice(busqueda, 1);
        $("#" + value[1] + "").remove();
    });
    $("#eliminarap").click(function () {
        alert("Se un Aprendiz");
        $("#mostrarapre").hide();
        $("#numero").text();
        $("#nombres").text();
        $("#primer").text();
        $("#segundo").text();
    });

    $("#enviar").click(function () {

        console.log(arrAprendiz);
        console.log(fichaSelec);
        var json = {
            option: 3,
            nombre: $("#nombre").val(),
            descripcion: $("#descripcion").val(),
            fechaInicio: $("#fechainicio").val(),
            fechaFin: $("#fechafin").val(),
            fichas: fichaSelec,
            aprendices: ""+arrAprendiz+""
        };
        $.ajax({
            url: "../../Proyecto",
            type: 'POST',
            data: json,
            dataType: 'json',
            cache: false,
            success: function (result) {

            },
            error: function () {
                alert("Error al Insertar Proyecto");
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
});
