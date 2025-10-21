import java.util.Scanner;

public class pe4 {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        boolean entranceLight = false, livingRoomLight = false, kitchenLight = false, bedroom1Light = false,
                bedroom2Light = false, bedroom3Light = false, bathroomLight = false, livingRoomDoorLocked = false, bedroom1DoorLocked = false, bedroom2DoorLocked = false, bedroom3DoorLocked = false, bathroomDoorLocked = false,
                kitchenDoorLocked = false, entranceDoorLocked = false;
        int entranceHeat = 26, livingRoomHeat = 22, kitchenHeat = 24, bedroom1Heat = 20, bedroom2Heat = 20,
                bedroom3Heat = 20, bathroomHeat = 23;
        String input;
        do{
            System.out.println(
                    "Que vols fer?:\n\ta) Control de llums\n\tb) Control de Rentadora\n\tc) Control de portes \n\td) Control de termostats\n\te) Sortir");
            input = e.nextLine();
            switch (input) {
                case "a":
                    System.out.println("Control de llums seleccionat.");
                    System.out.println(
                            "De on vols controlar els llums?:\n\ta) totes les habitacions\n\tb) habitació específica");
                    String lightControl = e.nextLine();
                    switch (lightControl) {
                        case "a":
                            System.out.println("Controlant els llums de totes les habitacions.");
                            System.out.println(
                                    "Quina acció vols realitzar?:\n\ta) Encendre llums\n\tb) controlar intensitat\n\tc) Canviar color\n\td) Apagar llums\n\te)Sortir");
                            String lightAction = e.nextLine();
                            switch (lightAction) {
                                case "a":
                                    System.out.println("Encenent els llums de totes les habitacions.");
                                    entranceLight = true;
                                    livingRoomLight = true;
                                    kitchenLight = true;
                                    bedroomLight = true;
                                    bathroomLight = true;
                                    break;
                                case "b":
                                    System.out.println("Controlant la intensitat dels llums de totes les habitacions.");
                                    break;
                                case "c":
                                    System.out.println("Canviant el color dels llums de totes les habitacions.");
                                    break;
                                case "d":
                                    System.out.println("Apagant els llums de totes les habitacions.");
                                    entranceLight = false;
                                    livingRoomLight = false;
                                    kitchenLight = false;
                                    bedroomLight = false;
                                    bathroomLight = false;
                                    break;
                                case "e":
                                    System.out.println("Sortint del control de llums.");
                                    break;
                                default:
                                    System.out.println("Opció no vàlida.");
                                    break;
                            }
                            break;
                        case "b":
                            System.out.println("Quina habitació vols controlar?");
                            String room = e.nextLine();
                            System.out.println("Controlant els llums de l'habitació: " + room);

                            break;
                        default:
                            System.out.println("Opció no vàlida.");
                            break;
                    }
                    break;
                case "b":
                    System.out.println("Control de Rentadora seleccionat.");
                    break;
                case "c":
                    System.out.println("Control de portes seleccionat.");
                    break;
                case "d":
                    System.out.println("Control de termostats seleccionat.");
                    break;
                case "e":
                    System.out.println("Sortint del programa.");
                    break;
                default:
                    System.out.println("Opció no vàlida. Si us plau, intenta-ho de nou.");
                    break;
            }
        } while (!input.equals("e"));

        e.close();
    }
}
// System.out.println("Quina acció vols realitzar?:\n\ta) Encendre llums\n\tb)
// controlar intensitat\n\t Camviar color\n\t \n\tc) Apagar llums");
