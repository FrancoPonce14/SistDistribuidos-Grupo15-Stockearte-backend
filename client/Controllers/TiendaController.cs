using Microsoft.AspNetCore.Mvc;
using com.server.grpc;
using System.Threading.Tasks;
using client.Services;

namespace client.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class TiendaController : ControllerBase
    {
        private readonly TiendaService _tiendaService;
        public TiendaController()
        {
             _tiendaService = new TiendaService("https://localhost:5098");
        }

        [HttpPost("crear")]
        public async Task<IActionResult> CrearTienda([FromBody] TiendaRequest request)
        {
            var response = await _tiendaService.CrearTiendaAsync(request.Codigo,request.Direccion, request.Provincia, request.Ciudad);
            return Ok(response);
        }

        [HttpPut("modificar")]
        public async Task<IActionResult> ModificarTienda([FromBody] TiendaModificarRequest request)
        {
            var response = await _tiendaService.ModificarTiendaAsync(request.IdTienda, request.Codigo,request.Direccion, request.Provincia, request.Ciudad, request.Habilitado);
            return Ok(response);
        }

        [HttpDelete("eliminar/{idTienda}")]
        public async Task<IActionResult> EliminarTienda(long idTienda)
        {
            var response = await _tiendaService.EliminarTiendaAsync(idTienda);
            return Ok(response);
        }

        [HttpGet("listar")]
        public async Task<IActionResult> TraerTiendas([FromQuery] string codigo, Boolean habilitado)
        {
            var response = await _tiendaService.TraerTiendasAsync(codigo, habilitado);
            return Ok(response);
        }

        [HttpGet("detalle/{codigo}")]
        public async Task<IActionResult> DetalleTienda(string codigo)
        {
            var response = await _tiendaService.DetalleTiendaAsync(codigo);
            return Ok(response);
        }

        [HttpPost("asignar-producto")]
        public async Task<IActionResult> AsignarProducto([FromBody] ManejarProducto request)
        {
            var response = await _tiendaService.AsignarProductoAsync(request.IdTienda, request.IdProducto);
            return Ok(response);
        }

        [HttpPost("desasignar-producto")]
        public async Task<IActionResult> DesasignarProducto([FromBody] ManejarProducto request)
        {
            var response = await _tiendaService.DesasignarProductoAsync(request.IdTienda, request.IdProducto);
            return Ok(response);
        }

        [HttpPost("asignar-usuario")]
        public async Task<IActionResult> AsignarUsuario([FromBody] ManejarUsuario request)
        {
            var response = await _tiendaService.AsignarUsuarioAsync(request.IdTienda, request.IdUsuario);
            return Ok(response);
        }

        [HttpPost("desasignar-usuario")]
        public async Task<IActionResult> DesasignarUsuario([FromBody] ManejarUsuario request)
        {
            var response = await _tiendaService.DesasignarUsuarioAsync(request.IdTienda, request.IdUsuario);
            return Ok(response);
        }

        [HttpPost("modificar-stock")]
        public async Task<IActionResult> ModificarStock([FromBody] ModificarStockRequest request)
        {
            var response = await _tiendaService.ModificarStockAsync(request.IdTienda, request.IdProducto, request.Cantidad);
            return Ok(response);
        }
    }
}