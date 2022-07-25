/*
// Propiedad intelectual= Esta prueba fue desarrollada por TCIT el año 2014 y registrada bajo propiedad intelectual, cualquier publicación o difamación podría estar sujeta a acciones legales. Hay otras empresas que nos han copiado esta prueba, no aceptes imitaciones, exige el original xD

// No realizar la prueba en repl.it al hacerlo su respuesta queda disponible para otros postulantes, tampoco subirla a repositorios de github públicos

// No editar

// Utilizar java 16


import java.util.*;

import java.util.stream.Collectors;


class Client {

    public Integer id;

    public String taxNumber;

    public String name;

}


class Account {

    public Integer clientId;

    public Integer bankId;

    public Integer balance;

}


class Bank {

    public Integer id;

    public String name;

}


public class Main {


    List<Client> clients = List.of(

            new Client() {{

                id = 1;

                taxNumber = "86620855";

                name = "HECTOR ACUÑA BOLAÑOS";

            }}, new Client() {{

                id = 2;

                taxNumber = "7317855K";

                name = "JESUS RODRIGUEZ ALVAREZ";

            }}, new Client() {{

                id = 3;

                taxNumber = "73826497";

                name = "ANDRES NADAL MOLINA";

            }}, new Client() {{

                id = 4;

                taxNumber = "88587715";

                name = "SALVADOR ARNEDO MANRIQUEZ";

            }}, new Client() {{

                id = 5;

                taxNumber = "94020190";

                name = "VICTOR MANUEL ROJAS LUCAS";

            }}, new Client() {{

                id = 6;

                taxNumber = "99804238";

                name = "MOHAMED FERRE SAMPER";

            }}

    );


    List<Account> accounts = List.of(

            new Account() {{

                clientId = 6;

                bankId = 1;

                balance = 15000;

            }}, new Account() {{

                clientId = 1;

                bankId = 3;

                balance = 18000;

            }}, new Account() {{

                clientId = 5;

                bankId = 3;

                balance = 135000;

            }}, new Account() {{

                clientId = 2;

                bankId = 2;

                balance = 5600;

            }}, new Account() {{

                clientId = 3;

                bankId = 1;

                balance = 23000;

            }}, new Account() {{

                clientId = 5;

                bankId = 2;

                balance = 15000;

            }}, new Account() {{

                clientId = 3;

                bankId = 3;

                balance = 45900;

            }}, new Account() {{

                clientId = 2;

                bankId = 3;

                balance = 19000;

            }}, new Account() {{

                clientId = 4;

                bankId = 3;

                balance = 51000;

            }}, new Account() {{

                clientId = 5;

                bankId = 1;

                balance = 89000;

            }}, new Account() {{

                clientId = 1;

                bankId = 2;

                balance = 1600;

            }}, new Account() {{

                clientId = 5;

                bankId = 3;

                balance = 37500;

            }}, new Account() {{

                clientId = 6;

                bankId = 1;

                balance = 19200;

            }}, new Account() {{

                clientId = 2;

                bankId = 3;

                balance = 10000;

            }}, new Account() {{

                clientId = 3;

                bankId = 2;

                balance = 5400;

            }}, new Account() {{

                clientId = 3;

                bankId = 1;

                balance = 9000;

            }}, new Account() {{

                clientId = 4;

                bankId = 3;

                balance = 13500;

            }}, new Account() {{

                clientId = 2;

                bankId = 1;

                balance = 38200;

            }}, new Account() {{

                clientId = 5;

                bankId = 2;

                balance = 17000;

            }}, new Account() {{

                clientId = 1;

                bankId = 3;

                balance = 1000;

            }}, new Account() {{

                clientId = 5;

                bankId = 2;

                balance = 600;

            }}, new Account() {{

                clientId = 6;

                bankId = 1;

                balance = 16200;

            }}, new Account() {{

                clientId = 2;

                bankId = 2;

                balance = 10000;

            }}

    );


    List<Bank> banks = List.of(

            new Bank() {{

                id = 1;

                name = "SANTANDER";

            }},

            new Bank() {{

                id = 2;

                name = "CHILE";

            }},

            new Bank() {{

                id = 3;

                name = "ESTADO";

            }}

    );


    */
