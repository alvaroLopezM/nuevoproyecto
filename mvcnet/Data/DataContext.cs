using MySqlConnector;
namespace mvcnet;

public class DataContext : IDataContext
{
    private readonly MySqlConnection _sqlConnection;
    public DataContext(MySqlConnection mySqlConnection)
    {
        _sqlConnection = mySqlConnection;
    }
    public async Task<List<Producto>> ObtenerProductosAsync()
    {
        //Conexion hacia MySQL
        await _sqlConnection.OpenAsync();
        List<Producto> productos = new();
        
        using var command = new MySqlCommand
        (@"SELECT producto.id, producto.nombre, producto.precio, fabricante.nombre AS fabricante_nombre
        FROM fabricante INNER JOIN producto ON fabricante.id=producto.id_fabricante",
        _sqlConnection);
        using var reader = await command.ExecuteReaderAsync();
        while (await reader.ReadAsync())
        {
            Producto item = new()
            {
                ProductoId = Convert.ToInt32(reader["id"]),
                Nombre = reader["nombre"].ToString(),
                Precio = Convert.ToDecimal(reader["precio"]),
                Fabricante = reader["fabricante_nombre"].ToString()
            };
            productos.Add(item);
        }
        //Envia productos
        return productos;
    }
}