<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>管理员登录</title>


    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- Theme style -->
    <!-- iCheck -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition login-page">
    <div class="login-box" id="loginForm">
        <div class="login-logo">


            <a href="#"><b>舒适圈</b>管理端登录</a>


        </div>
        <!-- /.login-logo -->
        <div class="login-box-body">
            <p class="login-box-msg">登录系统</p>

            <form action="${pageContext.request.contextPath}/login.do" method="get">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" name="adminName" placeholder="账号">
                    <span class="glyphicon fa fa-fw fa-user form-control-feedback"></span>
<!--                    <i class="fa fa-fw fa-user"></i>-->
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" name="adminPassword" placeholder="密码">
<!--                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>-->
                    <span class="glyphicon fa fa-fw fa-envelope form-control-feedback"></span>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="checkbox icheck">
                            <label><input type="checkbox"> 记住 下次自动登录</label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <div class="social-auth-links text-center">
                <p>- 或者 -</p>
                <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class=""></i>电话号码登录</a>
<!--                <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-weixin"></i> 微信用户登录</a>-->
            </div>
            <!-- /.social-auth-links -->

            <a href="#">忘记密码</a><br>
            <%--<a href="#" class="text-center">新用户注册</a>--%>

        </div>
        <!-- /.login-box-body -->
    </div>
    <!-- /.login-box -->

    <!-- jQuery 2.2.3 -->
    <!-- Bootstrap 3.3.6 -->
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/vue2.5/vue.min.js"/>
    <script>
        $(function() {
            $('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });
        });


        new Vue({
            el:"#loginForm",
            methods:{
                login:function () {
                    alert("login....")
                }
            }
        })
    </script>
</body>

</html>