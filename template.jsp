<%@ page contentType="text/html; charset=GB2312" %>
<html>
	<head>
	 <title> <%=titlename %></title>
	</head>
	<body>
		<table width="100%" height="100%">
			<tr>
				<td width="150" valign="top" align="left" bgcolor="#CCFFCC"><%@ include file="sidebar.htm" %></td>
				<td height="100%">
					<table width="100%" height="100%">
						<tr>
							<td valign="top" height="15%"><%@ include file="header.htm" %></td>
						</tr>
						<tr>
							<td valign="top">
							<jsp:include page="<%= bodyfile %>"></jsp:include>
							</td>
						</tr>
						<tr>
							<td valign="bottom" height="15%"><%@ include file="footer.htm" %></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>