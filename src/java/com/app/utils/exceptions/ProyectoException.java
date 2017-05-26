package com.app.utils.exceptions;

import com.app.utils.enums.EErroresAplicacion;

public class ProyectoException extends Exception {

    private final EErroresAplicacion errorAplicacion;
    private final Exception ex;

    public ProyectoException(EErroresAplicacion errorAplicacion, Exception ex) {
        this.errorAplicacion = errorAplicacion;
        this.ex = ex;
    }

    public EErroresAplicacion getErrorAplicacion() {
        return errorAplicacion;
    }

    public Exception getEx() {
        return ex;
    }

}
