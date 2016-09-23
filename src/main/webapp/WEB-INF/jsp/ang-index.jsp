<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html ng-app="ranaAngApp">

<head >
    <meta charset="UTF-8"/>
    <title>Angular SPA </title>
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/styles.css" rel="stylesheet">

    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.js"></script>

    <script src="/resources//angularjs/angular.js"></script>
</head>

<body>
<div ng-controller="IndexPageController">
    <h1>To-do List</h1>
    <p>1 + 2 = {{1 + 2}}</p>
    <ul>
        <li ng-repeat="item in items">
            {{item.desc}} <button ng-click="removeItem($index)">remove</button>
        </li>
    </ul>

    <p>
        <input type="text" ng-model="newItemDescription"/>
        <button ng-click="addItem()">Add</button>
    </p>
</div>

<script src="/resources/js/ang-app.js"></script>


<script type="text/javascript">
    $(document).ready(function () {
        console.log("in Angular index jquery js!");
    });

</script>
</body>

</html>