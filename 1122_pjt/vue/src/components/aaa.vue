<template>
    <div>
        <div class="row" style="background-color: #eee; padding: 10px;">
            <div class="col-md-offset-2" style="color: #555; font-size: 10px;">
                <span class="glyphicon glyphicon-home"></span> <a href="#"
                    style="color: #555;"><router-link to="/"> &nbsp;Home</router-link></a> &nbsp;>>&nbsp; 회원 가입
            </div>
        </div>
        <div class="row" style="background-color: #555;">
            <!-- 		<div class="row"  style="background-color: #555;"></div> -->
            <div class="container">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form class="form-horizontal" role="form" id="register" method="post"
                        action="memberreg" @submit.prevent="memberreg">
                        <div class="form-group">
                            <span style="font-size: 30px">회원가입</span>
                        </div>
                        <div class="form-group" id="divId">
                            <label for="inputId" class="col-lg-3 control-label">아이디</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control onlyAlphabetAndNumber"
                                    id="id" data-rule-required="true" placeholder="" maxlength="30" name="id" v-model="member.id">
                            </div>
                        </div>
                        <div class="form-group" id="divPassword">
                            <label for="inputPassword" class="col-lg-3 control-label">패스워드</label>
                            <div class="col-lg-8">
                                <input type="password" class="form-control" id="password"
                                    name="pw" data-rule-required="true"
                                    placeholder="영문 숫자포함  6자리 이상" maxlength="30" v-model="member.pw">
                            </div>
                        </div>
                        <div class="form-group" id="divName">
                            <label for="inputName" class="col-lg-3 control-label">이름</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control onlyHangul" id="name"
                                    data-rule-required="true" placeholder="User Name" maxlength="15" name="name" v-model="member.name">
                            </div>
                        </div>
                        <div class="form-group" id="divAddress">
                            <label for="inputAddress" class="col-lg-3 control-label">주소</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" id="address"
                                    data-rule-required="true" placeholder="address" maxlength="50" name="addr" v-model="member.addr">
                            </div>
                        </div>
                        <div class="form-group" id="divPhoneNumber">
                            <label for="inputPhoneNumber" class="col-lg-3 control-label">전화번호</label>
                            <div class="col-lg-8">
                                <input type="tel" class="form-control onlyNumber"
                                    id="phoneNumber" data-rule-required="true"
                                    placeholder="010-xxx-xxxx" maxlength="11" name="tel" v-model="member.tel">
                            </div>
                        </div>
                        <div class="form-group" id="divAllergy">
                            <label for="inputAllergy" class="col-lg-3 control-label">알레르기</label>
                            <div class="col-lg-8">
                                <fieldset>
                                    <legend>Check</legend>
                                    <input type="checkbox" name="allergyArr" value="대두" v-model="member.allergyArr" />대두
                                    <input type="checkbox" name="allergyArr" value="땅콩" v-model="member.allergyArr" />땅콩
                                    <input type="checkbox" name="allergyArr" value="우유" v-model="member.allergyArr" />우유
                                    <input type="checkbox" name="allergyArr" value="게" v-model="member.allergyArr" />게
                                    <br>
                                    <input type="checkbox" name="allergyArr" value="새우" v-model="member.allergyArr" />새우
                                    <input type="checkbox" name="allergyArr" value="참치" v-model="member.allergyArr" />참치
                                    <input type="checkbox" name="allergyArr" value="연어" v-model="member.allergyArr" />연어
                                    <input type="checkbox" name="allergyArr" value="쑥" v-model="member.allergyArr" />쑥
                                    <br>
                                    <input type="checkbox" name="allergyArr" value="소고기" v-model="member.allergyArr" />소고기
                                    <input type="checkbox" name="allergyArr" value="닭고기" v-model="member.allergyArr" />닭고기
                                    <input type="checkbox" name="allergyArr" value="돼지고기" v-model="member.allergyArr" />돼지고기
                                    <br>
                                    <input type="checkbox" name="allergyArr" value="복숭아" v-model="member.allergyArr" />복숭아
                                    <input type="checkbox" name="allergyArr" value="민들레" v-model="member.allergyArr" />민들레
                                    <input type="checkbox" name="allergyArr" value="계란흰자" v-model="member.allergyArr" />계란흰자
                                </fieldset>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button type="reset" class="btn btn-default">취소</button>
                                <button type="submit" class="btn btn-primary">등록</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import http from "../http-common";
export default {
    data() {
        return {
            member: {
                id:'',
                pw:'',
                name:'',
                addr:'',
                tel:'',
                allergyArr:[],
                alergins: ["대두","땅콩","우유","게","새우","참치","연어","쑥","소고기","닭고기","돼지고기","복숭아","민들레","계란흰자"]
            },
            submitted: false
        }
    },
    methods: {
        memberreg() {
            if(this.member.id == ''){ alert('아이디를 입력하세요.'); return ;}
            if(this.member.pw == ''){ alert('비밀번호를 입력하세요.'); return ;}
            http.post('/memberreg', {
                id: this.member.id,
                pw: this.member.pw,
                name: this.member.name,
                addr: this.member.addr,
                tel: this.member.tel,
                allergyArr: this.member.allergyArr
            }).then(response => {
                alert(response.data.resmsg);
                this.$router.push("/");
            }).catch(() => {
                alert("등록을 하지 못했습니다.");
            })
        }
    }
};
</script>
<style>
#register {
	margin: 30px;
	padding: 30px;
	background-color: #eee;
	border-radius: 10px;
}
.navbar .dropdown-menu.form-wrapper {
	width: 280px;
	padding: 20px;
	left: auto;
	right: 0;
	font-size: 14px;
	background-color: #212121;
}
.navbar .dropdown-menu.form-wrapper a {
	color: #33CABB;
	padding: 0 !important;
}
.navbar .dropdown-menu.form-wrapper a:hover {
	text-decoration: underline;
}
.navbar .form-wrapper .form-footer {
	text-align: center;
	padding-top: 10px;
	font-size: 13px;
}
.navbar .form-wrapper .form-footer a:hover {
	text-decoration: underline;
}
.navbar .form-wrapper .checkbox-inline input {
	margin-top: 3px;
}
.navbar .checkbox-inline {
	font-size: 13px;
}
.navbar .navbar-right .dropdown-toggle::after {
	display: none;
}
@media ( min-width : 1200px) {
	.form-inline .input-group {
		width: 300px;
		margin-left: 30px;
	}
}
</style>