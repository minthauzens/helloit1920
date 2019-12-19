<%--@elvariable id="sweet" type="lv.helloit.bootcamp.sweeter.Sweet"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sweet Id</title>
    <link rel="stylesheet" href="<c:url value="/styles.css"/>">
</head>
<body>
<button onclick="deleteSweetAndRedirectWithConfirmationCheck(${sweet.id})">DELETE</button>
<p>${sweet.id}</p>
<p class="author">${sweet.author}</p>
<p>${sweet.content}</p>
<p>${sweet.datePosted}</p>
<p>${sweet.dateLastUpdate}</p>
<br>
<a href="/sweets/">BACK</a>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script
        type="application/javascript"
        src="<c:url value="/sweetScripts.js"/>"></script>
</body>
</html>