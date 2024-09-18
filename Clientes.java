import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Cliente {

    private Documentacion id;
    private String nombre;
    private String direccion;
    private String telefono;
    private LocalDate fechaNac;
    private boolean suscripcion = false;
    private TipoPago pagoPref = TipoPago.getCodigo();

    public Cliente(Documentacion id, String nombre, String direccion, String telefono, LocalDate fechaNac, boolean suscripcion, TipoPago pagoPref) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
        this.suscripcion = suscripcion;
        this.pagoPref = pagoPref;

    }


    public static Cliente nuevoCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tipo de documento (NIF/NIE): ");
        String tipoDocumento = scanner.nextLine();
        while (!(tipoDocumento.equals("NIF")) && !tipoDocumento.equals("NIE")) {
            System.out.print("Ingrese el tipoDocumento de documento (NIF/NIE): ");
            tipoDocumento = scanner.nextLine();
        }
        Documentacion documento;

            if (tipoDocumento.equals("NIF")) {
                System.out.print("Ingrese los 8 digitos: ");
                String numerosNIF = scanner.nextLine();
                System.out.print("Ingrese la letra: ");
                char letraNIF = scanner.nextLine().charAt(0);
                documento = new NIF(numerosNIF, letraNIF);
                while (documento.validar() == false) {
                    System.out.print("Ingrese los 8 digitos: ");
                    numerosNIF = scanner.nextLine();
                    System.out.print("Ingrese la letra: ");
                    letraNIF = scanner.nextLine().charAt(0);
                }
            } else {
                System.out.print("Ingrese la primera letra: ");
                char letraInicialNIE = scanner.nextLine().charAt(0);
                System.out.print("Ingrese los 8 digitos: ");
                String numerosNIE = scanner.nextLine();
                System.out.print("Ingrese la letra final: ");
                char letraFinalNIE = scanner.nextLine().charAt(0);
                documento = new NIE(letraInicialNIE, numerosNIE, letraFinalNIE);
                while (documento.validar() == false) {
                    System.out.print("Ingrese la primera letra: ");
                    letraInicialNIE = scanner.nextLine().charAt(0);
                    System.out.print("Ingrese los 8 digitos: ");
                    numerosNIE = scanner.nextLine();
                    System.out.print("Ingrese la letra final: ");
                    letraFinalNIE = scanner.nextLine().charAt(0);
                }
            }

        System.out.print("Ingrese su nombre: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Ingrese su direccion: ");
        String direccion1 = scanner.nextLine();
        System.out.print("Ingrese su numero de telefono: ");
        String telefono1 = scanner.nextLine();
        System.out.print("Ingrese su fecha de nacimiento (dd/mm/yy): ");
        String fechaNac1 = scanner.nextLine();
        LocalDate fechaNac2 = null;
        System.out.print("Ingrese si quiere suscripcion ('S' para si, 'N' para no): ");
        boolean suscripcion1 = false;
        char suscripcion2 = scanner.nextLine().charAt(0);
        while (suscripcion2 != 'S' && suscripcion2 != 'N'){
            suscripcion2 = scanner.nextLine().charAt(0);
        }
        if (suscripcion2 == 'S') {
            suscripcion1 = true;
        }
        System.out.print("Ingrese el tipo de pago preferido ('E' para “efectivo”, 'T' para “transferencia” y 'C' para tarjeta de crédito): ");
        TipoPago pagoPref2;
        char pagoPref1 = scanner.nextLine().charAt(0);
        while (pagoPref1 != 'E' && pagoPref1 != 'T' && pagoPref1 != 'C'){
            pagoPref1 = scanner.nextLine().charAt(0);
        }
        Cliente cliente1 = new Cliente(documento,nombre1,direccion1,telefono1,fechaNac2, suscripcion1,TipoPago.getCodigo());

    }
}

