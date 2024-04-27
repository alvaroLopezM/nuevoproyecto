var builder = WebApplication.CreateBuilder(args);
//Servicio gRPC
builder.Services.AddGrpc();
var app = builder.Build();
//Proto en servidor
app.MapGrpcService<AudioServicer>();
app.Run();
