// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: Protos/receta.proto
// </auto-generated>
#pragma warning disable 0414, 1591, 8981, 0612
#region Designer generated code

using grpc = global::Grpc.Core;

namespace GrpcClientAPI {
  public static partial class receta
  {
    static readonly string __ServiceName = "receta";

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
    static readonly grpc::Marshaller<global::GrpcClientAPI.RecetaRequest> __Marshaller_RecetaRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.RecetaRequest.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.getRecetaCreada> __Marshaller_getRecetaCreada = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.getRecetaCreada.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.RecetaUpdateRequest> __Marshaller_RecetaUpdateRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.RecetaUpdateRequest.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.getRecetaEditada> __Marshaller_getRecetaEditada = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.getRecetaEditada.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.UsuarioRequestByUserId> __Marshaller_UsuarioRequestByUserId = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.UsuarioRequestByUserId.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.getRecetas> __Marshaller_getRecetas = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.getRecetas.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.RecetaRequestFilter> __Marshaller_RecetaRequestFilter = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.RecetaRequestFilter.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.Empty2> __Marshaller_Empty2 = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.Empty2.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.RecetaRequestById> __Marshaller_RecetaRequestById = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.RecetaRequestById.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.ListaIngredientes> __Marshaller_ListaIngredientes = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.ListaIngredientes.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.RecetaResponse> __Marshaller_RecetaResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.RecetaResponse.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.ListaIngredienteSinCantidad> __Marshaller_ListaIngredienteSinCantidad = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.ListaIngredienteSinCantidad.Parser));

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.RecetaRequest, global::GrpcClientAPI.getRecetaCreada> __Method_CrearReceta = new grpc::Method<global::GrpcClientAPI.RecetaRequest, global::GrpcClientAPI.getRecetaCreada>(
        grpc::MethodType.Unary,
        __ServiceName,
        "CrearReceta",
        __Marshaller_RecetaRequest,
        __Marshaller_getRecetaCreada);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.RecetaUpdateRequest, global::GrpcClientAPI.getRecetaEditada> __Method_EditarReceta = new grpc::Method<global::GrpcClientAPI.RecetaUpdateRequest, global::GrpcClientAPI.getRecetaEditada>(
        grpc::MethodType.Unary,
        __ServiceName,
        "EditarReceta",
        __Marshaller_RecetaUpdateRequest,
        __Marshaller_getRecetaEditada);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.UsuarioRequestByUserId, global::GrpcClientAPI.getRecetas> __Method_TraerRecetasPorId = new grpc::Method<global::GrpcClientAPI.UsuarioRequestByUserId, global::GrpcClientAPI.getRecetas>(
        grpc::MethodType.Unary,
        __ServiceName,
        "TraerRecetasPorId",
        __Marshaller_UsuarioRequestByUserId,
        __Marshaller_getRecetas);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.RecetaRequestFilter, global::GrpcClientAPI.getRecetas> __Method_TraerRecetas = new grpc::Method<global::GrpcClientAPI.RecetaRequestFilter, global::GrpcClientAPI.getRecetas>(
        grpc::MethodType.Unary,
        __ServiceName,
        "TraerRecetas",
        __Marshaller_RecetaRequestFilter,
        __Marshaller_getRecetas);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.Empty2, global::GrpcClientAPI.getRecetas> __Method_TraerTodasLasRecetas = new grpc::Method<global::GrpcClientAPI.Empty2, global::GrpcClientAPI.getRecetas>(
        grpc::MethodType.Unary,
        __ServiceName,
        "TraerTodasLasRecetas",
        __Marshaller_Empty2,
        __Marshaller_getRecetas);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.UsuarioRequestByUserId, global::GrpcClientAPI.getRecetas> __Method_TraerRecetasFavoritas = new grpc::Method<global::GrpcClientAPI.UsuarioRequestByUserId, global::GrpcClientAPI.getRecetas>(
        grpc::MethodType.Unary,
        __ServiceName,
        "TraerRecetasFavoritas",
        __Marshaller_UsuarioRequestByUserId,
        __Marshaller_getRecetas);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.RecetaRequestById, global::GrpcClientAPI.ListaIngredientes> __Method_TraerIngredientes = new grpc::Method<global::GrpcClientAPI.RecetaRequestById, global::GrpcClientAPI.ListaIngredientes>(
        grpc::MethodType.Unary,
        __ServiceName,
        "TraerIngredientes",
        __Marshaller_RecetaRequestById,
        __Marshaller_ListaIngredientes);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.RecetaRequestById, global::GrpcClientAPI.RecetaResponse> __Method_TraerRecetasPorIdReceta = new grpc::Method<global::GrpcClientAPI.RecetaRequestById, global::GrpcClientAPI.RecetaResponse>(
        grpc::MethodType.Unary,
        __ServiceName,
        "TraerRecetasPorIdReceta",
        __Marshaller_RecetaRequestById,
        __Marshaller_RecetaResponse);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.Empty2, global::GrpcClientAPI.ListaIngredienteSinCantidad> __Method_TraerTodosLosIngredientes = new grpc::Method<global::GrpcClientAPI.Empty2, global::GrpcClientAPI.ListaIngredienteSinCantidad>(
        grpc::MethodType.Unary,
        __ServiceName,
        "TraerTodosLosIngredientes",
        __Marshaller_Empty2,
        __Marshaller_ListaIngredienteSinCantidad);

    /// <summary>Service descriptor</summary>
    public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
    {
      get { return global::GrpcClientAPI.RecetaReflection.Descriptor.Services[0]; }
    }

    /// <summary>Client for receta</summary>
    public partial class recetaClient : grpc::ClientBase<recetaClient>
    {
      /// <summary>Creates a new client for receta</summary>
      /// <param name="channel">The channel to use to make remote calls.</param>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public recetaClient(grpc::ChannelBase channel) : base(channel)
      {
      }
      /// <summary>Creates a new client for receta that uses a custom <c>CallInvoker</c>.</summary>
      /// <param name="callInvoker">The callInvoker to use to make remote calls.</param>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public recetaClient(grpc::CallInvoker callInvoker) : base(callInvoker)
      {
      }
      /// <summary>Protected parameterless constructor to allow creation of test doubles.</summary>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      protected recetaClient() : base()
      {
      }
      /// <summary>Protected constructor to allow creation of configured clients.</summary>
      /// <param name="configuration">The client configuration.</param>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      protected recetaClient(ClientBaseConfiguration configuration) : base(configuration)
      {
      }

      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetaCreada CrearReceta(global::GrpcClientAPI.RecetaRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return CrearReceta(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetaCreada CrearReceta(global::GrpcClientAPI.RecetaRequest request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_CrearReceta, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetaCreada> CrearRecetaAsync(global::GrpcClientAPI.RecetaRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return CrearRecetaAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetaCreada> CrearRecetaAsync(global::GrpcClientAPI.RecetaRequest request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_CrearReceta, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetaEditada EditarReceta(global::GrpcClientAPI.RecetaUpdateRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return EditarReceta(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetaEditada EditarReceta(global::GrpcClientAPI.RecetaUpdateRequest request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_EditarReceta, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetaEditada> EditarRecetaAsync(global::GrpcClientAPI.RecetaUpdateRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return EditarRecetaAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetaEditada> EditarRecetaAsync(global::GrpcClientAPI.RecetaUpdateRequest request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_EditarReceta, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetas TraerRecetasPorId(global::GrpcClientAPI.UsuarioRequestByUserId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerRecetasPorId(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetas TraerRecetasPorId(global::GrpcClientAPI.UsuarioRequestByUserId request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_TraerRecetasPorId, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetas> TraerRecetasPorIdAsync(global::GrpcClientAPI.UsuarioRequestByUserId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerRecetasPorIdAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetas> TraerRecetasPorIdAsync(global::GrpcClientAPI.UsuarioRequestByUserId request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_TraerRecetasPorId, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetas TraerRecetas(global::GrpcClientAPI.RecetaRequestFilter request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerRecetas(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetas TraerRecetas(global::GrpcClientAPI.RecetaRequestFilter request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_TraerRecetas, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetas> TraerRecetasAsync(global::GrpcClientAPI.RecetaRequestFilter request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerRecetasAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetas> TraerRecetasAsync(global::GrpcClientAPI.RecetaRequestFilter request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_TraerRecetas, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetas TraerTodasLasRecetas(global::GrpcClientAPI.Empty2 request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerTodasLasRecetas(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetas TraerTodasLasRecetas(global::GrpcClientAPI.Empty2 request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_TraerTodasLasRecetas, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetas> TraerTodasLasRecetasAsync(global::GrpcClientAPI.Empty2 request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerTodasLasRecetasAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetas> TraerTodasLasRecetasAsync(global::GrpcClientAPI.Empty2 request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_TraerTodasLasRecetas, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetas TraerRecetasFavoritas(global::GrpcClientAPI.UsuarioRequestByUserId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerRecetasFavoritas(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.getRecetas TraerRecetasFavoritas(global::GrpcClientAPI.UsuarioRequestByUserId request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_TraerRecetasFavoritas, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetas> TraerRecetasFavoritasAsync(global::GrpcClientAPI.UsuarioRequestByUserId request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerRecetasFavoritasAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.getRecetas> TraerRecetasFavoritasAsync(global::GrpcClientAPI.UsuarioRequestByUserId request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_TraerRecetasFavoritas, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.ListaIngredientes TraerIngredientes(global::GrpcClientAPI.RecetaRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerIngredientes(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.ListaIngredientes TraerIngredientes(global::GrpcClientAPI.RecetaRequestById request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_TraerIngredientes, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.ListaIngredientes> TraerIngredientesAsync(global::GrpcClientAPI.RecetaRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerIngredientesAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.ListaIngredientes> TraerIngredientesAsync(global::GrpcClientAPI.RecetaRequestById request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_TraerIngredientes, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.RecetaResponse TraerRecetasPorIdReceta(global::GrpcClientAPI.RecetaRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerRecetasPorIdReceta(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.RecetaResponse TraerRecetasPorIdReceta(global::GrpcClientAPI.RecetaRequestById request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_TraerRecetasPorIdReceta, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.RecetaResponse> TraerRecetasPorIdRecetaAsync(global::GrpcClientAPI.RecetaRequestById request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerRecetasPorIdRecetaAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.RecetaResponse> TraerRecetasPorIdRecetaAsync(global::GrpcClientAPI.RecetaRequestById request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_TraerRecetasPorIdReceta, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.ListaIngredienteSinCantidad TraerTodosLosIngredientes(global::GrpcClientAPI.Empty2 request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerTodosLosIngredientes(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.ListaIngredienteSinCantidad TraerTodosLosIngredientes(global::GrpcClientAPI.Empty2 request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_TraerTodosLosIngredientes, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.ListaIngredienteSinCantidad> TraerTodosLosIngredientesAsync(global::GrpcClientAPI.Empty2 request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return TraerTodosLosIngredientesAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.ListaIngredienteSinCantidad> TraerTodosLosIngredientesAsync(global::GrpcClientAPI.Empty2 request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_TraerTodosLosIngredientes, null, options, request);
      }
      /// <summary>Creates a new instance of client from given <c>ClientBaseConfiguration</c>.</summary>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      protected override recetaClient NewInstance(ClientBaseConfiguration configuration)
      {
        return new recetaClient(configuration);
      }
    }

  }
}
#endregion
