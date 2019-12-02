<%@include file="header.jsp"%>

<jsp:setProperty property="*" name="voterbean"/>

<body>
<c:redirect url="${sessionScope.voterbean.authenticateVoter()}.jsp" />
</body>
