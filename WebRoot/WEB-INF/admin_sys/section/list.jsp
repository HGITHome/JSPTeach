<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>JSP教学管理系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<#include "/admin_sys/head.jsp"/>


  <link href="${base}/res/assets/global/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function getTableForm() {
		return document.getElementById('tableForm');
	}
</script>
</head>
<!-- END HEAD -->

<body
	class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid page-md">
	<!-- BEGIN HEADER -->
	<#include "/admin_sys/top.jsp"/>
	<!-- END HEADER -->
	<!-- BEGIN HEADER & CONTENT DIVIDER -->
	<div class="clearfix"></div>
	<!-- END HEADER & CONTENT DIVIDER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<#assign tb_12=true />
			<#assign tb_12_ul=true  />
			<#assign tb_12_li_1=true />
			<#assign tb_12_arrow=true />
		<#include "/admin_sys/left.jsp"/>
		<!-- END SIDEBAR -->
		<div class="page-content-wrapper">
			<!-- BEGIN CONTENT BODY -->
			<div style="min-height:1022px" class="page-content">
				<!-- page bar start -->
				<div class="page-bar">

					<ul class="page-breadcrumb">
						<li><a href="v_list.do">章节管理</a> <i class="fa fa-angle-right"></i>
						</li>
						<li><span>章节管理</span></li>
					</ul>
				</div>

				<div class="row ">
					<div class="col-md-12">
						<!-- BEGIN SAMPLE FORM PORTLET-->
						<div class="portlet box red bordered">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-comments"></i>筛选
								</div>
								<div class="tools">
									<a class="collapse" href="" data-original-title="" title="">
									</a> <a class="remove" href="" data-original-title="" title="">
									</a>
								</div>
							</div>
							<div class="portlet-body">	
								<form action="v_list.do" method="post" class="form-inline" id="tableForm" >
										<input type="hidden" name="chapterId" value="${chapterId!}"> 
										    <div class="form-group">
                                                                                                                                                                 节名: <input type="text" class="form-control" placeholder="" name="querySectionName" value="${querySectionName!}" />
                                            </div>
                                           	
                                           <input class="btn red" type="submit" value="查询"/>
								</form>
							</div>
						</div>
						<!-- END SAMPLE FORM PORTLET-->
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN SAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-comments"></i>节列表
								</div>
							    <div class="actions">
									<a href="v_add.do?chapterId=${chapterId}" class="btn btn-default btn-sm"> <i
										class="fa fa-plus"></i>添加</a> 
									
								</div>
							</div>

							<div class="portlet-body">
								<form id="tableForm" method="post">
									<input type="hidden" name="pageNo" value="${pageNo!}" />
									<div class="table-scrollable">
										<table
											class="table table-bordered table-hover dataTable table-checkable ">
											<thead>
												<tr>
													<th>ID</th>
													<th>名称</th>
													<th>优先级</th>
													<th>查看</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<#list pagination.list as section>
												<tr>
													<td>${section.id}</td>
												    <td>${section.name!}</td>
													<td>${section.priority!}</td>
													<td><a href="o_info.do?id=${section.id}"><i class="fa fa-eye">查看</i></a></td>
													<td>
													    <div class="btn-group">
															<button class="btn btn-xs blue dropdown-toggle"
																type="button" data-toggle="dropdown"
																aria-expanded="false">
																选择操作 <i class="fa fa-angle-down"></i>
															</button>
															<ul class="dropdown-menu pull-right" role="menu">	
															 <@cms_perm url="/section/v_edit.do"> 
															 <li><a href="v_edit.do?id=${section.id}"> <i
																		class="icon-docs"></i>编辑 </a></li> </@cms_perm>		
																<@cms_perm url="/section/o_delete.do">
																<li><a href="o_delete.do?id=${section.id}&chapterId=${chapterId}" onclick="if(!confirm('确定删除？')) {return false;}"> <i
																		class="icon-docs"></i>删除</a></li></@cms_perm>
															</ul>
														</div>
													</td>
												</tr>

												</#list>
											</tbody>
										</table>
									</div>
									<@p.pagination value=pagination;section,i,has_next>
									</@p.pagination>
								</form>
							</div>


						</div>
						<!-- END SAMPLE TABLE PORTLET-->
					</div>

				</div>

			</div>
		</div>
		<!-- BEGIN CONTENT -->

		<#include "/admin_sys/common/bootAlert_message.jsp"/>
		<!-- END CONTENT -->
			<script src="${base}/res/assets/global/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
			
        <script src="${base}/res/assets/pages/scripts/components-bootstrap-select.min.js" type="text/javascript"></script>
	</div>
	<!-- END CONTAINER -->
</body>

</html>