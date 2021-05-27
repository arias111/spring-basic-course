Skip to content
Search or jump to…

Pull requests
Issues
Marketplace
Explore

@arias111
Mansur908
/
Semestrovka1-2k2sem
1
01
Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights
Semestrovka1-2k2sem/SPRING1/src/main/resources/templates/admin.ftlh
@Mansur908
Mansur908 new
Latest commit daf0940 4 days ago
History
1 contributor
131 lines (123 sloc)  3.87 KB

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .d {
            margin: 170px 450px;
            height: 400px;
            width: 400px;
            border: 1px solid black;
        }

        .e1 {
            margin: 15px 100px 10px;
            text-align: center;
            width: 200px;
            height: 30px;
            border: 1px solid #000;
            background-position: 7px 7px;
            outline: none;
            border-radius: 10px;
        }

        .e2 {
            margin: 10px 100px;
            text-align: center;
            width: 200px;
            height: 30px;
            border: 1px solid #000;
            background-position: 7px 7px;
            outline: none;
            border-radius: 10px;
        }

        .i2 {
            margin: 10px 100px;
            text-align: center;
            width: 200px;
            height: 30px;
            background-position: 7px 7px;
            outline: none;
        }

        .sub {
            margin: 30px 160px;
            text-align: center;
            width: 80px;
            height: 25px;
            border: 1px solid #ffffff;
            outline: none;
            color: #ffffff;
            border-radius: 10px;
            background-color: transparent
        }

        .message {
            margin: 5px;
            text-align: center;
        }

        .mainPage {
            margin: -140px 1100px;
            position: absolute;
            text-align: center;
            width: 120px;
            height: 25px;
            border: 1px solid #ffffff;
            outline: none;
            color: #ffffff;
            border-radius: 10px;
            background-color: transparent;
        }

        .mainPage1 {
            margin: -140px 600px;
            position: absolute;
            text-align: center;
            width: 120px;
            height: 25px;
            border: 1px solid #ffffff;
            outline: none;
            color: #ffffff;
            border-radius: 10px;
            background-color: transparent;
        }

        .mainPage3 {
            margin: -140px 100px;
            position: absolute;
            text-align: center;
            width: 120px;
            height: 25px;
            border: 1px solid #ffffff;
            outline: none;
            color: #ffffff;
            border-radius: 10px;
            background-color: transparent;
        }
    </style>
</head>
<body bgcolor="darkkhaki">
<div class="d">
    <h3 align="center">Добавление товаров</h3>
    <#if message?has_content>
        <p class="message"><font color="red"><b>${message}</b></font></p>
    </#if>
    <form action="/admin" method="post" enctype="multipart/form-data">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input class="e1" required type="text" name="name" placeholder="Название товара"/>
        <input class="e2" required type="text" name="type" placeholder="Категория"/>
        <input class="i2" required align="center" type="file" name="file">
        <textarea class="e2" required name="text" placeholder="Описание"></textarea>
        <input class="sub" type="submit" value="ENTER"/>
    </form>
</div>
</body>
</html>