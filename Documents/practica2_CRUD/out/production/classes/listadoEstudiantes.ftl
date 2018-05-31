<!DOCTYPE html>
<html>
<head>
    <title>Estudiantes</title>
</head>
<body>
    <h1>Todos los estudiantes</h1>

    <button onclick="javascript:location.href='/estudiante/nuevo'">Agregar nuevo estudiante</button>

    <table width="100%" border="1">
        <thead>
            <tr>
                <th>Matricula</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <#list estudiantes as estudiante>
            <tr>
                <td>${estudiante.getStringMatricula()}</td>
                <td>${estudiante.getNombre()}</td>
                <td>${estudiante.getApellido()}</td>
                <td>${estudiante.getTelefono()}</td>
                <td><a href="/estudiante/borrar/${estudiante.getStringMatricula()}">Borrar</a><br><a href="/estudiante/editar/${estudiante.getStringMatricula()}">Editar</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>