<%@ include file="/components/taglibs.jsp" %>

<html>
<head>
    <title> <sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />

    <link rel="stylesheet" href="/style/main.css" />



</head>
<body>

<%@ include file="/components/topbar.jsp" %>

<div class="page-body">

    <sitemesh:write property='body'/>

</div>


<%@ include file="/components/footer.jsp" %>

</body>
</html>