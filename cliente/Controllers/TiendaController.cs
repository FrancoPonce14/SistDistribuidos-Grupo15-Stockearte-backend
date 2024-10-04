using Grpc.Net.Client;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;


namespace GrpcClientAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class TiendaController : ControllerBase
    {
        public tienda.tiendaClient Client { get; set; }

        public TiendaController()
        {
            Client = new tienda.tiendaClient(GrpcChannel.ForAddress("http://localhost:9090"));
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<CrudTiendaResponse> CrearTienda(TiendaRequest request)
        {
            var reply = await Client.CrearTiendaAsync(request);

            return reply;
        }

        [HttpPut()]
        [Route("[action]")]
        public async Task<CrudTiendaResponse> ModificarTienda(TiendaModificarRequest request)
        {
            var reply = await Client.ModificarTiendaAsync(request);

            return reply;
        }

        [HttpDelete()]
        [Route("[action]")]
        public async Task<CrudTiendaResponse> EliminarTienda(TiendaId request)
        {
            var reply = await Client.EliminarTiendaAsync(request);

            return reply;
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<getTiendas> TraerTiendas(FiltrosTienda request)
        {
            var reply = await Client.TraerTiendasAsync(request);

            return reply;
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<DetalleTiendaResponse> DetalleTiendas(DetalleTiendaRequest request)
        {
            var reply = await Client.DetalleAsync(request);

            return reply;
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<CrudTiendaResponse> AsignarProducto(ManejarProducto request)
        {
            var reply = await Client.AsignarProductoAsync(request);

            return reply;
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<CrudTiendaResponse> DesasignarProducto(ManejarProducto request)
        {
            var reply = await Client.DesasignarProductoAsync(request);

            return reply;
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<CrudTiendaResponse> AsignarUsuario(ManejarUsuario request)
        {
            var reply = await Client.AsignarUsuarioAsync(request);

            return reply;
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<CrudTiendaResponse> DesasignarUsuario(ManejarUsuario request)
        {
            var reply = await Client.DesasignarUsuarioAsync(request);

            return reply;
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<CrudTiendaResponse> ModificarStock(ModificarStockRequest request)
        {
            var reply = await Client.ModificarStockAsync(request);

            return reply;
        }
        [HttpPost]
        [Route("[action]")]
        public async Task<CrudTiendaResponse> CrearOrdenCompra([FromBody] CrearOrdenCompraRequestDto request)
        {
            var grpcRequest = new OrdenCompraRequest
            {
                IdUsuario = request.IdUsuario
            };

            foreach (var item in request.Items)
            {
                grpcRequest.Items.Add(new ItemResponse{CodigoProducto = item.CodigoProducto, Cantidad = item.Cantidad});
            }

            var reply = await Client.CrearOrdenCompraAsync(grpcRequest);
            return reply;
        }

        public class CrearOrdenCompraRequestDto
        {
            public long IdUsuario  { get; set; }
            public List<ItemRequestDto> Items { get; set; }
        }

        public class ItemRequestDto
        {
            public string CodigoProducto { get; set; }
            public int Cantidad { get; set; }
        }
    }

}