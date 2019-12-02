<%@include file="header.jsp"%>
<jsp:setProperty property="*" name="voterbean"/>
<c:redirect url="${sessionScope.voterbean.authenticateVoter()}.jsp" />
