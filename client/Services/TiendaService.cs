using System.Threading.Tasks;
using Grpc.Net.Client;
using com.server.grpc;

namespace client.Services
{
    public class TiendaService
    {
        private readonly tienda.tiendaClient _tiendaCliente;

        public TiendaService(string grpcServerUrl)
        {
            var channel = GrpcChannel.ForAddress(grpcServerUrl);
            _tiendaCliente = new tienda.tiendaClient(channel);
        }

        public async Task<CrudTiendaResponse> CrearTiendaAsync(string codigo, string direccion, string provincia, string ciudad)
        {
            var request = new TiendaRequest
            {
                Codigo = codigo,
                Direccion = direccion,
                Provincia = provincia,
                Ciudad = ciudad
            };
        var response = await _tiendaCliente.CrearTiendaAsync(request);
        return response;
        }

        public async Task<CrudTiendaResponse> ModificarTiendaAsync(long idTienda, string codigo, string direccion, string provincia, string ciudad, bool habilitado)
        {
            var request = new TiendaModificarRequest
            {
                IdTienda = idTienda,
                Codigo = codigo,
                Direccion = direccion,
                Provincia = provincia,
                Ciudad = ciudad,
                Habilitado = habilitado
            };
        var response = await _tiendaCliente.ModificarTiendaAsync(request);
        return response;
        }

        public async Task<CrudTiendaResponse> EliminarTiendaAsync(long idTienda)
        {
            var request = new TiendaId { IdTienda = idTienda };
            var response = await _tiendaCliente.EliminarTiendaAsync(request);
            return response;
        }

        public async Task<getTiendas> TraerTiendasAsync(string codigo, bool habilitado)
        {
            var request = new FiltrosTienda 
            { 
                Codigo = codigo,
                Habilitado = habilitado
            };
            var response = await _tiendaCliente.TraerTiendasAsync(request);
            return response;
        }

        public async Task<DetalleTiendaResponse> DetalleTiendaAsync(string codigo)
        {
            var request = new DetalleTiendaRequest { Codigo = codigo };
            var response = await _tiendaCliente.DetalleAsync(request);
            return response;
        }

        public async Task<CrudTiendaResponse> AsignarProductoAsync(long idTienda, long idProducto)
        {
            var request = new ManejarProducto 
            {
                IdTienda = idTienda, 
                IdProducto = idProducto
            };
            var response = await _tiendaCliente.AsignarProductoAsync(request);
            return response;
        }

        public async Task<CrudTiendaResponse> DesasignarProductoAsync(long idTienda, long idProducto)
        {
            var request = new ManejarProducto 
            { 
                IdTienda = idTienda, 
                IdProducto = idProducto
            };
            var response = await _tiendaCliente.DesasignarProductoAsync(request);
            return response;
        }

        public async Task<CrudTiendaResponse> AsignarUsuarioAsync(long idTienda, long idUsuario)
        {
            var request = new ManejarUsuario 
            { 
                IdTienda = idTienda, 
                IdUsuario = idUsuario
            };
            var response = await _tiendaCliente.AsignarUsuarioAsync(request);
            return response;
        }

        public async Task<CrudTiendaResponse> DesasignarUsuarioAsync(long idTienda, long idUsuario)
        {
            var request = new ManejarUsuario 
            { 
                IdTienda = idTienda, 
                IdUsuario = idUsuario
            };
            var response = await _tiendaCliente.DesasignarUsuarioAsync(request);
            return response;
        }

        public async Task<CrudTiendaResponse> ModificarStockAsync(long tiendaId, long productoId, int cantidad)
        {
            var request = new ModificarStockRequest
            {
                IdTienda = tiendaId,
                IdProducto = productoId,
                Cantidad = cantidad
            };
            var response = await _tiendaCliente.ModificarStockAsync(request);
            return response;
        }
    }
}