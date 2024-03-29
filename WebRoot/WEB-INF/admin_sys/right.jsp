<div class="page-content-wrapper">
	<!-- BEGIN CONTENT BODY -->
	<div style="min-height:1022px" class="page-content">
		<!-- page bar start -->
		<div class="page-bar">

			<ul class="page-breadcrumb">
				<li><a href="index.do">首页</a> <i class="fa fa-angle-right"></i>
				</li>
				<li><span>系统信息</span>
				</li>
			</ul>
		</div>
		<!-- page bar end-->
		<div class="row">

			<div class="col-md-12 ">
				<!-- BEGIN Portlet PORTLET-->
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="icon-screen-desktop"></i> 欢迎使用${title!''}
						</div>
					</div>
					<div class="portlet-body">
						<dl>
							<dt>智能系统程序版本:&nbsp;&nbsp;&nbsp;&nbsp;V1.0.0</dt>
							<dd>
								<br>
							</dd>
							<dt>您上次登录的时间:&nbsp;&nbsp;&nbsp;&nbsp;${user.lastLoginTime?string('yyyy-MM-dd')}</dt>
							<dd>
								<br>
							</dd>
							<dd>
								已用内存:<span style="color:#0078ff;">${(usedMemory/1024/1024)?string("0.##")}MB</span>
							</dd>
							<dd>
								<br>
							</dd>
							<dd>
								剩余内存：<span style="color:#ff8400;">${(useableMemory/1024/1024)?string("0.##")}MB
								</span>
							</dd>
							<dd>
								<br>
							</dd>
							<dd>
								最大内存：<span style="color:#00ac41;">${(maxMemory/1024/1024)?string("0.##")}MB</span>
							</dd>
						</dl>
					</div>
					<!-- END Portlet PORTLET-->
				</div>

			</div>

		</div>

		<div class="row">

			<div class="col-md-12 ">
				<!-- BEGIN Portlet PORTLET-->
				<div class="portlet box red">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift"></i> 系统属性
						</div>
					</div>
					<div class="portlet-body">
						<dl>
							<dd>操作系统版本:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${props['os.name']!}
								${props['os.version']!}</dd>
							<dd>
								<br>
							</dd>
							<dd>操作系统类型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${props['os.arch']!}
								${props['sun.arch.data.model']!}位</dd>
							<dd>
								<br>
							</dd>
							<dd>用户、目录、临时目录:&nbsp;&nbsp;&nbsp;${props['user.name']!},
								${props['user.dir']!}, ${props['java.io.tmpdir']!}</dd>
							<dd>
								<br>
							</dd>
							<dd>
								JAVA运行环境:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${props['java.runtime.name']!}
								${props['java.runtime.version']!}</dd>
							<dd>
								<br>
							</dd>

							<dd>
								JAVA虚拟机:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${props['java.vm.name']!}
								${props['java.vm.version']!}</dd>
						</dl>
					</div>
					<!-- END Portlet PORTLET-->
				</div>
			</div>
		</div>
  
	</div>
	<!-- END CONTENT BODY -->
</div>