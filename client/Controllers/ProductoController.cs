using Microsoft.AspNetCore.Mvc;
using com.server.grpc;
using System.Threading.Tasks;
using client.Services;

namespace client.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class ProductoController : ControllerBase
    {
        private readonly ProductoService _productoService;

        public ProductoController()
        {
            _productoService = new ProductoService("https://localhost:5098");
        }

        [HttpPost("crear")]
        public async Task<IActionResult> CrearProducto([FromBody] ProductoRequest request)
        {
            var response = await _productoService.CrearProductoAsync(request.Nombre, request.Imagen, request.Talle, request.Color);
            return Ok(response);
        }

        [HttpPut("modificar")]
        public async Task<IActionResult> ModificarProducto([FromBody] ProductoModificarRequest request)
        {
            var response = await _productoService.ModificarProductoAsync(request.IdProducto, request.Nombre, request.Imagen, request.Talle, request.Color, request.Habilitado);
            return Ok(response);
        }

        [HttpDelete("eliminar/{idProducto}")]
        public async Task<IActionResult> EliminarProducto(long idProducto)
        {
            var response = await _productoService.EliminarProductoAsync(idProducto);
            return Ok(response);
        }

        [HttpGet("listar")]
        public async Task<IActionResult> TraerProductos([FromQuery] long idUsuario, string nombre, string codigo, string talle, string color)
        {
            var response = await _productoService.TraerProductosAsync(idUsuario, nombre, codigo, talle, color);
            return Ok(response);
        }

        [HttpGet("detalle/{codigo}")]
        public async Task<IActionResult> DetalleProducto(string codigo)
        {
            var response = await _productoService.DetalleProductoAsync(codigo);
            return Ok(response);
        }

        [HttpGet("no-asociados/{idTienda}")]
        public async Task<IActionResult> GetProductosNoAsociados(long idTienda)
        {
            var response = await _productoService.GetProductosNoAsociadosAsync(idTienda);
            return Ok(response);
        }
    }
}