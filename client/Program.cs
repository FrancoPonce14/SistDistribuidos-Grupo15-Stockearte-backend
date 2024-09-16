var builder = WebApplication.CreateBuilder(args);

builder.Services.AddGrpc();

// Registrar los servicios de controladores
builder.Services.AddControllers();

builder.Services.AddHttpsRedirection(options =>
{
    options.HttpsPort = 5098; // Define el puerto HTTPS
});

builder.Services.AddAuthorization();

var app = builder.Build();

// Configurar HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection(); // Redirige todas las solicitudes HTTP a HTTPS
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllers();

app.Run();
