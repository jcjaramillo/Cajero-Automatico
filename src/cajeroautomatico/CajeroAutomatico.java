package cajeroautomatico;
//importacion scanner
import java.util.Scanner;

/**
 *
 * @author jcarl
 */
public class CajeroAutomatico {

    public static void main(String[] args) {
        // TODO code application logic here
        //clase escaner
        Scanner sc = new Scanner(System.in);
        //opcion para el cajero
        int opcion;
        //contraseña para seguridad
        String contraseña;
        //saldo inicial
        int saldo_inicial = 200000;
        //transacciones o acciones
        int deposito, giro;
        //intentos de contraseña erronea
        int intentos = 0;
        //variables
        int continuar = 0;
        boolean salir = false;
        int saldo_actual;
        
        //menu repetitivo
        do {            
            System.out.println("Ingrese su contrasena : ");
            contraseña = sc.next(); //lee contraseña
            
            //si esta bien,ingresa a las opciones
            if (contraseña.equals("holamundo")) {
                //transacciones
                while (!salir) { //true
                    System.out.println("");
                    System.out.println("Cajero JCJ");
                    System.out.println("");
                    System.out.println("Ingrese una opcion");
                    System.out.println("1.- Depositar");
                    System.out.println("2.- Girar");
                    System.out.println("3.- Consulta de saldo");
                    System.out.println("4.- Salir");
                    opcion = sc.nextInt(); //lee las opciones
                    
                    switch (opcion) {
                        case 1:
                            System.out.println("");
                            System.out.print("Ingrese cantidad a depositar : ");
                            deposito = sc.nextInt(); //lee el deposito
                            saldo_actual = saldo_inicial + deposito; //saldo inicial + deposito
                            System.out.println("Deposito : " + deposito); //muestra cantidad depositada
                            System.out.println("");
                            System.out.println("---------------------------------------------");
                            System.out.println("Su saldo actual es : " + saldo_actual);
                            System.out.println("---------------------------------------------");
                            saldo_inicial = saldo_actual;
                            break;
                        case 2:
                            System.out.println("");
                            System.out.println("Ingrese cantidad a girar : ");
                            giro = sc.nextInt(); //lee el giro
                            
                            if (giro > saldo_inicial) {
                                System.out.println("");
                                System.out.println("Saldo insuficiente");
                            }else{
                                saldo_actual = saldo_inicial - giro;
                                saldo_inicial = saldo_actual;
                                 System.out.println("");
                                 System.out.println("Retiro de : " + giro); //muestra cantidad retirada
                                 System.out.println("");
                                 System.out.println("---------------------------------------------");
                                 System.out.println("Su saldo actual es : " + saldo_inicial);
                                 System.out.println("---------------------------------------------");
                                 System.out.println("");
                            }
                        case 3:
                            System.out.println("");
                            System.out.println("----------------------------------------------");
                            System.out.println("Su saldo actual es : " + saldo_inicial);
                            System.out.println("----------------------------------------------");
                            break;
                        case 4:
                            salir = true;
                            continuar = 1;
                            System.out.println("");
                            System.out.println("GRACIAS VUELVA PRONTO !!!");
                        default:
                            System.out.println("");
                            System.out.println("Opcion Incorrecta");
                            System.out.println("");
                    }
                }
            }else{ //si esta erronea
                System.out.println("");
                System.out.println("************************");
                System.out.println("contrasena incorrecta");
                System.out.println("************************");
                System.out.println("");
                intentos++; //intento suma 1
            }
            //suma de intentos 3
            if (intentos == 3) { //si esta erronea 3 veces se cierra el programa
                System.out.println("");
                System.out.println("Usted a intentado mas de 3 veces, por seguridad se ha bloqueado el acceso");
                break;
            }
        } while (continuar == 0);
    }
}
