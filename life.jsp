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
			System.out.println("jspInit(): Jsp����ʼ����" + initVar + "��");
		}
		public void jspDestory(){
			destoryVar++;
			System.out.println("jspDestory(): Jsp��������" + destoryVar + "��");
		}
		%>
		<%
		serviceVar++;
		System.out.println("jspService(): Jsp����Ӧ��" + serviceVar + "��");
		
		String content1 = "��ʼ��������" + initVar;
		String content2 = "��Ӧ�ͻ����������" + serviceVar;
		String content3 = "���ٴ�����" + destoryVar;
		%>
		
		<h1><%=content1 %></h1>
		<h1><%=content2 %></h1>
		<h1><%=content3 %></h1>
	</body>
</html>