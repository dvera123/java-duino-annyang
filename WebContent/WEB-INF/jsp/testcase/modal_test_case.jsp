<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header"></div>
	<div class="modal-body">
		<form:form method="post" commandName="testCase" action="">
			<form:input path="name" />
			<form:input path="description" />
			<form:select path="fkTestCaseStatus">
				<c:forEach items="${testCaseStatusList}" var="testCaseStatus"
					varStatus="status">
					<form:option value="${testCaseStatus.id}">${testCaseStatus.name}</form:option>
				</c:forEach>
			</form:select>
			<input type="submit" value="save">
		</form:form>
	</div>
	<div class="modal-footer"></div>
</div>
