<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<h1 style="text-align:center; color:red; font:30px"><b><sp:message code="edit.form.title"/></b></h1>
<br><br>
<center>
	<frm:form modelAttribute="emp">
		<table bgcolor="cyan">
			<tr>
				<td><sp:message code="common.empno"/></td>
				<td><frm:input path="empno" readonly="true" /></td>
			</tr>
			<tr>
				<td><sp:message code="common.ename"/></td>
				<td><frm:input path="ename" /></td>
			</tr>
			<tr>
				<td><sp:message code="common.job"/></td>
				<td><frm:input path="job"/></td>
			</tr>
			<tr>
				<td><sp:message code="common.sal"/></td>
				<td><frm:input path="sal"/></td>
			</tr>
			<tr>
				<td><sp:message code="common.deptno"/></td>
				<td><frm:input path="deptno"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="<sp:message code="edit.form.submit"/>"></td>
				<td><input type="reset" value="<sp:message code="edit.form.reset"/>"></td>
			</tr>
		</table>
	</frm:form>
</center>