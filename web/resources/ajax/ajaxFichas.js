$(document).ready(function () {
    var ficha = {option: 2};
    console.log(ficha);
    $.ajax({
        url: "../../Proyecto",
        type: 'POST',
        data: ficha,
        dataType: 'json',
        cache: false,
        success: function (i) {
            var htmlTabla = "";
            for (var x = 0; x < i.datos.length; x++) {
                var fv = i.datos[x].fv;
                var pf = i.datos[x].pf;
                var prograFormacion = pf.programa;
                var ficha = fv.numero;
                var fechaIni = fv.fechaInicio;
                var fechaFin = fv.fechaFin;
                htmlTabla = "<tr>";
                htmlTabla += "<td>" + prograFormacion + "</td>";
                htmlTabla += "<td>" + ficha + "</td>";
                htmlTabla += "<td>" + fechaIni + "</td>";
                htmlTabla += "<td>" + fechaFin + "</td>";
                htmlTabla += "<td><input type='button' value='agregar' name='agregar' onclick='armarPeticion(" + fv.idFichas + ");' /></td>";
                htmlTabla += "<td><input type='button' value='eliminar' name='eliminar' onclick='quitarPeticion(" + fv.idFichas + ");' /></td>";
                htmlTabla += "</tr>";
            }

            $("#tabla").find("tbody").html(htmlTabla);
        },
        error: function () {
            alert("Error en la consulta");
        }
    });
});