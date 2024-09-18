public class NIF extends Documentacion {

    private String numero;
    private char letraFinal;

    public NIF(String numero,char letraFinal) {
        this.numero = numero;
        this.letraFinal = letraFinal;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public char getLetraFinal() {
        return letraFinal;
    }

    public void setLetraFinal(char letraFinal) {
        this.letraFinal = letraFinal;
    }

    @Override
    public boolean validar() {
        return getNumero().length() == 8
                && getNumero().matches("[0-9]*")
                && getLetraFinal() >= 65
                && getLetraFinal() <= 90;
    }

    @Override
    public String mostrar() {
        if (validar()) {
            return getNumero() + getLetraFinal();
        }
        return ("Error, NIF incorrecto");
    }
}
