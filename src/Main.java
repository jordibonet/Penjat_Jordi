public class Main {
    public static void main(String[] args) {

        String palabra;
        char [] mascara;
        int errores=0;
        boolean salir;
        char letra;
        boolean letraEncontrada;
        char [] letrasUsadas=new char[23];
        boolean nuevaletra;


        palabra = palabraRandom();
        mascara = esconderPalabra(palabra);
        letrasUsadas = letrasEnBlanco(letrasUsadas);

        salir=false;
        do {
            mostrarErrores(errores);
            mostrarAhorcado(errores);
            mostrarMascara(mascara);
            mostrarLetrasUsadas(letrasUsadas);
            letra = elegirLetra();
            nuevaletra = comrpobarLetraNueva(letrasUsadas, letra);
            letrautilizada(nuevaletra, letra);
            incluirLetraUsada(nuevaletra,letra,letrasUsadas);
            letraEncontrada = buscarLetra(letra,mascara,palabra);
            mostrarLetra(letraEncontrada,letra,mascara,palabra);
            errores = comprobarErrores(letraEncontrada,errores,nuevaletra);
            salir = acabarJuego(salir,errores,mascara,palabra);
        }while (!salir);

    }

    private static void letrautilizada(boolean nuevaletra, char letra) {
        if (!nuevaletra){
            System.out.println("La letra " +letra +" ya ha sido utilizada");
        }
    }

    private static void incluirLetraUsada(boolean nuevaletra, char letra, char[] letrasUsadas) {
        if (nuevaletra){
            boolean letranueva=false;
            int i=0;
            do {
                if (letrasUsadas[i]==' '){
                    letrasUsadas[i]=letra;
                    letranueva=true;
                }else i++;
            }while (!letranueva);
        }
    }

    private static boolean comrpobarLetraNueva(char[] letrasUsadas, char letra) {
        boolean nuevaLetra=true;
        for (char letrasUsada : letrasUsadas) {
            if (letra == letrasUsada) {
                nuevaLetra = false;
                break;
            }
        }
        return nuevaLetra;
    }

    private static void mostrarLetrasUsadas(char[] letrasUsadas) {
        System.out.print("\nLetras usadas: ");
        for (char aux:letrasUsadas) {
            System.out.print(aux + " ");
        }
    }

    private static char[] letrasEnBlanco(char[] letrasUsadas) {
        for (int i = 0; i < letrasUsadas.length; i++) {
            letrasUsadas[i]=' ';
        }
        return letrasUsadas;
    }

    private static boolean acabarJuego(boolean salir, int errores, char[] mascara, String palabra) {
        if (errores==6){
            mostrarAhorcado(errores);
            System.out.println("¡¡¡Has perdido!!!");
            System.out.println("La palabra escondida era: " +palabra);
            salir=true;
        }
        boolean acertado=true;
        for (int i = 0; i < palabra.length(); i++) {
            if (mascara[i] != palabra.charAt(i)) {
                acertado = false;
                break;
            }
        }
        if (acertado){
            System.out.println("Palabra: " +palabra);
            System.out.println("¡¡¡Has acertado la palabra!!!");
            salir=true;
        }
        return salir;
    }

    private static int comprobarErrores(boolean letraEncontrada, int errores, boolean nuevaletra) {
        if (!letraEncontrada && nuevaletra){
            errores++;
        }
        return errores;
    }

    private static void mostrarLetra(boolean letraEncontrada, char letra, char[] mascara, String palabra) {
        if (letraEncontrada){
            for (int i = 0; i < mascara.length; i++) {
                if (letra == palabra.charAt(i)){
                    mascara[i]=letra;
                }
            }
        }
    }

    private static boolean buscarLetra(char letra, char[] mascara, String palabra) {
        boolean encontrada=false;
        for (int i = 0; i < mascara.length; i++) {
            if (letra == palabra.charAt(i)) {
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }

    private static char elegirLetra() {
        boolean caracaterLetra=false;
        char letra;
        do {
            System.out.print("\nLetra: ");
            letra= teclat.Teclat.llegirChar();
            boolean letter=Character.isLetter(letra);
            if (!letter){
                System.out.println("El caracter introducido es incorrecto.");
                System.out.println("Introduce una letra de la 'a' a la 'z'");
            }else {
                letra= Character.toLowerCase(letra);
                caracaterLetra=true;
            }
        }while (!caracaterLetra);
        return letra;
    }

    private static void mostrarAhorcado(int errores) {
        switch (errores) {
            case 0:
                System.out.println("-----------");
                System.out.println("|         |");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("-----      ");
                break;
            case 1:
                System.out.println("-----------");
                System.out.println("|         |");
                System.out.println("|         0");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("-----      ");
                break;
            case 2:
                System.out.println("-----------");
                System.out.println("|         |");
                System.out.println("|         0");
                System.out.println("|         |");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("-----      ");
                break;
            case 3:
                System.out.println("-----------");
                System.out.println("|         |");
                System.out.println("|         0");
                System.out.println("|         |\\");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("-----      ");
                break;
            case 4:
                System.out.println("-----------");
                System.out.println("|         |");
                System.out.println("|         0");
                System.out.println("|        /|\\");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("-----      ");
                break;
            case 5:
                System.out.println("-----------");
                System.out.println("|         |");
                System.out.println("|         0");
                System.out.println("|        /|\\");
                System.out.println("|          \\");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("-----      ");
                break;
            case 6:
                System.out.println("-----------");
                System.out.println("|         |");
                System.out.println("|         0");
                System.out.println("|        /|\\");
                System.out.println("|        / \\");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("-----      ");
                break;
        }
    }

    private static void mostrarErrores(int errores) {
        System.out.println("\n\nErrores = " +errores);
    }

    private static void mostrarMascara(char[] mascara) {
        System.out.print("Palabra: ");
        for (char aux:mascara) {
            System.out.print(aux);
        }
    }

    private static char [] esconderPalabra(String palabra) {
        //Creamos una matriz con el número de caracteres como letras tiene la palabra que buscaremos y transformamos
        // estos caracteres en guiones para esconder la palabra
        char [] mascara = new char [palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            mascara[i]='_';
        }
        return mascara;
    }

    private static String palabraRandom() {
        //Se elige al azar una de las 30 palabras de la matriz para ser la palabra que tendremos que buscar
        String [] palabras = {"elefante", "murcielago", "escarabajo", "computadora", "mariposa", "guitarra",
                "helicoptero", "chocolate", "girasol", "pizza", "dinosaurio", "astronauta", "catarata", "pirata",
                "camaleon", "piramide", "violin", "unicornio", "hipopotamo", "anacardo", "jirafa", "telescopio",
                "tigre", "naranja", "paraguas", "acordeon", "orquidea", "metralleta", "teclado", "zanahoria"};
        double numeroAletorio = Math.random();
        int i = (int) (numeroAletorio * 30);
        return palabras[i];
    }
}