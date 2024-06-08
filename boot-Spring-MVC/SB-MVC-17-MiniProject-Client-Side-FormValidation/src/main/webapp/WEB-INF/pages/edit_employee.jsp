<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>




<h1 style="text-align:center; color:red; font:30px"><b>Add Employee Records</b></h1>
<br><br>
<center>
	<frm:form modelAttribute="emp" onsubmit="return doValidation(this)">
		<table bgcolor="cyan">
			<tr>
				<td>Employee No.</td>
				<td><frm:input path="empno" readonly="true" /></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><frm:input path="ename"/><div style="color:red;font-weight:800;" id="enameErr"></div></td>
			</tr>
			<tr>
				<td>Employee Job</td>
				<td><frm:input path="job"/><div style="color:red;font-weight:800;" id="jobErr"></div></td>
			</tr>
			<tr>
				<td>Employee Salary</td>
				<td><frm:input path="sal" placeholder="0"/><div style="color:red;font-weight:800;" id="salErr"></div></td>
			</tr>
			<tr>
				<td>Employee Department No.</td>
				<td><frm:input path="deptno" placeholder="0"/><div style="color:red;font-weight:800;" id="deptnoErr"></div></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Details"></td>
				<td><input type="reset" value="Reset Data"></td>
			</tr>
		</table>
	</frm:form>
</center>

<script type="text/javascript" src="js/validation.js">

</script>
