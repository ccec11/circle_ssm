<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/badWord/add.do">
    <%--<input type="text" name="badWordId" placeholder="id自增长">--%>
    <input type="text" name="badWordContent" placeholder="敏感词名称">
    <br>
    <button type="submit">提交表单</button>


</form>

</body>
</html>
