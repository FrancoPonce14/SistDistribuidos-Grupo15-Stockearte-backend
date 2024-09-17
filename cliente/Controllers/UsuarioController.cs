using Grpc.Net.Client;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;


namespace GrpcClientAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class UsuarioController  : ControllerBase
    {
        public usuario.usuarioClient Client { get; set; }

        public UsuarioController()
        {
            Client = new usuario.usuarioClient(GrpcChannel.ForAddress("http://localhost:9090"));
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<LoginResponse> Login(LoginRequest request)
        {
            var reply = await Client.LoginAsync(request);

            return reply;
        }

        [HttpPost()]
        [Route("[action]")]
        public async Task<CrudResponse> CrearUsuario(UsuarioRequest request)
        {
            var reply = await Client.CrearUsuarioAsync(request);

            return reply;
        }

        [HttpPut()]
        [Route("[action]")]
        public async Task<CrudResponse> ModificarUsuario(UsuarioModificarRequest request)
        {
            var reply = await Client.ModificarUsuarioAsync(request);

            return reply;
        }

        [HttpDelete()]
        [Route("[action]")]
        public async Task<CrudResponse> EliminarUsuario(UsuarioId request)
        {
            var reply = await Client.EliminarUsuarioAsync(request);

            return reply;
        }

        [HttpGet()]
        [Route("[action]")]
        public async Task<getUsuarios> TraerUsuarios(FiltrosUsuario request)
        {
            var reply = await Client.TraerUsuariosAsync(request);

            return reply;
        }

        [HttpGet()]
        [Route("[action]")]
        public async Task<DetalleResponse> Detalle(UsuarioId request)
        {
            var reply = await Client.DetalleAsync(request);

            return reply;
        }

        [HttpGet()]
        [Route("[action]")]
        public async Task<getUsuarios> GetUsuariosNoAsignados(Empty request)
        {
            var reply = await Client.GetUsuariosNoAsignadosAsync(request);

            return reply;
        }
        
    }

}