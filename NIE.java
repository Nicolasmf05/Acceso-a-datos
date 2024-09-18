public class NIE extends Documentacion {

    private char letraInicial;


    public NIE(char letraInicial, String numero,char letraFinal) {
        this.letraInicial = letraInicial;
        this.numero = numero;
        this.letraFinal = letraFinal;
    }

    public char getLetraInicial() {
        return letraInicial;
    }

    public void setLetraInicial(char letraInicial) {
        this.letraInicial = letraInicial;
    }

    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    private char letraFinal;

    public char getLetraFinal() {
        return letraFinal;
    }

    public void setLetraFinal(char letraFinal) {
        this.letraFinal = letraFinal;
    }

    @Override
    boolean validar() {
        if (
                getNumero().length() == 8
                && getNumero().matches("[0-9]*")
                && getLetraInicial() >= 88
                && getLetraInicial() <= 90
                && getLetraFinal() >= 65
                && getLetraFinal() <= 90
        ) {
            return true;
        }
        return false;
    }

    @Override
    String mostrar() {
        if (validar()) {
            return getLetraInicial()+ getNumero() + getLetraFinal();
        }
        return ("Error, NIE es incorrecto");
    }
}
