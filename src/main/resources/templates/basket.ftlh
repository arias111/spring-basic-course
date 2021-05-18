<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Basket</title>
    <link rel="stylesheet" href="css/basket.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:ital,wght@0,300;1,400&display=swap"
          rel="stylesheet">
</head>
<body>
<div class="marquee shrift"><span>Скидки до 50% на осеннюю коллекцию!</span></div>
<div class="main">
    <nav class="navbar navbar-expand-lg navbar-light bg-white ">
        <a class="navbar-brand " href="#">
            <h1>Calvin Klein</h1>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto ">
                <li class="nav-item active shrift ">
                    <a class="nav-link " href="#">ЖЕНЩИНЫ</a>
                </li>
                <li class="nav-item shrift">
                    <a class="nav-link" href="#">МУЖЧИНЫ</a>
                </li>
                <li class="nav-item shrift">
                    <a class="nav-link" href="#">ДЕТИ</a>
                </li>
            </ul>
            <form>
                <input type="text" class="shrift input" placeholder="ПОИСК">
                <button type="submit" class="shrift">ИСКАТЬ</button>
            </form>
        </div>
        <button type="submit" class="shrift signUp" style="color: black" data-toggle="modal"
                data-target="#exampleModalSignUp">ЗАРЕГИСТРИРОВАТЬСЯ
        </button>
        <button type="submit" class="shrift signIn" style="color: black" data-toggle="modal"
                data-target="#exampleModal">ВОЙТИ
        </button>
        <button class="logo">
            <svg width="2em" height="2em" viewBox="0 0 20 20" class="bi bi-bag" fill="black"
                 xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
                      d="M8 1a2.5 2.5 0 0 0-2.5 2.5V4h5v-.5A2.5 2.5 0 0 0 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5v9a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V5H2z"/>
            </svg>
        </button>
    </nav>
    <div class="modal fade " id="exampleModalSignUp" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabelSignUp" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title shrift" id="exampleModalLabelSignUp" style="margin-left:190px">
                        ЗАРЕГИСТРИРОВАТЬСЯ</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/signIn" method="post">
                        <p class="form">НОМЕР ТЕЛЕФОНА: <input type="tel" name="tel" class="form"
                                                               pattern="2[0-9]{3}-[0-9]{3}"
                                                               placeholder="ВВЕДИТЕ НОМЕР ТЕЛЕФОНА"></p>
                        <p class="form">ВВЕДИТЕ ЭЛ.ПОЧТУ:<input name="login" class="form"
                                                                placeholder="ВВЕДИТЕ ЭЛ.ПОЧТУ"></p>
                        <p class="form">ПАРОЛЬ:<input type="password" class="form" name="password"
                                                      placeholder="ВВЕДИТЕ ПАРОЛЬ"></p>
                        <p class="shrift"><input type="submit" class="formclosebtn" value="ЗАРЕГИСТРИРОВАТЬСЯ"></p>
                    </form>
                </div>
                <div class="block" style="margin-left:120px">
                    <a href="#"><img src="images/facebook_logos_PNG19759.png" height="40" width="40"/></a>
                    <a href="#"><img src="images/twitter_PNG34.png" height="30" width="30"/></a>
                    <a href="#"><img src="images/google_PNG19635.png" height="40" width="40"/></a>
                    <a href="#"><img src="images/youtube_PNG15.png" height="45" width="45"/></a>
                    <a href="#"><img src="images/instagram_PNG12.png" height="40" width="40"/></a>
                </div>
                <div class="shrift">
                    <button type="button" data-dismiss="modal" class="formclosebtn">ЗАКРЫТЬ</button>
                </div>

            </div>
        </div>
    </div>
    <div class="modal fade " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title shrift" id="exampleModalLabel" style="margin-left: 130px">ВОЙТИ В ЛИЧНЫЙ
                        КАБИНЕТ</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/signIn" method="post">
                        <p class="form">ВВЕДИТЕ ЭЛ.ПОЧТУ:<input name="login" class="form"
                                                                placeholder="ВВЕДИТЕ ЭЛ.ПОЧТУ"></p>
                        <p class="form">ПАРОЛЬ:<input type="password" class="form" name="password"
                                                      placeholder="ВВЕДИТЕ ПАРОЛЬ"></p>
                        <p class="shrift"><input type="submit" class="formclosebtn" value="ВОЙТИ"></p>
                    </form>
                </div>
                <div class="block" style="margin-left:120px">
                    <a href="#"><img src="images/facebook_logos_PNG19759.png" height="40" width="40"/></a>
                    <a href="#"><img src="images/twitter_PNG34.png" height="30" width="30"/></a>
                    <a href="#"><img src="images/google_PNG19635.png" height="40" width="40"/></a>
                    <a href="#"><img src="images/youtube_PNG15.png" height="45" width="45"/></a>
                    <a href="#"><img src="images/instagram_PNG12.png" height="40" width="40"/></a>
                </div>
                <div class="shrift">
                    <button type="button" data-dismiss="modal" class="formclosebtn">ЗАКРЫТЬ</button>
                </div>

            </div>
        </div>
    </div>
    </nav>
    <div class="category catside">
        <a class="categoryall" href="#">НОВИНКИ</a>
        <a class="categoryall" href="#">НИЖНЕЕ БЕЛЬЕ</a>
        <a class="categoryall" href="#">ОДЕЖДА</a>
        <a class="categoryall" href="#">СУМКИ И АКСЕССУАРЫ</a>
        <a class="categoryall" href="#">ОБУВЬ</a>
        <a class="categoryall" href="#">ПОДАРКИ</a>
        <a class="categoryall" href="#">ПРЕДЫДУЩИЕ КОЛЛЕКЦИИ</a>
    </div>
