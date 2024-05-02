namespace mvcnet;

public interface IDataContext
{
    public Task<List<Producto>> ObtenerProductosAsync();
}