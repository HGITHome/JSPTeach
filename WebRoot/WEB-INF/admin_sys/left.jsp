<div class="page-sidebar-wrapper">
	
	<div class="page-sidebar navbar-collapse collapse">
		
		<ul class="page-sidebar-menu  page-header-fixed "
			data-keep-expanded="false" data-auto-scroll="true"
			data-slide-speed="200" style="padding-top: 20px">
			<!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
			<li class="sidebar-toggler-wrapper hide">
				<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				<div class="sidebar-toggler"></div> <!-- END SIDEBAR TOGGLER BUTTON -->
			</li>
			<!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->

			<li class="nav-item <#if tb_11??>start active open</#if>" id="tb_11" ><a href="javascript:;"
				class="nav-link nav-toggle"> <i class="icon-home"></i> <span
					class="title">首页</span> <span class="arrow <#if tb_11_arrow??>open</#if>"></span> </a>
				<ul class="sub-menu" <#if tb_11_ul??>display="block"</#if>>
					<li class="nav-item <#if tb_11_li_1??>start active open</#if>"><a href="${base}/admin/index.do"
						class="nav-link "> <i class="icon-home"></i> <span
							class="title">系统信息</span> <span class="selected"></span> </a></li>
					<@cms_perm url="/personal/v_profile.do">
					<li class="nav-item <#if tb_11_li_2??>start active open</#if>"><a
						href="${base}/admin/personal/v_profile.do" class="nav-link ">
							<i class="icon-user"></i> <span class="title">个人资料</span> <span
							class="selected"></span> </a></li> 
							</@cms_perm>
				</ul>
			</li>
			<!-- //章节管理 -->
			<@cms_perm url="/chapter/v_list.do">
			<li class="nav-item <#if tb_12??>start active open</#if>" id="tb_12"><a href="javascript:;"
				class="nav-link nav-toggle"> <i class="icon-diamond"></i> 
				<span class="title">章节管理</span> <span class="arrow <#if tb_12_arrow??>open</#if>"></span> </a>
				<@cms_perm url="/chapter/v_list.do">
				<ul class="sub-menu" <#if tb_12_ul??>display="block"</#if>>
					<li class="nav-item <#if tb_12_li_1??>start active open</#if>"><a href="${base}/admin/chapter/v_list.do"
						class="nav-link "> <i class="fa fa-cubes"></i> <span
							class="title">章节管理</span> <span class="selected"></span> </a></li>
				</ul>
					</@cms_perm>
			</li>
			</@cms_perm>
			
			<!-- //文章管理 -->
			<@cms_perm url="/article/v_list.do">
			<li class="nav-item <#if tb_13??>start active open</#if>" id="tb_13"><a href="javascript:;"
				class="nav-link nav-toggle"> <i class="icon-diamond"></i> 
				<span class="title">文章管理</span> <span class="arrow <#if tb_13_arrow??>open</#if>"></span> </a>
				<@cms_perm url="/article/v_list.do">
				<ul class="sub-menu" <#if tb_13_ul??>display="block"</#if>>
					<li class="nav-item <#if tb_13_li_1??>start active open</#if>"><a href="${base}/admin/article/v_list.do"
						class="nav-link "> <i class="fa fa-cubes"></i> <span
							class="title">文章列表</span> <span class="selected"></span> </a></li>
				</ul>
					</@cms_perm>
			</li>
			</@cms_perm>
			
			<!-- //公告管理 -->
			<@cms_perm url="/notice/v_list.do">
			<li class="nav-item <#if tb_14??>start active open</#if>" id="tb_14"><a href="javascript:;"
				class="nav-link nav-toggle"> <i class="icon-diamond"></i> 
				<span class="title">公告管理</span> <span class="arrow <#if tb_14_arrow??>open</#if>"></span> </a>
				<@cms_perm url="/notice/v_list.do">
				<ul class="sub-menu" <#if tb_14_ul??>display="block"</#if>>
					<li class="nav-item <#if tb_14_li_1??>start active open</#if>"><a href="${base}/admin/notice/v_list.do"
						class="nav-link "> <i class="fa fa-cubes"></i> <span
							class="title">公告列表</span> <span class="selected"></span> </a></li>
				</ul>
					</@cms_perm>
			</li>
			</@cms_perm>
			
			
				<!-- //用户管理 -->
				<@cms_perm url="/frame/user">
			<li class="nav-item <#if tb_15??>start active open</#if>" id="tb_15"><a href="javascript:;"
				class="nav-link nav-toggle"> <i class="icon-user"></i> <span
					class="title">用户管理</span> <span class="arrow <#if tb_15_arrow??>open</#if>"></span> </a>
				<ul class="sub-menu" <#if tb_15_ul??>display="block"</#if>>
				
				
				<@cms_perm url="/admin_global/v_list.do">
				<li class="nav-item <#if tb_15_li_1??>start active open</#if>">
						<a href="${base}/admin/admin_global/v_list.do" class="nav-link "> 
							<i class="fa fa-child"></i> 
							<span class="title">用户管理</span>
						  </a>
					</li>
				</@cms_perm>
				
				
				</ul>
			</li>
				</@cms_perm>
		
		</ul>
		
	</div>
</div>

