<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복 확인</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- jquery -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		
		<div class="form-group">
			<label for="name">이름</label>
			<div class="d-flex">
				<input type="text" id="name" class="form-control col-3" placeholder="이름을 입력하세요."><!--name 필요없음-->
				<button type="button" class="btn btn-primary" id="nameCheckBtn">중복 확인</button>
			</div>
			
			<small id="nameStatusArea"></small>
		</div>
		
		<button type="button" class="btn btn-info" id="joinBtn">가입하기</button>
	</div>
	
	<script>
		$(document).ready(function() {
			$('#nameCheckBtn').on('click', function() {
				// nameStatusArea의 하위 태그들 초기화
				$('#nameStatusArea').empty(); // 자식 태그들을 모두 비움
				
				let name = $('#name').val().trim();
				
				// 이름이 입력됐는지 확인 validation
				if (name == '') {
					$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>');
					return;
				}
				
				// 이름 중복 확인 -> DB에서 조회 => AJAX 통신
				$.ajax({
					// Request
					type:"get"
					, url:"/lesson06/ex02/is_duplication"
					, data: {"name":name}

					// Response
					, success:function(data) {
						// alert(data.is_duplication);
						if (data.is_duplication) { // data.is_duplication이 boolean이라서 == true가 필요없음
							$('#nameStatusArea').append('<span class="text-danger">중복된 이름입니다.</span>');
							return;
						}
					}
					, error:function(e) {
						alert("error" + e);
					}
				});
			});
		});
	</script>
</body>
</html>