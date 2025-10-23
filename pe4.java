import java.util.Scanner;

public class PE4 {

    // Estat de les llums
    static boolean entradaLight = false, menjadorLight = false, cuinaLight = false,
            habitacio1Light = false, habitacio2Light = false, habitacio3Light = false, banyLight = false;

    // Intensitat de les llums
    static int entradaLightIntensity = 50, menjadorLightIntensity = 50, cuinaLightIntensity = 50,
            habitacio1LightIntensity = 50, habitacio2LightIntensity = 50, habitacio3LightIntensity = 50,
            banyLightIntensity = 50;

    // Color de les llums
    static String entradaLightColor = "Blanc", menjadorLightColor = "Blanc", cuinaLightColor = "Blanc",
            habitacio1LightColor = "Blanc", habitacio2LightColor = "Blanc", habitacio3LightColor = "Blanc",
            banyLightColor = "Blanc";

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        String input;

        do {
            System.out.println(
                    "Què vols fer?:\n" +
                            "\ta) Control de llums\n" +
                            "\tb) Control de Rentadora\n" +
                            "\tc) Control de portes\n" +
                            "\td) Control de termòstats\n" +
                            "\te) Sortir");

            input = e.nextLine();

            switch (input) {
                case "a":
                    lightMenu(e);
                    break;
                case "b":
                    washingMachineControl();
                    break;
                case "c":
                    doorControl();
                    break;
                case "d":
                    thermostatControl();
                    break;
                case "e":
                    System.out.println("Sortint del programa...");
                    break;
                default:
                    System.out.println("Opció no vàlida. Si us plau, intenta-ho de nou.");
                    break;
            }

        } while (!input.equals("e"));

