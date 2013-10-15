<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:if test="${fn:length(testCaseList) > 0}">
	<c:forEach items="${testCaseList}" var="testCase" varStatus="status">
		<div>${fn:toLowerCase(testCase.name)}</div>
		<form id="editTCForm" class="editTCForm" action="find.do">
			<input type="hidden" name="id" value="${testCase.id}">
			<input type="submit" value="edit">
		</form>
		<form id="deleteTCForm" class="deleteTCForm" action="#">
			<input type="hidden" name="id" value="${testCase.id}">
			<input type="submit" value="delete">
		</form>
	</c:forEach>
</c:if>

<script src="${pageContext.request.contextPath}/assets/js/testcase/delete_test_case.js"></script>