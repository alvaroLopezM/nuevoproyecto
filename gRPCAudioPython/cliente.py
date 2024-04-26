import grpc
import audio_pb2
import audio_pb2_grpc
import pyaudio
import pyglet

def streamAudio(stub, nombre_archivo):
    #Usando stub, enviamos nombre del archivo a servidor
    respuesta = stub.downloadAudio(
        audio_pb2.DownloadFileRequest(nombre=nombre_archivo)
    )

    # Escribir el archivo MP3 en un archivo temporal
    with open(nombre_archivo, 'wb') as f:
        for audio_chunk in respuesta:
            print(".", end="", flush=True)
            f.write(audio_chunk.data)

    # Cargar y reproducir el archivo MP3 con pyglet
    music = pyglet.resource.media(nombre_archivo)
    music.play()

    pyglet.app.run()

    print("\nRecepción de datos correcta.")
    print("Reproducción terminada.", end="\n\n")

def run():
    puerto = "3000"
    #Crear canal
    channel = grpc.insecure_channel("localhost:" + puerto)
    #Crear stub
    stub = audio_pb2_grpc.AudioServiceStub(channel)
    nombre_archivo = ""
    
    try:
        #Recibe archivo WAV y reproduce mientras llega
        nombre_archivo = "anyma.mp3"
        streamAudio(stub, nombre_archivo)
    except KeyboardInterrupt:
        pass
    finally:
        channel.close()

if __name__ == "__main__":
    run()


'''
    #Usar dependencia pyAudio para reproducir audios
    p = pyaudio.PyAudio()
    stream = p.open(format=pyaudio.paInt16, channels=2, rate=48000, output=True)

    print("Reproduciendo el archivo: " + nombre_archivo)
    for audio_chunk in respuesta:
        print(".", end="", flush=True)
        stream.write(audio_chunk.data)

    print("\nRecepción de datos correcta.")
    print("Reproducción terminada.", end="\n\n")
'''