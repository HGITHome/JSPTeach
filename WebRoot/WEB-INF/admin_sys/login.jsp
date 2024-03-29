

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
<head>
  <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        
        <link href="${base}/res/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${base}/res/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="${base}/res/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${base}/res/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
        <link href="${base}/res/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link href="${base}/res/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
        <link href="${base}/res/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="${base}/res/assets/global/css/components-md.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="${base}/res/assets/global/css/plugins-md.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN PAGE LEVEL STYLES -->
        <link href="${base}/res/assets/pages/css/login.min.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="favicon.ico" /> 
</head>
    <body class=" login">
        <!-- BEGIN LOGO -->
        <div class="logo">
            <h3 class="form-title font-green">欢迎使用JSP教学管理系统</h3>
        </div>
        <!-- END LOGO -->
        <!-- BEGIN LOGIN -->
        <div class="content">
            <!-- BEGIN LOGIN FORM -->
            <form class="login-form" action="login.do" method="post">
				            
				<#if returnUrl??><input type="hidden" name="returnUrl" value="${returnUrl}"/></#if>
				<#if processUrl??><input type="hidden" name="processUrl" value="${processUrl}"/></#if>
                <h3 class="form-title font-green">登录</h3>
                <div class="alert alert-danger display-hide">
                    <button class="close" data-close="alert"></button>
                  
                    <span> 用户名或密码不能为空 </span>
            
                </div>
                	<#if errors??>
                    <div class="alert alert-danger ">
	                    <button class="close" data-close="alert"></button>
							<#list errors as error> <span> ${error}</span><br></#list>
	               	 </div>
                     </#if>  
					
                <div class="form-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">Username</label>
                    <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">Password</label>
                    <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password" /> </div>
               
               
                  <#if errorRemaining?? && errorRemaining<=0>
             		   <div class="input-group">
                             <div class="input-group-control">
                                 <input type="text" placeholder="验证码" autocomplete="off" placeholder="验证码" name="captcha" class="form-control"> </div>
                             <span class="input-group-btn btn-right ">
                                 <img src="${base}/captcha.svl" height="40"  onclick="this.src='${base}/captcha.svl?d='+new Date()*1"/>
                             </span>
                         </div>
                    </#if>
                    
                   
                <div class="form-actions">
                    <button type="submit" class="btn green uppercase btn-block">登&nbsp;录</button>
                </div>
                
                没有账号？<a href="input.do">注册</a>
                <div class="create-account">
                    <p>
                        <a href="#"  class="uppercase">2017 © 奋斗少年 </a>
                    </p>
                </div>
            </form>
            <!-- END LOGIN FORM -->
        </div>
        <!--[if lt IE 9]>
<script src="${base}/res/assets/global/plugins/respond.min.js"></script>
<script src="${base}/res/assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
        <!-- BEGIN CORE PLUGINS -->
        <script src="${base}/res/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="${base}/res/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${base}/res/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
        <script src="${base}/res/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="${base}/res/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="${base}/res/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="${base}/res/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
        <script src="${base}/res/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="${base}/res/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="${base}/res/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
        <script src="${base}/res/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="${base}/res/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="${base}/res/assets/pages/scripts/login.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <!-- END THEME LAYOUT SCRIPTS -->
    </body>

</html>