        e.close();
    }

    public static void lightMenu(Scanner e) {
        System.out.println(
                "Control de llums seleccionat.\n" +
                        "Desitges controlar:\n" +
                        "\ta) Totes les habitacions\n" +
                        "\tb) Habitació específica\n" +
                        "\tc) Estat de les llums");
        String lightControl = e.nextLine();

        switch (lightControl) {
            case "a":
                allLightsControl(e);
                break;
            case "b":
                roomLightControl(e);
                break;
            case "c":
                showLightsStatus();
                break;
            default:
                System.out.println("Opció no vàlida.");
                break;
        }
    }

    public static void showLightsStatus() {
        System.out.println("\n--- Estat actual de les llums ---");
        System.out.print("\tEntrada (");
        if (entradaLight)
            System.out.print("encès");
        else
            System.out.print("apagada");
        System.out.println(")");

        System.out.print("\tMenjador (");
        if (menjadorLight)
            System.out.print("encès");
        else
            System.out.print("apagada");
        System.out.println(")");

        System.out.print("\tCuina (");
        if (cuinaLight)
            System.out.print("encès");
        else
            System.out.print("apagada");
        System.out.println(")");

        System.out.print("\tHabitació 1 (");
        if (habitacio1Light)
            System.out.print("encès");
        else
            System.out.print("apagada");
        System.out.print(") - Habitació 2 (");
        if (habitacio2Light)
            System.out.print("encès");
        else
            System.out.print("apagada");
        System.out.print(") - Habitació 3 (");
        if (habitacio3Light)
            System.out.print("encès");
        else
            System.out.print("apagada");
        System.out.println(")");

        System.out.print("\tBany (");
        if (banyLight)
            System.out.print("encès");
        else
            System.out.print("apagada");
        System.out.println(")\n---------------------------------\n");
    }

    public static void allLightsControl(Scanner e) {
        System.out.println(
                "Quina acció vols realitzar?:\n" +
                        "\ta) Encendre llums\n" +
                        "\tb) Controlar intensitat\n" +
                        "\tc) Canviar color\n" +
                        "\td) Apagar llums\n" +
                        "\te) Sortir");
        String lightAction = e.nextLine();

        if (lightAction.equals("a"))
            turnOnAllLights();
        else if (lightAction.equals("b"))
            adjustAllLightIntensity(e);
        else if (lightAction.equals("c"))
            changeAllLightsColor(e);
        else if (lightAction.equals("d"))
            turnOffAllLights();
        else if (lightAction.equals("e"))
            System.out.println("Sortint del control de llums...");
        else
            System.out.println("Opció no vàlida.");
    }

    public static void turnOnAllLights() {
        entradaLight = true;
        menjadorLight = true;
        cuinaLight = true;
        habitacio1Light = true;
        habitacio2Light = true;
        habitacio3Light = true;
        banyLight = true;
        System.out.println("S'han encès totes les llums.");
    }

    public static void turnOffAllLights() {
        entradaLight = false;
        menjadorLight = false;
        cuinaLight = false;
        habitacio1Light = false;
        habitacio2Light = false;
        habitacio3Light = false;
        banyLight = false;
        System.out.println("S'han apagat totes les llums.");
    }

    public static void adjustAllLightIntensity(Scanner e) {
        System.out.println(
                "Com vols ajustar la intensitat?\n" +
                        "\ta) Intensitat específica\n" +
                        "\tb) Baixar intensitat en 10%\n" +
                        "\tc) Pujar intensitat en 10%");
        String intensityControl = e.nextLine();
        if (intensityControl.equals("a")) {
            System.out.print("Introdueix la nova intensitat (0-100): ");
            int specific = e.nextInt();
            e.nextLine();
            setAllIntensity(specific);
        } else if (intensityControl.equals("b"))
            changeAllIntensity(-10);
        else if (intensityControl.equals("c"))
            changeAllIntensity(10);
        else
            System.out.println("Opció no vàlida.");
    }

    public static void setAllIntensity(int value) {
        entradaLightIntensity = value;
        menjadorLightIntensity = value;
        cuinaLightIntensity = value;
        habitacio1LightIntensity = value;
        habitacio2LightIntensity = value;
        habitacio3LightIntensity = value;
        banyLightIntensity = value;
        System.out.println("S'ha establert la intensitat a " + value + "% a totes les habitacions.");
    }

    public static void changeAllIntensity(int delta) {
        entradaLightIntensity += delta;
        menjadorLightIntensity += delta;
        cuinaLightIntensity += delta;
        habitacio1LightIntensity += delta;
        habitacio2LightIntensity += delta;
        habitacio3LightIntensity += delta;
        banyLightIntensity += delta;
        System.out.println("S'ha ajustat la intensitat de totes les habitacions en " + delta + "%.");
    }

    public static void changeAllLightsColor(Scanner e) {
        System.out.print("Introdueix el nou color per a totes les llums: ");
        String color = e.nextLine();
        entradaLightColor = menjadorLightColor = cuinaLightColor = habitacio1LightColor = habitacio2LightColor = habitacio3LightColor = banyLightColor = color;
        System.out.println("S'ha canviat el color de totes les llums a " + color + ".");
    }

    public static void roomLightControl(Scanner e) {
        System.out.println(
                "Quina habitació vols controlar?\n" +
                        "\t- entrada\n" +
                        "\t- menjador\n" +
                        "\t- cuina\n" +
                        "\t- habitacio1\n" +
                        "\t- habitacio2\n" +
                        "\t- habitacio3\n" +
                        "\t- bany");
        String room = e.nextLine().toLowerCase();

        System.out.println(
                "Quina acció vols realitzar?:\n" +
                        "\ta) Encendre llum\n" +
                        "\tb) Controlar intensitat\n" +
                        "\tc) Canviar color\n" +
                        "\td) Apagar llum\n" +
                        "\te) Sortir");
        String action = e.nextLine();

        if (action.equals("a"))
            setLightState(room, true);
        else if (action.equals("b"))
            adjustRoomIntensity(e, room);
        else if (action.equals("c"))
            changeRoomLightColor(e, room);
        else if (action.equals("d"))
            setLightState(room, false);
        else if (action.equals("e"))
            System.out.println("Sortint del control d'habitació...");
        else
            System.out.println("Opció no vàlida.");
    }

    public static void setLightState(String room, boolean state) {
        String accio = "";
        if (room.equals("entrada"))
            entradaLight = state;
        else if (room.equals("menjador"))
            menjadorLight = state;
        else if (room.equals("cuina"))
            cuinaLight = state;
        else if (room.equals("habitacio1"))
            habitacio1Light = state;
        else if (room.equals("habitacio2"))
            habitacio2Light = state;
        else if (room.equals("habitacio3"))
            habitacio3Light = state;
        else if (room.equals("bany"))
            banyLight = state;
        else {
            System.out.println("Habitació no reconeguda.");
            return;
        }

        if (state)
            accio = "encès";
        else
            accio = "apagada";
        System.out.println("S'ha " + accio + " la llum de " + room + ".");
    }

    public static void adjustRoomIntensity(Scanner e, String room) {
        System.out.print("Nova intensitat per a " + room + " (0-100): ");
        int intensity = e.nextInt();
        e.nextLine();

        if (room.equals("entrada"))
            entradaLightIntensity = intensity;
        else if (room.equals("menjador"))
            menjadorLightIntensity = intensity;
        else if (room.equals("cuina"))
            cuinaLightIntensity = intensity;
        else if (room.equals("habitacio1"))
            habitacio1LightIntensity = intensity;
        else if (room.equals("habitacio2"))
            habitacio2LightIntensity = intensity;
        else if (room.equals("habitacio3"))
            habitacio3LightIntensity = intensity;
        else if (room.equals("bany"))
            banyLightIntensity = intensity;
        else {
            System.out.println("Habitació no reconeguda.");
            return;
        }

        System.out.println("S'ha ajustat la intensitat de " + room + " a " + intensity + "%.");
    }

    public static void changeRoomLightColor(Scanner e, String room) {
        System.out.print("Introdueix el nou color per a " + room + ": ");
        String color = e.nextLine();

        if (room.equals("entrada"))
            entradaLightColor = color;
        else if (room.equals("menjador"))
            menjadorLightColor = color;
        else if (room.equals("cuina"))
            cuinaLightColor = color;
        else if (room.equals("habitacio1"))
            habitacio1LightColor = color;
        else if (room.equals("habitacio2"))
            habitacio2LightColor = color;
        else if (room.equals("habitacio3"))
            habitacio3LightColor = color;
        else if (room.equals("bany"))
            banyLightColor = color;
        else {
            System.out.println("Habitació no reconeguda.");
            return;
        }

        System.out.println("S'ha canviat el color de la llum de " + room + " a " + color + ".");
    }

    public static void washingMachineControl() {
        System.out.println("Control de Rentadora seleccionat.");
    }

    public static void doorControl() {
        System.out.println("Control de portes seleccionat.");
    }

    public static void thermostatControl() {
        System.out.println("Control de termòstats seleccionat.");
    }
}
