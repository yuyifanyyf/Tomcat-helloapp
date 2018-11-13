din.jsp is including content.jsp
<% int var = 1;
	request.setAttribute("username", "Tom");
	%>
<jsp:include page="content.jsp" flush="true"></jsp:include>
<p>din.jsp is doing something else.