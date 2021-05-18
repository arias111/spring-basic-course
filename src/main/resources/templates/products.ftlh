<!doctype html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Snippet - BBBootstrap</title>
    <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet'>
    <style>
        body {
            margin: 0;
            font-family: Roboto, -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
            font-size: .8125rem;
            font-weight: 500;
            line-height: 1.5385;
            color: #333;
            text-align: left;
            background-color: #f5f5f5
        }

        .mt-50 {
            margin-top: 50px
        }

        .mb-50 {
            margin-bottom: 50px
        }

        .bg-teal-400 {
            background-color: #26a69a
        }

        a {
            text-decoration: none !important
        }

        .fa {
            color: red
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
    <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
    <script type='text/javascript'></script>
</head>
<body oncontextmenu='return false' class='snippet-body'>
<div class="header">
    <#--    <img src="/static/MESAN.png" alt="" class="img">-->
    <div class="header-right">
        <a href="/profile">Профиль</a>
        <a href="/categories">Каталог</a>
        <a class="active" href="/categories/{categoryId}">Товары</a>
        <a  href="/delivery">Доставка</a>
    </div>
</div>
<#list products as products>
<div class="container d-flex justify-content-center mt-50 mb-50">
    <div class="row">
        <div class="col-md-10">
            <div class="card card-body">
                <div class="media align-items-center align-items-lg-start text-center text-lg-left flex-column flex-lg-row">
                    <div class="mr-2 mb-3 mb-lg-0"><img style="width: 200px" src="/img/${products.getImageName()}" alt="img"/>
                    </div>
                    <div class="media-body">
                        <h6 class="media-title font-weight-semibold"> <a href="#" data-abc="true">${products.name}</a> </h6>
                        <p class="mb-3"></p>
                        <ul class="list-inline list-inline-dotted mb-0">
                        </ul>
                    </div>
                    <div class="mt-3 mt-lg-0 ml-lg-3 text-center">
                        <h3 class="mb-0 font-weight-semibold"></h3>
                        <div class="text-muted"></div> <button type="button" class="btn btn-warning mt-4 text-white"><i class="icon-cart-add mr-2"></i> Add to cart</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</#list>
</body>
</html>