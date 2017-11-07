<!DOCTYPE html>


<html lang="en">

<head>
    <meta charset="utf-8"/>
    <title>JSP教学管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <#include "/admin_sys/head.jsp"/>


    <link
            href="${base}/res/assets/global/plugins/bootstrap-select/css/bootstrap-select.min.css"
            rel="stylesheet" type="text/css"/>

 <link href="${base}/res/assets/pages/css/blog.min.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/res/assets/global/plugins/cubeportfolio/css/cubeportfolio.css" rel="stylesheet"
          type="text/css"/>
    <link href="${base}/res/assets/pages/css/portfolio.min.css" rel="stylesheet" type="text/css"/>
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
    <#assign tb_12_ul=true />
    <#assign tb_12_li_2=true />
    <#assign tb_12_arrow=true />
    <#include "/admin_sys/left.jsp"/>
    <!-- END SIDEBAR -->
    <div class="page-content-wrapper">
        <!-- BEGIN CONTENT BODY -->
        <div style="min-height:1022px" class="page-content">
            <!-- page bar start -->
            <div class="page-bar">

                <ul class="page-breadcrumb">
                    <li><a href="v_list.do">节列表</a> <i class="fa fa-angle-right"></i>
                    </li>
                    <li><span>节详情</span></li>
                </ul>
            </div>

            <div class="row">
               <!--  <div class="portlet box blue">
                    <div class="portlet-title">
                        <div class="caption">举报详情</div>
                      <div class="tools">
									<div class="dt-buttons">
										<a class="dt-button buttons-print btn white  btn-outline"
											href="v_list.do" tabindex="0"><span>返回</span> </a>
									</div>
						</div>
                    </div>
                </div> -->

                <div class="portlet box purple">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="fa fa-gift"></i> 节详情
                        </div>
                        <div class="actions">

                            <form method="post" action="v_list.do?chapterId=${section.chapter.id}">
                                <div class="col-md-6">
                                    <button type="submit"
                                            class="dt-button buttons-print btn white  btn-outline">
                                        <i class="fa fa-check"></i> 返回

                                    </button>
                                </div>

                            </form>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <div class="row static-info">
                            <div class="col-md-3 name">ID:</div>
                            <div class="col-md-4 value">${section.id!}</div>
                        </div>
                        <div class="row static-info">
                            <div class="col-md-3 name">章名称:</div>
                            <div class="col-md-4 value">${section.name!}</div>
                        </div>
                        <div class="row static-info">
                            <div class="col-md-3 name">章优先级:</div>
                            <div class="col-md-4 value">${section.priority!}</div>
                        </div>
                        <div class="row static-info">
                            <div class="col-md-3 name">创建时间:</div>
                            <div class="col-md-4 value">${section.register_time?string('yyyy-MM-dd HH:mm:ss')}</div>
                        </div>
                        <div class="row static-info">
                            <div class="col-md-3 name">最后更新时间:</div>
                            <div class="col-md-4 value">${section.lastUpdate_time?string('yyyy-MM-dd HH:mm:ss')}</div>
                        </div>
                        <div class="row static-info">
                            <div class="col-md-3 name">所属章:</div>
                            <div class="col-md-4 value">${section.chapter.name!}</div>
                        </div>
                </div>
            </div>
        </div>
    </div>
    <#include "/admin_sys/common/bootAlert_message.jsp"/>
    <!-- END CONTENT -->
    <script
            src="${base}/res/assets/global/plugins/bootstrap-select/js/bootstrap-select.min.js"
            type="text/javascript"></script>

    <script
            src="${base}/res/assets/pages/scripts/components-bootstrap-select.min.js"
            type="text/javascript"></script>

    <script
            src="${base}/res/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"
            type="text/javascript"></script>
    <script
            src="${base}/res/assets/global/plugins/jquery-validation/js/localization/messages_zh.js"></script>
    <script
            src="${base}/res/assets/global/plugins/jquery-validation/js/additional-methods.min.js"
            type="text/javascript"></script>


  	<script src="${base}/res/assets/global/plugins/cubeportfolio/js/jquery.cubeportfolio.min.js"
        type="text/javascript"></script>
    <script src="${base}/res/assets/pages/scripts/portfolio-1.min.js" type="text/javascript"></script> 
    </body >

    </html>