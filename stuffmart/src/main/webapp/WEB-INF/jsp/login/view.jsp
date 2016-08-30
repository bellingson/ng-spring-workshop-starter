<%@ include file="/components/taglibs.jsp" %>

<html>
<head>
    <title></title>
</head>
<body>

<div class="container login-page">

    <div class="row">
        <div class="col-xs-12 col-sm-4 col-sm-offset-4">

                <h1>Sign In</h1>

                <form action="/login" method="post" class="form-horizontal" role="form">

                    <div class="form-group">
                       <label >User Name</label>

                           <input type="text" name="username" class="form-control" value="admin" required />

                    </div>

                    <div class="form-group">
                        <label>Password</label>
                        <div>
                            <input type="password" name="password" class="form-control" value="admin" required />
                        </div>
                    </div>

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>

                    <div class="form-group">
                        <div class="pull-right">
                            <button type="submit" class="btn btn-primary">OK</button>
                        </div>
                    </div>
                </form>




        </div>
    </div>




</div>




</body>
</html>