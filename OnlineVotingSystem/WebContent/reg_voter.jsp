<%@include file="header.jsp"%>

<jsp:setProperty property="*" name="voterbean"/>
<body>

<jsp:forward page="${sessionScope.voterbean.registerVoter()}.jsp" />

</body>
