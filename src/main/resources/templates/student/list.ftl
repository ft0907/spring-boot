[#if page.content?has_content]
	<ul>
		[#list page.content as student]
			<li>名称: ${student.name}</li>
			<li>年龄: ${student.age}</li>
		[/#list]
	</ul>
[#else]
	没有任何数据
[/#if]