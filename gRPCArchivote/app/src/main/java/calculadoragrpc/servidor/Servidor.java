package calculadoragrpc.servidor;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Servidor {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Puerto
        int port = 3000;
        //Creación de servdior gRPC usando proto
        Server servidor = ServerBuilder.forPort(port).addService(new ServidorImpl()).build();
        //Inicia
        servidor.start();
        System.out.println("Servidor iniciando");
        System.out.println("Escuchando en puerto " + port);
        //Solicitud de apagado
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("Recibiendo solicitud de apagado");
                servidor.shutdown();
                System.out.println("Servidor detenido");

            }
        });
        //Espera a que cierren conexiones
        servidor.awaitTermination();
    }
}

/*

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class Servidor {
    public static void main(String[] args) throws IOException, InterruptedException {
        int puerto = 3000;

        Server servidor = ServerBuilder
                          .forPort(puerto)
                          .addService(new ServidorImpl())
                          .build();

        servidor.start();
        
        System.out.println("Servidor iniciado...");
        System.out.println("Escuchando en el puerto: " + puerto);

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override 
            public void run(){
                System.out.println("Recibiendo solicitud de apagado: ");
                servidor.shutdown();
                System.out.println("Servidor detenido");
            }
        });

        servidor.awaitTermination();
    }
}
*/