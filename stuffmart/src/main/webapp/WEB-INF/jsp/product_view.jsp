
<%@ include file="/components/taglibs.jsp" %>

<html>
<head>
    <title>${product.name}</title>

</head>
<body>

<div class="layer product-view">

    <div class="container">

        <h1>${product.name}</h1>

        <div class="row">
            <div class="col-xs-12 col-sm-4">

                <div class="img-wrapper">
                    <img src="${product.imagePath}" alt="${product.name}" />
                </div>

            </div>
            <div class="col-xs-12 col-sm-4">

                <h4><fmt:formatNumber type="currency" value="${product.price}"/></h4>

                <button class="btn btn-primary">
                    Buy Now
                </button>

            </div>


        </div>


        <div class="row">
            <div class="col-xs-12 col-sm-6">

                <p>${product.description}</p>

            </div>
        </div>

    </div> <!-- // container -->

</div>

</body>
</html>