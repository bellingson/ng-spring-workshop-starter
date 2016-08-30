
<%@ include file="/components/taglibs.jsp" %>

<html>
<head>
    <title>Products</title>


</head>
<body>

<div class="layer product-list">

    <div class="container">

        <div class="row">

            <c:forEach items="${products}" var="item">

                <div class="col-xs-12 col-sm-4">

                    <div class="product">

                        <h3>${item.name}</h3>

                        <a class="img-wrapper" href="/product/${item.id}">
                            <img src="${item.imagePath}" alt="${item.name}" />
                        </a>

                        <div class="clearfix">
                            <h4 class="pull-right"><fmt:formatNumber type="currency" value="${item.price}"/></h4>
                        </div>

                        <p>${item.summary}</p>


                    </div>


                </div>


            </c:forEach>


        </div>

    </div>

</div>


</body>
</html>