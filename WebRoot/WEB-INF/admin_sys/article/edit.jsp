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
						<li><span>添加</span>
						</li>
					</ul>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-gift"></i>文章
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
								<form action="o_update.do" method="post" id="form_update"
									novalidate="novalidate"
									class="form-horizontal form-row-seperated">
									<input type="hidden" name="id" value="${article.id}" /> 
									<input type="hidden" name="fileUrl" value="${article.fileUrl!}" />
									 <div class="alert alert-danger display-hide">
                                                <button class="close" data-close="alert"></button> 请检查输入的文章信息 </div>
							            <div class="form-group">
                                                <label class="control-label col-md-3">请选择章节类
                                                <span class="required"> * </span>
                                                </label>
                                                <div class="col-md-9">
                                                    <div class="margin-bottom-10">
                                                        <select class="form-control input-small input-inline" id="chapter" name="chapter" data-style="btn-primary">
                                                            <option value="">章</option>
                                                            <#list chapterList as chapter>
                                                            <option value="${chapter.id }">${chapter.name! }</option>
                                                            </#list>
                                                        </select>
                                                        <select class="form-control input-small input-inline" id="section" name="sectionList" data-style="btn-success">
                                                            <option value="">节</option>
                                                            <#list sectionList as section>
                                                            <option value="${section.id}">${section.name!}</option>
                                                            </#list>
                                                        </select>
                                                    </div>
                                                </div>
                                         </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">文章题目
                                                    <span class="required"> * </span>
                                                </label>
                                                <div class="col-md-4">
                                                    <input type="text" name="title" id="title" data-required="1" class="form-control" value="${article.title!}"/> </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">专业术语
                                                    <span class="required"> * </span>
                                                </label>
                                                <div class="col-md-4">
                                                    <input type="text" name="label" id="label" data-required="1" class="form-control" value="${article.label!}"/> </div>
                                            </div>
                                      <div class="form-group">
                                        <span class="required"> * </span> 
                                        <textarea id="editor" name="content" style="width: 100%;height: 500px;" id="content">${content!}</textarea>
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
          <script type="text/javascript">
          var chapterEle = $('#chapter');
          chapterEle.change(function(){
        	  var chapterId = $("#chapter").val();
        	  if(chapterId == null || $.trim(chapterId)==""){
        		 bootbox.alert("请选择章!");
        	  }else{
        		  var sections = $("#section");
        		  sections.empty();
        	  $.ajax({
                  url: "v_ajaxSections.do",
                  type: "post",
                  dataType : "json",
                  data: { "id": chapterId},
                  success: function(data) {
                	  var select = data;
                      if(select != null && select != "" && select.length > 0){//如果子列表有值则把值赋上去
                          var tr = "";
                          for(var i = 0 ; i < select.length ; i ++){                        
                              tr = tr + "<option value='" + select[i].id + "'>" + select[i].name + "</option>";
                          }
                          $('#section').append(tr);
                      }
                  },
                  error:function(xhr,textStatus){
                      console.log('错误');
                      console.log(textStatus);
                  },
              });
        	  }});
          $(function(){
        	  $("#chapter").val('${article.section.chapter.id}');
        	  $("#section").val('${article.section.id}');
          });
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
			<script src="${base}/res/assets/js/article_validation.js" type="text/javascript"></script>
           <script src="${base}/res/assets/global/plugins/jquery-validation/js/localization/messages_zh.js"></script>
           <script src="${base}/res/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
           <script type="text/javascript" src="${base}/res/assets/global/plugins/icheck/icheck.min.js"></script>
		<script src="${base }/res/assets/pages/scripts/components-bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${base }/res/assets/global/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
	
	</div>
	<!-- END CONTAINER -->
</body>

</html>