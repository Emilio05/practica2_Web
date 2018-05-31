<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>

    <link href="css/bootstrap.css" rel="stylesheet" />
</head>
<body>
<h1>Agregar nuevo estudiante</h1>
<form class="form-inline" method="POST" action="/estudiante/nuevo">
    <div class="form-group">
        <label for="matricula">Matricula</label>
        <input type="text"
               class="form-control"
               id="matricula"
               name="matricula"
               placeholder="20180000">
    </div>
    <div class="form-group">
        <label for="nombre">Nombre</label>
        <input type="text"
               class="form-control"
               id="nombre"
               name="nombre">
    </div>

    <div class="form-group">
        <label for="apellido">Apellido</label>
        <input type="text"
               class="form-control"
               id="apellido"
               name="apellido">
    </div>

    <div class="form-group">
        <label for="apellido">Telefono</label>
        <input type="tel"
               class="form-control"
               id="telefono"
               name="telefono"
               pattern="^\d{3}-\d{3}-\d{4}$" required
               placeholder="formato: 000-000-0000">
    </div>
    <button type="submit" class="btn btn-default">Agregar</button>
    <button onclick="javascript:location.href='/estudiantes'">Ver estudiantes registrados</button>
</form>
<body>
</html>
