<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user3-128x128.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>TOM</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>
			<%--<li id="admin-login"><a--%>
				<%--href="${pageContext.request.contextPath}/adminLoginInterface.jsp"><i--%>
					<%--class="fa fa-dashboard"></i> <span>登录</span></a></li>--%>

			<li class="treeview">
				<a href="#">
					<i class="fa fa-folder"></i> <span>登录模块</span>
					<span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
				</a>
				<ul class="treeview-menu">

					<li id="admin-login">
						<a href="${pageContext.request.contextPath}/adminLoginInterface.jsp">
							<i class="fa fa-circle-o"></i> 登录
						</a>
					</li>

					<li id="admin-register">
						<a href="all-admin-register.html">
							<i class="fa fa-circle-o"></i> 注册
						</a>
					</li>

					<li id="admin-404">
						<a href="all-admin-404.html">
							<i class="fa fa-circle-o"></i> 404页
						</a>
					</li>

					<li id="admin-500">
						<a href="all-admin-500.html">
							<i class="fa fa-circle-o"></i> 500页
						</a>
					</li>

				</ul>
			</li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">


					<li id="system-setting3"><a
						href="${pageContext.request.contextPath}/badWord/getAll.do"> <i
							class="fa fa-circle-o"></i> 敏感词汇管理
					</a></li>

					<li id="system-setting4"><a
						href="${pageContext.request.contextPath}/labelInfo/getAll.do">
							<i class="fa fa-circle-o"></i> 标签管理
					</a></li>
					<li id="system-setting5"><a
						href="${pageContext.request.contextPath}/news/getAllWait.do"> <i
							class="fa fa-circle-o"></i> 资讯管理
					</a></li>


				</ul></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
				<span>用户管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting1"><a
							href="${pageContext.request.contextPath}/user/getBanned.do"> <i
							class="fa fa-circle-o"></i> 解封用户
					</a></li>
					<li id="system-setting2"><a
							href="${pageContext.request.contextPath}/user/getReported.do"> <i
							class="fa fa-circle-o"></i> 封禁用户
					</a></li>



				</ul></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>圈子管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="room-setting"><a
						href="${pageContext.request.contextPath}/circle/getInvalid.do">
							<i class="fa fa-circle-o"></i> 创圈审核
					</a></li>


                    <li id="system-set2"><a
                            href="${pageContext.request.contextPath}/circle/getReported.do"> <i
                            class="fa fa-circle-o"></i> 封禁圈子
                    </a></li>
					<li id="system-set3"><a
							href="${pageContext.request.contextPath}/circle/getBanned.do"> <i
							class="fa fa-circle-o"></i> 解封圈子
					</a></li>


				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>