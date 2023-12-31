<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EducaTech</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="text-center">Cadastro</h2>
            <form action="/register" method="post">
          <span class="text-danger"><c:if test="${param.error != null}">
              ${requestScope.message}
          </c:if></span>
                <div class="mb-3">
                    <label for="name" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Digite seu nome">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">E-mail</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Digite seu e-mail">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Digite sua senha">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Confirme sua senha</label>
                    <input type="password" class="form-control" id="" name="password" placeholder="Confirme sua senha">
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
                <a href="/login" class="btn btn-primary ms-2">Login</a>
            </form>

        </div>
    </div>
</div>

</body>
</html>
