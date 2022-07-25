import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Client {

    public Integer id;
    public String taxNumber;
    public String name;

    public Integer getId() {
        return id;
    }


    public String getTaxNumber() {
        return taxNumber;
    }

       public String getName() {
        return name;
    }


}

class Account {

    public Integer clientId;

    public Integer bankId;

    public Integer balance;

    public Integer getClientId() {
        return clientId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public Integer getBalance() {
        return balance;
    }


}

class Bank {

    public Integer id;

    public String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}

public class Main {

    List<Client> clients = List.of(

            new Client() {
                {

                    id = 1;

                    taxNumber = "86620855";

                    name = "HECTOR ACUÑA BOLAÑOS";

                }
            }, new Client() {
                {

                    id = 2;

                    taxNumber = "7317855K";

                    name = "JESUS RODRIGUEZ ALVAREZ";

                }
            }, new Client() {
                {

                    id = 3;

                    taxNumber = "73826497";

                    name = "ANDRES NADAL MOLINA";

                }
            }, new Client() {
                {

                    id = 4;

                    taxNumber = "88587715";

                    name = "SALVADOR ARNEDO MANRIQUEZ";

                }
            }, new Client() {
                {

                    id = 5;

                    taxNumber = "94020190";

                    name = "VICTOR MANUEL ROJAS LUCAS";

                }
            }, new Client() {
                {

                    id = 6;

                    taxNumber = "99804238";

                    name = "MOHAMED FERRE SAMPER";

                }
            }

    );

    List<Account> accounts = List.of(

            new Account() {
                {

                    clientId = 6;

                    bankId = 1;

                    balance = 15000;

                }
            }, new Account() {
                {

                    clientId = 1;

                    bankId = 3;

                    balance = 18000;

                }
            }, new Account() {
                {

                    clientId = 5;

                    bankId = 3;

                    balance = 135000;

                }
            }, new Account() {
                {

                    clientId = 2;

                    bankId = 2;

                    balance = 5600;

                }
            }, new Account() {
                {

                    clientId = 3;

                    bankId = 1;

                    balance = 23000;

                }
            }, new Account() {
                {

                    clientId = 5;

                    bankId = 2;

                    balance = 15000;

                }
            }, new Account() {
                {

                    clientId = 3;

                    bankId = 3;

                    balance = 45900;

                }
            }, new Account() {
                {

                    clientId = 2;

                    bankId = 3;

                    balance = 19000;

                }
            }, new Account() {
                {

                    clientId = 4;

                    bankId = 3;

                    balance = 51000;

                }
            }, new Account() {
                {

                    clientId = 5;

                    bankId = 1;

                    balance = 89000;

                }
            }, new Account() {
                {

                    clientId = 1;

                    bankId = 2;

                    balance = 1600;

                }
            }, new Account() {
                {

                    clientId = 5;

                    bankId = 3;

                    balance = 37500;

                }
            }, new Account() {
                {

                    clientId = 6;

                    bankId = 1;

                    balance = 19200;

                }
            }, new Account() {
                {

                    clientId = 2;

                    bankId = 3;

                    balance = 10000;

                }
            }, new Account() {
                {

                    clientId = 3;

                    bankId = 2;

                    balance = 5400;

                }
            }, new Account() {
                {

                    clientId = 3;

                    bankId = 1;

                    balance = 9000;

                }
            }, new Account() {
                {

                    clientId = 4;

                    bankId = 3;

                    balance = 13500;

                }
            }, new Account() {
                {

                    clientId = 2;

                    bankId = 1;

                    balance = 38200;

                }
            }, new Account() {
                {

                    clientId = 5;

                    bankId = 2;

                    balance = 17000;

                }
            }, new Account() {
                {

                    clientId = 1;

                    bankId = 3;

                    balance = 1000;

                }
            }, new Account() {
                {

                    clientId = 5;

                    bankId = 2;

                    balance = 600;

                }
            }, new Account() {
                {

                    clientId = 6;

                    bankId = 1;

                    balance = 16200;

                }
            }, new Account() {
                {

                    clientId = 2;

                    bankId = 2;

                    balance = 10000;

                }
            }

    );

    List<Bank> banks = List.of(

            new Bank() {
                {

                    id = 1;

                    name = "SANTANDER";

                }
            }, new Bank() {
                {

                    id = 2;

                    name = "CHILE";

                }
            }, new Bank() {
                {

                    id = 3;

                    name = "ESTADO";

                }
            }

    );

    // 0 Arreglo con los ids de clientes

    public Integer[] listClientIds() {
        return clients.stream().map(client -> client.id).toArray(Integer[]::new);
    }

    // 1 Arreglo con los ids de clientes ordenados por rut

    Integer[] listClientsIdsSortByTaxNumber() {
        return clients.stream().sorted(Comparator.comparing(Client::getTaxNumber))
                .map(client -> client.id).toList().toArray(Integer[]::new);
    }

    // 2 Arreglo con los nombres de cliente ordenados de mayor a menor por la suma
    // TOTAL de los saldos de cada cliente en los bancos que participa.

