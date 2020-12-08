<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- 页面meta /-->
    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="../plugins/morris/morris.css">
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="../plugins/select2/select2.css">
    <link rel="stylesheet" href="../plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="../plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">
    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->
    <!-- 内容区域 -->
    <div class="content-wrapper">
        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                游记攻略管理
                <small>游记攻略表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="all-travellog-manage-list.html">游记攻略管理</a></li>
                <li class="active">游记攻略表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <!-- 正文区域 -->
        <section class="content">
            <div class="box-body">
                <!--tab页-->
                <div class="nav-tabs-custom">
                    <!--tab头-->
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#tab-form" data-toggle="tab">表单</a>
                        </li>
                    </ul>
                    <!--tab头/-->
                    <!--tab内容-->
                    <div class="tab-content">
                        <!--表单内容-->
                        <div class="tab-pane active" id="tab-form">
                            <div class="row data-type">
                                <div class="col-md-2 title">ID</div>
                                <div class="col-md-10 data text">
                                    ${newsInfo.newsId}
                                </div>
                                <div class="col-md-2 title">标题</div>
                                <div class="col-md-10 data">
                                    <%--<input type="text" class="form-control" placeholder="标题" value="">--%>
                                    <input type="text" class="form-control" placeholder="标题" value="${newsInfo.newsTitle}">
                                </div>
                                <div class="col-md-2 title">来源</div>
                                <div class="col-md-10 data">
                                    <input type="text" class="form-control" placeholder="来源" value="">
                                </div>
                                <div class="col-md-2 title">作者</div>
                                <div class="col-md-10 data">
                                    <input type="text" class="form-control" placeholder="作者" value="${newsInfo.userId}">
                                </div>
                                <div class="col-md-2 title">发布日期</div>
                                <div class="col-md-10 data">
                                    <input type="text" class="form-control" placeholder="作者" value="${newsInfo.releaseDateStr}">
                                </div>
                                <div class="col-md-2 title">状态</div>
                                <div class="col-md-10 data line-height36">
                                    <div class="form-group form-inline">
                                        ${newsInfo.newsStatusStr}
                                    </div>
                                </div>
                                <div class="col-md-2 title">点赞数</div>
                                <div class="col-md-10 data">
                                    <input type="text" class="form-control" placeholder="点赞数" value="">
                                </div>
                                <div class="col-md-2 title">资讯内容文本</div>
                                <textarea class="form-control" rows="5" cols="10">${newsInfo.newsContent}</textarea>
                            <%--<input type="text" class="form-control" placeholder="资讯内容文本" value="">--%>
                            </div>
                            <!--游记-->
                            <div class="panel panel-default">
                                <div class="panel-heading">游记</div>
                                <button type="button" class="btn bg-maroon btn-flat margin" id="btn-dayadd">添加游记</button>
                                <div id="dayslist" class="panel-body">
                                    <div class="box box-success">
                                        <div class="box-header with-border">
                                            <h3 class="box-title">第xx天游记</h3>
                                            <div class="box-tools pull-right">
                                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <input type="text" class="form-control" placeholder="第xx天游记标题" value=""><br>
                                            <textarea class="textarea" placeholder="第xx天游记正文" style="width: 100%; height: 265px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--游记/-->
                            <!--工具栏-->
                            <div class="box-tools text-center">
                                <button type="button" class="btn bg-maroon">保存</button>
                                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
                            </div>
                            <!--工具栏/-->
                            <!--游记输入模板-->
                            <div id="day-tpl" style="display:none">
                                <div class="box box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">第xx天游记</h3>
                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body">
                                        <input type="text" class="form-control" placeholder="第xx天游记标题" value=""><br>
                                        <textarea class="" placeholder="第xx天游记正文" style="width: 100%; height: 265px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                                    </div>
                                </div>
                            </div>
                            <!--游记输入模板/-->
                        </div>
                        <!--表单内容/-->
                    </div>
                    <!--tab内容/-->
                </div>
                <!--tab页/-->
                <!-- .box-footer
    <div class="box-footer"></div>
    -->
                <!-- /.box-footer-->
            </div>
        </section>
        <!-- 正文区域 /-->
    </div>
    <!-- 内容区域 /-->
    <!-- 底部导航 -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- 底部导航 /-->
</div>
<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../plugins/raphael/raphael-min.js"></script>
<script src="../plugins/morris/morris.min.js"></script>
<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../plugins/knob/jquery.knob.js"></script>
<script src="../plugins/daterangepicker/moment.min.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../plugins/fastclick/fastclick.js"></script>
<script src="../plugins/iCheck/icheck.min.js"></script>
<script src="../plugins/adminLTE/js/app.min.js"></script>
<script src="../plugins/treeTable/jquery.treetable.js"></script>
<script src="../plugins/select2/select2.full.min.js"></script>
<script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="../plugins/ckeditor/ckeditor.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="../plugins/chartjs/Chart.min.js"></script>
<script src="../plugins/flot/jquery.flot.min.js"></script>
<script src="../plugins/flot/jquery.flot.resize.min.js"></script>
<script src="../plugins/flot/jquery.flot.pie.min.js"></script>
<script src="../plugins/flot/jquery.flot.categories.min.js"></script>
<script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="../plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();
        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });
    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }
    // 添加每天的游记
    function addEditer() {
        var dayEditer = $('#day-tpl').html();
        $(".panel-body").append(dayEditer);
        $("#dayslist textarea:last").wysihtml5({
            locale: 'zh-CN'
        });
    }
    $(document).ready(function() {
        $("#btn-dayadd").click(function() {
            addEditer();
        });
    });
    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("travellog-manage");
    });
</script>
</body>
</html>