<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<script src="../js/jquery-1.9.1.min.js"></script>

</head>

<title>任务列表</title>

<body>

	<form id="addForm" method="post">

		<table border="1">
			<thead>
				<tr>
					<td style="width: 20xp">id&nbsp;&nbsp;&nbsp;</td>
					<td>name</td>
					<td>group</td>
					<td>状态&nbsp;&nbsp;</td>
					<td>cron表达式</td>
					<td>描述</td>
					<td>同步否</td>
					<td>类路径</td>
					<td>spring id</td>
					<td>方法名</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="job" items="${jobList}">
					<tr>
						<td>${job.jobId }</td>
						<td>${job.jobName }</td>
						<td>${job.jobGroup }</td>
						<td>${job.jobStatus }<c:choose>
								<c:when test="${job.jobStatus=='1' }">
									<a href="javascript:;"
										onclick="changeJobStatus('${job.jobId}','stop')">停止</a>&nbsp;
								</c:when>
								<c:otherwise>
									<a href="javascript:;"
										onclick="changeJobStatus('${job.jobId}','start')">开启</a>&nbsp;
								</c:otherwise>
							</c:choose>
						</td>
						<td>${job.cronExpression }</td>
						<td>${job.description }</td>
						<td>${job.isConcurrent }</td>
						<td>${job.beanClass }</td>
						<td>${job.springId }</td>
						<td>${job.methodName }</td>
						<td><a href="javascript:;" onclick="updateCron('${job.jobId}')">更新cron</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td>n</td>
					<td><input type="text" name="jobName" id="jobName"></input></td>
					<td><input type="text" name="jobGroup" id="jobGroup"></input></td>
					<td>0<input type="hidden" name="jobStatus" value="0"></input></td>
					<td><input type="text" name="cronExpression"
						id="cronExpression"></input></td>
					<td><input type="text" name="description" id="description"></input></td>
					<td><select name="isConcurrent" id="isConcurrent">
							<option value="1">1</option>
							<option value="0">0</option>
					</select></td>
					<td><input type="text" name="beanClass" id="beanClass"></input></td>
					<td><input type="text" name="springId" id="springId"></input></td>
					<td><input type="text" name="methodName" id="methodName"></input></td>
					<td><input type="button" onclick="add()" value="保存" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	<script>
	
		function validateAdd() {
			if ($.trim($('#jobName').val()) == '') {
				alert('name不能为空！');
				$('#jobName').focus();
				return false;
			}
			if ($.trim($('#jobGroup').val()) == '') {
				alert('group不能为空！');
				$('#jobGroup').focus();
				return false;
			}
			if ($.trim($('#cronExpression').val()) == '') {
				alert('cron表达式不能为空！');
				$('#cronExpression').focus();
				return false;
			}
			if ($.trim($('#beanClass').val()) == '' && $.trim($('#springId').val()) == '') {
				$('#beanClass').focus();
				alert('类路径和spring id至少填写一个');
				return false;
			}
			if ($.trim($('#methodName').val()) == '') {
				$('#methodName').focus();
				alert('方法名不能为空！');
				return false;
			}
			return true;
		}
		
		function add() {
			if (validateAdd()) {
				$.ajax({
					type : "POST",
					async : false,
					dataType : "JSON",
					cache : false,
					url : "add",
					data : $("#addForm").serialize(),
					success : function(data) {
						if (data.flag) {
							location.reload();
						} else {
							alert(data.msg);
						}

					}//end-callback
				});//end-ajax
			}
		}
		
		function changeJobStatus(jobId, cmd) {
			$.ajax({
				type : "POST",
				async : false,
				dataType : "JSON",
				cache : false,
				url : "changeJobStatus",
				data : {
					jobId : jobId,
					cmd : cmd
				},
				success : function(data) {
					if (data.flag) {
						location.reload();
					} else {
						alert(data.msg);
					}

				}//end-callback
			});//end-ajax
		}
		
		function updateCron(jobId) {
			var cron = prompt("输入cron表达式！", "")
			if (cron) {
				$.ajax({
					type : "POST",
					async : false,
					dataType : "JSON",
					cache : false,
					url : "updateCron",
					data : {
						jobId : jobId,
						cron : cron
					},
					success : function(data) {
						if (data.flag) {
							location.reload();
						} else {
							alert(data.msg);
						}
					}//end-callback
				});//end-ajax
			}

		}
		
	</script>
</body>
</html>




