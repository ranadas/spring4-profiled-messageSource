<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8"/>
    <title>Bootstrap jsp</title>
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/styles.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
</head>

<body>
<div class="container">
    <br/>

    <div class="container">
        <div id="something"></div>
        <div id="displaycan"></div>
    </div>

    <div class="canvas1" id="canvas1">
        <div class="row" align="center">
            <form action=""></form>
            <label for="input1"></label>
            <input type="text" name="input1" id="input1">
            <input type="button" name="Save" value="Save">
        </div>
    </div>
    <br/>
    <div class="canvas2">
        <div class="row" align="center">
            <input type="button" id="b1" name="Save1" value="One">
            <input type="button" id="b2" name="Save2" value="Two">
            <input type="button" id="b3" name="Save3" value="Three">
        </div>
    </div>
    <br/>
    <div class="canvas3" id ="canvas3">
        <div class="row" align="center">
            <label for="input3"></label>
            <input type="text" name="input3" id="input3">
        </div>
    </div>
    <br/>
</div>


<script src="/resources/bootstrap/js/bootstrap.js"></script>
<script src="/resources/js/custom.js"></script>

<script type="text/javascript">
    $(document).ready(
            function () {
                console.log("in index js, showing hiding!!");

                $('#b1').click(function(e) {
                    dispplayFunction("create");
                });
                $('#b2').click(function(e) {
                    dispplayFunction("modify");
                });
                $('#b3').click(function(e) {
                    dispplayFunction("all");
                });

                var usr = '${user}';
                var jsonObj = JSON.parse(usr);
                var currentUser = jsonObj.user;
                var currentDisplayCanvas = jsonObj.displayCanvas;
                console.log("Setting " + currentUser);
                document.getElementById('something').innerHTML = "<strong>Welcome back :</strong>" + currentUser;

                var inp1 = document.getElementById('input1');
                inp1.value = currentUser;
                var inp2 = document.getElementById('input3');
                inp2.value = currentUser;
                dispplayFunction(currentDisplayCanvas);
                
            }
    );

</script>
</body>

</html>