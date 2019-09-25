<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<link rel="stylesheet" href="js/bootstrap.js">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->


<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<script type="text/javascript">
	function goInfo() {
		location.href = "proInfo.html";
	}
</script>


<body>
	<iframe src="mainMenu.html" width="100%" height="369px" scrolling="no"></iframe>
	<div>
		<div class="main hc-element-invisible"
			data-animation-effect="fadeInUpSmall" data-effect-delay="100">
			<div class="form-block p-30 light-gray-bg border-clear"
				style="width: 100%">
				<h2 class="title" style="text-align:center;">비밀번호 찾기</h2>

				<form class="form-horizontal" action="main.do?action=find_mem" method="post">
					<div class="form-group has-feedback row">
						<label for="inputName"
							class="col-md-3 control-label text-md-right col-form-label">아이디
							<span class="text-danger small">*</span>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="inputID"
								placeholder="" required name="id"> <i
								class="fa fa-pencil form-control-feedback pr-4"></i>
						</div>
					</div>
					<div class="form-group has-feedback row">
						<label for="inputUserName"
							class="col-md-3 control-label text-md-right col-form-label">이름
							<span class="text-danger small">*</span>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="inputName"
								placeholder="홍길동" required name="name"> <i
								class="fa fa-user form-control-feedback pr-4"></i>
						</div>
					</div>
					<div class="form-group has-feedback row">
						<label for="inputPassword"
							class="col-md-3 control-label text-md-right col-form-label">전화번호
							<span class="text-danger small">*</span>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="inputTel"
								placeholder="010-xxxx-xxxx" required name="tel"> <i
								class="fa fa-lock form-control-feedback pr-4"></i>
						</div>
					</div>
					<div class="form-group row">
						<div class="ml-md-auto col-md-9" style="text-align:center;">
							<button type="submit"
								class="btn btn-group btn-default btn-animated">
								비밀번호 찾기<i class="fa fa-check"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- main end -->

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>