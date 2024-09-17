// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: Protos/producto.proto
// </auto-generated>
#pragma warning disable 0414, 1591, 8981, 0612
#region Designer generated code

using grpc = global::Grpc.Core;

namespace GrpcClientAPI {
  public static partial class producto
  {
    static readonly string __ServiceName = "producto";

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static void __Helper_SerializeMessage(global::Google.Protobuf.IMessage message, grpc::SerializationContext context)
    {
      #if !GRPC_DISABLE_PROTOBUF_BUFFER_SERIALIZATION
      if (message is global::Google.Protobuf.IBufferMessage)
      {
        context.SetPayloadLength(message.CalculateSize());
        global::Google.Protobuf.MessageExtensions.WriteTo(message, context.GetBufferWriter());
        context.Complete();
        return;
      }
      #endif
      context.Complete(global::Google.Protobuf.MessageExtensions.ToByteArray(message));
    }

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static class __Helper_MessageCache<T>
    {
      public static readonly bool IsBufferMessage = global::System.Reflection.IntrospectionExtensions.GetTypeInfo(typeof(global::Google.Protobuf.IBufferMessage)).IsAssignableFrom(typeof(T));
    }

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static T __Helper_DeserializeMessage<T>(grpc::DeserializationContext context, global::Google.Protobuf.MessageParser<T> parser) where T : global::Google.Protobuf.IMessage<T>
    {
      #if !GRPC_DISABLE_PROTOBUF_BUFFER_SERIALIZATION
      if (__Helper_MessageCache<T>.IsBufferMessage)
      {
        return parser.ParseFrom(context.PayloadAsReadOnlySequence());
      }
      #endif
      return parser.ParseFrom(context.PayloadAsNewBuffer());
    }

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.ProductoRequest> __Marshaller_ProductoRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.ProductoRequest.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.CrudProductoResponse> __Marshaller_CrudProductoResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.CrudProductoResponse.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.ProductoModificarRequest> __Marshaller_ProductoModificarRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.ProductoModificarRequest.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.ProductoId> __Marshaller_ProductoId = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.ProductoId.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.FiltrosProducto> __Marshaller_FiltrosProducto = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.FiltrosProducto.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.getProductos> __Marshaller_getProductos = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.getProductos.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.DetalleProductoRequest> __Marshaller_DetalleProductoRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.DetalleProductoRequest.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.DetalleProductoResponse> __Marshaller_DetalleProductoResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.DetalleProductoResponse.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.TiendaId> __Marshaller_TiendaId = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.TiendaId.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.getProductosNoAsociados> __Marshaller_getProductosNoAsociados = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.getProductosNoAsociados.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.getProductosAsociados> __Marshaller_getProductosAsociados = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.getProductosAsociados.Parser));

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.ProductoRequest, global::GrpcClientAPI.CrudProductoResponse> __Method_CrearProducto = new grpc::Method<global::GrpcClientAPI.ProductoRequest, global::GrpcClientAPI.CrudProductoResponse>(
        grpc::MethodType.Unary,
        __ServiceName,
        "CrearProducto",
        __Marshaller_ProductoRequest,
        __Marshaller_CrudProductoResponse);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.ProductoModificarRequest, global::GrpcClientAPI.CrudProductoResponse> __Method_ModificarProducto = new grpc::Method<global::GrpcClientAPI.ProductoModificarRequest, global::GrpcClientAPI.CrudProductoResponse>(
        grpc::MethodType.Unary,
        __ServiceName,
        "ModificarProducto",
        __Marshaller_ProductoModificarRequest,
        __Marshaller_CrudProductoResponse);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.ProductoId, global::GrpcClientAPI.CrudProductoResponse> __Method_EliminarProducto = new grpc::Method<global::GrpcClientAPI.ProductoId, global::GrpcClientAPI.CrudProductoResponse>(
        grpc::MethodType.Unary,
        __ServiceName,
        "EliminarProducto",
        __Marshaller_ProductoId,
        __Marshaller_CrudProductoResponse);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.FiltrosProducto, global::GrpcClientAPI.getProductos> __Method_TraerProductos = new grpc::Method<global::GrpcClientAPI.FiltrosProducto, global::GrpcClientAPI.getProductos>(
        grpc::MethodType.Unary,
        __ServiceName,
        "TraerProductos",
        __Marshaller_FiltrosProducto,
        __Marshaller_getProductos);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.DetalleProductoRequest, global::GrpcClientAPI.DetalleProductoResponse> __Method_Detalle = new grpc::Method<global::GrpcClientAPI.DetalleProductoRequest, global::GrpcClientAPI.DetalleProductoResponse>(
        grpc::MethodType.Unary,
        __ServiceName,
        "Detalle",
        __Marshaller_DetalleProductoRequest,
        __Marshaller_DetalleProductoResponse);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.TiendaId, global::GrpcClientAPI.getProductosNoAsociados> __Method_GetProductosNoAsociados = new grpc::Method<global::GrpcClientAPI.TiendaId, global::GrpcClientAPI.getProductosNoAsociados>(
        grpc::MethodType.Unary,
        __ServiceName,
        "GetProductosNoAsociados",
        __Marshaller_TiendaId,
        __Marshaller_getProductosNoAsociados);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.TiendaId, global::GrpcClientAPI.getProductosAsociados> __Method_GetProductosAsociados = new grpc::Method<global::GrpcClientAPI.TiendaId, global::GrpcClientAPI.getProductosAsociados>(
        grpc::MethodType.Unary,
        __ServiceName,
        "GetProductosAsociados",
        __Marshaller_TiendaId,
        __Marshaller_getProductosAsociados);

    /// <summary>Service descriptor</summary>
    public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
    {
      get { return global::GrpcClientAPI.ProductoReflection.Descriptor.Services[0]; }
    }

    /// <summary>Client for producto</summary>
    public partial class productoClient : grpc::ClientBase<productoClient>
    {
      /// <summary>Creates a new client for producto</summary>
      /// <param name="channel">The channel to use to make remote calls.</param>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public productoClient(grpc::ChannelBase channel) : base(channel)
      {
      }
      /// <summary>Creates a new client for producto that uses a custom <c>CallInvoker</c>.</summary>
      /// <param name="callInvoker">The callInvoker to use to make remote calls.</param>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public productoClient(grpc::CallInvoker callInvoker) : base(callInvoker)
      {
      }
      /// <summary>Protected parameterless constructor to allow creation of test doubles.</summary>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      protected productoClient() : base()
      {
      }
      /// <summary>Protected constructor to allow creation of configured clients.</summary>
      /// <param name="configuration">The client configuration.</param>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      protected productoClient(ClientBaseConfiguration configuration) : base(configuration)
      {
      }

      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.CrudProductoResponse CrearProducto(global::GrpcClientAPI.ProductoRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return CrearProducto(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.CrudProductoResponse CrearProducto(global::GrpcClientAPI.ProductoRequest request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_CrearProducto, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.CrudProductoResponse> CrearProductoAsync(global::GrpcClientAPI.ProductoRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return CrearProductoAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.CrudProductoResponse> CrearProductoAsync(global::GrpcClientAPI.ProductoRequest request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_CrearProducto, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.CrudProductoResponse ModificarProducto(global::GrpcClientAPI.ProductoModificarRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return ModificarProducto(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.CrudProductoResponse ModificarProducto(global::GrpcClientAPI.ProductoModificarRequest request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_ModificarProducto, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.CrudProductoResponse> ModificarProductoAsync(global::GrpcClientAPI.ProductoModificarRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return ModificarProductoAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.CrudProductoResponse> ModificarProductoAsync(global::GrpcClientAPI.ProductoModificarRequest request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_ModificarProducto, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.CrudProductoResponse EliminarProducto(global::GrpcClientAPI.ProductoId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return EliminarProducto(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.CrudProductoResponse EliminarProducto(global::GrpcClientAPI.ProductoId request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_EliminarProducto, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.CrudProductoResponse> EliminarProductoAsync(global::GrpcClientAPI.ProductoId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return EliminarProductoAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.CrudProductoResponse> EliminarProductoAsync(global::GrpcClientAPI.ProductoId request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_EliminarProducto, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getProductos TraerProductos(global::GrpcClientAPI.FiltrosProducto request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerProductos(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getProductos TraerProductos(global::GrpcClientAPI.FiltrosProducto request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_TraerProductos, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getProductos> TraerProductosAsync(global::GrpcClientAPI.FiltrosProducto request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerProductosAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getProductos> TraerProductosAsync(global::GrpcClientAPI.FiltrosProducto request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_TraerProductos, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.DetalleProductoResponse Detalle(global::GrpcClientAPI.DetalleProductoRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return Detalle(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.DetalleProductoResponse Detalle(global::GrpcClientAPI.DetalleProductoRequest request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_Detalle, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.DetalleProductoResponse> DetalleAsync(global::GrpcClientAPI.DetalleProductoRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return DetalleAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.DetalleProductoResponse> DetalleAsync(global::GrpcClientAPI.DetalleProductoRequest request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_Detalle, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getProductosNoAsociados GetProductosNoAsociados(global::GrpcClientAPI.TiendaId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return GetProductosNoAsociados(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getProductosNoAsociados GetProductosNoAsociados(global::GrpcClientAPI.TiendaId request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_GetProductosNoAsociados, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getProductosNoAsociados> GetProductosNoAsociadosAsync(global::GrpcClientAPI.TiendaId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return GetProductosNoAsociadosAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getProductosNoAsociados> GetProductosNoAsociadosAsync(global::GrpcClientAPI.TiendaId request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_GetProductosNoAsociados, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getProductosAsociados GetProductosAsociados(global::GrpcClientAPI.TiendaId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return GetProductosAsociados(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getProductosAsociados GetProductosAsociados(global::GrpcClientAPI.TiendaId request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_GetProductosAsociados, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getProductosAsociados> GetProductosAsociadosAsync(global::GrpcClientAPI.TiendaId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return GetProductosAsociadosAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getProductosAsociados> GetProductosAsociadosAsync(global::GrpcClientAPI.TiendaId request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_GetProductosAsociados, null, options, request);
      }
      /// <summary>Creates a new instance of client from given <c>ClientBaseConfiguration</c>.</summary>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      protected override productoClient NewInstance(ClientBaseConfiguration configuration)
      {
        return new productoClient(configuration);
      }
    }

  }
}
#endregion
