import java.util.Scanner;

public class PE4 {
    // Llums
    // Estat de les llums
    static boolean entryLight = false;
    static boolean livingLight = false;
    static boolean kitchenLight = false;
    static boolean bedroom1Light = false;
    static boolean bedroom2Light = false;
    static boolean bedroom3Light = false;
    static boolean bathroomLight = false;

    // Intensitat de les llums (0-100)
    static int entryIntensity = 0;
    static int livingIntensity = 0;
    static int kitchenIntensity = 0;
    static int bedroom1Intensity = 0;
    static int bedroom2Intensity = 0;
    static int bedroom3Intensity = 0;
    static int bathroomIntensity = 0;

    // Rentadora
    static boolean washingRunning = false;
    static String washingMode = "regular";

    // Portes
    // Estat de les portes (oberta/tancada i bloquejada/desbloquejada)
    static boolean entryDoorOpen = false;
    static boolean entryDoorLocked = true;
    static boolean livingDoorOpen = false;
    static boolean livingDoorLocked = true;
    static boolean kitchenDoorOpen = false;
    static boolean kitchenDoorLocked = true;
    static boolean bedroom1DoorOpen = false;
    static boolean bedroom1DoorLocked = true;
    static boolean bedroom2DoorOpen = false;
    static boolean bedroom2DoorLocked = true;
    static boolean bedroom3DoorOpen = false;
    static boolean bedroom3DoorLocked = true;
    static boolean bathroomDoorOpen = false;
    static boolean bathroomDoorLocked = true;
    static boolean panicMode = false;

    // Termòstats
    static int entryTemp = 21;
    static int livingTemp = 21;
    static int kitchenTemp = 21;
    static int bedroom1Temp = 21;
    static int bedroom2Temp = 21;
    static int bedroom3Temp = 21;
    static int bathroomTemp = 21;

    // Menú principal
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        String option;
        System.out.println("Totes les llums estan APAGADES.");
        do {
            if (panicMode) {
                for (int panicModeTime = 30; panicModeTime > 0; panicModeTime = panicModeTime - 5) {
                    System.out.println("Panic mode activat. Temps restant: " + panicModeTime + " minuts.");
                    e.nextLine();
                }
                panicMode = false;
                System.out.println("Panic mode desactivat.");
                option = "";
            } else {

                System.out.println("\nQuè vols fer?:");
                System.out.println("a) Control de llums");
                System.out.println("b) Rentadora");
                System.out.println("c) Control de portes");
                System.out.println("d) Termòstats");
                System.out.println("e) Sortir");
                option = e.nextLine();
                // Opcions del menú principal
                if (option.equalsIgnoreCase("a")) {
                    lightMenu(e);
                } else if (option.equalsIgnoreCase("b")) {
                    washingMenu(e);
                } else if (option.equalsIgnoreCase("c")) {
                    doorMenu(e);
                } else if (option.equalsIgnoreCase("d")) {
                    thermostatMenu(e);
                } else if (option.equalsIgnoreCase("e")) {
                    System.out.println("Sortint del sistema SmartHome...");
                } else {
                    System.out.println("Opció no vàlida.");
                }
            }
        } while (!option.equalsIgnoreCase("e"));