</div>
<hr>
<div class="shrift">
    <h2 style="margin-left: 50px">ВАША КОРЗИНА</h2>
    <hr>
    <div style="padding-bottom: 200px">
        <div class="line_block">
            <img style="margin-left: 40px" src="images/13059536-1-brgtwhtracingred.jpg" height="200" width="160"/>
        </div>
        <div class="line_block">
            <p>НАЗВАНИЕ ПРОДУКТА:</p>
            <p>ЦВЕТ:</p>
            <p>РАЗМЕР:</p>
            <p>КОЛИЧЕСТВО:</p>
            <p>СУММА БЕЗ НДС:</p>
        </div>
    </div>
    <hr>
    <p style="margin-left: 50px">Стандартная доставка: 399,00 руб.</p>
    <p><h5 style="margin-left: 50px">ИТОГ:</h5></p>
    <div>
        <hr>
        <div class="payment">
            <p style="margin-left:40px">СПОСОБЫ ОПЛАТЫ:</p></div>
        <div class="payment">
            <button>ОПЛАТА ПРИ ПОЛУЧЕНИИ</button>
        </div>
        <div class="payment">
            <button>ОПЛАТА БАНКОВСКОЙ КАРТОЙ</button>
        </div>
    </div>
</div>
<footer class="shrift" style="padding-top: 100px">
    <hr>
    <p style="margin-left: 50px">ПОДПИШИТЕСЬ НА РАССЫЛКУ И ПОЛУЧИТЕ СКИДКУ 10% НА ВАШ ЗАКАЗ</p>
    <p class="dop" style="margin-left: 50px">ОСТАВАЙТЕСЬ В КУРСЕ НАШИХ НОВОСТЕЙ И ПОЛУЧИТЕ СКИДКУ 10%</p>
    <form>
        <div class="form-inline">
            <input type="text" style="margin-left: 50px" class="gdg" placeholder="ВВЕДИТЕ ЭЛ.АДРЕС">
            <button class="test mybtn">ПОДПИШИТЕСЬ</button>
        </div>
    </form>
</footer>
</div>
</body>
</html>