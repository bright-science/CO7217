<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" media="screen" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
	<head>
		<title>Friends Report</title>
		<style>
		table {
		    border-collapse: collapse;
		}
		
		table, td, th {
		    border: 1px solid black;
		}
		</style>
	</head>
	<body>
		<h4>These are your friends:</h4>
		
		<ul>
			<c:forEach var="friend" items="${friends}">
			<li>${friend.name}</li>
			</c:forEach>
		</ul>
		
		<table>
			<tr>
				<td>Name</td>
				<td>Description</td>
				<td>Number of posts</td>
				<td>Number of overall retweets</td>
				<td>Number of active tweets (>100 retweets)</td>
			</tr>
			<c:forEach var="friend" items="${friends}">
				<tr>
					<td>${friend.name}</td>
					<td>${friend.description}</td>
					<td>${friend.noTweets}</td>
					<td>${friend.noRetweets}</td>
					<td>${friend.noActiveTweets}</td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>