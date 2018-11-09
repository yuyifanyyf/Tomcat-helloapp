<%@ page contentType="text/html; charset=GB2312" %>
<html>
	<head>
		<title>life.jsp</title>
	</head>
	<body>
		<%!
		private int initVar = 0;
		private int serviceVar = 0;
		private int destoryVar = 0;
		public void jspInit(){
			initVar++;
			System.out.println("jspInit(): Jsp被初始化了" + initVar + "次");
		}
		public void jspDestory(){
			destoryVar++;
			System.out.println("jspDestory(): Jsp被销毁了" + destoryVar + "次");
		}
		%>
		<%
		serviceVar++;
		System.out.println("jspService(): Jsp共响应了" + serviceVar + "次");
		
		String content1 = "初始化次数：" + initVar;
		String content2 = "响应客户请求次数：" + serviceVar;
		String content3 = "销毁次数：" + destoryVar;
		%>
		
		<h1><%=content1 %></h1>
		<h1><%=content2 %></h1>
		<h1><%=content3 %></h1>
	</body>
</html>