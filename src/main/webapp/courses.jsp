<%@ page import="br.com.educatech.models.Course" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Cursos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<h1 class="text-center">Cursos</h1>

<table class="table table-striped">
    <thead>
    <tr>
        <th>CATEGORIA</th>
        <th>NOME</th>
        <th>DESCRICAO</th>
        <th>DURACAO</th>
        <th>PROFESSOR</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Course> courses = (List<Course>) request.getAttribute("courses");

        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
    %>
    <tr>
        <td><%= course.getCategory() %></td>
        <td><%= course.getName() %></td>
        <td><%= course.getDescription() %></td>
        <td><%= course.getDuration() %></td>
        <td><%= course.getTeacher() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

</body>
</html>