    String[] sortClientsTotalBalances() {
        return accounts.stream()
                .collect(Collectors.groupingBy(Account::getClientId,
                        Collectors.mapping(
                                Account::getBalance,
                                Collectors.summingInt(Integer::intValue))))
                .entrySet().stream().sorted(Entry.<Integer, Integer>comparingByValue().reversed())
                .map(Entry::getKey)
                .map(c -> clients.stream().filter(p -> p.getId().equals(c)).findFirst().get().getName()).toList().toArray(String[]::new);
    }

    // 3 Objeto en que las claves sean los nombres de los bancos y los valores
    // un arreglo con los ruts de sus clientes ordenados alfabéticamente por nombre.


    Map<String, String[]> banksClientsTaxNumbers() {
        // bancos - account - cliente
        return banks.stream()
                .collect(Collectors.toMap(Bank::getName,
                        bank -> accounts.stream().filter(account -> account.getBankId().equals(bank.getId()))
                                .map(Account::getClientId)
                                .map(p -> clients.stream().filter(client -> p.equals(client.getId())).findFirst().get())
                                .sorted(Comparator.comparing(Client::getName))
                                .distinct()
                                .map(Client::getTaxNumber).toList().toArray(String[]::new)));
    }

    // 4 Arreglo ordenado decrecientemente con los saldos de clientes que
    // tengan más de 25.000 en el Banco SANTANDER


    Integer[] richClientsBalances() {
        return banks.stream().filter(bank -> bank.getName().equals("SANTANDER"))
                .flatMap(bank -> accounts.stream()
                        .filter(account -> bank.getId().equals(account.getBankId()))
                        .collect(Collectors.groupingBy(Account::getClientId, Collectors.mapping(
                                Account::getBalance,
                                Collectors.summingInt(Integer::intValue))))
                        .entrySet().stream().filter(i -> i.getValue() > 25000)
                        .sorted(Entry.comparingByValue())
                        .map(Entry::getValue)).toList().toArray(Integer[]::new);
    }

    // 5 Arreglo con ids de bancos ordenados crecientemente por la cantidad
    // TOTAL de dinero que administran.

    Integer[] banksRankingByTotalBalance() {

        return accounts.stream()
                .collect(Collectors.groupingBy(Account::getBankId, Collectors.mapping(
                        Account::getBalance,
                        Collectors.summingInt(Integer::intValue))))
                .entrySet().stream()
                .sorted(Entry.comparingByValue())
                .map(Entry::getKey)
                .toList().toArray(Integer[]::new);

    }

    // 6 Objeto en que las claves sean los nombres de los bancos y los valores
    // el número de clientes que solo tengan cuentas en ese banco.

    Map<String, Integer> banksFidelity() {

        return banks.stream().collect(Collectors.toMap(Bank::getName,
                bank -> accounts.stream().collect(Collectors.groupingBy(
                                Account::getClientId,
                                Collectors.mapping(Account::getBankId, Collectors.toList())
                        )).entrySet().stream().collect(
                                Collectors.toMap(
                                        Entry::getKey,
                                        (integers -> integers.getValue().stream().distinct().toList())))
                        .entrySet().stream()
                        .filter(bankId -> bankId.getValue().size() == 1).collect(Collectors.toMap(
                                Entry::getKey, Entry::getValue))
                        .entrySet().stream().collect(Collectors.toMap(
                                Entry::getKey, id -> id.getValue().stream().filter(e -> e.equals(bank.getId())).toList()))
                        .entrySet().stream().filter(v -> !v.getValue().isEmpty()).map(Entry::getKey).toList().size()));

    }

    // 7 Objeto en que las claves sean los nombres de los bancos y los valores
    // el id de su cliente con menos dinero.

    Map<String, Integer> banksPoorClients() {

        return banks.stream().collect(Collectors.toMap(Bank::getName,
                bank -> accounts.stream().filter(account -> account.getBankId().equals(bank.getId()))
                        .collect(Collectors.groupingBy(
                                Account::getClientId,
                                Collectors.mapping(
                                        Account::getBalance,
                                        Collectors.summingInt(Integer::intValue))))
                        .entrySet().stream().sorted(Entry.comparingByValue()).map(Entry::getKey)
                        .findFirst().get()));
    }

    // 8 Agregar nuevo cliente con datos ficticios a "clientes" y agregar una cuenta
    // en el BANCO ESTADO con un saldo de 9000 para este nuevo empleado.

    // Luego devolver el lugar que ocupa este cliente en el ranking de la pregunta
    // 2.

    // No modificar arreglos originales para no alterar las respuestas anteriores al
    // correr la solución

    int newClientRanking() {

        clients = new ArrayList<>(clients);
        clients.add(new Client() {{
            id = 7;
            taxNumber = "84040291";
            name = "ALEJANDRO ISMAEL MOLINAR TORRES";
        }});

        accounts = new ArrayList<>(accounts);
        accounts.add(new Account() {{
            clientId = 7;
            bankId = 3;
            balance = 9000;
        }});

        List<String> p2 = Arrays.stream(sortClientsTotalBalances()).toList();
        return p2.indexOf("ALEJANDRO ISMAEL MOLINAR TORRES");

    }


    // No modificar, eliminar o alterar cualquier línea de código o comentario de
    // acá para abajo

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


