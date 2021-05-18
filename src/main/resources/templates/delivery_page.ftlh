<!DOCTYPE html>
<html>
<head>
    <title>Add Map</title>

    <style type="text/css">
        #map {
            height: 350px;
            width: 500px;
            position: absolute;
            right: 100px;
            top: 230px;
        }
        /* Style the body */
        body {
            font-family: Arial;
            margin: 0;
        }
        .img {
            height: 100px;
            width: 250px;
            margin-left: 120px; /* Отступ слева */
        }
        .ul {
            margin-left: 120px; /* Отступ слева */
            vertical-align: top;
            display: inline;
        }
        .us {
            margin-left: 800px;
            display: inline;        }
        .vl {
            border-left: 1px solid #5a5858;
            height: 500px;
            position: absolute;
            left: 50%;
            margin-left: -3px;
            top: 200px;
        }

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
    <script>
        function initMap() {
            const uluru = { lat: 55.74580, lng: 49.137199 };
            const map = new google.maps.Map(document.getElementById("map"), {
                zoom: 15,
                center: uluru,
            });
            const marker = new google.maps.Marker({
                position: uluru,
                map: map,
            });
        }
    </script>
</head>
<body>
<div class="header">
<#--    <img src="/static/MESAN.png" alt="" class="img">-->
    <div class="header-right">
        <a href="/profile">Профиль</a>
        <a href="/categories">Каталог</a>
        <a class="active" href="/delivery">Доставка</a>
    </div>
</div>

<div class="content">
    <div>
        <h3 class="ul">Доставка</h3>
        <h3 class="us">Самовызов</h3>

    </div>
    </br>
    <h4 align="left">
        Доставка осуществляется по всем направлениям РФ.</br>
        </br>
        БЕСПЛАТНАЯ доставка по Казани, при покупке от 30 000 руб.</br>
        </br>
        БЕСПЛАТНАЯ доставка грузов до терминала отправки.</br>
        </br>
        Мы работаем с такими транспортными компаниями как Возовоз, Экспресс — Авто,</br>
        Деловые линии и другими, представленными в г.Казани</br>
        </br>
    </h4>

    <div class="vl"></div>
    <div id="map"></div>
    <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAseUIk4BGrkhSxS1ojgDmD_kCEbAwxzr0&callback=initMap&libraries=&v=weekly"
            async></script>
</div>
</body>
</html>