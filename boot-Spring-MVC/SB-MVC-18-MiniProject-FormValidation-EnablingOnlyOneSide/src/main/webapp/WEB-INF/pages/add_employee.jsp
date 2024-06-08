<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="text-align:center; color:red; font:30px"><b>Add Employee Records</b></h1>
<br><br>
<center>
	<frm:form modelAttribute="emp" onsubmit="return doValidation(this)">
	<frm:hidden path="flag" />
		<%-- <span style="color:red;font-weight:800 ;">
			<frm:errors path="*"/>
		</span> --%>
		<table bgcolor="cyan">
			<tr>
				<td>Employee Name</td>
				<td>
					<frm:input path="ename"/>
					<div style="color:red;font-weight:800;" id="enameErr"><frm:errors path="ename"/></div>

 			</tr>
			<tr>
				<td>Employee Job</td>
				<td>
					<frm:input path="job"/>
					<div style="color:red;font-weight:800;" id="jobErr"><frm:errors path="job"/></div>

				</td>
			</tr>
			<tr>
				<td>Employee Salary</td>
				<td>
					<frm:input path="sal" placeholder="0"/>
					<div style="color:red;font-weight:800;" id="salErr"><frm:errors path="sal"/></div>

				</td>
			</tr>
			<tr>
				<td>Employee Department No.</td>
				<td>
					<frm:input path="deptno" placeholder="0"/>
					<div style="color:red;font-weight:800;" id="deptnoErr"><frm:errors path="deptno"/></div>

				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Details"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</frm:form>
</center>
<script type="text/javascript" src="js/validation.js"></script>