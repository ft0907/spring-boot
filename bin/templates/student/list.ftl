[#if page.content?has_content]
	<table>
		<tr>
			<th>名称</th>
			<th>年龄</th>
		</tr>
		[#list page.content as student]
			<tr>
				<td>${student.name}</td>
				<td>${student.age}</td>
			</tr>
		[/#list]
	</table>
[#else]
	没有任何数据
[/#if]