using Microsoft.AspNetCore.Mvc;
using com.server.grpc;
using System.Threading.Tasks;
using client.Services;

namespace client.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class UsuarioController : ControllerBase
    {
        private readonly UsuarioService _usuarioService;

        public UsuarioController()
        {
             _usuarioService = new UsuarioService("https://localhost:9090");
        }

        [HttpPost("login")]
        public async Task<IActionResult> Login([FromBody] LoginRequest request)
        {
            var response = await _usuarioService.LoginAsync(request.Email, request.Clave);
            return Ok(response);
        }

        [HttpPost("crear")]
        public async Task<IActionResult> CrearUsuario([FromBody] UsuarioRequest request)
        {
            var response = await _usuarioService.CrearUsuarioAsync(request.Nombre, request.Email, request.Clave, request.Habilitado, request.Rol);
            return Ok(response);
        }
        
        [HttpPut("modificar")]
        public async Task<IActionResult> ModificarUsuario([FromBody] UsuarioModificarRequest request)
        {
            var response = await _usuarioService.ModificarUsuarioAsync(request.IdUsuario, request.Nombre, request.Email, request.Clave, request.Habilitado);
            return Ok(response);
        }

        [HttpDelete("eliminar/{idUsuario}")]
        public async Task<IActionResult> EliminarUsuario(long idUsuario)
        {
            var request = new UsuarioId { IdUsuario = idUsuario };
            var response = await _usuarioService.EliminarUsuarioAsync(request.IdUsuario);
            return Ok(response);
        }

        [HttpGet("listar")]
        public async Task<IActionResult> TraerUsuarios([FromQuery] string nombre, string codigo)
        {
            var request = new FiltrosUsuario { Nombre = nombre, Codigo = codigo };
            var response = await _usuarioService.TraerUsuariosAsync(request.Nombre, request.Codigo);
            return Ok(response);
        }

        [HttpGet("detalle/{idUsuario}")]
        public async Task<IActionResult> Detalle(long idUsuario)
        {
            var request = new UsuarioId { IdUsuario = idUsuario };
            var response = await _usuarioService.DetalleAsync(request.IdUsuario);
            return Ok(response);
        }

        [HttpGet("no-asignados")]
        public async Task<IActionResult> GetUsuariosNoAsignados()
        {
            var response = await _usuarioService.GetUsuariosNoAsignadosAsync();
            return Ok(response);
        }
    }
}