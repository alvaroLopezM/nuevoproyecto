package calculadoragrpc.servidor;

import com.proto.saludo.Holamundo.SaludoRequest;
import com.proto.saludo.Holamundo.SaludoResponse;
import com.proto.saludo.SaludoServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.util.Scanner;

public class ServidorImpl extends SaludoServiceGrpc.SaludoServiceImplBase{
    @Override
    public void saludo(SaludoRequest request, StreamObserver<SaludoResponse> responseObserver){
        //Respuesta a cliente
        SaludoResponse respuesta = SaludoResponse.newBuilder().setResultado("Hola" + request.getNombre()).build();
        //Envío de respuesta
        responseObserver.onNext(respuesta);
        //Fin
        responseObserver.onCompleted();
    }

    @Override
    public void saludoStream(SaludoRequest request, StreamObserver<SaludoResponse> respObserver){
        //Misma función de arriba, pero con for para simulación de envío de chunks de datos.
        for (int i = 0; i <= 10; i++) {
            //Construcción respuesta
            SaludoResponse respuesta = 
            SaludoResponse.newBuilder().setResultado("Hola " + request.getNombre() + " por " + i + " vez.").build();
            //gRPC usa onNext para envíar para envíar respusta, en unaria era soloa una vez.
            respObserver.onNext(respuesta);
        }
        //Avisa que termina
        respObserver.onCompleted();
    }

    @Override
    public void saludoArchivoStream(SaludoRequest request, StreamObserver<SaludoResponse> respObserver){
        System.out.println("Enviando el archivo: " + ServidorImpl.class.getResource(request.getNombre()) + "...");
        try (Scanner scanner = new Scanner(ServidorImpl.class.getResourceAsStream(request.getNombre()))) {
            while (scanner.hasNextLine()) {
                SaludoResponse cadena = SaludoResponse.newBuilder().setResultado(scanner.nextLine()).build();
                respObserver.onNext(cadena);
            }
            respObserver.onCompleted();
        }catch (Exception e) {
            respObserver.onError(e);
        }
    }
}
/* 

import com.proto.saludo.Holamundo.SaludoRequest;
import com.proto.saludo.Holamundo.SaludoResponse;
import com.proto.saludo.SaludoServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ServidorImpl extends SaludoServiceGrpc.SaludoServiceImplBase{
    @Override
    public void saludo(SaludoRequest request, StreamObserver<SaludoResponse> responseObserver){
        //Respuesta a cliente
        SaludoResponse respuesta = SaludoResponse.newBuilder().setResultado("Hola" + request.getNombre()).build();
        //Envío de respuesta
        responseObserver.onNext(respuesta);
        //Fin
        responseObserver.onCompleted();
    }
}

import com.proto.calculadora.Calculadora.OperacionRequest;
import com.proto.calculadora.Calculadora.OperacionResponse;
import com.proto.calculadora.CalculadoraServiceGrpc;

import io.grpc.stub.StreamObserver;

public class ServidorImpl extends CalculadoraServiceGrpc.CalculadoraServiceImplBase {
    @Override 
    public void realizarOperacion(OperacionRequest request, StreamObserver<OperacionResponse> responseObserver) {
        int resultado = 0;
        switch (request.getOperador()) {
            case "+":
                resultado = request.getNumero1() + request.getNumero2();
                break;
            case "-":
                resultado = request.getNumero1() - request.getNumero2();
                break;
            case "*":
                resultado = request.getNumero1() * request.getNumero2();
                break;
            case "/":
                resultado = request.getNumero1() / request.getNumero2();
                break;
            default:
                responseObserver.onError(
                    new IllegalArgumentException("Operador no válido: " + request.getOperador())
                );
                return;
        }
        
        OperacionResponse respuesta = OperacionResponse.newBuilder().setResultado(resultado).build();
        responseObserver.onNext(respuesta);
        responseObserver.onCompleted();
    }
}
*/