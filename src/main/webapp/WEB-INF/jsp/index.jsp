<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8"/>
    <title>Index jsp</title>
    <%--<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="/resources/css/styles.css" rel="stylesheet">--%>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
</head>

<body>
<div class="container">
    <br/>
    <form action="save">
        <input type="text" name="version">
        <input type="text" name="name">
        <input type="text" name="limit">
    </form>
     <h2>here</h2>
    <div id="result"></div>
    <spring:message code="logout.url" />
</div>


<script type="text/javascript">
    $(document).ready(function () {
        console.log("in index js, showing hiding!!");
    });

    function getRequest(url, successCallback, failCallback) {
        console.log("calling "+url);
        $.ajax({
            url: url,
            timeout: 3000,
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                console.log(jqXHR.status);
                successCallback(data, textStatus, jqXHR);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR.status);
                failCallback(jqXHR, textStatus, errorThrown);
            }
        });
    };


    function onSuccess(data, textStatus, jqXHR) {
        console.log("success");
        $("#result").html("Success data is " + JSON.stringify(data));
    };
    function onFail(jqXHR, textStatus, errorThrown) {
        console.log("failure");
        $("#result").html("Shit happens");
    };

    //fire request
    //getRequest("/all",onSuccess,onFail);
    getRequest("cust?name=bla",onSuccess,onFail);

</script>
</body>

</html>