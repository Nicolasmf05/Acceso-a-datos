public class TipoPago {

    private static char codigo;
    private String nombre;

    public TipoPago(char codigo) {
        this.codigo = codigo;
    }

    public static TipoPago getCodigo() {
        return codigo;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
        setNombre(codigo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(char codigo) {
        if (codigo == 'E') {
            this.nombre = "Efectivo";
        } else if (codigo == 'T') {
            this.nombre = "Transferencia";
        } else {
            this.nombre = "Tarjeta de credito";
        }
    }
}