/*

      SECCIÓN PROBLEMAS:

        - No promover la copia:

          - No preguntar en StackOverflow, foros, o similares ya que estas preguntas/respuestas quedan disponibles a otros candidatos

          - No subir a repositorios públicos (github, o similares)

          - Otros sitios como codepen o editores de texto on-line (codepen, repl, o similares), dejan guardado el código, por lo que les pedimos tampoco usar editores on-line, la mejor forma de debuggear su código es usando un interprete de Java y ejecutarlo de manera local

          - Para nosotros es fácil detectar pruebas con copia, no pierda su tiempo intentando hacerlo

          - Posteriormente, se evaluará conocimiento en programación en entrevistas presenciales

        - Las siguientes son preguntas básicas de Java y manejo de datos. Se evaluará eficiencia, ORDEN y claridad del código entregado.

        - Se debe programar un algoritmo para cada método y que este retorne lo requerido.

        - Debe usar nombres explicativos para sus variables.

        - Los resultados son evaluados con un test automatizado, revise que sus retornos sean con la estructura de datos solicitada en cada pregunta.

        - Métodos menos verbosos, DRY, y buenas prácticas en el código mejoran el puntaje final de su prueba

        - Si necesita hacer supuestos que afecten las respuestas entregadas, por favor déjelos escritos en el cuerpo del correo cuando envíe su prueba (No en este archivo). Supuestos que contradigan lo solicitado, no serán considerados como válidos.

        - Su prueba debe compilar y ejecutarse sin errores con: javac Main.java y java Main

                - Su prueba debe ejecutarse sin errores

    *//*


    // 0 Arreglo con los ids de clientes

    public Integer[] listClientIds(){

        return clients.stream().map(client -> client.id).toArray(Integer[]::new);

    }


    // 1 Arreglo con los ids de clientes ordenados por rut

    Integer[] listClientsIdsSortByTaxNumber() {

        // CODE HERE

        return new Integer[]{};

    }


    // 2 Arreglo con los nombres de cliente ordenados de mayor a menor por la suma TOTAL de los saldos de cada cliente en los bancos que participa.

    String[] sortClientsTotalBalances() {

        // CODE HERE

        return new String[]{};

    }


    // 3 Objeto en que las claves sean los nombres de los bancos y los valores un arreglo con los ruts de sus clientes ordenados alfabéticamente por nombre.

    Map<String, String[]> banksClientsTaxNumbers() {

        // CODE HERE

        return new Hashtable<String, String[]>();

    }


    // 4 Arreglo ordenado decrecientemente con los saldos de clientes que tengan más de 25.000 en el Banco SANTANDER

    Integer[] richClientsBalances() {

        // CODE HERE

        return new Integer[]{};

    }


    // 5 Arreglo con ids de bancos ordenados crecientemente por la cantidad TOTAL de dinero que administran.

    Integer[] banksRankingByTotalBalance() {

        // CODE HERE

        return new Integer[]{};

    }


    // 6 Objeto en que las claves sean los nombres de los bancos y los valores el número de clientes que solo tengan cuentas en ese banco.

    Map<String, Integer> banksFidelity() {

        // CODE HERE

        return new Hashtable<String, Integer>();

    }


    // 7 Objeto en que las claves sean los nombres de los bancos y los valores el id de su cliente con menos dinero.

    Map<String, Integer>  banksPoorClients() {

        // CODE HERE

        return new Hashtable<String, Integer>();

    }


    // 8 Agregar nuevo cliente con datos ficticios a "clientes" y agregar una cuenta en el BANCO ESTADO con un saldo de 9000 para este nuevo empleado.

    // Luego devolver el lugar que ocupa este cliente en el ranking de la pregunta 2.

    // No modificar arreglos originales para no alterar las respuestas anteriores al correr la solución

    int newClientRanking() {

        // CODE HERE

        return -1;

    }




    // No modificar, eliminar o alterar cualquier línea de código o comentario de acá para abajo

    // Cualquier cambio hará que su prueba quede invalidada automáticamente


    public static void main(String[] args) {

        Main main = new Main();

        System.out.println("Pregunta 0");

        Integer[] p0 = main.listClientIds();

        System.out.println(Arrays.toString(p0));

        System.out.println("Pregunta 1");

        Integer[] p1 = main.listClientsIdsSortByTaxNumber();

        System.out.println(Arrays.toString(p1));

        System.out.println("Pregunta 2");

        String[] p2 = main.sortClientsTotalBalances();

        System.out.println(Arrays.toString(p2));

        System.out.println("Pregunta 3");

        Map<String, String[]> p3 = main.banksClientsTaxNumbers();

        System.out.println(p3.keySet().stream()

                .map(key -> key + "=" + Arrays.toString(p3.get(key)))

                .collect(Collectors.joining(", ", "{", "}")));

        System.out.println("Pregunta 4");

        Integer[] p4 = main.richClientsBalances();

        System.out.println(Arrays.toString(p4));

        System.out.println("Pregunta 5");

        Integer[] p5 = main.banksRankingByTotalBalance();

        System.out.println(Arrays.toString(p5));

        System.out.println("Pregunta 6");

        Map<String, Integer> p6 = main.banksFidelity();

        System.out.println(p6.keySet().stream()

                .map(key -> key + "=" + p6.get(key))

                .collect(Collectors.joining(", ", "{", "}")));


        System.out.println("Pregunta 7");

        Map<String, Integer> p7 = main.banksPoorClients();

        System.out.println(p7.keySet().stream()

                .map(key -> key + "=" + p7.get(key))

                .collect(Collectors.joining(", ", "{", "}")));


        System.out.println("Pregunta 8");

        System.out.println(main.newClientRanking());

    }

}



*/
