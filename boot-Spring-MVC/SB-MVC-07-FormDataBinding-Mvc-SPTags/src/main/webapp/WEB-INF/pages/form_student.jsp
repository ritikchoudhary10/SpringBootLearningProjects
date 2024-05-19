<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="text-align:center;background:red;">Student form</h1>
<br><br><br>
<%-- <frm:form action="show_result" method="POST" modelAttribute="stud"> --%>
<!-- if we donot specify action by default it will take the previous path as requst path for form submission 
		with method as POST type  -->
<frm:form modelAttribute="stud">
	<table align="center" bgcolor="yellow" border="1">
		<tr>
			<td>Student Id::</td>
			<td><frm:input path="sid"/></td>
		</tr>
		<tr>
			<td>Student name::</td>
			<td><frm:input path="sname"/></td>
		</tr>
		<tr>
			<td>Student Address::</td>
			<td><frm:input path="sadd"/></td>
		</tr>
		<tr>
			<td>Student Average::</td>
			<td><frm:input path="avgMarks"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Show Result"/></td>
			<td><input type="reset" value="Cancel"/></td>
		</tr>
	</table>


</frm:form>
