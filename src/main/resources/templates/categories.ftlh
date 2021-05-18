<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="/js/jquery.js"></script>
    <title>Document</title>
    <style>
    .header {
    padding: 80px;
    text-align: center;
    background: #01409b;
    color: white;
    font-size: 30px;
    }
    .header a {
    float: left;
    color: black;
    text-align: center;
    padding: 12px;
    text-decoration: none;
    font-size: 18px;
    line-height: 25px;
    border-radius: 4px;
    }

    .header a.logo {
    font-size: 25px;
    font-weight: bold;
    }

    .header a:hover {
    background-color: #ddd;
    color: black;
    }

    .header a.active {
    background-color: #78a6cf;
    color: white;
    }

    .header-right {
    float: right;
    }

    @media screen and (max-width: 500px) {
    .header a {
    float: none;
    display: block;
    text-align: left;
    }
    .header-right {
    float: none;
    }
    }

    /* Page Content */
    .content {
    padding:20px;
    }
    </style>
</head>
<body>
<div class="header">
    <div class="header-right">
        <a  href="/profile">Профиль</a>
        <a  class="active" href="/categories">Каталог</a>
        <a  href="/delivery">Доставка</a>
    </div>
</div>

<div class="container">
    <h1>Категории</h1>
    <div class="categories">
        <#list categories as categories>
            <div class="category">
                <div class="category-photo">
                    <img style="width: 200px" src="/img/${categories.getImageName()}" alt="img"/>
                </div>
                <a class="categoryName" href="/categories/${categories.getId()}">${categories.getName()}</a>
            </div>
        </#list>
    </div>
</div>
</body>
</html>