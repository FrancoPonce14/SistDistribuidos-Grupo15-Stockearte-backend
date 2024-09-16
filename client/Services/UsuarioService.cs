using System.Threading.Tasks;
using Grpc.Net.Client;
using com.server.grpc;

namespace client.Services
{
    public class UsuarioService
    {
        private readonly usuario.usuarioClient _usuarioCliente;

        public UsuarioService(string grpcServerUrl)
        {
            var channel = GrpcChannel.ForAddress(grpcServerUrl);
            _usuarioCliente = new usuario.usuarioClient(channel);
        }

        public async Task<LoginResponse> LoginAsync(string username, string password)
        {
            var request = new LoginRequest
            {
                Email = username,
                Clave = password
            };
            return await _usuarioCliente.LoginAsync(request);
        }

        public async Task<CrudResponse> CrearUsuarioAsync(string nombre, string email, string clave, bool habilitado, string rol)
        {
            var request = new UsuarioRequest
            {
                Nombre = nombre,
                Email = email,
                Clave = clave,
                Habilitado = habilitado,
                Rol = rol
            };
            return await _usuarioCliente.CrearUsuarioAsync(request);
        }

        public async Task<CrudResponse> ModificarUsuarioAsync(long idUsuario, string nombre, string email, string clave, bool habilitado)
        {
        var request = new UsuarioModificarRequest
            {
                IdUsuario = idUsuario,
                Nombre = nombre,
                Email = email,
                Clave = clave,
                Habilitado = habilitado
            };

            var response = await _usuarioCliente.ModificarUsuarioAsync(request);
            return response;
        }

        public async Task<CrudResponse> EliminarUsuarioAsync(long id)
        {
            var request = new UsuarioId { IdUsuario = id };
            var response = await _usuarioCliente.EliminarUsuarioAsync(request);
            return response;
        }

        public async Task<getUsuarios> TraerUsuariosAsync(string nombre, string codigo)
        {
            var request = new FiltrosUsuario 
            { 
                Nombre = nombre,
                Codigo = codigo
            };
            var response = await _usuarioCliente.TraerUsuariosAsync(request);
            return response;
        }

        public async Task<DetalleResponse> DetalleAsync(long id)
        {
            var request = new UsuarioId { IdUsuario = id };
            var response = await _usuarioCliente.DetalleAsync(request);
            return response;
        }

        public async Task<getUsuarios> GetUsuariosNoAsignadosAsync()
        {
            var response = await _usuarioCliente.GetUsuariosNoAsignadosAsync(new Empty());
            return response;
        }
    }
}