        e.close();
    }

    // Llums
    public static void lightMenu(Scanner e) {
        String option;
        // Menú de control de llums
        do {
            System.out.println("\nControl de llums:");
            System.out.println("a) Totes les habitacions");
            System.out.println("b) Habitació específica");
            System.out.println("c) Mostrar estat");
            System.out.println("d) Sortir");
            option = e.nextLine();
            // Opcions del menú de llums
            if (option.equalsIgnoreCase("a")) {
                allLightsMenu(e);
            } else if (option.equalsIgnoreCase("b")) {
                roomLightMenu(e);
            } else if (option.equalsIgnoreCase("c")) {
                showLightsStatus();
            }

        } while (!option.equalsIgnoreCase("d"));
    }

    // Funcions de control de totes les llums
    public static void allLightsMenu(Scanner e) {
        System.out.println("a) Encendre totes");
        System.out.println("b) Ajustar intensitat de totes");
        System.out.println("c) Apagar totes");
        System.out.println("d) Sortir");
        String option = e.nextLine();
        // Opcions del menú de totes les llums
        if (option.equalsIgnoreCase("a")) {
            setAllLights(true);
        } else if (option.equalsIgnoreCase("b")) {
            adjustAllLightsIntensity(e);
        } else if (option.equalsIgnoreCase("c")) {
            setAllLights(false);
        }
    }

    // Funcions específiques de control de totes les llums
    public static void setAllLights(boolean state) {
        entryLight = livingLight = kitchenLight = bedroom1Light = bedroom2Light = bedroom3Light = bathroomLight = state;
        if (state) {
            entryIntensity = livingIntensity = kitchenIntensity = bedroom1Intensity = bedroom2Intensity = bedroom3Intensity = bathroomIntensity = 100;
            System.out.println("Totes les llums s'han encès al 100% d'intensitat.");
        } else {
            entryIntensity = livingIntensity = kitchenIntensity = bedroom1Intensity = bedroom2Intensity = bedroom3Intensity = bathroomIntensity = 0;
            System.out.println("Totes les llums s'han apagat.");
        }
    }

    // Ajustar intensitat de totes les llums
    public static void adjustAllLightsIntensity(Scanner e) {
        System.out.print("Introdueix la nova intensitat (0-100): ");
        String input = e.nextLine();
        boolean valid = true;
        int intensity = 0;
        // Validació de l'entrada
        try {
            intensity = Integer.parseInt(input);
        } catch (Exception ex) {
            valid = false;
        }
        // Comprovació de validesa
        if (!valid || intensity < 0 || intensity > 100) {
            System.out.println("Valor no vàlid.");
            return;
        }
        // Ajustar intensitat de totes les llums
        entryIntensity = livingIntensity = kitchenIntensity = bedroom1Intensity = bedroom2Intensity = bedroom3Intensity = bathroomIntensity = intensity;
        System.out.println("Intensitat de totes les llums establerta a " + intensity + "%.");
    }

    // Funcions de control de llum per habitació específica
    public static void roomLightMenu(Scanner e) {
        System.out.print("Escriu la habitació: ");
        String room = e.nextLine();

        System.out.println("a) Encendre");
        System.out.println("b) Ajustar intensitat");
        System.out.println("c) Apagar");
        System.out.println("d) Sortir");
        String option = e.nextLine();
        // Opcions del menú de llum per habitació específica
        if (option.equalsIgnoreCase("a")) {
            changeRoomLight(room, true);
        } else if (option.equalsIgnoreCase("b")) {
            adjustRoomIntensity(e, room);
        } else if (option.equalsIgnoreCase("c")) {
            changeRoomLight(room, false);
        }
    }

    // Funcions específiques de control de llum per habitació específica
    public static void changeRoomLight(String room, boolean state) {
        if (room.equalsIgnoreCase("entrada")) {
            entryLight = state;
        } else if (room.equalsIgnoreCase("menjador")) {
            livingLight = state;
        } else if (room.equalsIgnoreCase("cuina")) {
            kitchenLight = state;
        } else if (room.equalsIgnoreCase("habitacio1")) {
            bedroom1Light = state;
        } else if (room.equalsIgnoreCase("habitacio2")) {
            bedroom2Light = state;
        } else if (room.equalsIgnoreCase("habitacio3")) {
            bedroom3Light = state;
        } else if (room.equalsIgnoreCase("bany")) {
            bathroomLight = state;
        } else {
            System.out.println("Habitació no reconeguda.");
            return;
        }
        // Mostrar estat de la llum després del canvi
        if (state) {
            System.out.println("La llum de " + room + " està encesa.");
        } else {
            System.out.println("La llum de " + room + " està apagada.");
        }
    }

    // Ajustar intensitat de la llum per habitació específica
    public static void adjustRoomIntensity(Scanner e, String room) {
        System.out.print("Nova intensitat (0-100): ");
        String input = e.nextLine();
        boolean valid = true;
        int intensity = 0;
        // Validació de l'entrada
        try {
            intensity = Integer.parseInt(input);
        } catch (Exception ex) {
            valid = false;
        }
        // Comprovació de validesa
        if (!valid || intensity < 0 || intensity > 100) {
            System.out.println("Valor no vàlid.");
            return;
        }
        // Ajustar intensitat segons l'habitació
        if (room.equalsIgnoreCase("entrada")) {
            entryIntensity = intensity;
        } else if (room.equalsIgnoreCase("menjador")) {
            livingIntensity = intensity;
        } else if (room.equalsIgnoreCase("cuina")) {
            kitchenIntensity = intensity;
        } else if (room.equalsIgnoreCase("habitacio1")) {
            bedroom1Intensity = intensity;
        } else if (room.equalsIgnoreCase("habitacio2")) {
            bedroom2Intensity = intensity;
        } else if (room.equalsIgnoreCase("habitacio3")) {
            bedroom3Intensity = intensity;
        } else if (room.equalsIgnoreCase("bany")) {
            bathroomIntensity = intensity;
        } else {
            System.out.println("Habitació no reconeguda.");
            return;
        }
        // Mostrar intensitat després del canvi
        System.out.println("Intensitat de " + room + " establerta a " + intensity + "%.");
    }

    // Mostrar estat de totes les llums
    public static void showLightsStatus() {
        System.out.println("Entrada: " + entryLight);
        System.out.println("Menjador: " + livingLight);
        System.out.println("Cuina: " + kitchenLight);
        System.out.println("Habitació1: " + bedroom1Light);
        System.out.println("Habitació2: " + bedroom2Light);
        System.out.println("Habitació3: " + bedroom3Light);
        System.out.println("Bany: " + bathroomLight);
    }

    // Rentadora
    // Menú de control de la rentadora
    public static void washingMenu(Scanner e) {
        String option;
        // Opcions del menú de la rentadora
        do {
            System.out.println("\nControl de rentadora:");
            System.out.println("a) Iniciar programa");
            System.out.println("b) Establir mode");
            System.out.println("c) Comprovar estat");
            System.out.println("d) Cancel·lar programa");
            System.out.println("e) Sortir");
            option = e.nextLine();
            // Funcions específiques de la rentadora
            if (option.equalsIgnoreCase("a")) {
                if (washingRunning) {
                    System.out.println("Programa ja en execució.");
                } else {
                    washingRunning = true;
                    System.out.println("Programa iniciat en mode " + washingMode + ".");
                }

                // Establir mode de rentadora
            } else if (option.equalsIgnoreCase("b")) {
                System.out.println("a) Mode eco");
                System.out.println("b) Mode turbo");
                System.out.println("c) Mode regular");
                String mode = e.nextLine();
                // Canviar mode segons l'entrada
                if (mode.equalsIgnoreCase("a")) {
                    washingMode = "eco";
                } else if (mode.equalsIgnoreCase("b")) {
                    washingMode = "turbo";
                } else if (mode.equalsIgnoreCase("c")) {
                    washingMode = "regular";
                } else {
                    System.out.println("Mode no vàlid.");
                }

                System.out.println("Mode establert a: " + washingMode);
            } else if (option.equalsIgnoreCase("c")) {
                System.out.println("Programa en execució: " + washingRunning);
                System.out.println("Mode actual: " + washingMode);
            } else if (option.equalsIgnoreCase("d")) {
                washingRunning = false;
                System.out.println("Programa cancel·lat.");
            }

        } while (!option.equalsIgnoreCase("e"));
    }

    // Portes
    public static void doorMenu(Scanner e) {
        // Menú de control de portes
        String option;
        do {
            System.out.println("\nControl de portes:");
            System.out.println("a) Porta específica");
            System.out.println("b) Totes les portes");
            System.out.println("c) Comprovar portes");
            System.out.println("d) Panic mode");
            System.out.println("e) Sortir");
            option = e.nextLine();

            // Opcions del menú de portes
            if (option.equalsIgnoreCase("a")) {
                specificDoorMenu(e);
            } else if (option.equalsIgnoreCase("b")) {
                allDoorsMenu(e);
            } else if (option.equalsIgnoreCase("c")) {
                checkDoors();
            } else if (option.equalsIgnoreCase("d")) {
                panicMode = !panicMode;
                System.out.println("Panic mode: " + panicMode);
                break;
            }

        } while (!option.equalsIgnoreCase("e"));
    }

    // Termòstats
    public static void thermostatMenu(Scanner e) {
        String option;
        // Menú de control de termòstats
        do {
            System.out.println("\nControl de termòstats:");
            System.out.println("a) Canviar temperatura per habitació específica");
            System.out.println("b) Canviar temperatura de totes les habitacions");
            System.out.println("c) Sortir");
            option = e.nextLine();
            // Opcions del menú de termòstats
            if (option.equalsIgnoreCase("a")) {
                specificRoomTempMenu(e);
            } else if (option.equalsIgnoreCase("b")) {
                allRoomsTemperature(e);
            }

        } while (!option.equalsIgnoreCase("c"));
    }

    // Funció per calcular la nova temperatura
    public static int calculateNewTemperature(int current, String action, boolean manual, int newTemp) {
        int temp = current;
        // Canvi segons l'acció
        if (manual) {
            temp = newTemp;
        } else if (action.equalsIgnoreCase("b")) {
            temp = temp + 1;
        } else if (action.equalsIgnoreCase("c")) {
            temp = temp - 1;
        }

        if (temp < 10) {
            temp = 10;
        }
        if (temp > 30) {
            temp = 30;
        }

        return temp;
    }

    // Funció per actualitzar la temperatura d'una habitació específica
    public static void updateRoomTemperature(String room, String action, Scanner e) {
        int newTemp = 0;
        boolean manual = false;
        // Si l'acció és manual, demanar la nova temperatura
        if (action.equalsIgnoreCase("a")) {
            System.out.print("Introdueix la nova temperatura: ");
            String input = e.nextLine();
            boolean valid = true;
            try {
                newTemp = Integer.parseInt(input);
            } catch (Exception ex) {
                valid = false;
            }
            if (!valid) {
                System.out.println("Valor no vàlid.");
                return;
            }
            manual = true;
        }
        // Actualitzar la temperatura segons l'habitació
        if (room.equalsIgnoreCase("entrada")) {
            entryTemp = calculateNewTemperature(entryTemp, action, manual, newTemp);
        } else if (room.equalsIgnoreCase("menjador")) {
            livingTemp = calculateNewTemperature(livingTemp, action, manual, newTemp);
        } else if (room.equalsIgnoreCase("cuina")) {
            kitchenTemp = calculateNewTemperature(kitchenTemp, action, manual, newTemp);
        } else if (room.equalsIgnoreCase("habitacio1")) {
            bedroom1Temp = calculateNewTemperature(bedroom1Temp, action, manual, newTemp);
        } else if (room.equalsIgnoreCase("habitacio2")) {
            bedroom2Temp = calculateNewTemperature(bedroom2Temp, action, manual, newTemp);
        } else if (room.equalsIgnoreCase("habitacio3")) {
            bedroom3Temp = calculateNewTemperature(bedroom3Temp, action, manual, newTemp);
        } else if (room.equalsIgnoreCase("bany")) {
            bathroomTemp = calculateNewTemperature(bathroomTemp, action, manual, newTemp);
        } else {
            System.out.println("Habitació no reconeguda.");
        }
    }

    // Funció per actualitzar la temperatura de totes les habitacions
