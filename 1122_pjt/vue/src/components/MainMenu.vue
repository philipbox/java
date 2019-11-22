<template>

<div >
	<div class="container">
	<nav class="navbar navbar-inverse" style="margin-bottom:0px;">
		<ul class="nav navbar-nav navbar-right">
		</ul>
		<!-- Single button -->
		<ul class="nav navbar-nav navbar-right">

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false">Login<span
					class="caret"></span>
			</a>
				<ul class="dropdown-menu" role="menu" style="background-color: rgb(46, 53, 55); padding: 20px 20px 20px 20px;">
					<li>
						<div class="row">
							<div class="col-md-12">
								<form class="form" role="form" method="post" action="/mem/login"
									accept-charset="UTF-8" id="login-nav">
									<div class="form-group">
										<label style="color:#848484;">아 이 디</label><input type="text" class="form-control"
											id="login_id" placeholder="I D" required name="login_id" style="width:238px;">
									</div>
									<div class="form-group">
										<label style="color:#848484;">비 밀 번 호</label>
										<input type="password" class="form-control"
											id="login_pw" placeholder="Password" required name="login_pw">
										<div class="help-block text-right">
											<a onClick="gofindPW()">비밀번호 찾기</a>
										</div>
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-primary btn-block">로그인</button>
									</div>
								</form>
							</div>
							<div class="bottom text-center">
								<a onClick="goJoin()"><b>회 원 가 입</b></a>
							</div>
						</div>
					</li>




				</ul>
            </li>
		</ul>


	</nav>



	<nav class="navbar navbar-default navbar" role="navigation" style="margin-bottom:0px;">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

				<a href="/"> <img src="../assets/header-logo.jpg"></a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">

				</button>
				<a class="navbar-brand" href="#"></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">					
					<li><router-link to="/noticelist">공지사항</router-link></li>
					<li><router-link to="/foodinfo">상품 정보</router-link></li>
					<li><router-link to="/QnA">QnA</router-link></li>
				</ul>
				<form class="navbar-form navbar-right" role="search" action="/food/list" method="get">
					<div class="form-group">
						<input type="text" name="search_text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">
						<span class="glyphicon glyphicon-search"></span>
					</button>
					<input type="hidden" value="list" name="action">					
				</form>
			</div>


		</div>
		<!-- /.navbar-collapse -->
		<!-- /.container-fluid -->
	</nav>
	<div class="jumbotron" style="padding: 15px 10px 10px 15px;">
		<div class="container">
		<h1 style="text-align: center;">WHAT WE PROVIDE</h1>
		<hr>
		건강한 삶을 위한 먹거리 프로젝트
		</div>
	</div>
	</div>


</div>


</template>

<script>
 import http from "../http-common";
// import 'bootstrap'
// import 'bootstrap/dist/css/bootstrap.min.css'
// import 'bootstrap/dist/js/bootstrap.min.js'
export default {
	name: "MainMenu",
	data() {
		return {
			info: null,
			loading: true,
			errored: false,
			deps:null,
			titls:null,
			ccommission_pct:0,
			cdept_id:0,
			cmailid:'',
			cmanager_id:0,
			cname:'',
			csalary:0,
			cstart_date:'',
			ctitle:'',
			submitted: false
		};
	},
	filters: {
		salarydecimal (value) {
			var a=parseInt(value);
			return a.toFixed(2);
		}
	}, 
	mounted () {
	http
		.get('/findAllEmployees')
		.then(response => (this.info = response.data))
		.catch(() => {
			this.errored = true
		})
		.finally(() => this.loading = false);
	http
		.get('/findAllDepartments')
		.then(response => (this.deps = response.data))
		.catch(() => {
			this.errored = true
		})
		.finally(() => this.loading = false);
	http
		.get('/findAllTitles')
		.then(response => (this.titls = response.data))
		.catch(() => {
			this.errored = true
		})
		.finally(() => this.loading = false);
	},
	methods: {
	addEmployee() {
		if(this.cname==''){ alert('아이디를 입력하세요.'); return ;}
		if(this.cdept_id==''){ alert('부서를 선택하세요.'); return ;}
		if(this.cmailid==''){ alert('이메일을 선택하세요.'); return ;}
		if(this.cmanager_id==''){ alert('관리자를 선택하세요.'); return ;}
		if(this.csalary==''){ alert('월급을 입력하세요.'); return ;}
		if(this.cstart_date==''){ alert('입사일을 선택하세요.'); return ;}
		if(this.ctitle==''){ alert('직책을 선택하세요.'); return ;}
		
		http.post('/addEmployee', {
			commission_pct: this.ccommission_pct,
			dept_id: this.cdept_id,
			mailid: this.cmailid,
			manager_id: this.cmanager_id,
			name: this.cname,
			salary: this.csalary,
			start_date:this.cstart_date,
			title: this.ctitle
		} 
		).then(response => {
				if (response.data.state=='succ') {
					alert("입사처리를 하였습니다.");
				}else{
					alert("입사처리를 하지 못했습니다.");
				}
		});
		this.submitted = true;
	},
	newCustomer() {
		this.submitted=false,
		this.info=null,
		this.loading=true,
		this.errored=false,
		this.deps=null,
		this.titls=null,
		this.ccommission_pct=0,
		this.cdept_id=0,
		this.cmailid='',
		this.cmanager_id=0,
		this.cname='',
		this.csalary=0,
		this.cstart_date='',
		this.ctitle=''
	}
  }
}
</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>
