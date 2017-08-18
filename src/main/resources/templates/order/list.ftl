[#if page.content?has_content]
	<ul>
		[#list page.content as order]
			<li>标题: ${order.states}</li>
			<li>内容: ${order.events}</li>
		[/#list]
	</ul>
[#else]
	没有任何数据
[/#if]