package calculadoragrpc.cliente;

import com.proto.saludo.SaludoServiceGrpc;
import com.proto.saludo.Holamundo.SaludoRequest;
import com.proto.saludo.Holamundo.SaludoResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Cliente {
    public static void main(String[] args) {
        //Servidor
        String host = "localhost";
        //Puerto
        int port = 3000;
        //Canal comunicación
        ManagedChannel ch = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        //Saludo una vez a unario
        saludarUnario(ch);
        //Varios saludos a stream
        saludarStream(ch);
        //Archivo
        saludarArchivoStream(ch);
        //Fin comunicación
        System.out.println("Apagando...");
        ch.shutdown();
    }
    //Saludo unario
    public static void saludarUnario(ManagedChannel ch) {
        //Obtener ref a stub
        SaludoServiceGrpc.SaludoServiceBlockingStub stub = SaludoServiceGrpc.newBlockingStub(ch);
        //Petición enviando parametro
        SaludoRequest peticion = SaludoRequest.newBuilder().setNombre("Alvaro").build();
        //Usando stub llamar RPC
        SaludoResponse respuesta =  stub.saludo(peticion);
        //Imprimir más respuestas
        System.out.println("Respuesta RCP: " + respuesta.getResultado());
    }

    //Saludar varias veces
    public static void saludarStream(ManagedChannel ch) {
        //Rererencia stub
        SaludoServiceGrpc.SaludoServiceBlockingStub stub = SaludoServiceGrpc.newBlockingStub(ch);
        //Peticion enviando parametro
        SaludoRequest peticion = SaludoRequest.newBuilder().setNombre("Alvaro").build();
        //Stub llamar RPC | Como es stream iterar
        stub.saludoStream(peticion).forEachRemaining(respuesta -> {
        //Imprimir más respuestas
            System.out.println("Respuesta RCP: " + respuesta.getResultado());
        });
    }

    //Archivo grande
    public static void saludarArchivoStream(ManagedChannel ch) {
        //Rererencia stub
        SaludoServiceGrpc.SaludoServiceBlockingStub stub = SaludoServiceGrpc.newBlockingStub(ch);
        //Peticion enviando parametro
        SaludoRequest peticion = SaludoRequest.newBuilder().setNombre("/archivote.csv").build();
        //Stub llamar RPC | Como es stream iterar   
        stub.saludoArchivoStream(peticion).forEachRemaining(respuesta ->{
            //Imprimir más respuestas
            System.out.println("Respuesta RPC: " + respuesta.getResultado());
        });
    }
}

/* 

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.swing.JOptionPane;
import com.proto.calculadora.Calculadora.OperacionRequest;
import com.proto.calculadora.Calculadora.OperacionResponse;
import com.proto.calculadora.CalculadoraServiceGrpc;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 3000;

        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, puerto)
                                                      .usePlaintext()
                                                      .build();
        try {
            CalculadoraServiceGrpc.CalculadoraServiceBlockingStub stub = CalculadoraServiceGrpc.newBlockingStub(channel);

            while (true) {
                String opt = JOptionPane.showInputDialog(
                        "Calculadora\n" +
                                "Suma..........(1)\n" +
                                "Resta.........(2)\n" +
                                "Multiplicacion.(3)\n" +
                                "Division......(4)\n\n" +
                                "Cancelar para salir");
                if (opt == null) {
                    break;
                }
                int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese a"));
                int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese b"));

                switch (opt) {
                    case "1":
                        OperacionRequest sumaRequest = OperacionRequest.newBuilder()
                                                                      .setNumero1(a)
                                                                      .setNumero2(b)
                                                                      .setOperador("+")
                                                                      .build();
                        OperacionResponse sumaResponse = stub.realizarOperacion(sumaRequest);
                        JOptionPane.showMessageDialog(null, a + "+" + b + "=" + sumaResponse.getResultado());
                        break;
                    case "2":
                        OperacionRequest restaRequest = OperacionRequest.newBuilder()
                                                                       .setNumero1(a)
                                                                       .setNumero2(b)
                                                                       .setOperador("-")
                                                                       .build();
                        OperacionResponse restaResponse = stub.realizarOperacion(restaRequest);
                        JOptionPane.showMessageDialog(null, a + "-" + b + "=" + restaResponse.getResultado());
                        break;
                    case "3":
                        OperacionRequest multiplicacionRequest = OperacionRequest.newBuilder()
                                                                                 .setNumero1(a)
                                                                                 .setNumero2(b)
                                                                                 .setOperador("*")
                                                                                 .build();
                        OperacionResponse multiplicacionResponse = stub.realizarOperacion(multiplicacionRequest);
                        JOptionPane.showMessageDialog(null, a + "*" + b + "=" + multiplicacionResponse.getResultado());
                        break;
                    case "4":
                        OperacionRequest divisionRequest = OperacionRequest.newBuilder()
                                                                           .setNumero1(a)
                                                                           .setNumero2(b)
                                                                           .setOperador("/")
                                                                           .build();
                        OperacionResponse divisionResponse = stub.realizarOperacion(divisionRequest);
                        JOptionPane.showMessageDialog(null, a + "/" + b + "=" + divisionResponse.getResultado());
                        break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            channel.shutdown();
        }
    }
}
*/
