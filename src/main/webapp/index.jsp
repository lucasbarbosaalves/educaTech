<%@ page import="br.com.educatech.models.Course" %>
<%@ page import="java.util.List" %>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Educatech</title>
    <link rel="stylesheet" href="reset.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="styles/header.css">

</head>

<body>
    <header class="cabeçalho">
        <div class="container">
            <input type="checkbox" id="menu" class="container__botao">
            <label for="menu" class="container__rotulo">
                <span class="cabeçalho__menu-hamburguer container__imagem"></span>
            </label>
            <ul class="lista-menu">
                <li class="lista-menu__titulo">Categorias</li>
                <li class="lista-menu__item">
                    <a href="#" class="lista-menu__link">DATA SCIENCE</a>
                </li>
                <li class="lista-menu__item">
                    <a href="#" class="lista-menu__link">FRONT-END</a>
                </li>
                <li class="lista-menu__item">
                    <a href="#" class="lista-menu__link">BACK-END</a>
                </li>
            </ul>
            <img src="img/Logo.svg" alt="Logo da Educatech" class="container__imagem">
            <h1 class="container__titulo"><b class="container__titulo--negrito">Educa</b>Tech</h1>
        </div>

        <ul class="opcoes">
            <input type="checkbox" id="opcoes-menu" class="opcoes__botao">
            <label for="opcoes-menu" class="opcoes__rotulo">
                <li class="opcoes__item">Categorias</li>
            </label>
            
            <ul class="lista-menu">
                <li class="lista-menu__item">
                    <a href="#" class="lista-menu__link">DATA SCIENCE</a>
                </li>
                <li class="lista-menu__item">
                    <a href="#" class="lista-menu__link">FRONT-END</a>
                </li>
                <li class="lista-menu__item">
                    <a href="#" class="lista-menu__link">BACK-END</a>
                </li>
            </ul>

            <li class="opcoes__item"><a href="#" class="opcoes__link">Comunidade</a></li>
            <li class="opcoes__item"><a href="#" class="opcoes__link">Meus cursos</a></li>
        </ul>

        <div class="container">
            <a href="/profile.jsp" class="container__link">
                <p class="container__texto">Meu perfil</p>
            </a>
            <a href="/login.jsp" class="container__link">
                <p class="container__texto">Login</p>
            </a>
            <a href="/register.jsp" class="container__link">
                <p class="container__texto">Cadastro</p>
            </a>
        </div>    
    </header>
    <section class="banner">
        <h2 class="banner__titulo">Já sabe por onde começar?</h2>
        <input type="search" class="banner__pesquisa" placeholder="Qual será seu próximo estudo?">
    </section>

    <section>
        <h2 class="carrossel__titulo">CONTINUE ESTUDANDO ...</h2>
    </section>

        <div class="card">
            <div class="card__descricao">
                <div class="descricao">
                    <h3 class="descricao__titulo">A partir do zero : HTML e css...</h3>
                    <h2 class="descricao__titulo-livro">Continue de onde parou</h2>
                </div>
                <img src="img/Angular.svg" class="descricao__imagem">
            </div>

            <div class="card__botoes">
                <a href="#" class="botoes__ancora">Todas as aulas</a>
            </div>
        </div>

    <section class="carrossel">
        <h2 class="carrossel__titulo">CURSOS DISPONIVEIS</h2>
        <div class="carrossel__container">
        <%
            List<Course> courses = (List<Course>) request.getAttribute("courses");
            if (courses != null && !courses.isEmpty()) {
                for (Course course : courses) { %>

                     <div class="card" name="courses">
                         <div class="card__descricao">
                             <div class="descricao">
<%--                                 <h3 class="descricao__titulo"><img src="img/Estrelinhas.svg" alt="icones de estrelinhas"></h3>--%>
                                 <h3 class="descricao__titulo" id="name"><%= course.getName() %></h3>
                                 <h2 class="descricao__titulo-livro" id="category"><%= course.getCategory() %></h2>
                                 <p class="descricao__texto" id="description"><%= course.getDescription() %></p>
                                 <p class="descricao__texto" id="teacher"><%= course.getTeacher() %></p>
                             </div>
                             <img src="img/Perfil-escritora 1.png" alt="foto da escritora juliana agarikov" class="descricao__imagem">
                         </div>

                         <div class="card__botoes">
                             <ul class="botoes">
                                 <li class="botoes__item"><img src="img/Favoritos.svg" alt="favoritar livro"></li>
                                 <li class="botoes__item"><img src="img/Compras.svg" alt="adicionar no carrinho de compras"></li>
                             </ul>
                             <a href="#" class="botoes__ancora">Saiba mais</a>
                         </div>
                     </div>

                <% }
            } else { %>
                <p>Nenhum curso disponível.</p>
            <% } %>
    </div>
    </section>
    <section class="contato">
        <div class="contato__descricao">
            <h2 class="contato__titulo">Fique por dentro das novidades!</h2>
            <p class="contato__texto">Atualizações de e-books, novos livros, promoções e outros.</p>
        </div>    
        <input type="email" placeholder="Cadastre seu e-mail" class="contato__email">
    </section>

    <hr/>

    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <script>
        const swiper = new Swiper('.swiper', {
            spaceBetween: 10,
            slidesPerView: 3,
            pagination: {
                el: '.swiper-pagination',
                type: 'bullets',
            },
        });
    </script>
</body>

</html>