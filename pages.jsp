<%@ page contentType="text/html; charset=GB2312" %>
<%
final int e = 3;
int totalPages = 0;
int currentPage = 1;
int totalCount = 0;
int p = 0;

String tempStr = request.getParameter("currentPage");
if (tempStr != null && !tempStr.equals("")) currentPage = Integer.parseInt(tempStr);

rs = stmt.executeQuery("select count(*) from BOOKS");
if (rs.next()) totalCount = rs.getInt(1);

totalPages = ((totalCount % e == 0) ? (totalCount / e) : (totalCount / e + 1));

if (currentPage > totalPages) currentPage = totalPages;
else if (currentPage < 1) currentPage = 1;

p = (currentPage - 1) * e;

String sql = "select ID, NAME, TITLE, PRICE from BOOKS order by ID limit " + p + "," + e;
rs = stmt.executeQuery(sql);
%>

页码：
<% for (int i = 1; i <= totalPages; i++){
	if (i == currentPage){
%>
<%=i %>
<%} else{ %>
<a href="dbaccess2.jsp?currentPage=<%=i %>"><%=i %></a>
<% }%>
<% }%>
&nbsp;共<%=totalPages %>页，共<%=totalCount%>条记录

<table border="1" width=400>
<tr>
	<td bgcolor="#D8E4F1"><b>书编号</b></td>
	<td bgcolor="#D8E4F1"><b>作者</b></td>
	<td bgcolor="#D8E4F1"><b>书名</b></td>
	<td bgcolor="#D8E4F1"><b>价格</b></td>
</tr>
<%
while(rs.next())
{
	String id = rs.getString(1);
	String name = rs.getString(2);
	String title = rs.getString(3);
	float price = rs.getFloat(4);
%>
<tr>
	<td><%=id %></td>
	<td><%=name %></td>
	<td><%=title %></td>
	<td><%=price %></td>
</tr>
<%} %>
</table>