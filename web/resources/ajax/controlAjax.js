/* global jsActual */

var control = {
    funcionIn: function () {
        jsActual.inicioPK();
    },
    ConsuAJAX: function (urlConsumo, datosEnviar, funcionRespuesta) {
        var controlAJAX = new XMLHttpRequest();
        controlAJAX.open('POST', urlConsumo, true);
        controlAJAX.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        controlAJAX.onreadystatechange = function () {
            if (controlAJAX.readyState === 4 && controlAJAX.status === 200) {
                funcionRespuesta(JSON.parse(controlAJAX.responseText));
            } else if (controlAJAX.status === 404) {
                control.mostrarErrores(controlAJAX.responseText);
            }

        };
        debugger;
        controlAJAX.send('datos=' + JSON.stringify(datosEnviar));
    },
    mostrarErrores: function (textoError) {
        alert("Error : " + textoError);
    }
};
document.addEventListener('DOMContentLoaded', control.funcionIn);


