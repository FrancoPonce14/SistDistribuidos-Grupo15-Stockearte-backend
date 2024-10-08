// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: Protos/interaccion.proto
// </auto-generated>
#pragma warning disable 0414, 1591, 8981, 0612
#region Designer generated code

using grpc = global::Grpc.Core;

namespace GrpcClientAPI {
  public static partial class interaccion
  {
    static readonly string __ServiceName = "interaccion";

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
    static readonly grpc::Marshaller<global::GrpcClientAPI.IdSeguirUsuario> __Marshaller_IdSeguirUsuario = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.IdSeguirUsuario.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.StringSeguido> __Marshaller_StringSeguido = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.StringSeguido.Parser));
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Marshaller<global::GrpcClientAPI.favorito> __Marshaller_favorito = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GrpcClientAPI.favorito.Parser));

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.IdSeguirUsuario, global::GrpcClientAPI.StringSeguido> __Method_seguirUsuario = new grpc::Method<global::GrpcClientAPI.IdSeguirUsuario, global::GrpcClientAPI.StringSeguido>(
        grpc::MethodType.Unary,
        __ServiceName,
        "seguirUsuario",
        __Marshaller_IdSeguirUsuario,
        __Marshaller_StringSeguido);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.IdSeguirUsuario, global::GrpcClientAPI.StringSeguido> __Method_dejarDeSeguirUsuario = new grpc::Method<global::GrpcClientAPI.IdSeguirUsuario, global::GrpcClientAPI.StringSeguido>(
        grpc::MethodType.Unary,
        __ServiceName,
        "dejarDeSeguirUsuario",
        __Marshaller_IdSeguirUsuario,
        __Marshaller_StringSeguido);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.favorito, global::GrpcClientAPI.StringSeguido> __Method_agregarFavorito = new grpc::Method<global::GrpcClientAPI.favorito, global::GrpcClientAPI.StringSeguido>(
        grpc::MethodType.Unary,
        __ServiceName,
        "agregarFavorito",
        __Marshaller_favorito,
        __Marshaller_StringSeguido);

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    static readonly grpc::Method<global::GrpcClientAPI.favorito, global::GrpcClientAPI.StringSeguido> __Method_removerFavorito = new grpc::Method<global::GrpcClientAPI.favorito, global::GrpcClientAPI.StringSeguido>(
        grpc::MethodType.Unary,
        __ServiceName,
        "removerFavorito",
        __Marshaller_favorito,
        __Marshaller_StringSeguido);

    /// <summary>Service descriptor</summary>
    public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
    {
      get { return global::GrpcClientAPI.InteraccionReflection.Descriptor.Services[0]; }
    }

    /// <summary>Client for interaccion</summary>
    public partial class interaccionClient : grpc::ClientBase<interaccionClient>
    {
      /// <summary>Creates a new client for interaccion</summary>
      /// <param name="channel">The channel to use to make remote calls.</param>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public interaccionClient(grpc::ChannelBase channel) : base(channel)
      {
      }
      /// <summary>Creates a new client for interaccion that uses a custom <c>CallInvoker</c>.</summary>
      /// <param name="callInvoker">The callInvoker to use to make remote calls.</param>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public interaccionClient(grpc::CallInvoker callInvoker) : base(callInvoker)
      {
      }
      /// <summary>Protected parameterless constructor to allow creation of test doubles.</summary>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      protected interaccionClient() : base()
      {
      }
      /// <summary>Protected constructor to allow creation of configured clients.</summary>
      /// <param name="configuration">The client configuration.</param>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      protected interaccionClient(ClientBaseConfiguration configuration) : base(configuration)
      {
      }

      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.StringSeguido seguirUsuario(global::GrpcClientAPI.IdSeguirUsuario request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return seguirUsuario(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.StringSeguido seguirUsuario(global::GrpcClientAPI.IdSeguirUsuario request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_seguirUsuario, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.StringSeguido> seguirUsuarioAsync(global::GrpcClientAPI.IdSeguirUsuario request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return seguirUsuarioAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.StringSeguido> seguirUsuarioAsync(global::GrpcClientAPI.IdSeguirUsuario request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_seguirUsuario, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.StringSeguido dejarDeSeguirUsuario(global::GrpcClientAPI.IdSeguirUsuario request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return dejarDeSeguirUsuario(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.StringSeguido dejarDeSeguirUsuario(global::GrpcClientAPI.IdSeguirUsuario request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_dejarDeSeguirUsuario, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.StringSeguido> dejarDeSeguirUsuarioAsync(global::GrpcClientAPI.IdSeguirUsuario request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return dejarDeSeguirUsuarioAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.StringSeguido> dejarDeSeguirUsuarioAsync(global::GrpcClientAPI.IdSeguirUsuario request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_dejarDeSeguirUsuario, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.StringSeguido agregarFavorito(global::GrpcClientAPI.favorito request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return agregarFavorito(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.StringSeguido agregarFavorito(global::GrpcClientAPI.favorito request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_agregarFavorito, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.StringSeguido> agregarFavoritoAsync(global::GrpcClientAPI.favorito request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return agregarFavoritoAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.StringSeguido> agregarFavoritoAsync(global::GrpcClientAPI.favorito request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_agregarFavorito, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.StringSeguido removerFavorito(global::GrpcClientAPI.favorito request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return removerFavorito(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual global::GrpcClientAPI.StringSeguido removerFavorito(global::GrpcClientAPI.favorito request, grpc::CallOptions options)
      {
        return CallInvoker.BlockingUnaryCall(__Method_removerFavorito, null, options, request);
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.StringSeguido> removerFavoritoAsync(global::GrpcClientAPI.favorito request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
      {
        return removerFavoritoAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
      }
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      public virtual grpc::AsyncUnaryCall<global::GrpcClientAPI.StringSeguido> removerFavoritoAsync(global::GrpcClientAPI.favorito request, grpc::CallOptions options)
      {
        return CallInvoker.AsyncUnaryCall(__Method_removerFavorito, null, options, request);
      }
      /// <summary>Creates a new instance of client from given <c>ClientBaseConfiguration</c>.</summary>
      [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
      protected override interaccionClient NewInstance(ClientBaseConfiguration configuration)
      {
        return new interaccionClient(configuration);
      }
    }

  }
}
#endregion
