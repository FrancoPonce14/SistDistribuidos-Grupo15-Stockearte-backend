using Grpc.Net.Client;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GrpcClientAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class ProductoController : ControllerBase
    {
        public producto.productoClient Client { get; set; }

        public ProductoController()
        {
            Client = new producto.productoClient(GrpcChannel.ForAddress("http://localhost:9090"));
        }

        [HttpPost]
        [Route("[action]")]
        public async Task<CrudProductoResponse> CrearProducto(ProductoRequest request)
        {
            var reply = await Client.CrearProductoAsync(request);
            return reply;
        }

        [HttpPut]
        [Route("[action]")]
        public async Task<CrudProductoResponse> ModificarProducto(ProductoModificarRequest request)
        {
            var reply = await Client.ModificarProductoAsync(request);
            return reply;
        }

        [HttpDelete]
        [Route("[action]")]
        public async Task<CrudProductoResponse> EliminarProducto(ProductoId request)
        {
            var reply = await Client.EliminarProductoAsync(request);
            return reply;
        }

        [HttpPost]
        [Route("[action]")]
        public async Task<getProductos> TraerProducto(FiltrosProducto request)
        {
            var reply = await Client.TraerProductosAsync(request);
            return reply;
        }

        [HttpPost]
        [Route("[action]")]
        public async Task<DetalleProductoResponse> Detalle(DetalleProductoRequest request)
        {
            var reply = await Client.DetalleAsync(request);
            return reply;
        }

        [HttpPost]
        [Route("[action]")]
        public async Task<getProductosNoAsociados> GetProductosNoAsociados(TiendaId request)
        {
            var reply = await Client.GetProductosNoAsociadosAsync(request);
            return reply;
        }

        [HttpPost]
        [Route("[action]")]
        public async Task<getProductosAsociados> GetProductosAsociados(TiendaId request)
        {
            var reply = await Client.GetProductosAsociadosAsync(request);
            return reply;
        }

        [HttpPost]
        [Route("[action]")]
        public async Task<getNovedades> GetNovedadesProducto(Empty request)
        {
            var reply = await Client.TraerNovedadesAsync(request);
            return reply;
        }

        [HttpPost]
        [Route("[action]")]
        public async Task<CrudProductoResponse> CrearProductos([FromBody] CrearProductoRequestDto request)
        {
            var grpcRequest = new CrearProductosRequest
            {
                DatosProducto = new DatosProducto{Codigo = request.DatosProducto.Codigo, Nombre = request.DatosProducto.Nombre, Url = request.DatosProducto.Url, Habilitado = request.DatosProducto.Habilitado}
            };

            foreach (var tc in request.DatosProducto.TallesColores)
            {
                grpcRequest.DatosProducto.TallesColores.Add(new Variante{Talle = tc.Talle, Color = tc.Color});
            }

            var reply = await Client.CrearProductosAsync(grpcRequest);
            return reply;
        }

        public class CrearProductoRequestDto
        {
            public DatosProductoDto DatosProducto { get; set; }
        }

        public class DatosProductoDto
        {
            public string Codigo { get; set; }
            public string Nombre { get; set; }
            public string Url { get; set; }
            public bool Habilitado { get; set; }
            public List<VarianteDto> TallesColores { get; set; }
        }

        public class VarianteDto
        {
            public string Talle { get; set; }
            public string Color { get; set; }
        }
    }
}
