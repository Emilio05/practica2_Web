<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>

    <link href="css/bootstrap.css" rel="stylesheet" />
</head>
<body>
<h1>Agregar nuevo estudiante</h1>
<form class="form-inline" method="POST" action="/estudiante/editar/${estudiante.getStringMatricula()}">
    <div class="form-group">
        <label for="matricula">Matricula</label>
        <input type="text"
               class="form-control"
               id="matricula"
               name="matricula"
               value="${estudiante.getStringMatricula()}"
               placeholder="20180000" readonly>
    </div>
    <div class="form-group">
        <label for="nombre">Nombre</label>
        <input type="text"
               class="form-control"
               id="nombre"
               name="nombre"
               value="${estudiante.getNombre()}">
    </div>

    <div class="form-group">
        <label for="apellido">Apellido</label>
        <input type="text"
               class="form-control"
               id="apellido"
               name="apellido"
               value="${estudiante.getApellido()}">
    </div>

    <div class="form-group">
        <label for="apellido">Telefono</label>
        <input type="tel"
               class="form-control"
               id="telefono"
               name="telefono"
               value="${estudiante.getTelefono()}"
               pattern="^\d{3}-\d{3}-\d{4}$" required
               placeholder="formato: 000-000-0000">
    </div>
    <button type="submit" class="btn btn-default">Actualizar</button>
    <a href="/estudiantes">Ver estudiantes registrados</a>
</form>
<body>
</html>
