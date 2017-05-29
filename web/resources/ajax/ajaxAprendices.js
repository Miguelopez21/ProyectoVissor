$(document).ready(function () {
    $("#botonFicha").click(function () {
        var ficha = {obtener: $("inputfichas").val(),option:2};
        console.log(ficha);
        $.ajax({
            url: "CrearProyecto",
            type: 'POST',
            data: ficha,
            contentType: false,
            cache: false,
            success: function (i) {
                console.log(i);
            },
            error: function () {
                alert("Error se jodio");
            }
        });

    });
});


