using System.Threading.Tasks;
using Grpc.Net.Client;
using com.server.grpc;
using System.Drawing;

namespace client.Services
{
    public class ProductoService
    {
        private readonly producto.productoClient _productoCliente;

        public ProductoService(string grpcServerUrl)
        {
            var channel = GrpcChannel.ForAddress(grpcServerUrl);
            _productoCliente = new producto.productoClient(channel);
        }

        public async Task<CrudProductoResponse> CrearProductoAsync(string nombre, string imagen, string talle, string color)
        {
            var request = new ProductoRequest
            {
                Nombre = nombre,
                Talle = talle,
                Imagen = imagen,
                Color = color
            };
            var response = await _productoCliente.CrearProductoAsync(request);
            return response;
        }

        public async Task<CrudProductoResponse> ModificarProductoAsync(long idProducto, string nombre, string imagen, string talle, string color, Boolean habilitado)
        {
            var request = new ProductoModificarRequest
            {
                IdProducto = idProducto,
                Nombre = nombre,
                Color = color,
                Talle = talle,
                Imagen = imagen,
                Habilitado = habilitado
            };
            var response = await _productoCliente.ModificarProductoAsync(request);
            return response;
        }

        public async Task<CrudProductoResponse> EliminarProductoAsync(long idProducto)
        {
            var request = new ProductoId { IdProducto = idProducto };
            var response = await _productoCliente.EliminarProductoAsync(request);
            return response;
        }

        public async Task<getProductos> TraerProductosAsync(long idUsuario, string nombre, string codigo, string talle, string color)
        {
            var request = new FiltrosProducto 
            {
                IdUsuario = idUsuario,
                Nombre = nombre,
                Codigo = codigo,
                Talle = talle,
                Color = color,
            };
            var response = await _productoCliente.TraerProductosAsync(request);
            return response;
        }

        public async Task<DetalleProductoResponse> DetalleProductoAsync(string codigo)
        {
            var request = new DetalleProductoRequest { Codigo = codigo };
            var response = await _productoCliente.DetalleAsync(request);
            return response;
        }

        public async Task<getProductosNoAsociados> GetProductosNoAsociadosAsync(long idTienda)
        {
            var request = new TiendaId { IdTienda = idTienda };
            var response = await _productoCliente.GetProductosNoAsociadosAsync(request);
            return response;
        }
    }
}