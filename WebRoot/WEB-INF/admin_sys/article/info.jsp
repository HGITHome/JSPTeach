<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
<link type="text/css" rel="stylesheet" href="${base}/res/assets/global/plugins/icheck/skins/all.css">
<link href="${base }/res/assets/global/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
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
		<#assign tb_13=true />
			<#assign tb_13_ul=true  />
			<#assign tb_13_li_1=true />
			<#assign tb_13_arrow=true />
		<#include "/admin_sys/left.jsp"/>
		<!-- END SIDEBAR -->
		<div class="page-content-wrapper">
			<!-- BEGIN CONTENT BODY -->
			<div style="min-height:1022px" class="page-content">
				<!-- page bar start -->
				<div class="page-bar">

					<ul class="page-breadcrumb">
						<li><a href="v_list.do">文章管理</a> <i class="fa fa-angle-right"></i>
						</li>
						<li><span>查看</span>
						</li>
					</ul>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-gift"></i>文章详情
								</div>
								<div class="tools">
									<div class="dt-buttons">
										<a class="dt-button buttons-print btn white  btn-outline"
											href="v_list.do" tabindex="0"><span>返回</span> </a>
									</div>
								</div>
							</div>
							<div class="portlet-body form" style="display: block;">
								<!-- BEGIN FORM-->
								<form action="o_save.do" method="post" id="form_save"
									novalidate="novalidate"
									class="form-horizontal form-row-seperated">
								
							            <div class="form-group">
                                                <label class="control-label col-md-3">章节
                                                <span class="required"> * </span>
                                                </label>
                                                <div class="col-md-9">
                                                   ${article.section.chapter.name!}-${article.section.name! }
                                                </div>
                                         </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">文章题目
                                                    <span class="required"> * </span>
                                                </label>
                                                <div class="col-md-4">
                                                    ${article.title!} </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">专业术语
                                                    <span class="required"> * </span>
                                                </label>
                                                <div class="col-md-4">
                                                    ${article.label! } </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">编辑人
                                                    <span class="required"> * </span>
                                                </label>
                                                <div class="col-md-4">
                                                    ${article.admin.username! } </div>
                                            </div>
                                      <div class="form-group">
                                        <span class="required"> * </span> 
                                        ${content! }
                                       </div>
                           
								</form>
								<!-- END FORM-->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- BEGIN CONTENT -->
		
		 
		<#include "/admin_sys/common/bootAlert_message.jsp"/>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->
</body>

</html>