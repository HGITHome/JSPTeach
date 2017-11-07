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
		<#assign tb_14=true />
			<#assign tb_14_ul=true  />
			<#assign tb_14_li_1=true />
			<#assign tb_14_arrow=true />
		<#include "/admin_sys/left.jsp"/>
		<!-- END SIDEBAR -->
		<div class="page-content-wrapper">
			<!-- BEGIN CONTENT BODY -->
			<div style="min-height:1022px" class="page-content">
				<!-- page bar start -->
				<div class="page-bar">

					<ul class="page-breadcrumb">
						<li><a href="v_list.do">公告管理</a> <i class="fa fa-angle-right"></i>
						</li>
						<li><span>添加</span>
						</li>
					</ul>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-gift"></i>公告
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
								<form action="o_update.do" method="post" id="form_save"
									novalidate="novalidate"
									class="form-horizontal form-row-seperated">
									<input type="hidden" name="id" value="${notice.id}" />
									<input type="hidden" name="filePath" value="${notice.filePath }" />
									 <div class="alert alert-danger display-hide">
                                                <button class="close" data-close="alert"></button> 请检查输入的公告信息 </div>
							          
                                            <div class="form-group">
                                                <label class="control-label col-md-3">公告标题
                                                    <span class="required"> * </span>
                                                </label>
                                                <div class="col-md-4">
                                                    <input type="text" name="title" id="title" data-required="1" class="form-control" /> </div>
                                            </div>
                                      <div class="form-group">
                                        <span class="required"> * </span> 
                                        <textarea id="editor" name="content" style="width: 100%;height: 500px;" id="content">${content! }</textarea>
                                       </div>
                           
									<div class="form-actions">
										<div class="row">
											<div class="col-md-offset-6 col-md-6">
												<button type="submit"  class="btn  btn-primary" >
													<i class="fa fa-check"></i> 提交
												</button>
											</div>
										</div>
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
		
		  <script type="text/javascript">
                var editor = new UE.ui.Editor();
                editor.render('editor');//要显示控件的id
          </script>
          </script>
		<#include "/admin_sys/common/bootAlert_message.jsp"/>
		<!-- END CONTENT -->
		<script
			src="${base}/res/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"
			type="text/javascript"></script>
		<script
			src="${base}/res/assets/global/plugins/jquery-validation/js/localization/messages_zh.js"></script>
		<script
			src="${base}/res/assets/global/plugins/jquery-validation/js/additional-methods.min.js"
			type="text/javascript"></script>
			<script type="text/javascript" src="${base}/res/assets/global/plugins/icheck/icheck.min.js"></script>
			<script src="${base}/res/assets/js/notice_validation.js" type="text/javascript"></script>
           <script src="${base}/res/assets/global/plugins/jquery-validation/js/localization/messages_zh.js"></script>
           <script src="${base}/res/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
           <script type="text/javascript" src="${base}/res/assets/global/plugins/icheck/icheck.min.js"></script>
		<script src="${base }/res/assets/pages/scripts/components-bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${base }/res/assets/global/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
	
	</div>
	<!-- END CONTAINER -->
</body>

</html>