public static void allRoomsTemperature(Scanner e) {
    System.out.println("a) Triar temperatura manualment");
    System.out.println("b) Augmentar temperatura (+1)");
    System.out.println("c) Disminuir temperatura (-1)");
    System.out.println("d) Sortir");
    String action = e.nextLine();

    if (action.equalsIgnoreCase("d")) {
        return;
    }

    int newTemp = 0; // variable per guardar la temperatura manual
    boolean manual = false;

    if (action.equalsIgnoreCase("a")) {
        System.out.print("Introdueix la nova temperatura: ");
        String input = e.nextLine();
        try {
            newTemp = Integer.parseInt(input);
            manual = true;
        } catch (Exception ex) {
            System.out.println("Valor no vàlid.");
            return;
        }
    }

    // Aplicar la mateixa acció a totes les habitacions
    entryTemp    = calculateNewTemperature(entryTemp, action, manual, newTemp);
    livingTemp   = calculateNewTemperature(livingTemp, action, manual, newTemp);
    kitchenTemp  = calculateNewTemperature(kitchenTemp, action, manual, newTemp);
    bedroom1Temp = calculateNewTemperature(bedroom1Temp, action, manual, newTemp);
    bedroom2Temp = calculateNewTemperature(bedroom2Temp, action, manual, newTemp);
    bedroom3Temp = calculateNewTemperature(bedroom3Temp, action, manual, newTemp);
    bathroomTemp = calculateNewTemperature(bathroomTemp, action, manual, newTemp);

    System.out.println("Temperatures actualitzades:");
    System.out.println("Entrada: " + entryTemp + "°C");
    System.out.println("Menjador: " + livingTemp + "°C");
    System.out.println("Cuina: " + kitchenTemp + "°C");
    System.out.println("Habitació1: " + bedroom1Temp + "°C");
    System.out.println("Habitació2: " + bedroom2Temp + "°C");
    System.out.println("Habitació3: " + bedroom3Temp + "°C");
    System.out.println("Bany: " + bathroomTemp + "°C");
}

    // Aquí afegiria les funcions específiques per portes, DRY també es pot aplicar
    public static void specificDoorMenu(Scanner e) {
        System.out.println("Funció de porta específica no implementada encara.");
    }

    // Funció per totes les portes
    public static void allDoorsMenu(Scanner e) {
        System.out.println("Funció de totes les portes no implementada encara.");
    }

    // Funció per comprovar portes
    public static void checkDoors() {
        System.out.println("Funció de comprovar portes no implementada encara.");
    }
    // Funció per menú de temperatura d'habitació específica
    public static void specificRoomTempMenu(Scanner e) {
        System.out.print("Escriu la habitació: ");
        String room = e.nextLine();

        System.out.println("a) Triar temperatura manualment");
        System.out.println("b) Augmentar temperatura (+1)");
        System.out.println("c) Disminuir temperatura (-1)");
        System.out.println("d) Sortir");
        String action = e.nextLine();
        // Si l'acció és sortir, tornar

        if (!action.equalsIgnoreCase("d")) {
            updateRoomTemperature(room, action, e);
            System.out.println("Temperatura de " + room + " actualitzada.");
        }
    }
}
