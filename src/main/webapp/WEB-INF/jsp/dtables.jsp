<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8"/>
    <title>Bootstrap jsp</title>
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/css/jquery.dataTables.css" rel="stylesheet">
    <link href="/resources/css/dtables.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
</head>

<body>

<%--<table id="example">--%>
    <%--<thead>--%>
    <%--<tr><th>Sites</th></tr>--%>
    <%--</thead>--%>
    <%--<tbody>--%>
    <%--<tr><td>SitePoint</td></tr>--%>
    <%--<tr><td>Learnable</td></tr>--%>
    <%--<tr><td>Flippa</td></tr>--%>
    <%--</tbody>--%>
<%--</table>--%>


<table id="example1" class="table text-info">
    <thead>
    <tr><th class="site_name">Name</th><th>Url </th><th>Type</th><th>Last modified</th></tr>
    </thead>
    <tbody>
    </tbody>
</table>

<script src="/resources/bootstrap/js/bootstrap.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="/resources/js/dtables.js"></script>

<script type="text/javascript">

    $(document).ready(function () {
        console.log("dtables ready!");

    });

</script>
</body>

</html>