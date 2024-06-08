<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="text-align:center; color:red; font:30px"><b>Add Employee Records</b></h1>
<br><br>
<center>
	<frm:form modelAttribute="emp">
	<%-- <span style="color:red;font-weight:800;">
			<frm:errors path="*"/>
		</span> --%>
		<table bgcolor="cyan">
			<tr>
				<td>Employee No.</td>
				<td>
					<frm:input path="empno" readonly="true" />
				</td>
			</tr>
			<tr>				<td>Employee Name</td>
				<td><frm:input path="ename" />
					<div style="color:red;font-weight:800;"><frm:errors path="ename"/></div>
				</td>
					
			</tr>
			<tr>
				<td>Employee Job</td>
				<td><frm:input path="job"/>
					<div style="color:red;font-weight:800;"><frm:errors path="job"/></div>
				</td>
			</tr>
			<tr>
				<td>Employee Salary</td>
				<td><frm:input path="sal"/>
					<div style="color:red;font-weight:800;"><frm:errors path="sal"/></div>
				</td>
			</tr>
			<tr>
				<td>Employee Department No.
				<td><frm:input path="deptno"/></td>
					<div style="color:red;font-weight:800;"><frm:errors path="deptno"/></div>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Details"></td>
				<td><input type="reset" value="Reset Data"></td>
			</tr>
		</table>
	</frm:form>
</center>