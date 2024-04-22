package com.proto.calculadora;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: calculadora.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CalculadoraServiceGrpc {

  private CalculadoraServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "CalculadoraService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.calculadora.Calculadora.OperacionRequest,
      com.proto.calculadora.Calculadora.OperacionResponse> getRealizarOperacionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "realizarOperacion",
      requestType = com.proto.calculadora.Calculadora.OperacionRequest.class,
      responseType = com.proto.calculadora.Calculadora.OperacionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.calculadora.Calculadora.OperacionRequest,
      com.proto.calculadora.Calculadora.OperacionResponse> getRealizarOperacionMethod() {
    io.grpc.MethodDescriptor<com.proto.calculadora.Calculadora.OperacionRequest, com.proto.calculadora.Calculadora.OperacionResponse> getRealizarOperacionMethod;
    if ((getRealizarOperacionMethod = CalculadoraServiceGrpc.getRealizarOperacionMethod) == null) {
      synchronized (CalculadoraServiceGrpc.class) {
        if ((getRealizarOperacionMethod = CalculadoraServiceGrpc.getRealizarOperacionMethod) == null) {
          CalculadoraServiceGrpc.getRealizarOperacionMethod = getRealizarOperacionMethod =
              io.grpc.MethodDescriptor.<com.proto.calculadora.Calculadora.OperacionRequest, com.proto.calculadora.Calculadora.OperacionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "realizarOperacion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculadora.Calculadora.OperacionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculadora.Calculadora.OperacionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculadoraServiceMethodDescriptorSupplier("realizarOperacion"))
              .build();
        }
      }
    }
    return getRealizarOperacionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculadoraServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculadoraServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculadoraServiceStub>() {
        @java.lang.Override
        public CalculadoraServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculadoraServiceStub(channel, callOptions);
        }
      };
    return CalculadoraServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculadoraServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculadoraServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculadoraServiceBlockingStub>() {
        @java.lang.Override
        public CalculadoraServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculadoraServiceBlockingStub(channel, callOptions);
        }
      };
    return CalculadoraServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculadoraServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculadoraServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculadoraServiceFutureStub>() {
        @java.lang.Override
        public CalculadoraServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculadoraServiceFutureStub(channel, callOptions);
        }
      };
    return CalculadoraServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void realizarOperacion(com.proto.calculadora.Calculadora.OperacionRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculadora.Calculadora.OperacionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRealizarOperacionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CalculadoraService.
   */
  public static abstract class CalculadoraServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CalculadoraServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CalculadoraService.
   */
  public static final class CalculadoraServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CalculadoraServiceStub> {
    private CalculadoraServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculadoraServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculadoraServiceStub(channel, callOptions);
    }

    /**
     */
    public void realizarOperacion(com.proto.calculadora.Calculadora.OperacionRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculadora.Calculadora.OperacionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRealizarOperacionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CalculadoraService.
   */
  public static final class CalculadoraServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CalculadoraServiceBlockingStub> {
    private CalculadoraServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculadoraServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculadoraServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.calculadora.Calculadora.OperacionResponse realizarOperacion(com.proto.calculadora.Calculadora.OperacionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRealizarOperacionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CalculadoraService.
   */
  public static final class CalculadoraServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CalculadoraServiceFutureStub> {
    private CalculadoraServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculadoraServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculadoraServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.calculadora.Calculadora.OperacionResponse> realizarOperacion(
        com.proto.calculadora.Calculadora.OperacionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRealizarOperacionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REALIZAR_OPERACION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REALIZAR_OPERACION:
          serviceImpl.realizarOperacion((com.proto.calculadora.Calculadora.OperacionRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculadora.Calculadora.OperacionResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getRealizarOperacionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.proto.calculadora.Calculadora.OperacionRequest,
              com.proto.calculadora.Calculadora.OperacionResponse>(
                service, METHODID_REALIZAR_OPERACION)))
        .build();
  }

  private static abstract class CalculadoraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculadoraServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.calculadora.Calculadora.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CalculadoraService");
    }
  }

  private static final class CalculadoraServiceFileDescriptorSupplier
      extends CalculadoraServiceBaseDescriptorSupplier {
    CalculadoraServiceFileDescriptorSupplier() {}
  }

  private static final class CalculadoraServiceMethodDescriptorSupplier
      extends CalculadoraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CalculadoraServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalculadoraServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculadoraServiceFileDescriptorSupplier())
              .addMethod(getRealizarOperacionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
